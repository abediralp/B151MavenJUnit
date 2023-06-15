package techproed.practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class dropdown01 {
    /*
        ●https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.
     */

    WebDriver driver;
    @Before
    public  void setup() throws Exception {
        driver= new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void option1() {
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement option1 = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(option1);
        select.selectByIndex(1);
        System.out.println("1 "+select.getFirstSelectedOption().getText());
        bekle(1);

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println("2 "+select.getFirstSelectedOption().getText());
        bekle(1);

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByVisibleText("Option 1");
        System.out.println("3 "+select.getFirstSelectedOption().getText());
        bekle(1);

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> list = select.getOptions();
        System.out.println("*************************");
        list.forEach(t-> System.out.println(t.getText()));

        //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        bekle(2);
        if (list.size()==4){
            System.out.println("True");
        }else System.out.println("False");

        bekle(2);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
