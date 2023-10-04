import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class MAIN {


    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scn = new Scanner(System.in);
        System.out.print("Youtube'da aranacak konuyu giriniz : ");
        String keyWord = scn.nextLine();
        System.out.println("Link ist richtig ->  " + SearchOnYoutube.isLinkCorrect("https://www.youtube.com/"));
        SearchOnYoutube youtube = new SearchOnYoutube(keyWord);
        youtube.getScreenShot("D:\\ILF\\2022-2023_RTG\\_03_VideoTextes\\", keyWord + ".png");
        DownloadSubText.getSubText(youtube.getStrUrl());
        List<String> list = ReadTxtFile.getFileNames();

        list.removeIf(s -> !s.contains("[DownSub.com]"));
        System.out.println("list = " + list);

        WriteOnWordDocument wow = new WriteOnWordDocument();
        wow.createWordDocument(ReadTxtFile.readText(list.get(0)));
    }
}
