package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_Dropdown {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test1() {
        //programming languages ddm den istediginiz 4 secenegi seciniz
        WebElement languages = driver.findElement(By.xpath("//*[@name = 'Languages']"));
        Select select=new Select(languages);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);
        //Eger sadece secili olan option'lari yani secenekleri yazdirmak istersek
        select.getAllSelectedOptions().forEach(t-> System.out.println(t.getText()));

        //Seceneklerden 4 tane sectigimizi dogrulayalim
        Assert.assertEquals(4,select.getAllSelectedOptions().size());

        //Sectigimiz seceneklerden ilkini yazdiralim
        System.out.println(select.getFirstSelectedOption().getText());

        //Sectigimiz seceneklerin hepsini kaldiralim
        bekle(2);
        select.deselectAll();


        //visibleText olarak secim yapacagimiz bir method olusturup programming languages ddm den bir secenek secelim
        selectVisibleText(languages,"Java");

        bekle(1);
        //index olarak secim yapacagimiz bir method olusturup programming languages ddm den bir secenek secelim
        selectIndex(languages,2);

        bekle(1);
        //value olarak secim yapacagimiz bir method olusturup programming languages ddm den bir secenek secelim
        selectValue(languages,"python");

        bekle(2);


    }
    public void selectVisibleText(WebElement ddm,String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }
    public void selectIndex(WebElement ddm, int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
