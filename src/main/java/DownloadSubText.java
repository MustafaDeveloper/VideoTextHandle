import org.openqa.selenium.By;
import utils.ParentClass;

public class DownloadSubText extends ParentClass {

    public static void getSubText(String url) throws InterruptedException {
        gotoSite("https://downsub.com/");
        By element = By.xpath("//input[@name='url']");
        By downloadButton = By.cssSelector(".v-input__append-outer>button");
        By declineButton = By.xpath("//div//button[text()='Decline']");
        By downloadCloseButton = By.xpath("//div[@class='pl-dee4f2455ab43dc9f44a5f28fcc0dfe7__closelink']");
        By txtButton = By.cssSelector(".layout.justify-start>button:nth-child(2)");


        sendKeysTo(element, url);
        clickTo(downloadButton);
        //clickTo(declineButton);
       // clickTo(downloadCloseButton);


        clickTo(txtButton);
        quitDriver();
    }
}
