package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    static WebDriver driver;

    @BeforeClass
    public static void before() throws Exception {
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");
    }

    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("qa", Keys.ENTER);

    }

    @Test
    public void test02() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("developer", Keys.ENTER);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
    }

}
