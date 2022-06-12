package Presentation.Controllers.Froms;

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
        //TODO: run convert
    }

    public void clearForm() {
        convertImageFolder.clearForm();
    }
}