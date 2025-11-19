import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    private final TicketService service = new TicketService();

    private final CardLayout cards = new CardLayout();
    private final JPanel root = new JPanel(cards);

    private final LoginPanel loginPanel;
    private final AdminPanel adminPanel;
    private final UserPanel userPanel;

    public App() {
        super("Gestion de tickets — Lab 3 (Swing)");

        loginPanel = new LoginPanel(service, this::onLoginAsAdmin, this::onLoginAsUser);
        adminPanel = new AdminPanel(service, this::logout);
        userPanel  = new UserPanel(service, this::logout);

        root.add(loginPanel, "LOGIN");
        root.add(adminPanel, "ADMIN");
        root.add(userPanel,  "USER");

        setContentPane(root);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 660);
        setLocationRelativeTo(null);
    }

    private void onLoginAsAdmin() {
        adminPanel.refreshAll();
        cards.show(root, "ADMIN");
    }

    private void onLoginAsUser(User u) {
        userPanel.setCurrentUser(u);
        userPanel.refreshAll();
        cards.show(root, "USER");
    }

    private void logout() {
        loginPanel.refreshUsers();
        cards.show(root, "LOGIN");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().setVisible(true));
    }
}
