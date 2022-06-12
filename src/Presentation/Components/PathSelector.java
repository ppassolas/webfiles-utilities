package Presentation.Components;

import Presentation.Enums.FormElementType;

import javax.swing.*;

public class PathSelector extends JFileChooser {

    JFileChooser fileChooser;
    String selected = "";


    public PathSelector(FormElementType type) {
        fileChooser = new JFileChooser();
        switch (type) {
            case PATH_FILE_SELECTOR -> fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            case PATH_FOLDER_SELECTOR -> fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selected = fileChooser.getSelectedFile().getAbsolutePath();
        }
    }

    public String getSelected() {
        return selected;
    }
}
