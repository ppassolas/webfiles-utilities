package Presentation.Controllers;

import Presentation.Views.ConvertImageFolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static Presentation.Views.SelectMode.ABOUT;

public class ConvertImageFolderController implements FormRunInterface {

    ConvertImageFolder convertImageFolder;

    public ConvertImageFolderController(JButton bGoBack) {
        this.convertImageFolder = new ConvertImageFolder(bGoBack, this);
    }

    public ConvertImageFolder getConvertImageFolder() {
        return convertImageFolder;
    }


    public void run() {
        System.out.println("ConvertImageFolderController.run()");
    }
}