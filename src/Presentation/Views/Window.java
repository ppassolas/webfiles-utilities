package Presentation.Views;

import Business.Converter;
import Business.Enums.DefaultValues;
import Presentation.Components.Button;
import Presentation.Controllers.ConvertImageController;
import Presentation.Controllers.Froms.ConvertImageFileController;
import Presentation.Controllers.Froms.ConvertImageFolderController;
import Presentation.Controllers.Froms.PDFToImageFileController;
import Presentation.Controllers.Froms.PDFToImageFolderController;
import Presentation.Controllers.PDFToImageController;
import Presentation.Controllers.SelectModeController;
import Presentation.Enums.ButtonSize;
import Presentation.Enums.ButtonType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    CardLayout crd;
    Container cPane;

    JPanel pMainMenu;
    JPanel pPDFtoImage;
    JPanel pPDFtoImageFolder;
    JPanel pPDFtoImageFile;
    JPanel pConvertImage;
    JPanel pConvertImageFolder;
    JPanel pConvertImageFile;

    JButton bGoBackPDFtoImage;
    JButton bGoBackConvertImage;
    JButton bGoToPDFtoImage;
    JButton bGoToPDFtoImageFolder;
    JButton bGoBackPDFtoImageFolder;
    JButton bGoToPDFtoImageFile;
    JButton bGoBackPDFtoImageFile;
    JButton bGoToConvertImage;
    JButton bGoToConvertImageFolder;
    JButton bGoBackConvertImageFolder;
    JButton bGoToConvertImageFile;
    JButton bGoBackConvertImageFile;


    // Card Layout Identifiers
    public static final String MAIN_MENU = "MainMenu";
    public static final String PDF_TO_IMAGE = "PDFtoImage";
    public static final String PDF_TO_IMAGE_FOLDER = "PDFtoImageFolder";
    public static final String PDF_TO_IMAGE_FILE = "PDFtoImageFile";
    public static final String CONVERT_IMAGE = "ConvertImage";
    public static final String CONVERT_IMAGE_FOLDER = "ConvertImageFolder";
    public static final String CONVERT_IMAGE_FILE = "ConvertImageFile";


    // Buttons text and identifiers
    public static final String GOTO_MAIN = DefaultValues.GO_BACK;
    public static final String GOTO_PDF_TO_IMAGE = "PDF to image";
    public static final String GOTO_PDF_TO_IMAGE_FOLDER = "PDF to image folder";
    public static final String GOTO_PDF_TO_IMAGE_FILE = "PDF to image file";
    public static final String GOTO_CONVERT_IMAGE = "Convert image";
    public static final String GOTO_CONVERT_IMAGE_FOLDER = "Convert image folder";
    public static final String GOTO_CONVERT_IMAGE_FILE = "Convert image file";

    private final ActionListener actionListener;
    private final Converter converter;

    public Window(ActionListener actionListener, Converter converter) {
        this.actionListener = actionListener;
        this.converter = converter;
        setupButtons();
        setupCards();
        setupView();
    }

    private void setupButtons() {
        bGoToPDFtoImage = new Button(GOTO_PDF_TO_IMAGE, ButtonType.PRIMARY, ButtonSize.MEDIUM);
        bGoToPDFtoImage.addActionListener(actionListener);
        bGoToPDFtoImage.setActionCommand(GOTO_PDF_TO_IMAGE);

        bGoToPDFtoImageFolder = new Button(GOTO_PDF_TO_IMAGE_FOLDER, ButtonType.PRIMARY, ButtonSize.MEDIUM);
        bGoToPDFtoImageFolder.addActionListener(actionListener);
        bGoToPDFtoImageFolder.setActionCommand(GOTO_PDF_TO_IMAGE_FOLDER);

        bGoToPDFtoImageFile = new Button(GOTO_PDF_TO_IMAGE_FILE, ButtonType.PRIMARY, ButtonSize.MEDIUM);
        bGoToPDFtoImageFile.addActionListener(actionListener);
        bGoToPDFtoImageFile.setActionCommand(GOTO_PDF_TO_IMAGE_FILE);

        bGoToConvertImage = new Button(GOTO_CONVERT_IMAGE, ButtonType.PRIMARY, ButtonSize.MEDIUM);
        bGoToConvertImage.addActionListener(actionListener);
        bGoToConvertImage.setActionCommand(GOTO_CONVERT_IMAGE);

        bGoToConvertImageFolder = new Button(GOTO_CONVERT_IMAGE_FOLDER, ButtonType.PRIMARY, ButtonSize.MEDIUM);
        bGoToConvertImageFolder.addActionListener(actionListener);
        bGoToConvertImageFolder.setActionCommand(GOTO_CONVERT_IMAGE_FOLDER);

        bGoToConvertImageFile = new Button(GOTO_CONVERT_IMAGE_FILE, ButtonType.PRIMARY, ButtonSize.MEDIUM);
        bGoToConvertImageFile.addActionListener(actionListener);
        bGoToConvertImageFile.setActionCommand(GOTO_CONVERT_IMAGE_FILE);

        bGoBackPDFtoImage = new Button(GOTO_MAIN, ButtonType.SECONDARY, ButtonSize.SMALL);
        bGoBackPDFtoImage.addActionListener(actionListener);
        bGoBackPDFtoImage.setActionCommand(GOTO_MAIN);

        bGoBackConvertImage = new Button(GOTO_MAIN, ButtonType.SECONDARY, ButtonSize.SMALL);
        bGoBackConvertImage.addActionListener(actionListener);
        bGoBackConvertImage.setActionCommand(GOTO_MAIN);

        bGoBackPDFtoImageFolder = new Button(DefaultValues.GO_BACK, ButtonType.SECONDARY, ButtonSize.SMALL);
        bGoBackPDFtoImageFolder.addActionListener(actionListener);
        bGoBackPDFtoImageFolder.setActionCommand(GOTO_PDF_TO_IMAGE);

        bGoBackPDFtoImageFile = new Button(DefaultValues.GO_BACK, ButtonType.SECONDARY, ButtonSize.SMALL);
        bGoBackPDFtoImageFile.addActionListener(actionListener);
        bGoBackPDFtoImageFile.setActionCommand(GOTO_PDF_TO_IMAGE);

        bGoBackConvertImageFolder = new Button(DefaultValues.GO_BACK, ButtonType.SECONDARY, ButtonSize.SMALL);
        bGoBackConvertImageFolder.addActionListener(actionListener);
        bGoBackConvertImageFolder.setActionCommand(GOTO_CONVERT_IMAGE);

        bGoBackConvertImageFile = new Button(DefaultValues.GO_BACK, ButtonType.SECONDARY, ButtonSize.SMALL);
        bGoBackConvertImageFile.addActionListener(actionListener);
        bGoBackConvertImageFile.setActionCommand(GOTO_CONVERT_IMAGE);

    }

    private void setupCards() {
        // Set up the Card Layout
        cPane = getContentPane();
        crd = new CardLayout();
        cPane.setLayout(crd);

        SelectModeController selectModeController = new SelectModeController(bGoToPDFtoImage, bGoToConvertImage);
        pMainMenu = selectModeController.getSelectMode();

        ConvertImageController convertImageController = new ConvertImageController(bGoToConvertImageFolder, bGoToConvertImageFile, bGoBackConvertImage);
        pConvertImage = convertImageController.getConvertImage();

        ConvertImageFileController convertImageFileController = new ConvertImageFileController(bGoBackConvertImageFile);
        pConvertImageFile = convertImageFileController.getConvertImageFile();

        ConvertImageFolderController convertImageFolderController = new ConvertImageFolderController(bGoBackConvertImageFolder);
        pConvertImageFolder = convertImageFolderController.getConvertImageFolder();

        PDFToImageController pdfToImageController = new PDFToImageController(bGoToPDFtoImageFolder, bGoToPDFtoImageFile, bGoBackPDFtoImage);
        pPDFtoImage = pdfToImageController.getPDFToImage();

        PDFToImageFolderController pdfToImageFolderController = new PDFToImageFolderController(bGoBackPDFtoImageFolder, converter);
        pPDFtoImageFolder = pdfToImageFolderController.getPdfToImageFolder();

        PDFToImageFileController pdfToImageFileController = new PDFToImageFileController(bGoBackPDFtoImageFile, converter);
        pPDFtoImageFile = pdfToImageFileController.getPdfToImageFile();


        // Add the cards to the Card Layout
        cPane.add(MAIN_MENU, pMainMenu);
        cPane.add(PDF_TO_IMAGE, pPDFtoImage);
        cPane.add(PDF_TO_IMAGE_FOLDER, pPDFtoImageFolder);
        cPane.add(PDF_TO_IMAGE_FILE, pPDFtoImageFile);
        cPane.add(CONVERT_IMAGE, pConvertImage);
        cPane.add(CONVERT_IMAGE_FOLDER, pConvertImageFolder);
        cPane.add(CONVERT_IMAGE_FILE, pConvertImageFile);
    }

    private void setupView() {
        setTitle(DefaultValues.TITLE);
        setBounds(300, 90, DefaultValues.FRAME_WIDTH, DefaultValues.FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        ImageIcon icon = new ImageIcon(DefaultValues.ICON_PATH);
        setIconImage(icon.getImage());
    }

    public void switchPanel(String panelName) {
        crd.show(cPane, panelName);
    }

}




