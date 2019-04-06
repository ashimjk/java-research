package pdf;

import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Stack;

public class PdfTest {

    private static final String STR = "as";

    public static void main(String[] args) throws IOException,
            DocumentException {

        System.out.println(STR);

        LinkedList l = new LinkedList();
        Stack<String> s = new Stack();



//        String inputFile = "src/main/resources/index.xhtml";
//        String url = new File(inputFile).toURI().toURL().toString();
//        String outputFile = "Converted.pdf";
//        OutputStream os = new FileOutputStream(outputFile);
//
//        ITextRenderer renderer = new ITextRenderer();
//        renderer.setDocument(new File(inputFile));
//        renderer.layout();
//        renderer.createPDF(os);
//        System.out.println("done");
//
//        os.close();
    }
}