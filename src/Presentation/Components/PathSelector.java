package Presentation.Components;

import Presentation.Enums.FormElementType;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PathSelector extends JFileChooser {


    String selected = "";


    public PathSelector(FormElementType type) {
        super();
        switch (type) {
            case PATH_PDF_SELECTOR -> {
                setFileSelectionMode(JFileChooser.FILES_ONLY);
                setAcceptAllFileFilterUsed(false);
                addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
            }
            case PATH_IMAGE_SELECTOR -> {
                setFileSelectionMode(JFileChooser.FILES_ONLY);
                setAcceptAllFileFilterUsed(false);
                addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
            }
            case PATH_FOLDER_SELECTOR -> setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        int returnVal = showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selected = getSelectedFile().getAbsolutePath();
        }
    }

    public String getSelected() {
        return selected;
    }
}
