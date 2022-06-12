package Presentation.Components;

import Presentation.Enums.ButtonSize;
import Presentation.Enums.ButtonType;
import Presentation.Enums.Colors;
import Presentation.Enums.Fonts;

import javax.swing.*;

public class Button extends JButton {

    public Button(String text, ButtonType type, ButtonSize size) {
        super(text);
        switch (type) {
            case PRIMARY -> {
                setBackground(Colors.PRIMARY);
                setForeground(Colors.WHITE);
            }
            case SECONDARY -> {
                setBackground(Colors.SECONDARY);
                setForeground(Colors.WHITE);
            }
            case TERTIARY -> {
                setBackground(Colors.TERTIARY);
                setForeground(Colors.WHITE);
            }
        }
        switch (size) {
            case SMALL -> {
                setFont(Fonts.H6);
                setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            }
            case MEDIUM -> {
                setFont(Fonts.H3);
                setBorder(BorderFactory.createEmptyBorder(12, 30, 12, 30));
            }
            case LARGE -> {
                setFont(Fonts.H1);
                setBorder(BorderFactory.createEmptyBorder(15, 40, 15, 40));
            }
        }

        setFocusPainted(false);
    }


}
