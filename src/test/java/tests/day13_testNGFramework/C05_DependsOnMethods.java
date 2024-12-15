package tests.day13_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C05_DependsOnMethods {

    @Test(priority = 0)
    public void anasayfaTest(){
        Driver.getDriver().get("https://www.testotomasyonua.com");
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrlIcerik = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));
    }

    @Test(priority = 1, dependsOnMethods = "anasayfaTest")
    public void phoneAramaTest(){

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        WebElement urunVarMi = Driver.getDriver().findElement(By.className("product-count-text"));

        int bulunanUrunString = Integer.parseInt(urunVarMi.getText().replaceAll("\\D",""));

        int sonucSayisi = bulunanUrunString;

        Assert.assertEquals(sonucSayisi,4);
    }

    @Test(priority = 2,dependsOnMethods = "phoneAramaTest")
    public void urunIsimTesti(){

        Driver.getDriver().findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        WebElement urunIsmiSensitive = Driver.getDriver().findElement(By.xpath(" //*[@class=' heading-sm mb-4']"));

        String expectedIcerik = "phone";
        String actualIcerik = urunIsmiSensitive.getText().toLowerCase();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

        Driver.quitDriver();


    }
}
