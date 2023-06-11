package techproed.day08_BeforeClassAfterClass_Assertion;

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

public class C07_AssertionClassWork {
 //  1)https://amazon.com adresine gidin
 //  2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleriyapin
 //  ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
 //  ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
 //  ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
 //  ○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @Test
    public void titleTest() {
        //  ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
        String title= driver.getTitle();
        Assert.assertTrue(title.contains("Amazon"));

    }
    @Test
    public void imageTest() {
        //  ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement image= driver.findElement(By.cssSelector("a[aria-label='Amazon']"));
        Assert.assertTrue(image.isDisplayed());
    }

    @Test
    public void searchBox() {
        //  ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest() {
        //  ○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
        String title= driver.getTitle();
        Assert.assertFalse(title.contains("amazon"));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
