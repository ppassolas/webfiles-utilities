package Presentation.Controllers.Froms;

import Business.Converter;
import Presentation.Controllers.FormRunInterface;
import Presentation.Views.PDFToImageFolder;

import javax.swing.*;
import java.util.ArrayList;

public class PDFToImageFolderController implements FormRunInterface {

    PDFToImageFolder pdfToImageFolder;
    Converter converter;

    public PDFToImageFolderController(JButton bGoBack, Converter c) {
        this.pdfToImageFolder = new PDFToImageFolder(bGoBack, this);
        this.converter = c;
    }

    public PDFToImageFolder getPdfToImageFolder() {
        return pdfToImageFolder;
    }


    public void run(ArrayList<String> values) {
        clearForm();
        Converter.generateCoversOfPdfsFromFolder(values.get(2), values.get(3), Integer.parseInt(values.get(0)), Integer.parseInt(values.get(1)));

    }

    public void clearForm() {
        pdfToImageFolder.clearForm();
    }
}