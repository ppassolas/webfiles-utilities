package Presentation.Views;

import Presentation.Components.Header;
import Presentation.Components.OptionSelector;
import Presentation.Enums.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConvertImage extends JPanel {

    private ActionListener actionListener;
    JButton bGoToConvertImageFolder;
    JButton bGoToConvertImageFile;
    JButton bGotoMain;

    public ConvertImage(JButton bGoToConvertImageFolder, JButton bGoToConvertImageFile, JButton bGoToMain, ActionListener actionListener) {
        this.bGoToConvertImageFolder = bGoToConvertImageFolder;
        this.bGoToConvertImageFile = bGoToConvertImageFile;
        this.bGotoMain = bGoToMain;
        this.actionListener = actionListener;

        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        setBackground(Colors.WHITE);

        Header header = new Header(bGoToMain, "CONVERT IMAGE", "", "Choose if you want to convert an entire directory or only one file:");
        add(header, BorderLayout.NORTH);

        ArrayList<OptionSelector.Option> options = new ArrayList<>();
        options.add(new OptionSelector.Option("CONVERT A FILE", bGoToConvertImageFile));
        options.add(new OptionSelector.Option("CONVERT AN ENTIRE FOLDER", bGoToConvertImageFolder));

        JPanel pButtons = new OptionSelector(options);
        pButtons.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(pButtons, BorderLayout.CENTER);
    }
}
