package techproed.practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class dropdown03 {
    /*
    1.http://zero.webappsecurity.com/ Adresine gidin
    2.Sign in butonuna basin
    3.Login kutusuna “username” yazin
    4.Password kutusuna “password.” yazin
    5.Sign in tusuna basin(not: navigate.Back yapınız)
    6.Pay Bills sayfasina gidin
    7.“Purchase Foreign Currency” tusuna basin
    8.“Currency” drop down menusunden Eurozone’u secin
    9.“amount” kutusuna bir sayi girin
    10.“US Dollars” in secilmedigini test edin
    11.“Selected currency” butonunu secin
    12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
     */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test() {
        //    1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //    2.Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        //    3.Login kutusuna “username” yazin  //    4.Password kutusuna “password.” yazin
        driver.findElement(By.id("user_login")).sendKeys("username", Keys.TAB,"password",Keys.TAB,Keys.TAB,Keys.ENTER);

        //    5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.navigate().back();

        //    6.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//a[@id='online-banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //    7.“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//*[@class='ui-state-default ui-corner-top'])[2]")).click();

        //    8.“Currency” drop down menusunden Eurozone’u secin
        WebElement currency = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currency);
        select.selectByValue("EUR");
        currency.sendKeys(Keys.TAB,"500");
        //    9.“amount” kutusuna bir sayi girin


        //    10.“US Dollars” in secilmedigini test edin
        WebElement usDollars = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usDollars.isSelected());

        //    11.“Selected currency” butonunu secin
        WebElement selectedCurrency = driver.findElement(By.id("pc_inDollars_false"));
        selectedCurrency.click();
        selectedCurrency.sendKeys(Keys.TAB);

        //    12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        selectedCurrency.sendKeys(Keys.TAB,Keys.SPACE,Keys.TAB,Keys.ENTER);

        //    “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        String last = driver.findElement(By.id("alert_content")).getText();
        Assert.assertEquals("Foreign currency cash was successfully purchased.",last);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
