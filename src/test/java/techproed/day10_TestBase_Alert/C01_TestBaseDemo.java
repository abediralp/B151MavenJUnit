package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    @Test
    public void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //2 saniye bekle
        wait(2);

        //Başlığın Bootcamp içerdiğini test edelim
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Bootcamp"));
    }
}
