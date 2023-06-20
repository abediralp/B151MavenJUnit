package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Iframe extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String title = driver.findElement(By.xpath("//h3")).getText();
        assert title.contains("Editor");

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame(0);
        WebElement testBox = driver.findElement(By.xpath("//p"));
        wait(2);
        testBox.clear();

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        testBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        wait(2);
        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement elemental = driver.findElement(By.xpath("(//a)[3]"));
        System.out.println("is Displayed = "+elemental.isDisplayed());
        Assert.assertTrue(elemental.isDisplayed());

    }

}
