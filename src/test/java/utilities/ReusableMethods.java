package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReusableMethods {
    public static void tumSayfaFotografCek(WebDriver driver) throws IOException {

        TakesScreenshot tss = (TakesScreenshot) driver;

        LocalDateTime ldt = LocalDateTime.now();

        String tarihEtiketi  ="TumSayfa"+ldt.getYear()+ldt.getMonth()
                +ldt.getDayOfMonth()
                +ldt.getHour()
                +ldt.getMinute()
                +ldt.getSecond()+".png";

        String path = "target/ekranResimleri/"+tarihEtiketi;

        File tumSayfaFotograf = new File(path);

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,tumSayfaFotograf);

    }

    public static void webElementFotografCek(WebDriver driver, WebElement webElement) {

        LocalDateTime ldt = LocalDateTime.now();

        String tarihEtiketi  ="webElementi"+ldt.getYear()+ldt.getMonth()
                +ldt.getDayOfMonth()
                +ldt.getHour()
                +ldt.getMinute()
                +ldt.getSecond()+".png";

        String path = "target/ekranResimleri/"+tarihEtiketi;

        File tumSayfaFotograf = new File(path);

        File geciciResim = webElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciResim,tumSayfaFotograf);
        } catch (IOException e) {

        }

    }


}
