package Presentation.Views;

import Business.DefaultValues;
import Presentation.Components.Header;
import Presentation.Controllers.FormController;
import Presentation.Controllers.FormRunInterface;
import Presentation.Enums.FormElementType;

import javax.swing.*;

public class ConvertImageFolder extends JPanel {

    private  FormController formController;

    public ConvertImageFolder(JButton goBackButton, FormRunInterface fromImplementation) {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        formController = new FormController("Convert Image Folder", fromImplementation);

        formController.addElement("New width (px)", true, FormElementType.NUMBER_FIELD);
        formController.addElement("New height (px)", true, FormElementType.NUMBER_FIELD);
        formController.addElement("Select folder", true, FormElementType.PATH_FOLDER_SELECTOR);
        formController.addComboBox("Select type", true,  DefaultValues.IMG_TYPES);
        formController.addRunButton("Convert");
        Header header = new Header(goBackButton);
        add(header);
        add(formController.getForm());
    }

    public void clearForm() {
        formController.clearForm();
    }

}
