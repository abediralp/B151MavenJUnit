package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void test01() {
        /*
    NO_SUCH_ELEMENT_EXCEPTION
        -Bir webelementin locate'ini yanlis aldığımızda, elementi bulamayacağı için bu
        exception'i alırız
     */
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='form-inpuut']"));
    /*
    org.openqa.selenium.NoSuchElementException:
      normal locatimiz //*[@type='search'] bu şekilde iken nosuchelementexception alabilmek için locate'i bozduk
    //*[@type='ssearch'] ve exception'ı aldığımızı gördük. Dolayısıyla bu hatayı handle edebilmek için
    düzgün locate almamız gerekiyor
     */
        aramaKutusu.sendKeys("qa", Keys.ENTER);


    }

    @Test
    public void test02() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.cssSelector("//*[@class='form-input']"));
    /*
    org.openqa.selenium.InvalidSelectorException: xpath ile aldığımız bir webelementin locate'ini
    cssSelector locator ile kullanırsak bu exception'ı alırız. Dolayısıyla bunu handle etmek için
    doğru locator'ı kullanmamız gerekir.
     */

        aramaKutusu.sendKeys("qa", Keys.ENTER);


    }
}
