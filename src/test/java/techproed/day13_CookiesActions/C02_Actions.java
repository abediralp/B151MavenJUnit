package techproed.day13_CookiesActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        Actions actions = new Actions(driver);
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).// sag click yapma methodu
                perform();// actions islemiyle yapacagimiz islemi uygulamak icin veya sonlardirmak icin perform() methodu kullanilir.

        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        String expectedAlert = "You selected a context menu";
        Assert.assertEquals(expectedAlert,getTextAlert());// TestBase deki getTextAlert() methodunu kullanidik
        wait(2);

        //Tamam diyerek alert'i kapatın
        acceptAlert();// TestBase deki acceptAlert() methodunu kullanidik
        wait(2);
    }
}
