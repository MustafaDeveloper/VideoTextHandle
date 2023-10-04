import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class WriteOnWordDocument {


    public void createWordDocument(List<String> writeThisArrayList) throws IOException {
        Scanner scnFileName = new Scanner(System.in);  // user give file name
        System.out.print("Enter word document name : ");

        String giveName = scnFileName.nextLine();  // Read user input
        System.out.println("User giveName is : " + giveName);  // Output user input

        String fileName = "D:\\ILF\\2022-2023_RTG\\_03_VideoTextes\\_newTxtToWord_"+giveName+".docx";
        System.out.println("User fileName is : " + fileName);

        try (XWPFDocument doc = new XWPFDocument()) {

            // create a paragraph
            XWPFParagraph p1 = doc.createParagraph();
            p1.setAlignment(ParagraphAlignment.BOTH);

            // set font
            XWPFRun r1 = p1.createRun();
            r1.setBold(false);
            r1.setItalic(false);
            r1.setFontSize(11);
            r1.setFontFamily("Arial");

            for (String s: writeThisArrayList) {
                r1.setText(s);
                r1.setText(" ");
            }
            // save it to .docx file
            try (FileOutputStream out = new FileOutputStream(fileName)) {
                doc.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
