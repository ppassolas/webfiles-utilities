package Presentation.Controllers.Froms;

import Business.Converter;
import Presentation.Controllers.FormRunInterface;
import Presentation.Views.PDFToImageFile;

import javax.swing.*;
import java.util.ArrayList;

public class PDFToImageFileController implements FormRunInterface {

    PDFToImageFile pdfToImageFile;
    Converter converter;

    public PDFToImageFileController(JButton bGoBack, Converter c) {
        this.pdfToImageFile = new PDFToImageFile(bGoBack, this);
        this.converter = c;
    }

    public PDFToImageFile getPdfToImageFile() {
        return pdfToImageFile;
    }


    public void run(ArrayList<String> values) {
        clearForm();
        Converter.generateCoverOfPdfFile(values.get(2), values.get(3), Integer.parseInt(values.get(0)), Integer.parseInt(values.get(1)));
    }

    public void clearForm() {
        pdfToImageFile.clearForm();
    }
}