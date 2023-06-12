package techproed.practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YoutubeAssertions {
    /**
     * 1)Bir class oluşturun: YoutubeAssertions
     * 2) https://www.youtube.com adresine gidin
     * 3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response-inverse'])[1]")).click();
    }

    // YouTube resminin görüntülendiğini (isDisplayed()) test edin

    @Test
    public void logo1() {
        WebElement logo = driver.findElement(By.xpath("(//*[@*='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
    // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void searchBox2(){
        WebElement searchBox = driver.findElement(By.id("search"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    // wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void wrongTitleTest3(){
        String expectedTitle = "youtube";
        String actualTitle =driver.getTitle();
        Assert.assertNotEquals(expectedTitle, actualTitle);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
