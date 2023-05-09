package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertions {

       // 1) Bir class olusturun : BestBuyAssertions
      // 2) https://www.bestbuy.com/ Adresine gidin farkli test method'lari olusturarak asagidaki testleri yapin
     //  sayfa URL'nin  https://www.bestbuy.com/ 'a esit oldugunu test edin
    //  titleTest => Sayfa basliginin "Rest" icermedigini(contains) test edin

    WebDriver driver = new ChromeDriver();

    public void mahserinAtlilari()
    {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void test01(){
        mahserinAtlilari();
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Test
    public void test02(){
        String unExpectedIcerik = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(unExpectedIcerik));

         }

}
