package com.uqac.tickets.api;

import com.uqac.tickets.core.TicketService;
import com.uqac.tickets.core.User;
import com.uqac.tickets.model.NewUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersApiDelegateImpl implements UsersApiDelegate {

    private final TicketService ticketService;

    public UsersApiDelegateImpl(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // ===================== GET /users =====================
    @Override
    public ResponseEntity<List<com.uqac.tickets.model.User>> usersGet() {
        List<User> domainUsers = ticketService.getUsers();

        List<com.uqac.tickets.model.User> dto = domainUsers.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dto);
    }

    // ===================== POST /users =====================
    @Override
    public ResponseEntity<com.uqac.tickets.model.User> usersPost(NewUser newUser) {
        // On ajoute l'utilisateur dans le modèle métier
        ticketService.addUser(
                newUser.getName(),
                newUser.getEmail(),
                newUser.getRole()
        );

        // On récupère l'utilisateur créé (dernier de la liste)
        List<User> all = ticketService.getUsers();
        User created = all.get(all.size() - 1);

        return ResponseEntity
                .status(201)
                .body(toDto(created));
    }

    // ===================== Mapping core.User -> model.User =====================
    private com.uqac.tickets.model.User toDto(User u) {
        // Utilisation du style "builder" généré par OpenAPI :
        return new com.uqac.tickets.model.User()
                .userID(u.getUserID())
                .name(u.getName())
                .email(u.getEmail())
                .role(u.getRole());
        // Équivalent possible avec les setters :
        // com.uqac.tickets.model.User dto = new com.uqac.tickets.model.User();
        // dto.setUserID(u.getUserID());
        // dto.setName(u.getName());
        // dto.setEmail(u.getEmail());
        // dto.setRole(u.getRole());
        // return dto;
    }
}
