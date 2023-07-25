package techproed.day16_SeleniumWait;

import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C04_ExplicitWaitClassWork extends TestBase {
    @Test
    public void test01() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Click me to open an Alert buttonuna basalım
        driver.findElement(By.id("alert")).click();

        //Çıkan Alert'ü kapatalım
        alertwait(10);
    }
}
