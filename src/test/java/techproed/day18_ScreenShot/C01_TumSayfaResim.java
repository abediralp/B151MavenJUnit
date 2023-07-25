package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResim extends TestBase {
    /*
    SCREENSHOT
       Selenium'da tüm ekran görüntüsünü alabilmek için TakesScreenShot arayünden bir obje oluşturup
    driver'a eşitleriz. Arayüzler farklı olduğu için casting yaparız. Ve bu oluşturduğumuz obje ile
    getScreenshotAs methodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek
    oranın yolunu belirtiriz.
    */
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Ve ekran görüntüsünü alalım
        /*
        Ilk olarak Screenshot aldigimizda nereye kaydetmek istiyorsak onun yolunu yazin
        Ikinci olarak TakesScreenShot arayuzunden obje olustur
        Ucuncu olarak FileUtils class'indan copyFile methodu ile ss objemizii kullanarak getScreenShotAs methodu ile dosya yolunu belirtecegiz

         */
        String dosyaYOlu = "target/screenshot/screenShot.png";
        TakesScreenshot ss = (TakesScreenshot) driver;
        FileUtils.copyFile(ss.getScreenshotAs(OutputType.FILE), new File(dosyaYOlu));


        /*--->2.Yol
        TakesScreenshot ss1 = (TakesScreenshot) driver;
        FileUtils.copyFile(ss1.getScreenshotAs(OutputType.FILE), new File("target/screenshot/screenShot.png"));
         */


    }

    @Test
    public void test02() throws IOException {
        /*
        Kaydettiğimiz ekran resmini her seferinde aynı dosya üzerine yazmaması için dosya isminden sonra
      String bir değişkene tarih formatı atayabiliriz.
        */
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Ve ekran görüntüsünü alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        /*
        SimpleDateFormat'ı kullanarak yeni bir tarih formatı oluşturup bir String'e assing ederiz.
        Ve bunu dosya isminden önce belirtiriz.
        */
        TakesScreenshot ss = (TakesScreenshot) driver;
        FileUtils.copyFile(ss.getScreenshotAs(OutputType.FILE),new File("target/screenshot/ss"+tarih+".png"));
    }

    @Test
    public void test03() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://amazon.com");

        //Ve ekran görüntüsünü alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        /*
        SimpleDateFormat'ı kullanarak yeni bir tarih formatı oluşturup bir String'e assing ederiz.
        Ve bunu dosya isminden önce belirtiriz.
        */
        TakesScreenshot ss = (TakesScreenshot) driver;
        FileUtils.copyFile(ss.getScreenshotAs(OutputType.FILE),new File("target/screenshot/ss"+tarih+".png"));
    }
}
