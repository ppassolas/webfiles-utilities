package Presentation.Controllers.Froms;

import Presentation.Controllers.FormRunInterface;
import Presentation.Views.PDFToImageFile;

import javax.swing.*;
import java.util.ArrayList;

public class PDFToImageFileController implements FormRunInterface {

    PDFToImageFile pdfToImageFile;

    public PDFToImageFileController(JButton bGoBack) {
        this.pdfToImageFile = new PDFToImageFile(bGoBack, this);
    }

    public PDFToImageFile getPdfToImageFile() {
        return pdfToImageFile;
    }


    public void run(ArrayList<String> values) {
        clearForm();
        //TODO: run convert
    }

    public void clearForm(){
        pdfToImageFile.clearForm();
    }
}