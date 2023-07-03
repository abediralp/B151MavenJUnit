package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here
        Actions actions = new Actions(driver);
        /*
        drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
         */
        driver.switchTo().frame(0);
        WebElement targetElement =driver.findElement(By.cssSelector("div[id='draggable']"));
        WebElement destination =driver.findElement(By.cssSelector("div[id='droppable']"));
        actions.dragAndDrop(targetElement,destination).perform();
        wait(2);
        /*
            Eğer bir hareketli webelementi tutup başka bir webelementin üzerene bırakmak istersek
         sürüklemek istediğimiz we'tin locatini alıp üzerine bırakacağımız we'tin locate'ini de alarak
         dragAndDrop(kaynak,hedef) methodu ile işlemi gerçekleştirebiliriz
         */
    }

    @Test
    public void test02() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        //And user moves the target element(Drag me to my target) in to  destination(Drop here
        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
        WebElement targetElement =driver.findElement(By.cssSelector("div[id='draggable']"));
        WebElement destination =driver.findElement(By.cssSelector("div[id='droppable']"));

        actions.clickAndHold(targetElement).moveToElement(destination).release().perform();
        wait(2);

    }

    @Test
    public void test03() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        //And user moves the target element(Drag me to my target) in to  destination(Drop here
        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
        WebElement targetElement =driver.findElement(By.cssSelector("div[id='draggable']"));
        WebElement destination =driver.findElement(By.cssSelector("div[id='droppable']"));

        actions.clickAndHold(targetElement).
                moveByOffset(84,28).//--> Belirtilen konuma web elementi tasir
                release().//--> Mouse u devre disi birakir
                perform();
        wait(2);

    }
}
