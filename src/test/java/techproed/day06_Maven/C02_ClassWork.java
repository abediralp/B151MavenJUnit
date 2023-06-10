package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.xpath("//div//li//button")).click();

        //3.Login alanine "username" yazdirin
        //4.Password alanine "password" yazdirin
        driver.findElement(By.xpath("(//div//input)[1]")).sendKeys("username", Keys.TAB, "password", Keys.TAB, Keys.TAB, Keys.ENTER);
        driver.navigate().back();
        //5.Sign in buttonuna tiklayin

        //6.Online Banking altinda Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='online-banking']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8.tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.cssSelector("input[id='sp_amount']")).sendKeys("500",Keys.TAB,"2020-09-10");

        //9.Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("input[id='pay_saved_payees']")).click();

        //10."The payment was successfully submitted." mesajinin ciktigini control edin
        String actualMessage = driver.findElement(By.cssSelector("div[id='alert_content']")).getText();
        String expectedMessage = "The payment was successfully submitted.";
        if (actualMessage.equals(expectedMessage)){
            System.out.println("TEST PASSED");
        }   else System.out.println("TEST FAILED");

        driver.close();
    }
}
