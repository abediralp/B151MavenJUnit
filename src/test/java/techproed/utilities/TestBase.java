package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

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
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    //HARD WAIT (Bekleme methodu)
    public void wait(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /** AcceptAlert */
    public void acceptAlert () {
        driver.switchTo().alert().accept();
    }

    /** DissmissAlert */
    public void dismissAlert () {
        driver.switchTo().alert().dismiss();
    }

    /** getTextAlert */
    public String getTextAlert () {
       return driver.switchTo().alert().getText();
    }

    /** sendKeysAlert */
    public void sendKeysAlert (String text) {
        driver.switchTo().alert().sendKeys(text);
    }
    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }
    public void selectIndex(WebElement ddm, int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }
}
