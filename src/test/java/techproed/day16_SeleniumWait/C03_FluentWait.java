package techproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {
    /*
        FluentWait--> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için
         max. belirtmiş olduğumuz süre kadar bizim belirttiğimiz aralıklarda (saniye/salise) bekler
         */

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)).//-->FluentWait icin max bekleme suresini belirtir
            pollingEvery(Duration.ofMillis(200)).//-->200 milisaniye araliklarla webelementin etkilesime girdigini kontrol eder
            withMessage("Webelementi kontrol et");//--> Hata alma durumunda konsol da bu mesaj verilir
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));
    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).
                pollingEvery(Duration.ofMillis(200)).
                until(ExpectedConditions.visibilityOf(helloWorldText));
        Assert.assertEquals("Hello World!",helloWorldText.getText());
    }

    @Test
    public void test03() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
        visibleFluentWait(helloWorldText,20,200);
        Assert.assertEquals("Hello World!",helloWorldText.getText());
    }
}
