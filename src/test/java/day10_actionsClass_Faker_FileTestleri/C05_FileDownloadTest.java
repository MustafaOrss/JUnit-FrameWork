package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileDownloadTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //-> https://the-internet.herokuapp.com/download adresine gidelim
        driver.get("https://the-internet.herokuapp.com/download");
        // -> foto.png dosyasini indirelim
        WebElement fotoElementi = driver.findElement(By.linkText("some-file.txt"));
        fotoElementi.click();
        Thread.sleep(2000);

        //-> Dosyasinin basariyla indirilip indirilmedigini test edelim

        //Dosyayi download klasorune indirecektir
        String dosyaYolu = "C://Users//MustafaOrs//Downloads";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // Herkesin bilgisayarinda farkli dosya hiyerarsisi oldugu icin
        // Herkesin dosya yolu farkli olur Dosya yolunu dinamik hale getirmek icin Java'dan yardim almamiz gerekir.

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
    }
}
