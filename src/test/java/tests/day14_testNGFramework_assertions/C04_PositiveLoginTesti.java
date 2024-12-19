package tests.day14_testNGFramework_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_PositiveLoginTesti {

    @Test
    public void dinamikPositiveLoginTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }
}
