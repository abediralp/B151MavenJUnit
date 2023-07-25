package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_WEresmi extends TestBase {
    /*
    Bir webelementin resmini almak için önce Webelementi locate edip bir webelemente assing ederiz.
    ve bu webelementi direk getScreenShotAs() methodunu kullanarak resmini belirttimiz dosyaya kaydederiz.
    */
    @Test
    public void test01() throws IOException {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Cikan sonucun ekran görüntüsünü alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/screenshot/WebelementResmi/ss"+tarih+".jpeg";
        WebElement result =driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        FileUtils.copyFile(result.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }

}
