package techproed.day13_CookiesActions;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import techproed.utilities.TestBase;

import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com/");

        /**
        Cookie'leri listelemek istersek
            driver.manage().getCookies() methodu ile bir Set ya da ArraList'e atarak listeyebiliriz
        */
        //2-tum cookie’leri listeleyin
        Set<Cookie> cookies = driver.manage().getCookies();
        //Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);
        int sayac = 1;
        for (Cookie w: cookies){
            System.out.println(sayac+" cookie : "+w);
            System.out.println(sayac+" cookie name : "+w.getName());//-->Sadece cookie lerin ismini alir
            System.out.println(sayac+" cookie value : "+w.getValue());//-->Sadece cookie lerin degerini alir
            sayac++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("Cookielerin sayisi = "+cookies.size());
        Assert.assertTrue(cookies.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookies = driver.manage().getCookies();

        for (Cookie each: cookies){
            System.out.println(each);
        }
        System.out.println(cookies.size());
        System.out.println("Cookielerin sayisi= "+Arrays.stream(driver.manage().getCookies().toArray()).count());

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookies = driver.manage().getCookies();
        int i=1;
        for (Cookie each: cookies){
            System.out.println(i+". cookie : "+each.getName());
            i++;
        }
        System.out.println(cookies.size());

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookies =driver.manage().getCookies();
        assert cookies.isEmpty();
    }
}
