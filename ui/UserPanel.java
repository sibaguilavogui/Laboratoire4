import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {
    private final TicketService service;
    private final Runnable onLogout;

    private User currentUser;

    private final DefaultListModel<Ticket> myModel = new DefaultListModel<>();
    private final JList<Ticket> myList = new JList<>(myModel);

    private final DefaultListModel<Ticket> allModel = new DefaultListModel<>();
    private final JList<Ticket> allList = new JList<>(allModel);

    private final DefaultListModel<Description> descModel = new DefaultListModel<>();
    private final JList<Description> descList = new JList<>(descModel);

    private final JComboBox<Priority> prioCombo = new JComboBox<>(Priority.values());
    private final JComboBox<Status> statusCombo = new JComboBox<>(Status.values());
    private final JComboBox<DescriptionType> descTypeCombo = new JComboBox<>(DescriptionType.values());

    public UserPanel(TicketService service, Runnable onLogout) {
        this.service = service;
        this.onLogout = onLogout;

        setLayout(new BorderLayout(10,10));

        // top bar
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton refreshBtn = new JButton("Rafraîchir");
        refreshBtn.addActionListener(e -> refreshAll());
        JButton logoutBtn = new JButton("Déconnexion");
        logoutBtn.addActionListener(e -> onLogout.run());
        top.add(refreshBtn); top.add(logoutBtn);
        add(top, BorderLayout.NORTH);

        // left: mes tickets
        myList.setCellRenderer(new TicketRenderer());
        myList.addListSelectionListener(e -> refreshDescriptions());

        // right: tous les tickets (lecture seule)
        allList.setCellRenderer(new TicketRenderer());

        JSplitPane splitLists = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(myList), new JScrollPane(allList));
        splitLists.setResizeWeight(0.5);

        // bottom-right: descriptions du ticket sélectionné (à gauche)
        descList.setCellRenderer(new DescriptionRenderer());
        JPanel rightBottom = new JPanel(new BorderLayout(6,6));
        rightBottom.add(new JLabel("Descriptions du ticket sélectionné"), BorderLayout.NORTH);
        rightBottom.add(new JScrollPane(descList), BorderLayout.CENTER);

        JSplitPane center = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitLists, rightBottom);
        center.setResizeWeight(0.6);
        add(center, BorderLayout.CENTER);

        // bottom: actions utilisateur
        JPanel bottom = new JPanel(new GridLayout(3,1,8,8));

        // Créer un ticket
        JPanel create = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField titleField = new JTextField(30);
        create.add(new JLabel("Titre :"));
        create.add(titleField);
        create.add(new JLabel("Priorité :"));
        create.add(prioCombo);
        JButton createBtn = new JButton("Créer");
        createBtn.addActionListener(e -> {
            String title = titleField.getText().trim();
            if (currentUser != null && !title.isBlank()) {
                Ticket t = service.createTicket(currentUser, title, (Priority) prioCombo.getSelectedItem());
                refreshAll();
                myList.setSelectedValue(t, true);
                titleField.setText("");
            }
        });
        create.add(createBtn);
        bottom.add(create);

        // Commentaire + statut
        JPanel edit = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField commentField = new JTextField(38);
        JButton addCommentBtn = new JButton("Ajouter commentaire");
        addCommentBtn.addActionListener(e -> {
            Ticket t = myList.getSelectedValue();
            if (t != null) {
                service.addComment(t.getTicketID(), commentField.getText());
                commentField.setText("");
                refreshAll();
                myList.setSelectedValue(service.findById(t.getTicketID()), true);
            }
        });
        edit.add(new JLabel("Commentaire :"));
        edit.add(commentField);
        edit.add(addCommentBtn);
        edit.add(new JLabel("Statut :"));
        edit.add(statusCombo);
        JButton statusBtn = new JButton("Changer statut");
        statusBtn.addActionListener(e -> {
            Ticket t = myList.getSelectedValue();
            Status s = (Status) statusCombo.getSelectedItem();
            if (t != null && s != null) {
                service.changeStatus(t.getTicketID(), s);
                refreshAll();
                myList.setSelectedValue(service.findById(t.getTicketID()), true);
            }
        });
        edit.add(statusBtn);
        bottom.add(edit);

        // Ajouter description
        JPanel addDesc = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField descField = new JTextField(40);
        addDesc.add(new JLabel("Description :"));
        addDesc.add(descField);
        addDesc.add(descTypeCombo);
        JButton addDescBtn = new JButton("Ajouter description");
        addDescBtn.addActionListener(e -> {
            Ticket t = myList.getSelectedValue();
            if (t != null && !descField.getText().isBlank()) {
                service.addDescriptionAsUser(t.getTicketID(),
                        (DescriptionType) descTypeCombo.getSelectedItem(),
                        descField.getText(),
                        currentUser);

                descField.setText("");
                refreshDescriptions();
            }
        });
        addDesc.add(addDescBtn);
        bottom.add(addDesc);

        add(bottom, BorderLayout.SOUTH);
    }

    public void setCurrentUser(User u) { this.currentUser = u; }

    public void refreshAll() {
        myModel.clear();
        if (currentUser != null) {
            for (Ticket t : service.ticketsAssignedTo(currentUser)) myModel.addElement(t);
        }
        allModel.clear();
        for (Ticket t : service.getTickets()) allModel.addElement(t);
        refreshDescriptions();
    }

    private void refreshDescriptions() {
        descModel.clear();
        Ticket t = myList.getSelectedValue();
        if (t == null) return;
        for (Description d : service.getDescriptions(t.getTicketID())) descModel.addElement(d);
    }
}
