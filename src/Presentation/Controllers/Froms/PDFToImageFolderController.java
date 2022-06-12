package Presentation.Controllers.Froms;

import Presentation.Controllers.FormRunInterface;
import Presentation.Views.PDFToImageFolder;

import javax.swing.*;
import java.util.ArrayList;

public class PDFToImageFolderController implements FormRunInterface {

    PDFToImageFolder pdfToImageFolder;

    public PDFToImageFolderController(JButton bGoBack) {
        this.pdfToImageFolder = new PDFToImageFolder(bGoBack, this);
    }

    public PDFToImageFolder getPdfToImageFolder() {
        return pdfToImageFolder;
    }


    public void run(ArrayList<String> values) {
        clearForm();
        //TODO: run convert
    }

    public void clearForm() {
        pdfToImageFolder.clearForm();
    }
}