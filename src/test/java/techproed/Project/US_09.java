package techproed.Project;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class US_09 extends TestBase {

    @Test
    public void test01() {

        driver.get("https://fakemail.net");
        String mail = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@class='color cetc']")).click();

        //Go to homepage



        //Click the "Register" button
        driver.findElement(By.xpath("(//div/a/span)[5]")).click();

        //Click the "Signup as a vendor?" button
        driver.findElement(By.className("register_as_vendor")).click();
        String register = driver.getWindowHandle();

        //Enter the email address
        driver.findElement(By.id("user_email")).sendKeys(Keys.CONTROL+"v",Keys.TAB);


        //Verify that "Verification code sent to your email" notification has arrived.

        wait(9);
        String actual = driver.findElement(By.xpath("//*[@class='wcfm-message email_verification_message wcfm-success']")).getText();
        String expected = "Verification code sent to your email: amine.arfan@fixedfor.com.";
        assert actual.equals(expected);

        //Access the email acoount and retrieve the verification code


        //Enter the verification code
        //Enter a password that includes uppercase, lowercase, digit and special char
        //Enter the password again
        //Click the "Register" button
        //Check the registration text.



    }
}
