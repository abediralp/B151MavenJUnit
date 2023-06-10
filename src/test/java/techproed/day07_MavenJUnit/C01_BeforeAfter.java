package techproed.day07_MavenJUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C01_BeforeAfter {

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra bir kez calisir.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan once bir kez calisir.");
    }

    @Test
    public void test1() {
        System.out.println("Test 1 methodu calisti");
    }

    @Test
    public void test2() {
        System.out.println("Test 2 methodu calisti");
    }

    @Test
    public void test3() {
        System.out.println("Test 3 methodu calisti");

    }
}
