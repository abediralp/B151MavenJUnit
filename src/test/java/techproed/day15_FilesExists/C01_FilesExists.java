package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;


import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {
        /*
            Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
        kontrol etmek varlığını doğrulamak için ya da bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulabilmek
        için;
            Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
        dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu))
        Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
        assing ederiz.
        */

        String docPath = "C:/Users/kizil/Desktop/my-cv.pdf";
        System.out.println(Files.exists(Paths.get(docPath)));
        Assert.assertTrue(Files.exists(Paths.get(docPath)));

    }

    @Test
    public void test02() {
        String docPath = "C:\\Users\\kizil\\Desktop\\lebenslauf.docx";
        System.out.println(Files.exists(Paths.get(docPath)));
        Assert.assertTrue(Files.exists(Paths.get(docPath)));
    }
    @Test
    public void test03() {
    /*
        Bir server'da farkli işlerim sistemleri ile aynı anda dosya varlığını test etmek istediğimiz zaman,
    daha dinamik olması açısından System.getProperty("os.name") bu şekilde işletim sistemi alır
    her işletim sistemin kullanıcı yolu farklı olacağından System.getProperty("user.home")
    bilgisayarımızdaki kullanıcı yolunu bu şekilde String bir değişkene farklıYol ismiyle System.getProperty("user.home")
    atayarak her seferinde farklı yolları almayla uğraşmamış oluruz. Dosya diyelimki masaüstünde ve her işletim
    sisteminde bize aynı yolu vereceği için bunuda ortakYol olarak bir String'e assing ederiz
     */
        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("oxs.name");//-->İşletim sistemimizin adını verir
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));//-->Bilgisayarımızdaki kullanıcı yolunu verir
        if (isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home");//-->Windows 10/-->C:\Users\Lenovo
        }else if (isletimSistemiAdi.contains("mac")){
            farkliYol = "/Users/aycapolatkamali";//-->Mac işletim sistemi yolu
        }
        String ortakYol = "/OneDrive/Masaüstü/sen.txt";
        String dosyaYolu = farkliYol+ortakYol;
    }
}
