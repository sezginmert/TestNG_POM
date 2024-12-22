package tests.day16_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluNegativeLoginTesti extends TestBaseRapor {


    TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

    @Test(groups = "smoke")
    public void gecersizPasswordTesti(){
        testotomasyonuPage = new TestotomasyonuPage();
        extentTest = extentReports.createTest("Gecersiz Password Testi","Gecerli email ve gecersiz password ile login olunamamasi test edilir");
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("TestOtomasyonu.com sitesine gidildi");
        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();
        extentTest.info("Account linkine tiklandi");
        // 3- 3 farkli test method’u olusturun.
        // - gecerli email, gecersiz password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Gecerli email adresi girildi");
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("Gecersiz password girildi");
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginButonu.click();
        extentTest.info("Login butonuna basildi");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigi test edildi");

        extentTest.info("Test tamamlandi ve sayfa kapatiliyor");

    }

    @Test(groups = {"smoke","regression"})
    public void gecersizEmailTesti(){
        extentTest = extentReports.createTest("Gecersiz Email Testi","Gecersiz email ve gecerli password ile login olunamamasi test edilir");
        testotomasyonuPage = new TestotomasyonuPage();
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("TestOtomasyonu.com sitesine gidildi");
        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();
        extentTest.info("Account linkine tiklandi");
        // 3- 3 farkli test method’u olusturun.
        // - gecersiz email, gecerli password
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        extentTest.info("Gecersiz email adresi girildi");
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Gecerli password girildi");
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginButonu.click();
        extentTest.info("Login butonuna basildi");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigi test edildi");

        extentTest.info("Test tamamlandi ve sayfa kapatiliyor");

    }

    @Test(groups = {"smoke","E2E"})
    public void gecersizEmailGecersizPasswordTesti(){
        extentTest = extentReports.createTest("Gecersiz Email ve Gecersiz Password Testi","Gecersiz email ve gecersiz password ile login olunamamasi test edilir");
        testotomasyonuPage = new TestotomasyonuPage();
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("TestOtomasyonu.com sitesine gidildi");
        //2- account linkine basin
        testotomasyonuPage.accountLinki.click();
        extentTest.info("Account linkine tiklandi");
        // 3- 3 farkli test method’u olusturun.
        // - gecersiz email, gecersiz password.
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        extentTest.info("Gecersiz email adresi girildi");
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        extentTest.info("Gecersiz password girildi");
        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginButonu.click();
        extentTest.info("Login butonuna basildi");
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigi test edildi");

        extentTest.info("Test tamamlandi ve sayfa kapatiliyor");

    }
}
