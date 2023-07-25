package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import javax.crypto.KeyAgreementSpi;

public class C04_StaleElementReferenceException extends TestBase {
        /*
    STALE_ELEMENT_REFERENCE_EXCEPTION
        Bir webelementin sayfayı refreh(yenileme) yada back-forward yapma sonucundan eskimesi(bayatlaması)
     durumunda bu exception'ı alırız. Yani driver sayfayı yeniden oluşturduğunda elementin locate'i aynı
     olmasına rağmen tekrar o elementin locatini almamızı ister. Almadığımız takdirde locate'i eskimis olarak görür ve
     staleelementrefenceexception hatası verir.
     */
    @Test
    public void test01() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        wait(2);
        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.id("searchHeaderInput"));

        driver.navigate().refresh();

        aramaKutusu.sendKeys("qa", Keys.ENTER);
        /*
        org.openqa.selenium.StaleElementReferenceException hatası aldık çünkü refresh yaptıktan sonra
        tekrar locate almadık. Dolayısıyla bu hatayı handle edebilmek için refresh yaptıktan sonra
        tekrar locate almalıyız.
         */

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }

    @Test
    public void test02() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        wait(2);
        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.id("searchHeaderInput"));

        driver.navigate().refresh();

        driver.findElement(By.id("searchHeaderInput")).sendKeys("qa", Keys.ENTER);


        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("TechPro"));

    }

    @Test
    public void test03() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        wait(2);
        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.id("searchHeaderInput"));
        aramaKutusu.sendKeys("developer",Keys.ENTER);

        driver.navigate().back();

        aramaKutusu.sendKeys("qa", Keys.ENTER);
        /*
        org.openqa.selenium.StaleElementReferenceException: back veya forward sonrasında da bu hatayı aldık
         */
        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("TechPro"));

    }

    @Test
    public void test04() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com/");

        //arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);

        //çıkan sonuclardan ilk beşine tıklayıp,her ürünün başlığını konsola yazdıralım
        for (int i =2 ;i<7 ; i++){
            driver.findElement(By.xpath("(//div/img)["+i+"]")).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }
        /*
         List<WebElement> urunler = driver.findElements(By.xpath("//h2//a"));
                 for (int i = 0; i < urunler.size(); i++) {
                     urunler.get(i).click();
                     bekle(2);
                     System.out.println(driver.getTitle());
                     driver.navigate().back();//-->org.openqa.selenium.StaleElementReferenceException:
                     bekle(2);
                     if (i==4){
                         break;
                     }
                     urunler = driver.findElements(By.xpath("//h2//a"));//-->S.E.R.E. hatasını handle ettik
                 }
         */

    }
}
