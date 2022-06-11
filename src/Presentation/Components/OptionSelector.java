package Presentation.Components;

import Presentation.Enums.Colors;
import Presentation.Enums.Fonts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class OptionSelector extends JPanel {

    public static class Option {
        String label;
        JButton button;

        public Option(String label, JButton button) {
            this.label = label;
            this.button = button;
        }
    }

    public OptionSelector(ArrayList<Option> options) {
        GridLayout layout = new GridLayout(2, options.size());
        setLayout(layout);
        setBackground(Colors.WHITE);


        for (Option option : options) {
            add(createButtonBlock(option.button));
        }

        for (Option option : options) {
            add(createLabelBlock(option.label));
        }
    }


    private JPanel createButtonBlock(JButton button) {
        JPanel panel = new JPanel();
        panel.setBackground(Colors.WHITE);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));
        panel.add(button);
        return panel;
    }

    private JLabel createLabelBlock(String sLabel) {
        JLabel label = new JLabel("<html>" + sLabel + "</html>");
        label.setFont(Fonts.P);
        label.setBorder(new EmptyBorder(0, 40, 10, 40));
        label.setVerticalAlignment(JLabel.NORTH);
        return label;
    }
}
