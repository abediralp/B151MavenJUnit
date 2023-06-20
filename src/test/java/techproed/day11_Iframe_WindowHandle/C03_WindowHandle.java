package techproed.day11_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

import java.awt.*;

public class C03_WindowHandle extends TestBase {
    @Test
    public void test01() {
         /*
        Eger sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle baska sayfaya gittikten sonra
        tekrar ilk actiginiz sayfaya dnmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir degiskene handle degerini assign ederseniz tekrar ilk acilan sayfaya donmek istediginizde
        driver.switchTo().window(ilksayfaHandleDegeri) ile gecis yapabilirsiniz
         */
        /*
        WindowType.WINDOW ile de WindowType.TAB ile de driver' i her halukarda tasimiz oluruz.Birinde yeni pencerede acilirken digerinde yeni sekmede acilir
         */

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle ="Techpro Education | Online It Courses & Bootcamps";
        assert actualTitle.equals(expectedTitle);
        String techpro = driver.getWindowHandle();
        //Window 2'de yeni bir pencerede https://www.youtube.com sayfasını açınız:
        driver.switchTo().
                newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String youtube = driver.getWindowHandle();

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().
                newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedin = driver.getWindowHandle();
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techpro);
        wait(2);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtube);
        wait(2);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedin);
        wait(2);
    }
}
