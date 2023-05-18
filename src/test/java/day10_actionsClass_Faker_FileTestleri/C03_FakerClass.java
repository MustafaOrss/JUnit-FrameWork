package day10_actionsClass_Faker_FileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_FakerClass extends TestBase {

    /*
        Faker kutuphanesi fake degerler olusturabilecegimiz bir kutuphanedir
        buradan deger uretebilmek icin faker class'indan bir obje olusturmaliyiz

     */
    @Test
    public void test01() throws InterruptedException {
        //1-> https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        // 2-> Yeni Hesap Olustur butonuna basalim
        driver.findElement(By.xpath("//a[@*='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // 3-> Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        // 4-> Kaydol tusuna basalim
        Actions actions = new Actions(driver);
        WebElement isimKutusu = driver.findElement(By.xpath("//div[@class='_5dbb']"));
        Faker faker= new Faker();
        String email = faker.internet().emailAddress();

        actions.click(isimKutusu).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys("15").sendKeys(Keys.TAB)
                .sendKeys("Mar").sendKeys(Keys.TAB).sendKeys("1990")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);
    }
}
