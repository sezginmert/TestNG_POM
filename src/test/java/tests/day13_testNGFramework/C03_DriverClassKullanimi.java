package tests.day13_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C03_DriverClassKullanimi {

    @Test
    public void testotomasyonuTest(){

        Driver.getDriver().get("https://testotomasyonu.com");

        String expctedUrl = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expctedUrl));

        Driver.quitDriver();
    }

    @Test
    public void wisequarterTest(){

        Driver.getDriver().get("https://wisequarter.com");

        String expctedUrl = "wisequarter";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expctedUrl));

        Driver.quitDriver();
    }

    @Test
    public void bestbuyTest(){

        Driver.getDriver().get("https://bestbuy.com");

        String expctedUrl = "bestbuy";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expctedUrl));

        Driver.quitDriver();
    }
}
