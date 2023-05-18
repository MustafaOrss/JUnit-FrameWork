package day09_switchingWindow_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_ActionsClass extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // Cizili alan uzerinde sag click yapin ve alani locate edin
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlan).perform();

        // Alert'te cikan yazinin "You selected a context menu" oldugunu test edin
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi =driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        // Tamam diyerek Alert'i kapatin
        driver.switchTo().alert().accept();
        // Elemental Selenium linkine tiklayalim
        // Linki tikladigimizda yeni window acildigindan tiklamadan once ilk window'un WHD olmamiz gerekir
        String ilkWindowWHD =driver.getWindowHandle();
         driver.findElement(By.linkText("Elemental Selenium")).click();
         // Ikinci sayfa biz newWindow() demeden acildigindan
        // ikinciWindow'un WHD'ini Java kullanarak bulmaliyiz
        String ikinciWindowWHD ="";
        Set<String> windowHDegerleriSeti = driver.getWindowHandles();// icinde 2 tane WHD var
        // ilkWindowWHD'e esit olmayani ikinciWindowWHD olarak atayalim

        for (String eacWHD : windowHDegerleriSeti
             ) {
            if(!eacWHD.equals(ilkWindowWHD)){
                ikinciWindowWHD=eacWHD;
            }

        }
        driver.switchTo().window(ikinciWindowWHD);
        // Acilan sayfada h1 taginda "Elemental Selenium" yazdigini test edelim
       String expectedYazi = "Elemental Selenium";
       WebElement yaziElementi = driver.findElement(By.tagName("h1"));
       String actualYazi = yaziElementi.getText();
       Assert.assertEquals(expectedYazi,actualYazi);

        Thread.sleep(3000);

    }
}
