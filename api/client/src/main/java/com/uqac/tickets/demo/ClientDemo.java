package com.uqac.tickets.demo;

import com.uqac.tickets.client.ApiClient;
import com.uqac.tickets.client.api.UsersApi;
import com.uqac.tickets.client.api.TicketsApi;
import com.uqac.tickets.client.model.User;
import com.uqac.tickets.client.model.Ticket;
import com.uqac.tickets.client.model.NewUser;
import com.uqac.tickets.client.model.NewTicket;
import com.uqac.tickets.client.model.UpdateTicket;

import java.util.List;

public class ClientDemo {

    public static void main(String[] args) {

        // 1. Configuration du client HTTP vers ton serveur local
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("http://localhost:8080");

        // 2. Création des API générées
        UsersApi usersApi = new UsersApi(apiClient);
        TicketsApi ticketsApi = new TicketsApi(apiClient);

        try {
            // ===================== UTILISATEURS =====================
            System.out.println("=== Liste des utilisateurs (avant) ===");
            List<User> users = usersApi.usersGet();
            for (User u : users) {
                System.out.println(u);
            }

            // --- Création d'un nouvel utilisateur ---
            System.out.println("\n=== Création d'un nouvel utilisateur ===");
            NewUser newUser = new NewUser()
                    .name("ClientDemo User")
                    .email("clientdemo@uqac.ca")
                    .role("DEV");

            User createdUser = usersApi.usersPost(newUser);
            System.out.println("Utilisateur créé : " + createdUser);

            // ===================== TICKETS =====================
            System.out.println("\n=== Liste des tickets (avant) ===");
            List<Ticket> tickets = ticketsApi.ticketsGet();
            for (Ticket t : tickets) {
                System.out.println(t);
            }

            // --- Création d'un nouveau ticket ---
            System.out.println("\n=== Création d'un nouveau ticket ===");
            NewTicket newTicket = new NewTicket()
                    .title("Ticket créé depuis ClientDemo")
                    .priority(NewTicket.PriorityEnum.MOYENNE);

            Ticket createdTicket = ticketsApi.ticketsPost(newTicket);
            System.out.println("Ticket créé : " + createdTicket);

            Integer createdId = createdTicket.getTicketID();

            // --- Mise à jour du ticket créé ---
            System.out.println("\n=== Mise à jour du ticket #" + createdId + " ===");
            UpdateTicket update = new UpdateTicket()
                    .status(UpdateTicket.StatusEnum.ASSIGNE)
                    .priority(UpdateTicket.PriorityEnum.HAUTE);

            Ticket updatedTicket = ticketsApi.ticketsIdPut(createdId, update);
            System.out.println("Ticket après mise à jour : " + updatedTicket);

            // --- Récupération d’un ticket par ID ---
            System.out.println("\n=== Lecture du ticket #" + createdId + " ===");
            Ticket loaded = ticketsApi.ticketsIdGet(createdId);
            System.out.println("Ticket relu depuis l’API : " + loaded);

            // ===================== LISTES FINALES =====================
            System.out.println("\n=== Liste des utilisateurs (après) ===");
            users = usersApi.usersGet();
            for (User u : users) {
                System.out.println(u);
            }

            System.out.println("\n=== Liste des tickets (après) ===");
            tickets = ticketsApi.ticketsGet();
            for (Ticket t : tickets) {
                System.out.println(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
