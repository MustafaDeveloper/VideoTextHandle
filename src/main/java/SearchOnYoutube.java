import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ParentClass;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static utils.Driver.getDriver;


public class SearchOnYoutube extends ParentClass {

    private String keyword;
    private String strUrl;

    public static final By searchGoogleInput = By.xpath("//input[@class='gLFyf gsfi']");
    public static final By googleRejectButton = By.xpath("//div[@class='QS5gu sy4vM']");
    public static final By googleSearchFirstResult = By.xpath("//div[@class='mkHrUc']//li");
    public static final By youtubeLinkOnGoogle = By.xpath("//div[@class='TbwUpd NJjxre']");
    public static final By searchInput = By.cssSelector("input#search"); //By.xpath("//div[@id='search-input']");
    public static final By searchButton = By.xpath("//button[@id='search-icon-legacy']");
    public static final By rejectAllButton = By.xpath("//div[@class='eom-buttons style-scope ytd-consent-bump-v2-lightbox']//div//ytd-button-renderer//a");
    public static final By youtubeStart = By.xpath("//div[@id='start']");
    public static final By youtubeHomeButton = By.xpath("//div[@id='items']//tp-yt-paper-item");

    public static final By firstResult = By.cssSelector("div#title-wrapper");

    public SearchOnYoutube(String keyword) {
        this.keyword = keyword;
        searchOnYoutube();
    }

    public void searchOnYoutube() {
        gotoSite("https://www.youtube.com/");
        ParentClass.clickTo(SearchOnYoutube.rejectAllButton);
        ParentClass.clickTo(SearchOnYoutube.youtubeStart);
        ParentClass.sendKeysTo(SearchOnYoutube.searchInput, keyword);
        ParentClass.submitTo(SearchOnYoutube.searchInput);
        ParentClass.clickTo(SearchOnYoutube.firstResult);
        strUrl = getDriver().getCurrentUrl();
        System.out.println("strUrl = " + strUrl);
        System.out.println("driver.getTitle() = " + getDriver().getTitle());

    }

    public String getStrUrl() {
        return strUrl;
    }

    public void getScreenShot(String saveOnPath, String fileName) {
        sleep(3000);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
        try {
            FileUtils.copyFile(scrFile, new File(saveOnPath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static boolean isLinkCorrect(String url){
        HttpURLConnection httpConn;
        try {
            URL link = new URL(url);
            httpConn = (HttpURLConnection) link.openConnection();
            httpConn.setConnectTimeout(2000);
            httpConn.connect();
            httpConn.disconnect();
        }catch (Exception e){
            return false;
        }
        return true;
    }


    public void closeYoutube() {
        sleep(5000);
        driver.close();
    }
}
