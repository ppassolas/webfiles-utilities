package Presentation.Controllers.Froms;

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
        //TODO: run convert
    }

    public void clearForm(){
        convertImageFile.clearForm();
    }
}