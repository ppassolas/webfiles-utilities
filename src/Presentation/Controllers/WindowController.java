package Presentation.Controllers;

import Presentation.Views.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Presentation.Views.Window.*;

public class WindowController implements ActionListener {
    Window window;

    public WindowController() {
        this.window = new Window(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case GOTO_MAIN -> {
                synchronized (this) {
                    window.switchPanel(MAIN_MENU);
                }
            }

            case GOTO_PDF_TO_IMAGE -> {
                synchronized (this) {
                    window.switchPanel(PDF_TO_IMAGE);
                }
            }

            case GOTO_PDF_TO_IMAGE_FILE -> {
                synchronized (this) {
                    window.switchPanel(PDF_TO_IMAGE_FILE);
                }
            }

            case GOTO_PDF_TO_IMAGE_FOLDER -> {
                synchronized (this) {
                    window.switchPanel(PDF_TO_IMAGE_FOLDER);
                }
            }

            case GOTO_CONVERT_IMAGE -> {
                synchronized (this) {
                    window.switchPanel(CONVERT_IMAGE);
                }
            }

            case GOTO_CONVERT_IMAGE_FILE -> {
                synchronized (this) {
                    window.switchPanel(CONVERT_IMAGE_FILE);
                }
            }

            case GOTO_CONVERT_IMAGE_FOLDER -> {
                synchronized (this) {
                    window.switchPanel(CONVERT_IMAGE_FOLDER);
                }
            }
        }
    }
}
