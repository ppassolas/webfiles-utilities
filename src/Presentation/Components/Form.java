package Presentation.Components;

import Business.Enums.DefaultValues;
import Presentation.Enums.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class Form extends JPanel {
    private final ActionListener actionListener;

    JLabel title;

    int elementCount = 0;
    ArrayList<Parameter> parameters = new ArrayList<>();
    JButton[] buttons = new JButton[18];

    public final static String RUN = "Run";


    private class Parameter {
        int position;
        JLabel label;
        boolean isMandatory;
        JComponent component;
        FormElementType type;

        Parameter(int position, String label, boolean isMandatory, FormElementType elementType) {
            this.position = position;
            this.label = new JLabel(label);
            this.isMandatory = isMandatory;
            this.type = elementType;
            this.component = createComponent(this.type, this.position, label);
        }

        private JComponent createComponent(FormElementType elementType, int position, String label) {
            JComponent component = null;
            switch (elementType) {
                case TEXT_FIELD -> component = new JTextField();
                case NUMBER_FIELD -> {
                    SpinnerModel model;
                    if (label.toLowerCase().contains("width"))
                        model = new SpinnerNumberModel(DefaultValues.DEFAULT_WIDTH, DefaultValues.MIN_WIDTH, DefaultValues.MAX_WIDTH, 1);
                    else
                        model = new SpinnerNumberModel(DefaultValues.DEFAULT_HEIGHT, DefaultValues.MIN_HEIGHT, DefaultValues.MAX_HEIGHT, 1);
                    component = new JSpinner(model);
                }
                case TEXT_AREA -> component = new JTextArea();
                case COMBO_BOX -> component = new JComboBox<>();
                case PATH_IMAGE_SELECTOR, PATH_PDF_SELECTOR, PATH_FOLDER_SELECTOR -> {
                    JButton button = new Button(DefaultValues.SELECT_PATH, ButtonType.TERTIARY, ButtonSize.SMALL);
                    button.addActionListener(actionListener);
                    button.setActionCommand(String.valueOf(position));
                    buttons[position] = button;
                    component = button;
                }
            }
            return component;
        }
    }

    public void addComboBox(String label, boolean isMandatory, String[] options) {
        if (elementCount >= 17) return;
        Parameter parameter = new Parameter(elementCount, label, isMandatory, FormElementType.COMBO_BOX);
        parameters.add(parameter);
        setNewParameterBounds(parameter);
        JComboBox box = (JComboBox) parameter.component;
        for (String option : options) {
            box.addItem(option);
        }
        this.add(parameter.label);
        this.add(parameter.component);
        elementCount++;
    }

    public void addElement(String label, boolean isMandatory, FormElementType elementType) {
        if (elementCount >= 17) return;
        Parameter parameter = new Parameter(elementCount, label, isMandatory, elementType);
        parameters.add(parameter);
        setNewParameterBounds(parameter);
        this.add(parameter.label);
        this.add(parameter.component);
        elementCount++;
    }

    public void addRunButton(String text) {
        JButton runButton = new Button(text, ButtonType.PRIMARY, ButtonSize.SMALL);
        runButton.addActionListener(actionListener);
        runButton.setActionCommand(RUN);
        runButton.setBounds(400, 460, 200, 30);
        this.add(runButton);
    }

    public Form(String title, ActionListener listener) {
        this.actionListener = listener;
        setPreferredSize(new Dimension(DefaultValues.FRAME_WIDTH, DefaultValues.FRAME_HEIGHT - 100));
        setLayout(null);
        this.title = new JLabel(title);
        this.title.setFont(Fonts.H4);
        this.title.setBounds(50, 10, 600, 30);
        this.add(this.title);
        this.setBackground(Colors.WHITE);
    }

    private void setNewParameterBounds(Parameter parameter) {
        int x = 50;
        int y = 60;
        int width = 120;
        int height = 30;
        int formYPosition = parameter.position;

        if (parameter.position >= 9) {
            x = 450;
            formYPosition = parameter.position - 9;
        }

        y = y + (formYPosition * 50);
        parameter.label.setBounds(x, y, width, height);
        parameter.component.setBounds(x + 100, y, width * 2, height);
    }


    public void buttonClicked(String command) {
        int selected = Integer.parseInt(command);
        String path = new PathSelector(parameters.get(selected).type).getSelected();
        if (!path.isEmpty()) buttons[selected].setText(path);
    }

    public ArrayList<String> getValues() {
        ArrayList<String> values = new ArrayList<>();
        for (Parameter parameter : parameters) {

            String value = "";
            switch (parameter.type) {
                case TEXT_FIELD -> {
                    value = ((JTextField) parameter.component).getText();
                }
                case NUMBER_FIELD -> {
                    value = ((JSpinner) parameter.component).getValue().toString();
                }
                case TEXT_AREA -> {
                    value = ((JTextArea) parameter.component).getText();
                }
                case COMBO_BOX -> {
                    value = Objects.requireNonNull(((JComboBox<String>) parameter.component).getSelectedItem()).toString();
                }
                case PATH_IMAGE_SELECTOR, PATH_PDF_SELECTOR, PATH_FOLDER_SELECTOR -> {
                    value = buttons[parameter.position].getText();
                    if (value.contains(DefaultValues.SELECT_PATH)) value = "";
                }
            }
            if (parameter.isMandatory && value.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all mandatory fields");
                return new ArrayList<>();
            }
            values.add(value);
        }
        return values;
    }

    public void clearForm() {
        for (Parameter parameter : parameters) {
            switch (parameter.type) {
                case TEXT_FIELD -> {
                    ((JTextField) parameter.component).setText("");
                }
                case NUMBER_FIELD -> {
                    if (((JLabel) parameter.label).getText().toLowerCase().contains("width"))
                        ((JSpinner) parameter.component).setValue(DefaultValues.DEFAULT_WIDTH);
                    else ((JSpinner) parameter.component).setValue(DefaultValues.DEFAULT_HEIGHT);
                }
                case TEXT_AREA -> {
                    ((JTextArea) parameter.component).setText("");
                }
                case COMBO_BOX -> {
                    ((JComboBox<String>) parameter.component).setSelectedIndex(0);
                }
                case PATH_IMAGE_SELECTOR, PATH_PDF_SELECTOR, PATH_FOLDER_SELECTOR -> {
                    buttons[parameter.position].setText(DefaultValues.SELECT_PATH);
                }
            }
        }
    }


}

