import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {
    private final TicketService service;
    private final Runnable onLogout;

    private final DefaultListModel<Ticket> ticketModel = new DefaultListModel<>();
    private final JList<Ticket> ticketList = new JList<>(ticketModel);

    private final JComboBox<User> userCombo = new JComboBox<>();
    private final JComboBox<Status> statusCombo = new JComboBox<>(Status.values());
    private final JComboBox<DescriptionType> descTypeCombo = new JComboBox<>(DescriptionType.values());
    private final DefaultListModel<Description> descModel = new DefaultListModel<>();
    private final JList<Description> descList = new JList<>(descModel);

    public AdminPanel(TicketService service, Runnable onLogout) {
        this.service = service;
        this.onLogout = onLogout;

        setLayout(new BorderLayout(10,10));

        // Top bar
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton refreshBtn = new JButton("Rafraîchir");
        refreshBtn.addActionListener(e -> refreshAll());
        JButton logoutBtn = new JButton("Déconnexion");
        logoutBtn.addActionListener(e -> onLogout.run());
        top.add(refreshBtn);
        top.add(logoutBtn);
        add(top, BorderLayout.NORTH);

        // Center: split tickets / descriptions
        ticketList.setVisibleRowCount(12);
        ticketList.setCellRenderer(new TicketRenderer());
        ticketList.addListSelectionListener(e -> refreshDescriptions());

        JSplitPane center = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(ticketList),
                buildRightPanel()
        );
        center.setResizeWeight(0.55);
        add(center, BorderLayout.CENTER);
    }

    private JPanel buildRightPanel() {
        JPanel right = new JPanel(new BorderLayout(8,8));

        // Actions
        JPanel actions = new JPanel();
        actions.setLayout(new BoxLayout(actions, BoxLayout.Y_AXIS));

        // Assigner
        JPanel assign = new JPanel(new FlowLayout(FlowLayout.LEFT));
        assign.add(new JLabel("Assigner à :"));
        assign.add(userCombo);
        JButton assignBtn = new JButton("Assigner");
        assignBtn.addActionListener(e -> {
            Ticket t = ticketList.getSelectedValue();
            User u = (User) userCombo.getSelectedItem();
            if (t != null && u != null) {
                service.assignTicket(t.getTicketID(), u);
                refreshAll();
                ticketList.setSelectedValue(service.findById(t.getTicketID()), true);
            }
        });
        assign.add(assignBtn);
        actions.add(assign);

        // Statut
        JPanel stat = new JPanel(new FlowLayout(FlowLayout.LEFT));
        stat.add(new JLabel("Statut :"));
        stat.add(statusCombo);
        JButton statusBtn = new JButton("Changer");
        statusBtn.addActionListener(e -> {
            Ticket t = ticketList.getSelectedValue();
            Status s = (Status) statusCombo.getSelectedItem();
            if (t != null && s != null) {
                service.changeStatus(t.getTicketID(), s);
                refreshAll();
                ticketList.setSelectedValue(service.findById(t.getTicketID()), true);
            }
        });
        stat.add(statusBtn);
        actions.add(stat);

        // Fermer
        JButton closeBtn = new JButton("Fermer le ticket sélectionné");
        closeBtn.addActionListener(e -> {
            Ticket t = ticketList.getSelectedValue();
            if (t != null) {
                service.closeTicket(t.getTicketID());
                refreshAll();
            }
        });
        actions.add(closeBtn);

        // Créer utilisateur
        JButton newUserBtn = new JButton("Créer un utilisateur…");
        newUserBtn.addActionListener(e -> createUserDialog());
        actions.add(newUserBtn);

        // Ajouter description
        JPanel addDesc = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField descField = new JTextField(28);
        addDesc.add(new JLabel("Description :"));
        addDesc.add(descField);
        addDesc.add(descTypeCombo);
        JButton addDescBtn = new JButton("Ajouter");
        addDescBtn.addActionListener(e -> {
            Ticket t = ticketList.getSelectedValue();
            if (t != null && !descField.getText().isBlank()) {
                service.addDescriptionAsAdmin(t.getTicketID(),
                        (DescriptionType) descTypeCombo.getSelectedItem(),
                        descField.getText());
                descField.setText("");
                refreshDescriptions();
            }
        });
        addDesc.add(addDescBtn);
        actions.add(addDesc);

        right.add(actions, BorderLayout.NORTH);

        // Liste des descriptions
        descList.setVisibleRowCount(10);
        descList.setCellRenderer(new DescriptionRenderer());
        right.add(new JScrollPane(descList), BorderLayout.CENTER);

        return right;
    }

    private void createUserDialog() {
        JTextField name = new JTextField();
        JTextField email = new JTextField();
        JTextField role = new JTextField("DEV");

        int ok = JOptionPane.showConfirmDialog(this,
                new Object[]{"Nom :", name, "Email :", email, "Rôle :", role},
                "Nouvel utilisateur", JOptionPane.OK_CANCEL_OPTION);
        if (ok == JOptionPane.OK_OPTION) {
            service.addUser(name.getText().trim(), email.getText().trim(), role.getText().trim());
            refreshAll();
        }
    }

    public void refreshAll() {
        ticketModel.clear();
        for (Ticket t : service.getTickets()) ticketModel.addElement(t);

        userCombo.removeAllItems();
        for (User u : service.getUsers()) userCombo.addItem(u);

        refreshDescriptions();
    }

    private void refreshDescriptions() {
        descModel.clear();
        Ticket t = ticketList.getSelectedValue();
        if (t == null) return;
        for (Description d : service.getDescriptions(t.getTicketID())) descModel.addElement(d);
    }
}
