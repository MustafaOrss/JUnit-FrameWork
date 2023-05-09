package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {


        // Bu class icerisinde 3 test calistiralim,
        // 1- Google anasayfasina gidin url'in, google icerdigini test edin
        // 2- Wisequarter ana sayfaya gidin, url'in wisequarter icerdigini test edin
        // 3- Amazon anasayfaya gidin, amazon logosunun goruldugunu test edin


        //JUnit'in bize sagladigi ilk ve belkide en onemli ozellik test method'larinin bagimsiz olarak calistirabilmesini saglayan
        // @Test notasyonudur

        //JUnit ile class level'dan birden fazla test method'u calistirirsak
        //hangi siralama ile calistiracagini ongoremeyiz ve yonetemeyiz

        // diyelim ki bir test method'u uzerinde calisiyorsunuz ve o method'un toplu calistirilmalarda kullanilmasini istemiyorsunuz


    WebDriver driver;

    @Test
    public void googleTest(){
        System.out.println("google test");
        mahserin4Atlisi();
        String expectedIcerik = "google";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Google test PASSED");
        }
        else
        {
            System.out.println("Url google icermiyor, Google test FAILED");
        }

    }
    @Test
    public void wiseTest(){
        System.out.println("wise test");
        mahserin4Atlisi();
        String expectedicerik = "wisequarter";

        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedicerik)){
            System.out.println("Google test PASSED");
        }
        else
        {
            System.out.println("Url google icermiyor, Google testi FAILED");
        }

    }

    @Test
    public void amazonTest(){
        System.out.println("amazon test");
        mahserin4Atlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi = driver.findElement(By.id("nav-logo-sprites"));
        if(amazonLogoElementi.isDisplayed())
        {
            System.out.println("Amazon test PASSED");
        }
        else{
            System.out.println("Amazon logosu gorunmuyor, Amazon test FAILED");
        }
    }
    public void mahserin4Atlisi (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}