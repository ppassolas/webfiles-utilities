package Presentation.Controllers;

import Presentation.Components.Form;
import Presentation.Enums.FormElementType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Presentation.Components.Form.RUN;


public class FormController implements ActionListener {
    private Form form;
    private FormRunInterface fromImplementation;

    public FormController(String title, FormRunInterface fromImplementation) {
        this.form = new Form(title, this);
        this.fromImplementation = fromImplementation;
    }

    public Form getForm() {
        return form;
    }

    public void addElement(String label, boolean isRequired, FormElementType type) {
        form.addElement(label, isRequired, type);
    }

    public void addComboBox(String label, boolean isRequired, String[] options) {
        form.addComboBox(label, isRequired, options);
    }

    public void addRunButton(String text) {
        form.addRunButton(text);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (RUN.equals(e.getActionCommand())) {
            ArrayList<String> values = form.getValues();
            if (values.size() > 0) {
                fromImplementation.run(values);
            }
        } else {
            form.buttonClicked(command);
        }
    }

    public void clearForm() {
        form.clearForm();
    }
}
