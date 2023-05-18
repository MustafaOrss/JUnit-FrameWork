package day07_JUnit_dropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownMenu {
    // • https://the-internet.herokuapp.com/dropdown adresine gidin.
    // 1. Index kullanarak Seçenek 1'i (Option 1) secin ve yazdirin
    // 2. Value kullanarak Secenek 2'gi (Option 2) segin ve yazdarin
    // 3. Visible Text (Görünen metin) kullanarak Segenek 1'i (Option 1) secin ve yazdiran
    //
    // 4. Tüm dropdown degerleri(value) yazdrin
    // 5. Dropdown' un boyutunun 4 oldugunu test edin

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public void dropdownTest(){

        // • https://the-internet.herokuapp.com/dropdown adresine gidin.
            driver.get("https://the-internet.herokuapp.com/dropdown");
        // 1. Index kullanarak Seçenek 1'i (Option 1) secin ve yazdirin
        WebElement dropdownMenuElementi = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(dropdownMenuElementi);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        // 2. Value kullanarak Secenek 2'gi (Option 2) segin ve yazdarin
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        // 3. Visible Text (Görünen metin) kullanarak Segenek 1'i (Option 1) secin ve yazdiran
            select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //
        // 4. Tüm dropdown degerleri(value) yazdrin
        List<WebElement> optionList = select.getOptions();
        System.out.println("========================");
        for (WebElement eachElement: optionList
              ) {
            System.out.println(eachElement.getText());

        }
        // 5. Dropdown' un boyutunun 4 oldugunu test edin
        int expectedSize = 4;
        int actualSize = optionList.size();

        Assert.assertEquals(expectedSize,actualSize);

    }


}
