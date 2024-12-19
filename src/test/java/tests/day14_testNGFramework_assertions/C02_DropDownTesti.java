package tests.day14_testNGFramework_assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class C02_DropDownTesti {


    @Test
    public void dropdownTesti(){
        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();


        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");
        //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        Select selectGun = new Select(testOtomasyonuFormPage.gunDdm);
        selectGun.selectByIndex(5);
        //3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        Select selectAy = new Select(testOtomasyonuFormPage.ayDdm);
        selectAy.selectByValue("nisan");
        //4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        Select selectYil = new Select(testOtomasyonuFormPage.yilDdm);
        selectYil.selectByVisibleText("1990");
        //5- Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText() + "\n" +
                selectAy.getFirstSelectedOption().getText() + "\n" +
                selectYil.getFirstSelectedOption().getText());
        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın
        System.out.println(ReusableMethods.stringListeyeDonustur(selectAy.getOptions()));
        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        int expectedSonuc = 13;
        int actualSonuc = selectAy.getOptions().size();

        Assert.assertEquals(actualSonuc,expectedSonuc);

    }
}
