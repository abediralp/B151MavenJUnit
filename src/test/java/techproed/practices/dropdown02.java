package techproed.practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.time.Duration;

public class dropdown02 {
    /*
    ●https://www.amazon.com/ adresine gidin.
    -Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    oldugunu test edin
    -Test 2
    1.Kategori menusunden Books secenegini secin
    2.Arama kutusuna Java yazin ve aratin
    3.Bulunan sonuc sayisini yazdirin
    4.Sonucun Java kelimesini icerdigini test edin
     */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test1() {
        /*
        -Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28
    oldugunu test edin
         */
        WebElement all = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(all);
        System.out.println(select.getOptions().size());
        Assert.assertEquals(28,select.getOptions().size());

    }

    @Test
    public void test2() {
        /*
         -Test 2
    1.Kategori menusunden Books secenegini secin
    2.Arama kutusuna Java yazin ve aratin
    3.Bulunan sonuc sayisini yazdirin
    4.Sonucun Java kelimesini icerdigini test edin
         */
        WebElement all = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(all);
        select.selectByVisibleText("Books");
        wait(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        String result = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();

        String []result1 = result.split(" ");
        System.out.println("Number of Result ="+result1[3]);
        Assert.assertTrue(result.contains("Java"));
        wait(2);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
    public void wait(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
