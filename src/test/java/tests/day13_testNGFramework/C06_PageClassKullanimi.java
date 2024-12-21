package tests.day13_testNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_PageClassKullanimi {

    // 3 farkli test methodu olusturup, asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidip url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmadan "phone" bulundugunu test edin

    public static TestotomasyonuPage testotomasyonuPage;

    @Test(groups = "smoke")
    public void anasayfaTesti(){
        testotomasyonuPage = new TestotomasyonuPage();
        // 1- testotomasyonu anasayfaya gidip
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);
    }

    @Test(dependsOnMethods = "anasayfaTesti", groups = {"smoke","regression"})
    public void phoneAramaTesti(){
        testotomasyonuPage = new TestotomasyonuPage();
        // 2- phone icin arama yapip
        ReusableMethods.bekle(2);

        testotomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(2);

        // urun bulunabildigini test edin

        String unExpectedSonuc = "4 Products Found";
        String actualSonuc = testotomasyonuPage.aramaSonucuElementi.getText();

        Assert.assertEquals(actualSonuc,unExpectedSonuc);

    }

    @Test(dependsOnMethods = "phoneAramaTesti",groups = {"smoke","E2E"})
    public void ilkUrunIsimTesti(){
        // 3- ilk urunu tiklayip,
        testotomasyonuPage.ilkUrunElementi
                .click();

        // urun isminde case sensitive olmadan "phone" bulundugunu test edin

        String expectedIsimIcerik = "phone";

        String actualUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi
                .getText()
                .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

        Driver.quitDriver();

    }
}
