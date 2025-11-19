import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class LoginPanel extends JPanel {
    private final TicketService service;
    private final Runnable onAdminLogin;
    private final Consumer<User> onUserLogin;

    private final JComboBox<User> usersCombo = new JComboBox<>();

    public LoginPanel(TicketService service, Runnable onAdminLogin, Consumer<User> onUserLogin) {
        this.service = service;
        this.onAdminLogin = onAdminLogin;
        this.onUserLogin = onUserLogin;

        setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Connexion");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 22f));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        JButton adminBtn = new JButton("Se connecter comme Administrateur");
        adminBtn.addActionListener(e -> onAdminLogin.run());
        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        add(adminBtn, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        add(new JLabel("Utilisateur : "), gbc);
        gbc.gridx = 1;
        add(usersCombo, gbc);

        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        JButton userBtn = new JButton("Se connecter comme Utilisateur");
        userBtn.addActionListener(e -> {
            User u = (User) usersCombo.getSelectedItem();
            if (u != null) onUserLogin.accept(u);
        });
        add(userBtn, gbc);

        gbc.gridy++;
        JLabel hint = new JLabel("<html><i>Deux utilisateurs de démo sont préchargés.</i></html>");
        add(hint, gbc);

        refreshUsers();
        usersCombo.setRenderer(new UserRenderer());
    }

    public void refreshUsers() {
        usersCombo.removeAllItems();
        for (User u : service.getUsers()) usersCombo.addItem(u);
    }
}
