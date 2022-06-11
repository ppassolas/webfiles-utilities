package Presentation.Controllers;

import Presentation.Views.PDFtoImage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PDFToImageController implements ActionListener {

    PDFtoImage pdFtoImage;

    public PDFToImageController(JButton bGoToPDFtoImageFolder, JButton bGoToPDFtoImageFile, JButton bGoToMain) {
        this.pdFtoImage = new PDFtoImage(bGoToPDFtoImageFolder, bGoToPDFtoImageFile, bGoToMain, this);
    }

    public PDFtoImage getPDFToImage() {
        return pdFtoImage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {


        }
    }
}