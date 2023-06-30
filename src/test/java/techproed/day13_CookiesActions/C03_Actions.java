package techproed.day13_CookiesActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_Actions extends TestBase {
    @Test
    public void test01() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
        Actions actions = new Actions(driver);
        WebElement account = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(account).perform();
        wait(1);
        driver.findElement(By.xpath("(//*[@class='nav-text'])[3]")).click();

        //Acilan sayfanin Title in "Your Account" icerdigini dogrula

        Assert.assertTrue(driver.getTitle().contains("Your Account"));


    }
}
