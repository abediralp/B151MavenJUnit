package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C04_ScreenShotClassWork extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //sayfanın resmini alalım
        screenShot();

        //Arama bölümünde java aratalım
        driver.findElement(By.id("searchHeaderInput")).sendKeys("java");
        wait(2);

        //ve sonuc yazısının resmini alalım
        WebElement result = driver.findElement(By.className("searchHeaderResult"));
        WEscreenShot(result);

        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //sayfanın resmini alalım
        screenShot();

        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement amazonResult = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        WEscreenShot(amazonResult);

        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        switchToWindow(0);
        screenShot();

    }
}
