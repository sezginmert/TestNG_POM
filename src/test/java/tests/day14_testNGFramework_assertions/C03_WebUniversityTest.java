package tests.day14_testNGFramework_assertions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebDriverUniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C03_WebUniversityTest {

    @Test
    public void popupTest(){
        WebDriverUniversityPage webDriverUniversityPage = new WebDriverUniversityPage();
        //1."https://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("https://webdriveruniversity.com/");
        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.PAGE_DOWN);
        //3."Login Portal" a tiklayin
        webDriverUniversityPage.loginButton.click();
        //4.Diger window'a gecin
        String ilkWhd = Driver.driver.getWindowHandle();

        Set<String> tumWhd = Driver.driver.getWindowHandles();

        for (String eachWhd:tumWhd){
            if (!eachWhd.equals(ilkWhd)){
                Driver.getDriver().switchTo().window(eachWhd);
            }
        }
        //5."username" ve "password" kutularina deger yazdirin
        webDriverUniversityPage.userName.sendKeys("asdfg");
        webDriverUniversityPage.password.sendKeys("L02154654");
        //6."login" butonuna basin
        webDriverUniversityPage.loginClick.click();
        ReusableMethods.bekle(1);
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedText = "validation failed";
        String actualText = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualText,expectedText);
        //8.Ok diyerek Popup'i kapatin
        Driver.getDriver().switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        Driver.getDriver().switchTo().window(ilkWhd);
        //10.Ilk sayfaya donuldugunu test edin

        Assert.assertTrue(webDriverUniversityPage.loginButton.isDisplayed());


    }
}
