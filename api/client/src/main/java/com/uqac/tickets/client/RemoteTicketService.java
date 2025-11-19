package com.uqac.tickets.client;

import com.uqac.tickets.client.api.TicketsApi;
import com.uqac.tickets.client.api.UsersApi;
import com.uqac.tickets.client.model.NewTicket;
import com.uqac.tickets.client.model.Ticket;
import com.uqac.tickets.client.model.UpdateTicket;
import com.uqac.tickets.client.model.User;

import java.util.List;

public class RemoteTicketService {

    private final UsersApi usersApi;
    private final TicketsApi ticketsApi;

    public RemoteTicketService(String baseUrl) {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(baseUrl);

        this.usersApi = new UsersApi(apiClient);
        this.ticketsApi = new TicketsApi(apiClient);
    }

    // =========================================================
    // Utilisateurs
    // =========================================================
    public List<User> listUsers() throws Exception {
        return usersApi.usersGet();
    }

    // =========================================================
    // Tickets
    // =========================================================

    public List<Ticket> listTickets() throws Exception {
        return ticketsApi.ticketsGet();
    }

    public Ticket getTicket(Integer id) throws Exception {
        return ticketsApi.ticketsIdGet(id);
    }

    public Ticket createTicket(String title, String priority) throws Exception {
        NewTicket dto = new NewTicket();
        dto.setTitle(title);

        if (hasText(priority)) {
            NewTicket.PriorityEnum prioEnum =
                    NewTicket.PriorityEnum.valueOf(priority.toUpperCase());
            dto.setPriority(prioEnum);
        }

        return ticketsApi.ticketsPost(dto);
    }

    public Ticket updateTicket(Integer id,
                               String status,
                               String priority,
                               String assignedTo) throws Exception {

        UpdateTicket dto = new UpdateTicket();

        // statut
        if (hasText(status)) {
            UpdateTicket.StatusEnum stEnum =
                    UpdateTicket.StatusEnum.valueOf(status.toUpperCase());
            dto.setStatus(stEnum);
        }

        // priorité
        if (hasText(priority)) {
            UpdateTicket.PriorityEnum prioEnum =
                    UpdateTicket.PriorityEnum.valueOf(priority.toUpperCase());
            dto.setPriority(prioEnum);
        }

        // assignation (id utilisateur)
        if (hasText(assignedTo)) {
            dto.setAssignedUserId(Integer.parseInt(assignedTo));
        }

        return ticketsApi.ticketsIdPut(id, dto);
    }

    // =========================================================
    // Utilitaire local
    // =========================================================
    private boolean hasText(String s) {
        return s != null && !s.trim().isEmpty();
    }
}
