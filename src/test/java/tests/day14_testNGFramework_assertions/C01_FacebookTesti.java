package tests.day14_testNGFramework_assertions;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C01_FacebookTesti {

    @Test
    public void negatifLoginTesti(){

        Driver.getDriver().get("https://facebook.com/");

        FacebookPage facebookPage = new FacebookPage();

        Faker faker = new Faker();

        facebookPage.emmailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());
        facebookPage.loginButonu.click();

        Assert.assertTrue(facebookPage.loginButonu.isDisplayed());
    }
}
