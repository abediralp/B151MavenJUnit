package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WindowHandles extends TestBase {
    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String windowHanle1 = driver.getWindowHandle();
        System.out.println(windowHanle1);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String test1 = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",test1);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        assert driver.getTitle().equals("The Internet");

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//-> Kontrolumuz disinda yeni bir sekme acildi.driver'i gecirmemiz lazim
        wait(2);
        /*
            Bir button'a click yaptığımızda kontrolümüz dışında yeni bir sekme yada pencere açılırsa
         yeni açılan pencerenin handle değerini bilmediğim için normal getWindowHandle ile driver'imi yeni pencere
         geçiremem. Bunu getWindowHandles() methoduyla açılan tüm pencereleri bir Set'e assign edip, ilkaçtiğimiz
         pencere değilse ikinci açılan yeni penceredir mantığıyla bir loop için çözebiliriz
         */
        Set<String> tabs= driver.getWindowHandles();
        for (String s:tabs) {
            System.out.println(s);
            if(!s.equals(windowHanle1)){
                driver.switchTo().window(s);
            }

        }

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        assert driver.getTitle().equals("New Window");
        String windowHandle2 = driver.getWindowHandle();
        wait(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(windowHanle1);
        assert driver.getTitle().equals("The Internet");
        wait(2);
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(windowHandle2);
        wait(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(windowHanle1);
        wait(2);
    }

    @Test
    public void test02() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String test1 = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",test1);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        assert driver.getTitle().equals("The Internet");

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        wait(2);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        List<String> tabs =new ArrayList<>(driver.getWindowHandles());

        /*
            getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
        Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
        driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
         */

        driver.switchTo().window(tabs.get(1));
        assert driver.getTitle().equals("New Window");
        wait(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(tabs.get(0));
        assert driver.getTitle().equals("The Internet");
        wait(2);
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(tabs.get(1));
        wait(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(tabs.get(0));
        wait(2);

    }

    @Test
    public void test03() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        wait(2);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        /*
    Set ve ArrayList kullanmadan switchTo() methodu icine arguman olarak driver.getWindowHandles() methodu ile butun acilan
    pencereli bir array olarak alip index belirterek istedigim pencereye gecis yapabilirim
        */
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewWindow);
        wait(2);

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle,ilkSayfaActualTitle);
        wait(2);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        wait(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        wait(2);
    }
}
