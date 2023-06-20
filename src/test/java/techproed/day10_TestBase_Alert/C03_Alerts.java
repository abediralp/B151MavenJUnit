package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C03_Alerts extends TestBase {

    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[2]")).click();

        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        System.out.println("Alert = " + getTextAlert());
        Assert.assertEquals("You clicked a button", getTextAlert());

        //Ve alert'ü kapatalım
        acceptAlert();

    }

    @Test
    public void test02() {
        //On button click, confirm box will appear karşısındaki butona tıklayalım.
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.xpath("(//button)[4]")).click();
        //Çıkan alertte iptale basalım.
        dismissAlert();
        wait(2);

        // Sonuç yazısında You selected Cancel yazdığını doğrulayalım
        String sonuc = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertTrue(sonuc.contains("You selected Cancel"));

    }

    @Test
    public void test03() {
        //On button click, prompt box will appear karşısındaki butona tıklayalım
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.xpath("(//button)[5]")).click();

        //çıkan alerte ismimizi girelim
        sendKeysAlert("Bedri");

        acceptAlert();

        //ismi girdiğimizi doğrulayalım
        String name = driver.findElement(By.id("promptResult")).getText();
        assert name.contains("You entered Bedri");

    }
}
