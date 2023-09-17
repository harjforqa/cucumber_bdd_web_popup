package utilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

public class JpgToPdfConverter {
    public static void main(String[] args) {

        String inputJpgFile = System.getProperty("user.dir") + File.separator + "Reports/input.jpg";
        String outputPdfFile = System.getProperty("user.dir") + File.separator + "Reports/output.pdf";

        try {
            // Create a document
            Document document = new Document();

            // Initialize PDF writer
            PdfWriter.getInstance(document, new FileOutputStream(outputPdfFile));
            document.open();

            // Add image to the PDF
            Image image = Image.getInstance(inputJpgFile);
            document.add(image);

            // Close the document
            document.close();

            LogUtil.info(JpgToPdfConverter.class, "Conversion complete. PDF file created.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}