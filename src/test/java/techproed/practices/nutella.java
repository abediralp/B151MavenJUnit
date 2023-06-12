package techproed.practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class nutella {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

    }

    @Test
    public void google() {
        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[1]")).click();
        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // arama cubuguna "Nutella" yazıp aratın
        driver.findElement(By.id("APjFqb")).sendKeys("Nutella", Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);


        // bulunan sonuc sayısını yazdırın
        String result = driver.findElement(By.id("result-stats")).getText();
        String[] numberOfResult = result.split(" ");
        String sonuc = numberOfResult[1];
        System.out.println(sonuc);
        sonuc = sonuc.replace(".","");
        Integer number = Integer.parseInt(sonuc);

        // sonuc sayısının 100000000  fazla oldugunu test edin
        Assert.assertTrue(number > 100000000);
    }

}