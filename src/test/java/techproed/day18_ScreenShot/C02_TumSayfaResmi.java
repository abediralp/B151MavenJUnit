package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_TumSayfaResmi extends TestBase {
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://amazon.com");

        //Ve ekran görüntüsünü alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/screenshot/ss"+tarih+".png";
        TakesScreenshot ss = (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu),ss.getScreenshotAs(OutputType.BYTES));
    }

    @Test
    public void test02() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Ve ekran görüntüsünü alalım
        screenShot();

    }
}
