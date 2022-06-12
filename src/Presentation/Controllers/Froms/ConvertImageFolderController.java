package Presentation.Controllers.Froms;

import Business.Converter;
import Presentation.Controllers.FormRunInterface;
import Presentation.Views.ConvertImageFolder;

import javax.swing.*;
import java.util.ArrayList;

public class ConvertImageFolderController implements FormRunInterface {

    ConvertImageFolder convertImageFolder;

    public ConvertImageFolderController(JButton bGoBack) {
        this.convertImageFolder = new ConvertImageFolder(bGoBack, this);
    }

    public ConvertImageFolder getConvertImageFolder() {
        return convertImageFolder;
    }


    public void run(ArrayList<String> values) {
        clearForm();
        Converter.convertImagesFromFolder(values.get(2), values.get(3), Integer.parseInt(values.get(0)), Integer.parseInt(values.get(1)));
    }

    public void clearForm() {
        convertImageFolder.clearForm();
    }
}