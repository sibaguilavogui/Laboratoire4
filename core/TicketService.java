import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketService {
    private final AtomicInteger TICKET_SEQ = new AtomicInteger(1000);

    private final Admin admin;
    private final List<User> users = new ArrayList<>();
    private final List<Ticket> tickets = new ArrayList<>();

    public TicketService() {
        // --- Données de démo ---
        this.admin = new Admin(100, "Guilavogui", "guilavogui@etu.ca");

        users.add(new User(101, "Elvis", "Elvis@.uqac", "DEV"));
        users.add(new User(102, "Siba",  "siba@.uqac",  "TEST"));

        // Ticket de démonstration (constructeur: id, title, priority)
        Ticket t0 = new Ticket(nextTicketId(), "Ticket d’exemple", Priority.MOYENNE);
        t0.updateStatus(Status.OUVERT);
        tickets.add(t0);
        admin.registerTicket(t0);
    }

    public int nextTicketId() { return TICKET_SEQ.getAndIncrement(); }

    public Admin getAdmin() { return admin; }
    public List<User> getUsers() { return new ArrayList<>(users); }
    public List<Ticket> getTickets() { return new ArrayList<>(tickets); }

    // --- Commandes principales ---
    public Ticket createTicket(User author, String title, Priority prio) {
        Objects.requireNonNull(author, "author");
        Objects.requireNonNull(title, "title");
        Objects.requireNonNull(prio, "priority");

        Ticket t = new Ticket(nextTicketId(), title, prio);
        t.updateStatus(Status.OUVERT);
        tickets.add(t);
        admin.registerTicket(t);
        return t;
    }

    public void assignTicket(int ticketId, User toUser) {
        Ticket t = findById(ticketId);
        if (t != null && toUser != null) t.assignTo(toUser);
    }

    public void changeStatus(int ticketId, Status s) {
        Ticket t = findById(ticketId);
        if (t != null && s != null) t.updateStatus(s);
    }

    public void closeTicket(int ticketId) {
        Ticket t = findById(ticketId);
        if (t != null) t.updateStatus(Status.TERMINE); // pas de close()
    }

    public void addComment(int ticketId, String comment) {
        Ticket t = findById(ticketId);
        if (t != null && comment != null && !comment.isBlank()) {
            t.addComment(comment.trim());
        }
    }

    // --- Descriptions ---
    // façade ADMIN : l’auteur n’est pas un User -> on passe null (affiché "inconnu")
    public void addDescriptionAsAdmin(int ticketId, DescriptionType type, String value) {
        addDescriptionInternal(ticketId, type, value, null);
    }

    // façade USER : l’auteur est l’utilisateur courant
    public void addDescriptionAsUser(int ticketId, DescriptionType type, String value, User by) {
        addDescriptionInternal(ticketId, type, value, by);
    }

    // Implémentation commune
    private void addDescriptionInternal(int ticketId, DescriptionType type, String value, User by) {
        Ticket t = findById(ticketId);
        if (t == null || type == null || value == null) return;
        String v = value.trim();
        if (v.isEmpty()) return;

        if (type == DescriptionType.TEXTE) {
            t.addTextDescription(v, by);      // API réelle de Ticket
        } else {
            t.addAttachment(type, v, by);     // API réelle de Ticket
        }
    }

    public List<Description> getDescriptions(int ticketId) {
        Ticket t = findById(ticketId);
        if (t == null) return List.of();
        return new ArrayList<>(t.getDescriptions());
    }

    // --- Utilisateurs ---
    public void addUser(String name, String email, String role) {
        int newId = users.stream().mapToInt(User::getUserID).max().orElse(200) + 1;
        users.add(new User(newId, name, email, role));
    }

    public List<Ticket> ticketsAssignedTo(User u) {
        List<Ticket> out = new ArrayList<>();
        for (Ticket t : tickets) {
            User a = t.getAssignedUser();
            if (a != null && a.getUserID() == u.getUserID()) out.add(t);
        }
        return out;
    }

    public Ticket findById(int id) {
        for (Ticket t : tickets) if (t.getTicketID() == id) return t;
        return null;
    }
}
