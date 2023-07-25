package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
    TIME_OUT_EXCEPTION
         Expilict wait kullanırken yanlış method yada yanlış max. bekleme süresi gibi durumlarda
     org.openqa.selenium.TimeoutException hatası alırız.
     */
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));
        /*
        org.openqa.selenium.TimeoutException: normalde helloWorldText webelementi 5-6 saniye civarında
        etkileşime gireken biz max. bekleme süresini 2 saniye verdiğimiz için bu hatayı aldık.Dolayısıyla
        bu exception'ı handle edebilmek için doğru süreyi ve doğru methodu kullanmamız gerekir.
         */


        Assert.assertEquals("Hello World!",helloWorldText.getText());
    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        //WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("yanlisLocate")));

        /*
        Yukaridaki örnekte max süreyi dogru vermemize ragmen yanlis locate aldigimiz icin yine TimeOutException hatasi aliriz
        */

    }

    @Test
    public void test03() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //CheckBox yazan buttona tıklayalım
        driver.findElement(By.xpath("//button[@id='checkbox']")).click();

        //checkBox'ın seçili olduğunu doğrulayalım(CheckBox'ı locate etmeliyiz)
        WebElement check = driver.findElement(By.xpath("//input[@id='ch']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeSelected(check));
        Assert.assertTrue(check.isSelected());

    }
}
