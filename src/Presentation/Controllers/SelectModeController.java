package Presentation.Controllers;

import Presentation.Views.SelectMode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static Presentation.Views.SelectMode.ABOUT;

public class SelectModeController implements ActionListener {

    SelectMode selectMode;


    public SelectModeController(JButton bGotoPDFToImage, JButton bGoToConvertImage) {
        this.selectMode = new SelectMode(bGotoPDFToImage, bGoToConvertImage, this);
    }

    public SelectMode getSelectMode() {
        return selectMode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case ABOUT -> {
                synchronized (this) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://aiplimpulsa.com/"));
                    } catch (IOException | URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }
}