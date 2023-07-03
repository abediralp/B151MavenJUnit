package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C01_Actions extends TestBase {

    @Test
    public void test01() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        wait(1);
        //sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();
        wait(2);
    }

    @Test
    public void test02() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //sayfanın altına scroll yapalim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        wait(2);

        //sayfanın üstüne scroll yapalim
        actions.sendKeys(Keys.HOME).perform();
        //build() --> methodu action'ları birleştirmek için kullanılan methoddur.Birden fazla oluşturduğumuz action
        //objesini birbirine bağlar
        //release() -->methodu mouse'u serbest birakir
        wait(2);
    }

    @Test
    public void test03() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //sayfanın altına dogru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,3000).perform();
        wait(1);

        //sayfanın üstüne dogru gidelim
        actions.scrollByAmount(0,-3000).perform();

        wait(2);
    }
}
