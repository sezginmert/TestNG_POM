package tests.day16_htmlReports;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_RaporluPozitifLoginTesti extends TestBaseRapor {

    /*
        TestNG kendisi HTML rapor olusturamaz

        HTML rapor olusturabilmek icin
        farkli dependency'ler kullanilabilir
        biz aventstack dependency kullandik

         aventstack raporlama icin 3 objeye ihtiyac duyar
         Bu objeleri her class'da olusturmak ve gerekli islemleri yapmak yerine
         bu isslemleri bizim adimiza yapacak bir TestBaseRapor olusturduk

         olusturlmasi gereken 3 obje TestBaseRapor'da olusturuldu
         bu objeleri ve yapilan ayarlari kullanmanin
         en kisa yolu extends keyword ile TestBaseRapor'u parent edinmektir

         TestBaseRapor'da olusturulan 3 objeden
         extentReports ve extentHtmlReporter'a deger atamasi yapildi
         extentTest'e deger atamasi her test method'unda yapilmalidir

         HTML raporda gorunmesini istedigimiz test adimlarini
         extentTest objesi ile rapora isleyebiliriz
     */

    @Test
    public void raporluPositiveLoginTesti(){

        extentTest = extentReports.createTest("Pozitife Login Testi","Gerekli bilgilerle sisteme giris yapilabildigini test eder");

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("TestOtomasyonu.com sitesine gidildi");

        ReusableMethods.bekle(1);
        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        Actions actions = new Actions(Driver.getDriver());
        testotomasyonuPage.accountLinki
                .click();
        extentTest.info("Account linkine tiklandi");

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Gecerli email adresi girildi");

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Gecerli sifre girildi");
        ReusableMethods.bekle(1);
        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginButonu
                .click();
        extentTest.info("Login butonuna tiklandi");

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());
        extentTest.pass("Basarili giris yapildi");

        ReusableMethods.bekle(1);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // logout olun
        testotomasyonuPage.logoutButonu
                .click();
        extentTest.info("Logout yapildi ve çıkış yapıldı");


        extentTest.info("Test tamamlandi ve sayfa kapatiliyor");

    }
}
