package com.uqac.tickets.api;

import com.uqac.tickets.core.Priority;
import com.uqac.tickets.core.Status;
import com.uqac.tickets.core.Ticket;
import com.uqac.tickets.core.TicketService;
import com.uqac.tickets.core.User;
import com.uqac.tickets.model.NewTicket;
import com.uqac.tickets.model.UpdateTicket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketsApiDelegateImpl implements TicketsApiDelegate {

    private final TicketService ticketService;

    public TicketsApiDelegateImpl(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // ===================== GET /tickets =====================
    @Override
    public ResponseEntity<List<com.uqac.tickets.model.Ticket>> ticketsGet() {
        List<Ticket> domainTickets = ticketService.getTickets();

        List<com.uqac.tickets.model.Ticket> dto = domainTickets.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dto);
    }

    // ===================== GET /tickets/{id} =====================
    @Override
    public ResponseEntity<com.uqac.tickets.model.Ticket> ticketsIdGet(Integer id) {
        Ticket t = ticketService.findById(id);
        if (t == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDto(t));
    }

    // ===================== PUT /tickets/{id} =====================
    @Override
    public ResponseEntity<com.uqac.tickets.model.Ticket> ticketsIdPut(
            Integer id, UpdateTicket updateTicket) {

        Ticket t = ticketService.findById(id);
        if (t == null) {
            return ResponseEntity.notFound().build();
        }

        // --- changement de statut ---
        if (updateTicket.getStatus() != null) {
            UpdateTicket.StatusEnum restStatus = updateTicket.getStatus();  // enum REST
            Status statusCore = Status.valueOf(restStatus.name());          // mêmes noms
            ticketService.changeStatus(id, statusCore);
        }

        // --- changement de priorité ---
        if (updateTicket.getPriority() != null) {
            UpdateTicket.PriorityEnum restPrio = updateTicket.getPriority();
            Priority prioCore = Priority.valueOf(restPrio.name());
            t.setPriority(prioCore);   // setter dans ton modèle core
        }

        Ticket updated = ticketService.findById(id);
        return ResponseEntity.ok(toDto(updated));
    }

    // ===================== POST /tickets =====================
    @Override
    public ResponseEntity<com.uqac.tickets.model.Ticket> ticketsPost(NewTicket newTicket) {
        // Auteur : on prend simplement le premier user existant
        User author = ticketService.getUsers().isEmpty()
                ? null
                : ticketService.getUsers().get(0);

        // priorité (enum REST)
        NewTicket.PriorityEnum restPrio = newTicket.getPriority();
        Priority prioCore = Priority.valueOf(restPrio.name());

        Ticket created = ticketService.createTicket(author, newTicket.getTitle(), prioCore);

        return ResponseEntity
                .status(201)
                .body(toDto(created));
    }

    // ==========================================================
    // Mapping modèle métier (core) -> modèle REST (openapi)
    // ==========================================================
    private com.uqac.tickets.model.Ticket toDto(Ticket t) {
        // On crée un DTO vide puis on utilise les setters générés
        com.uqac.tickets.model.Ticket dto = new com.uqac.tickets.model.Ticket();

        // id + titre
        dto.setTicketID(t.getTicketID());
        dto.setTitle(t.getTitle());

        // priorité
        if (t.getPriority() != null) {
            dto.setPriority(
                    com.uqac.tickets.model.Ticket.PriorityEnum.valueOf(
                            t.getPriority().name()
                    )
            );
        }

        // statut
        if (t.getStatus() != null) {
            dto.setStatus(
                    com.uqac.tickets.model.Ticket.StatusEnum.valueOf(
                            t.getStatus().name()
                    )
            );
        }

        // assignedUser : pour l’instant on laisse null (le modèle REST expose déjà Users via UsersApi)
        // Si tu veux, on pourra plus tard créer un com.uqac.tickets.model.User et le remplir ici.

        // descriptions : idem, on peut les ignorer pour le labo (la liste reste vide)

        return dto;
    }
}
