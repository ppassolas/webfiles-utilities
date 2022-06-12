package Presentation.Views;

import Business.DefaultValues;
import Presentation.Components.Button;
import Presentation.Components.Header;
import Presentation.Components.OptionSelector;
import Presentation.Enums.ButtonSize;
import Presentation.Enums.ButtonType;
import Presentation.Enums.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectMode extends JPanel {

    private ActionListener listener;
    JButton bGotoPDFToImage;
    JButton bGoToConvertImage;
    JButton bAbout;

    public static final String ABOUT = "About";

    public SelectMode(JButton bGotoPDFToImage, JButton bGoToConvertImage, ActionListener listener) {
        this.bGotoPDFToImage = bGotoPDFToImage;
        this.bGoToConvertImage = bGoToConvertImage;
        this.listener = listener;

        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        setBackground(Colors.WHITE);

        Header header = new Header(DefaultValues.TITLE ,"By: AIPL Impulsa SL", "Select mode:");
        add(header, BorderLayout.NORTH);

        ArrayList<OptionSelector.Option> options = new ArrayList<>();
        options.add(new OptionSelector.Option("PDFS TO IMAGES", bGotoPDFToImage));
        options.add(new OptionSelector.Option("CONVERT IMAGE", bGoToConvertImage));

        JPanel pButtons = new OptionSelector(options);
        pButtons.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(pButtons, BorderLayout.CENTER);
        add(about(), BorderLayout.SOUTH);
    }


    private JPanel about() {
        JPanel about = new JPanel();
        about.setLayout(new FlowLayout());
        about.setBackground(Colors.WHITE);
        bAbout = new Button("About", ButtonType.SECONDARY, ButtonSize.SMALL);
        bAbout.setActionCommand(ABOUT);
        bAbout.addActionListener(listener);
        about.add(bAbout);
        return about;
    }

}
