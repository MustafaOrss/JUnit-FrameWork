package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_dosyaYolunuDinamikYapma {
    @Test
    public void test01(){
        // Herkesin bilgisayarinda farkli dosya hiyerarsisi oldugu icin
        // Herkesin dosya yolu farkli olur Dosya yolunu dinamik hale getirmek icin Java'dan yardim almamiz gerekir.

        System.out.println(System.getProperty("user.dir"));
        //Projenin dosya yolunu verir
        //C:\Users\MustafaOrs\com.Team113JUnit
        System.out.println(System.getProperty("user.home"));
        //C:\Users\MustafaOrs

        /*
         biz Dowloads'a indirdigim dosyanin dosya yolunu 2'ye bolecegiz

         */

    String dosyaYoluDegisenKisim = System.getProperty("user.home");
        String dosyaYoluHerkesteAyniOlanKisim = "/Downloads/sonuc.png";

        String dosyaYolu = dosyaYoluDegisenKisim + dosyaYoluHerkesteAyniOlanKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // Ayni islemi projemizin altindaki deneme.txt icin yapsak
        dosyaYoluDegisenKisim = System.getProperty("user.dir");
        dosyaYoluHerkesteAyniOlanKisim = "/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";
        dosyaYolu = dosyaYoluDegisenKisim + dosyaYoluHerkesteAyniOlanKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
