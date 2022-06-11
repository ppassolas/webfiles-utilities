package Presentation.Controllers;

import Presentation.Views.ConvertImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static Presentation.Views.SelectMode.ABOUT;

public class ConvertImageController implements ActionListener {

    ConvertImage convertImage;

    public ConvertImageController(JButton bGoToConvertImageFolder, JButton bGoToConvertImageFile, JButton bGoToMain) {
        this.convertImage = new ConvertImage(bGoToConvertImageFolder, bGoToConvertImageFile, bGoToMain, this);
    }

    public ConvertImage getConvertImage() {
        return convertImage;
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