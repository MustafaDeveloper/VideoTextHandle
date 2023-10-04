import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 *
 */
public class ReadTxtFile {
    static String FILE_NAME = "C:\\Users\\Mustafa\\Downloads\\";

     static List<String> txtArrayList=new ArrayList<>();

    public static List<String> readText(String userFileName) throws IOException {
        System.out.println("User fileName is: " + userFileName);  // Output user input
        FILE_NAME += userFileName;
// 1st way to read File in Java - Using Scanner
        Scanner scnr = new Scanner(new FileInputStream(FILE_NAME));
        while (scnr.hasNextLine()) {
            String newLine=scnr.nextLine();

            if(newLine.contains(" ") ){
                String[] newArray=newLine.split(" ");
                for (String s:newArray ) { txtArrayList.add(s);}
            }
        }
        scnr.close();
        return txtArrayList;
    }

    public static  List<String> getFileNames(){
        File[] files = new File("C:\\Users\\Mustafa\\Downloads").listFiles();
        List<String> results = new ArrayList<String>();

//If this pathname does not denote a directory, then listFiles() returns null.

        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }
        return  results;
    }

//    public static String convertTextFileToString(String fileName) {
//        try (Stream<String> stream
//                     = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {
//
//            return stream.collect(Collectors.joining(" "));
//        } catch (IOException | URISyntaxException e) {
//            return null;
//        }
//    }

//    public static List<String>  readTXTwithBuffer() throws IOException {
//        // 2nd way to read File in Java - Using BufferedReader
//        BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME)));
//        String line = buffReader.readLine();
//        while (line != null) {
//           // System.out.println(line);
//            txtArrayList.add(line);
//            line = buffReader.readLine();
//        }
//        return txtArrayList;
//    }


    //Read more:https:
//www.java67.com/2015/06/2-ways-to-read-text-file-in-java-6.html#ixzz7eaDP8xHDpublic static void main(String args[]) throws IOException { final String FILE_NAME = "C://temp//GDP.txt"; // 1st way to read File in Java - Using Scanner Scanner scnr = new Scanner(new FileInputStream(FILE_NAME)); while (scnr.hasNextLine()) { System.out.println(scnr.nextLine()); } scnr.close(); // 2nd way to read File in Java - Using BufferedReader BufferedReader buffReader = new BufferedReader( new InputStreamReader(new FileInputStream(FILE_NAME))); String line = buffReader.readLine(); while (line != null) { System.out.println(line); line = buffReader.readLine(); } }

    //Read more:https:
//www.java67.com/2015/06/2-ways-to-read-text-file-in-java-6.html#ixzz7eaDP8xHD
}
