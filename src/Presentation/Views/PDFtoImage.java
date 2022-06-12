package Presentation.Views;

import Presentation.Components.Header;
import Presentation.Components.OptionSelector;
import Presentation.Enums.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PDFtoImage extends JPanel {

    private ActionListener actionListener;
    JButton bGoToPDFtoImageFolder;
    JButton bGoToPDFtoImageFile;
    JButton bGoToMain;

    public PDFtoImage(JButton bGoToPDFtoImageFolder, JButton bGoToPDFtoImageFile, JButton bGoToMain, ActionListener actionListener) {
        this.bGoToPDFtoImageFolder = bGoToPDFtoImageFolder;
        this.bGoToPDFtoImageFile = bGoToPDFtoImageFile;
        this.bGoToMain = bGoToMain;
        this.actionListener = actionListener;


        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        setBackground(Colors.WHITE);

        Header header = new Header(bGoToMain, "CONVERT PDF TO IMAGE", "By: AIPL Impulsa SL", "<html>Choose if you want to convert an entire directory or only one file:</html>");
        add(header, BorderLayout.NORTH);


        ArrayList<OptionSelector.Option> options = new ArrayList<>();
        options.add(new OptionSelector.Option("CONVERT A FILE", bGoToPDFtoImageFile));
        options.add(new OptionSelector.Option("CONVERT AN ENTIRE FOLDER", bGoToPDFtoImageFolder));

        JPanel pButtons = new OptionSelector(options);
        pButtons.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(pButtons, BorderLayout.CENTER);

    }

}
