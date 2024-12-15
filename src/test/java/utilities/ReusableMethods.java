package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye ){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            System.out.println("Thread.sleep calismadi");
        }


    }

    public static List<String> stringListeyeDonustur(List<WebElement> webElementList){
        List<String> tumListeStr = new ArrayList<>();

        for (WebElement eachBaslik:webElementList){

            tumListeStr.add(eachBaslik.getText());
        }

        return tumListeStr;
    }

    public static void urlIleWindowDegistir(WebDriver driver, String hedefUrl){
        Set<String> tumWindowWhdSeti = driver.getWindowHandles();
        for(String eachWhd :tumWindowWhdSeti){

            driver.switchTo().window(eachWhd);

            if (driver.getCurrentUrl().equals(hedefUrl)){
                break;
            }

        }
    }

    public static void titleIleWindowDegistir(WebDriver driver, String hedefTitle){
        Set<String> tumWindowWhdSeti = driver.getWindowHandles();
        for(String eachWhd :tumWindowWhdSeti){

            driver.switchTo().window(eachWhd);

            if (driver.getTitle().equals(hedefTitle)){
                break;
            }

        }
    }

    public static void tumSayfaScreenshotIsimli(WebDriver driver , String rapoIsmi){

        // 1.adim tss objesi olusturalim
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // 2.adim resmi kaydedecegimiz File'i olusturalim
        File asilResim = new File("target/screenshots/" + rapoIsmi + ".jpeg");

        // 3.adim screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi kaydedilemedi");
        }
    }

    public static void tumSayfaScreenshotTarihli(WebDriver driver){

        // once tarih etiketi olusturalim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyMMddHHmmss");

        String tarihEtiketi = ldt.format(format1);

        // 1.adim takesScreenshot objesi olusturalim
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // 2.adim resmi kaydedecegimiz File'i olusturalim
        File asilResim = new File("target/screenshots/TumSayfaSS" + tarihEtiketi + ".jpeg");

        // 3.adim screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi kaydedilemedi");
        }
    }

    public static void tumSayfaScreenshotIsimVeTarihli(WebDriver driver,String isim){

        // once tarih etiketi olusturalim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyMMdd_HHmmss");
        String tarihEtiketi = ldt.format(format1);

        // 1.adim tss objesi olusturalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim resmi kaydedecegimiz File'i olusturalim
        File asilResim = new File("target/screenshots/" + isim +"_"+ tarihEtiketi +".jpeg");


        // 3.adim screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi kaydedilemedi");
        }

    }

    public static void webElementScreenshotIsimli(WebElement targetElement, String rapoIsmi ){

        // 1.adim screenshot alacagimiz webelementi locate edip kaydedelim
        //        biz yukarda Logout butonunu locate ettik

        // 2.adim resmi kaydedecegimiz File'i olusturalim
        File asilResim = new File("target/screenshots/" + rapoIsmi+".jpeg");


        // 3.adim webElement'i kullanarak screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = targetElement.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,asilResim);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webbElementScreensshotTarihli(WebElement targetElement){

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarihEtiketi = ldt.format(format1);

        File asilDosya = new File("target/screenshots/WebElement" + tarihEtiketi + ".jpeg");

        File geciciDosya =  targetElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,asilDosya);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void webElementScreenshotTarihVeIsimli(WebElement targetElement,String raporIsmi){

        // once tarih etiketi olusturalim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyMMdd_HHmmss");
        String tarihEtiketi = ldt.format(format1);


        // 1.adim screenshot alacagimiz webelementi locate edip kaydedelim
        //        biz yukarda Logout butonunu locate ettik

        // 2.adim resmi kaydedecegimiz File'i olusturalim
        File asilResim = new File("target/screenshots/"+raporIsmi +"_"+ tarihEtiketi +".jpeg");


        // 3.adim webElement'i kullanarak screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = targetElement.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,asilResim);
        } catch (IOException e) {
            System.out.println("Fotograf cekilemedi");
        }
    }



}
