package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeydownKeyup extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://google.com/");
        driver.findElement(By.cssSelector("div[class='QS5gu sy4vM']")).click();
        wait(3);

       //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
       WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
       Actions actions = new Actions(driver);
       actions.keyDown(searchBox, Keys.SHIFT).//--> Arama kutusunda SHIFT tusuna bastik
               sendKeys("selenium").
               keyUp(Keys.SHIFT).//--> Shift tusunu serbest biraktik
               sendKeys("java",Keys.ENTER).
               perform();

       wait(2);



    }

    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://google.com/");
        driver.findElement(By.cssSelector("div[class='QS5gu sy4vM']")).click();
        wait(2);

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);
        wait(2);
        /*
    Mause işlemleri için actions class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri için
    actions class'ına kullanmadan sendKeys() methodu ile de istediğimiz bir metni büyük yazdırabilir,
    hatta bir den fazla klavye tuşlana bastırabiliriz. Yukardaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
    sonrasında yazdırmak istediğimiz metni küçük harfle yazmamıza rağmen büyük harflerle yazdırdı, tekrar Keys.SHIFT
    kullanarak shift tuşunu serbest bırakmış olduk
     */
    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://google.com");
        driver.findElement(By.cssSelector("div[class='QS5gu sy4vM']")).click();

        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium");
        driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]")).click();


        //Sayfayı bekleyin
        wait(4);

        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']")).//-->sayfa yenilendiği için tekrar locate aldık
                sendKeys(Keys.CONTROL,"a");//-->Metni kesebilmemiz için önce ctrl+a ile seçmemiz gerekir
        wait(2);
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"x");//-->Seçilen metni ctrl+x ile kestik
        wait(2);
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"v",Keys.ENTER);//-->Kestiğimiz metni ctrl+v tusu ile tekrar arama kutusuna yapıştırdık ve arattık
    }
}
