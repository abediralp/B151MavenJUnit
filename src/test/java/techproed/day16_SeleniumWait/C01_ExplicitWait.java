package techproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {

        /*
    SELENIUM WAIT:
            IMPLICITLY WAIT --> Driver'i oluşturduktan sonra sayfadaki tüm webelementlerin etkileşime girebilmesi için
         belirtmiş olduğumuz max. (Duration.ofSecond(20)) süre kadar bekler.
            EXPLICIT WAIT / WebDriverWait--> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için
         max. belirtmiş olduğumuz süre kadar default(varsayılan) olarak yarım saniyelik aralıklarla bekler. Örneğin bir
         webelemente tıkladık ve bir alert'ün çıkması zaman alabilir, internet yoğunluğundan yada sayfanın
         performansından kaynaklı bu süreyi normalde kullandığımız Thread.sleep() ile de çözebiliriz fakat testimizi
         her çalıştırdığımızda Thread.sleep() için kaç saniye beklemesi gerektiğini kestiremeyebiliriz. Bu gibi
         durumlar için explicit wait kullanırız.
            EXPLICIT WAIT / FluentWait--> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için
         max. belirtmiş olduğumuz süre kadar bizim belirttiğimiz aralıklarda (saniye/salise) bekler
         SYNTAX:
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));//--> max. 20 saniye belirttik
                wait.until(ExpectedConditions.visibilityOf(helloWorldText));

         */
        @Test
        public void test01() {
            //https://the-internet.herokuapp.com/dynamic_loading/1
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

            //Start buttonuna tıkla
            driver.findElement(By.xpath("//button")).click();

            //Hello World! Yazının sitede oldugunu test et
            WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
            //Locate'ini aldığımız helloWorldText webelementini görünür olana kadar explicit wait ile bekleyeceğim
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));//-->max.20 saniye belirttik
            wait.until(ExpectedConditions.visibilityOf(helloWorldText));
            //visibilityOf() methoduyla görünür olana kadar bekler

            Assert.assertEquals("Hello World!",helloWorldText.getText());
        }
    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = new WebDriverWait(driver,Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));

        Assert.assertEquals("Hello World!",helloWorldText.getText());
    }

    @Test
    public void test03() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        new WebDriverWait(driver,Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));

        Assert.assertEquals("Hello World!",driver.findElement(By.xpath("(//h4)[2]")).getText());
    }
}
