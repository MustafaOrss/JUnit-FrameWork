package day13_ExcelOtomasyonu_ScreenShot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void test01() throws IOException {

        String dosyaYolu = System.getProperty("user.dir") + "/src/test/java/day12_webTables_excelOtomasyon/ulkeler.xlsx/";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        // 1-> 4.Hucreye yeni bir cell olusturalim
        Sheet sheet = workbook.getSheet("Sayfa1");

        // 2-> Olusturdugumuz hucreye "Nufus" yazdiralim
        sheet.getRow(0).createCell(4).setCellValue("Nufus");
        // 3-> 2. satir nufus kolonuna 1500000 yazdiralim
        sheet.getRow(1).createCell(4).setCellValue("1500000");
        // 4-> 10. satir nufus kolonuna 250000 yazdiralim
            sheet.getRow(9).createCell(4).setCellValue("250000");
        // 5-> 15. satir nufus kolonuna 54000 yazdiralim
        sheet.getRow(14).createCell(4).setCellValue("54000");
        // 6-> Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        fis.close();
        fos.close();
        workbook.close();
    }
}
