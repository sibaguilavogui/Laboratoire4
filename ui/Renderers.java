import javax.swing.*;
import java.awt.*;

// Affichage "101 — Alice"
class UserRenderer extends DefaultListCellRenderer {
    @Override public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof User u) setText(u.getUserID() + " — " + u.getName());
        return this;
    }
}

// Affichage "#1000 — Titre [STATUT, PRIO] → AssignéA"
class TicketRenderer extends DefaultListCellRenderer {
    @Override public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Ticket t) {
            String who = (t.getAssignedUser() == null) ? "non assigné" : t.getAssignedUser().getName();
            setText("#" + t.getTicketID() + " — " + t.getTitle() + "  [" + t.getStatus() + ", " + t.getPriority() + "]  → " + who);
        }
        return this;
    }
}

// Affichage "• TEXTE : contenu…"
class DescriptionRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Description d) {
            String content;
            if (d.getType() == DescriptionType.TEXTE) {
                content = d.getText();
            } else {
                content = d.getUri();
            }
            String author = (d.getAddedBy() != null) ? d.getAddedBy().getName() : "inconnu";
            setText("• " + d.getType() + " : " + content + "  (par " + author + ")");
        }
        return this;
    }
}
