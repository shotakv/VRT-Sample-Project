package UI.util;


import io.visual_regression_tracker.sdk_java.VisualRegressionTracker;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static UI.util.BaseTest.vrt;

public class Helper {


    public static void validatePDFUsingVRT(File pdfFile){
        try {
            PDDocument document = PDDocument.load(pdfFile);
            PDFRenderer renderer = new PDFRenderer(document);

            int pageCount = document.getNumberOfPages();

            for (int i = 0; i < pageCount; i++) {
                System.out.println("Tracking PDF Page " + (i + 1) + "/" + pageCount);

                BufferedImage pageImage = renderer.renderImageWithDPI(i, 150);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(pageImage, "png", baos);
                String base64Image = Base64.getEncoder().encodeToString(baos.toByteArray());

                vrt.track(
                        "PDF Page " + (i + 1),
                        base64Image

                );
            }

            document.close();
        }
        catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void validatePDFUsingVRT(File pdfFile, VisualRegressionTracker vrt){
        try {
            PDDocument document = PDDocument.load(pdfFile);
            PDFRenderer renderer = new PDFRenderer(document);

            int pageCount = document.getNumberOfPages();

            for (int i = 0; i < pageCount; i++) {
                System.out.println("Tracking PDF Page " + (i + 1) + "/" + pageCount);

                BufferedImage pageImage = renderer.renderImageWithDPI(i, 150);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(pageImage, "png", baos);
                String base64Image = Base64.getEncoder().encodeToString(baos.toByteArray());

                vrt.track(
                        "PDF Page " + (i + 1),
                        base64Image

                );
            }

            document.close();
        }
        catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
