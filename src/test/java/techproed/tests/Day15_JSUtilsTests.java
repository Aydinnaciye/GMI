package techproed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.annotations.Test;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigurationReader;
import techproed.utilities.Driver;
import techproed.utilities.JSUtils;
import techproed.utilities.ReusableMethods;

public class Day15_JSUtilsTests {

    @Test
    public void scrollIntoViewTest(){
        //Going to the Url
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        //scroll into pricing plan Element
        WebElement pricingPlan =Driver.getDriver().findElement(By.xpath("//*[.≠'Pricing Plan']"));
        JSUtils.scrollIntoViewJS(pricingPlan);
        ReusableMethods.waitFor(2);
        Driver.closeDriver();
    }
   @Test
    public void clickWithJSTest(){
        //javascript Executer click work better than selenium click
       LoginPage loginPage= new LoginPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        ReusableMethods.waitFor(1);
        JSUtils.clickElementByJS(loginPage.loginDropDown);
        JSUtils.clickElementByJS(loginPage.signInButton);
        JSUtils.clickElementByJS(loginPage.loginButton);
   }
   @Test
    public void scrollDownThePage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        JSUtils.scrollDownByJS();
   }
   @Test
    public void flashTest(){
        LoginPage loginPage = new LoginPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        JSUtils.clickElementByJS(loginPage.loginDropDown);
        JSUtils.clickElementByJS(loginPage.signInButton);
        JSUtils.flash(loginPage.loginButton);
   }
}
