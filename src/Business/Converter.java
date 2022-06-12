package Business;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Converter {

    public Converter() {

    }

    public static void generateCoversOfPdfsFromFolder(String folderPath, String imageFormat, int width, int height) {
        File directoryPath = new File(folderPath);

        ArrayList<String> list = new ArrayList<>(Arrays.asList(Objects.requireNonNull(directoryPath.list())));
        list = filterPDFs(list);
        for (String element : list) {
            String path = folderPath + "\\" + element;
            BufferedImage image = convertPDFCoverToImg(path, width, height);
            saveImage(image, generateNewFilePath(path, imageFormat), imageFormat);
        }
    }

    private static ArrayList<String> filterPDFs(ArrayList<String> list) {
        ArrayList<String> filteredList = new ArrayList<>();
        for (String element : list) {
            if (element.endsWith(".pdf")) {
                filteredList.add(element);
            }
        }
        return filteredList;
    }

    public static void generateCoverOfPdfFile(String filePath, String imageFormat, int width, int height) {
        BufferedImage image = convertPDFCoverToImg(filePath, width, height);
        saveImage(image, generateNewFilePath(filePath, imageFormat), imageFormat);
    }

    private static String generateNewFilePath(String oldFilePath, String imageFormat) {
        String newFilePath = oldFilePath.substring(0, oldFilePath.lastIndexOf("."));
        newFilePath += "." + imageFormat;
        return newFilePath;
    }

    private static BufferedImage convertPDFCoverToImg(String filePath, int width, int height) {
        return generateImageFromPDF(filePath, 1, width, height);
    }

    private static BufferedImage generateImageFromPDF(String filePath, int page, int width, int height) {
        PDDocument document = null;
        BufferedImage image = null;
        try {
            document = PDDocument.load(new File(filePath));
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            image = pdfRenderer.renderImageWithDPI(page - 1, 300, ImageType.RGB);
            image = resizeImage(image, width, height);
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return image;
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int newWidth, int newHeight) {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
        Graphics2D graphics = resizedImage.createGraphics();
        graphics.setColor(Color.WHITE);
        // fill the entire picture with white
        graphics.fillRect(0, 0, newWidth, newHeight);
        Dimension newDimension = getScaledDimension(originalImage.getWidth(), originalImage.getHeight(), newWidth, newHeight);
        int maxWidth = newDimension.width;
        int maxHeight = newDimension.height;

        // calculate the x value with which the original image is centred
        int centerX = (resizedImage.getWidth() - maxWidth) / 2;
        // calculate the y value with which the original image is centred
        int centerY = (resizedImage.getHeight() - maxHeight) / 2;
        // draw the original image
        graphics.drawImage(originalImage, centerX, centerY, maxWidth, maxHeight, null);
        graphics.dispose();
        return resizedImage;
    }


    private static Dimension getScaledDimension(int original_width, int original_height, int bound_width, int bound_height) {
        int new_width = original_width;
        int new_height = original_height;

        // first check if we need to scale width
        if (original_width > bound_width) {
            //scale width to fit
            new_width = bound_width;
            //scale height to maintain aspect ratio
            new_height = (new_width * original_height) / original_width;
        }

        // then check if we need to scale even with the new height
        if (new_height > bound_height) {
            //scale height to fit instead
            new_height = bound_height;
            //scale width to maintain aspect ratio
            new_width = (new_height * original_width) / original_height;
        }

        return new Dimension(new_width, new_height);
    }

    private static void saveImage(BufferedImage image, String filePath, String extension) {
        try {
            ImageIO.write(image, String.valueOf(extension), new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
