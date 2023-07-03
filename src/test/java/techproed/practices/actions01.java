package techproed.practices;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class actions01 extends TestBase {
    @Test
    public void test01() {

    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    driver.get("http://webdriveruniversity.com/Actions");
    wait(2);

    //2- Hover over  Me First" kutusunun ustune gelin
        WebElement hoverover = driver.findElement(By.xpath("//*[@class='dropdown hover']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverover).perform();
    wait(2);

    //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//div[@class='dropdown-content'])[1]")).click();
    wait(2);

    //4- Popup mesajini yazdirin
        getTextAlert();
    wait(2);

    //5- Popup'i tamam diyerek kapatin
        acceptAlert();
    wait(2);

    //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();
    wait(2);

    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());
        wait(2);

        //8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
    WebElement doubleClick = driver.findElement(By.id("double-click"));
    actions.doubleClick(doubleClick).perform();
    WebElement isDisplayed = driver.findElement(By.xpath("//div[@class='div-double-click double']"));
        Assert.assertTrue(isDisplayed.isDisplayed());
        wait(2);
    }
}
