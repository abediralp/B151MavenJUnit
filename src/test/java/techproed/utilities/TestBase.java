package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {
    /*
    TestBase class'indan obje olusturmanin onune gecmek icin bu class'i abstract yapabiliriz.
    TestBase testBase = new TestBase(); yani bu sekilde obje olusturmanin onune gecmis oluruz
    Bu class'a extends yaptigimiz zaman test class'lardan ulasabiliriz
     */
    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    //HARD WAIT (Bekleme methodu)
    public void wait(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Selenium Wait/ Explicit Wait
    //visibilityof(element) methodu
    public void waitTillVisible(WebElement element, int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //visibilityOfElementLocated(locator) methodu
    public void visibleWait(By locator, int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //AlertWait
    public void alertwait(int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //FluentWait visible methodu
    public void visibleFluentWait(WebElement element, int saniye, int salise) {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(saniye)).
                pollingEvery(Duration.ofMillis(salise)).
                until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * AcceptAlert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * DissmissAlert
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * getTextAlert
     */
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    /**
     * sendKeysAlert
     */
    public void sendKeysAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void selectVisibleText(WebElement ddm, String text) {
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    /**
     * Dropdown Index
     */
    public void selectIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    /**
     * Dropdown Value
     */
    public void selectValue(WebElement ddm, String value) {
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    /**
     * SwitchTo Window
     */
    public void switchToWindow(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    /**
     * SwitchTo Window-2
     */
    public void switchToWindow2(int index) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }
    //Fullscreen screenshot
    public void screenShot() {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/screenshot/ss" + tarih + ".png";
        TakesScreenshot ss = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ss.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //Webelement screenshot
    public void WEscreenShot(WebElement webElement){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/WebelementResmi/ss"+tarih+".jpeg";
        try {
            FileUtils.copyFile(webElement.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
