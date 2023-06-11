package techproed.day08_BeforeClassAfterClass_Assertion;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;

public class C06_Asserstion {
    @Test
    public void test01() {
        Assert.assertEquals(2,2);
        System.out.println("Test passed");
    }

    @Test
    public void test02() {
        Assert.assertEquals(4,5);
        System.out.println("Test passed");
    }

    @Test
    public void test03() {
        Assert.assertNotEquals(5,6);
        System.out.println("Test passed");
    }

    String name =  "Ahmet";
    String name1 = "ahmet";
    @Test
    public void test04() {
        Assert.assertEquals(name,name1);
        System.out.println("Test passed");
    }

}
