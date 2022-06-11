package Presentation.Components;

import Presentation.Enums.Colors;
import Presentation.Enums.Fonts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Header extends JPanel {

    public Header(JButton leftButton, String line1, String line2, String line3) {
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        add(button(leftButton), BorderLayout.WEST);
        add(title(line1, line2), BorderLayout.CENTER);
        add(blank(), BorderLayout.EAST);
        add(lastLine(line3), BorderLayout.SOUTH);
    }

    public Header(String line1, String line2, String line3) {
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        add(blank(), BorderLayout.WEST);
        add(title(line1, line2), BorderLayout.CENTER);
        add(blank(), BorderLayout.EAST);
        add(lastLine(line3), BorderLayout.SOUTH);
    }

    private JPanel button(JButton leftButton) {
        JPanel goBack = new JPanel();
        goBack.setSize(new Dimension(100, 100));
        goBack.setBackground(Colors.WHITE);

        goBack.setLayout(new FlowLayout(FlowLayout.LEFT));
        goBack.add(leftButton);

        return goBack;
    }

    private JPanel title(String line1, String line2) {
        JPanel title = new JPanel();
        title.setLayout(new BoxLayout(title, BoxLayout.Y_AXIS));
        title.setBackground(Colors.WHITE);

        JLabel lTitle = new JLabel(line1);
        lTitle.setFont(Fonts.H1);
        lTitle.setForeground(Colors.PRIMARY);
        lTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lSubtitle = new JLabel(line2);
        lSubtitle.setFont(Fonts.I);
        lSubtitle.setForeground(Colors.TERTIARY);
        lSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.add(lTitle);
        title.add(lSubtitle);

        title.setBackground(Colors.WHITE);
        return title;
    }

    private JPanel lastLine(String line3){
        JPanel lastLine = new JPanel();
        lastLine.setLayout(new BoxLayout(lastLine, BoxLayout.Y_AXIS));
        lastLine.setBackground(Colors.WHITE);

        JLabel lTitle = new JLabel("<html>"+ line3 +"</html>");
        lTitle.setFont(Fonts.H5);
        lTitle.setForeground(Colors.GREY);
        lTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        lastLine.add(lTitle);

        lastLine.setBorder(new EmptyBorder( 30, 50, 5, 50));

        return lastLine;
    }

    private JPanel blank() {
        JPanel blank = new JPanel();
        blank.setBackground(Colors.WHITE);
        blank.setSize(new Dimension(100, 100));
        blank.setBorder(new EmptyBorder( 0, 50, 0, 50));
        return blank;
    }
}
