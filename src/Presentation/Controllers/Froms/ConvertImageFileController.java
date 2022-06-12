package Presentation.Controllers.Froms;

import Business.Converter;
import Presentation.Controllers.FormRunInterface;
import Presentation.Views.ConvertImageFile;

import javax.swing.*;
import java.util.ArrayList;

public class ConvertImageFileController implements FormRunInterface {

    ConvertImageFile convertImageFile;

    public ConvertImageFileController(JButton bGoBack) {
        this.convertImageFile = new ConvertImageFile(bGoBack, this);
    }

    public ConvertImageFile getConvertImageFile() {
        return convertImageFile;
    }


    public void run(ArrayList<String> values) {
        clearForm();
        Converter.convertImagesFromFile(values.get(2), values.get(3), Integer.parseInt(values.get(0)), Integer.parseInt(values.get(1)));
    }

    public void clearForm() {
        convertImageFile.clearForm();
    }
}