package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
/***
 *
 * The driver is created here from the utils.Driver class and the common methods are called from this class.
 */


public class ParentClass {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

   static {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    public ParentClass(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    public static void gotoSite(String url){
        driver.get(url);
    }
    public static void clickTo(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public static void clickTo(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public static void sendKeysTo(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
    public static void sendKeysTo(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public static void submitTo(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).submit();
    }

    public void scrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public void scrollIntoView(By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",locatorToElement(by));
    }
    public static void sleepTo(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void quitDriver() throws InterruptedException {
        sleepTo(1000);
        driver.quit();
    }
    public void hover(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }

    public List <WebElement> WebElementlist(By locator){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> productL=wait.until(ExpectedConditions.visibilityOfAllElements(element));
        return productL;

    }
    public static int getrandom(int size){
        return (int) (Math.random() * size);
    }
    public static int getrandom(int max, int min){
        return (int) (Math.random() * (max-min)+min);
    }
    public static WebElement locatorToElement(By locator){
        return driver.findElement(locator);
    }


    public static void login(){
        driver.get("https://www.google.com/");
   }

    public static void mouseOn(){
        Point coordinates = driver.findElement(By.xpath("//li[@id='1234']/a")).getLocation();
        Robot robot;
        try {
            robot = new Robot();
            robot.mouseMove(coordinates.getX(),coordinates.getY()+100);

        } catch (AWTException e1) {
            e1.printStackTrace();
        }

    }



    public static ArrayList<Double> getPrices(String[] strArray) {
        ArrayList<Double> arrayList = new ArrayList<>();
        for (int i = 0; i < strArray.length; i++) {
            arrayList.add(getPrice(strArray[i]));
        }
        return arrayList;
    }

    public static ArrayList<Double> getPrices(By by, String str1, String str2, int indexFirstLast) {
        List<WebElement> ürünlist = driver.findElements(by);
        ArrayList<Double> arrayList = new ArrayList<>();
        for (int i = 0; i < ürünlist.size(); i++) {
            String string = ürünlist.get(i).getText();
            string = string.substring(string.lastIndexOf(str1) + 2, string.lastIndexOf(str2) - 2);
            arrayList.add(Double.parseDouble(string));
        }
        return arrayList;
    }

    public static double getPrice(String str) {
        String fiyatstr = str.replaceAll("[^0-9]", "");
        return Double.parseDouble(fiyatstr);
    }
    public void selectAndClick(By listlocator, By clicklocator){
        List<WebElement> ürünlist = driver.findElements(listlocator) ;
        int random = getrandom(ürünlist.size());
        scrollIntoView(ürünlist.get(random));
        sleepTo(1000);
        ürünlist.get(random).click();
        clickTo(clicklocator);
    }




public static void sleep(long ms){
    try {
        Thread.sleep(ms);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}


}
