package Presentation.Views;

import Business.Enums.DefaultValues;
import Presentation.Components.Header;
import Presentation.Controllers.FormController;
import Presentation.Controllers.FormRunInterface;
import Presentation.Enums.FormElementType;

import javax.swing.*;

public class ConvertImageFile extends JPanel {

    FormController formController;

    public ConvertImageFile(JButton goBackButton, FormRunInterface fromImplementation) {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        formController = new FormController("Convert Image File", fromImplementation);

        formController.addElement("New width (px)", true, FormElementType.NUMBER_FIELD);
        formController.addElement("New height (px)", true, FormElementType.NUMBER_FIELD);
        formController.addElement("Select file", true, FormElementType.PATH_IMAGE_SELECTOR);
        formController.addComboBox("Select type", true, DefaultValues.IMG_TYPES);
        formController.addRunButton("Convert");
        Header header = new Header(goBackButton);
        add(header);
        add(formController.getForm());
    }

    public void clearForm() {
        formController.clearForm();
    }


}
