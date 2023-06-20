package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C02_ALerts extends TestBase {
    /*
       Eğer bir sayfadaki bir buttona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan pencereye sağ click
    yapıp locate alamıyorsak, bu bir js Alert'tür.
       js Alert'ü handle edebilmek için driver'ımızı o pencere geçirmemiz gerekir. Bunun için;
    driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js alert'e geçiş yapmış oluruz
    accept() yada dismiss() methodlarıyla js Alert'ü onaylar yada iptal ederek kapatırız
    */

    //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    @Test //--> Çalışmasını istemediğimiz test notasyonundan sonra (@Test) @Ignore notasyonu kullanırız
    public void acceptAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: acceptAlert

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[1]")).click();
        wait(2);
        driver.switchTo().//gecmek icin kullanilan method
                alert().//alert'e gecis yapar
                accept();//cikan alert'te ok ya da tamam butonuna tiklar
        wait(2);
        String result = driver.findElement(By.id("result")).getText();
        assert result.equals("You successfully clicked an alert");

    }

    @Test
    public void dismissAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: dismissAlert

        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[2]")).click();
        wait(2);
        driver.switchTo().
                alert().
                dismiss();//js Alert'te iptal ya da cancel tusuna basar
        wait(2);
        String cancel = driver.findElement(By.id("result")).getText();

        Assert.assertFalse(cancel.contains("successfuly"));
    }

    @Test
    public void sendKeysAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[3]")).click();
        wait(2);
        driver.switchTo().
                alert().
                sendKeys("Bedri");
        wait(2);
        driver.switchTo().alert().accept();

        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        String name = driver.findElement(By.id("result")).getText();
        assert name.contains("Bedri");

    }
}
