package Presentation.Views;

import Presentation.Controllers.FormController;
import Presentation.Controllers.FormRunInterface;
import Presentation.Enums.FormElementType;

import javax.swing.*;

public class ConvertImageFolder extends JPanel {

    private FormRunInterface fromImplementation;

    public ConvertImageFolder(JButton goBackButton, FormRunInterface fromImplementation) {
        FormController formController = new FormController("Convert Image Folder", fromImplementation);

        formController.addElement("New width (px)", true, FormElementType.NUMBER_FIELD);
        formController.addElement("New height (px)", true, FormElementType.NUMBER_FIELD);
        formController.addElement("Select folder", true, FormElementType.PATH_FOLDER_SELECTOR);
        formController.addComboBox("Select type", true, new String[]{"jpg", "webp", "png", "gif"});
        formController.addRunButton("Convert");
        add(goBackButton);
        add(formController.getForm());

    }

}
