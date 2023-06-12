package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class C02_Dropdown {
        /*
    DROPDOWN --->Alt basliklarin oldugu acilir menu listesidir.
    dropdown u handle(automate) etmek icin
        1-dropdown menuyu ilk olarak locate ederiz
        2-Select objesi olusturuuz
        3-select objesinin ddm webelementlerinin iceriginine ve seceneklerine erisim saglamak icin
        SELECT sinifina arguman olarak locate ettigimizwebelementleri koyariz
        SYNTAX:
        Select select0 nev Select(ddm webelement)
        4-Select classi sadece <select > tag i ile olusturulmus dropdown menulere uygulanabilir
        5-Select objesi ddm yi handle edebilmek icin 3 method kullanilir
            a-selectByVisibleText()->-> Ddm'deki elemente gorunur metin ile ulasmak icin kullanilir
            b-selectbyIndex()->Index ile ulasmak icin kullanilir(Index 0(sifir))'dan baslar
            c-selectByValue()-> Elementin degeri ile ulasmak icin kullanilir(option tag'larindaki deger(value) ile)
        6-getOptions() -> locate ettigimiz tum secenekleri bize verir.(List e atip loop ile yazdirabiliriz)
        7-getFirstselectedOption()->Ddm deki secili kalan secenegi bize verir.Birden fazla secenek secildiyse bu secilenlerin ilkini verir
        8-Ddm ' sendKeys() methodu ile de menude istenen veriyi yazarak getirebiliriz.
     */

    /*
       Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
       -3 farklı test methodu oluşturalım
           1.Method:
               a. Yil,ay,gün dropdown menu'leri locate ediniz
               b. Select objesi olustur
               c. Select object i kullaarak 3 farkli sekilde secim yapiniz
           2.Method:
               a. Tüm eyalet isimlerini yazdıralım
           3.Method:
               a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

        */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {
        /*
        a. Yil,ay,gün dropdown menu'leri locate ediniz
               b. Select objesi olustur
               c. Select object i kullaarak 3 farkli sekilde secim yapiniz
         */

        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        Select select =new Select(year);
        Select select1 = new Select(month);
        Select select2 = new Select(day);
        select.selectByValue("1997");
        select1.selectByIndex(3);
        select2.selectByVisibleText("2");
    }

    @Test
    public void test02() {
        /*
        2.Method:
               a. Tüm eyalet isimlerini yazdıralım
         */
        //1.Yol
        WebElement states =driver.findElement(By.id("state"));
        Select select = new Select(states);
        select.getOptions().forEach(t-> System.out.println(t.getText()));

        //2.Yol
        List<WebElement> listOfStates = driver.findElements(By.id("state"));
        for (WebElement e:listOfStates) {
            System.out.println(e.getText());
        }
    }

    @Test
    public void test03() {
        /*
         3.Method:
               a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
         */
        WebElement state=driver.findElement(By.id("state"));
        Select select = new Select(state);
        WebElement first = select.getFirstSelectedOption();
        String actual = first.getText();
        Assert.assertTrue(actual.equals("Select a State"));
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
