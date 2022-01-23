package techproed.tests.smoketest;

import org.testng.annotations.Test;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigurationReader;
import techproed.utilities.Driver;

public class Day13_NegativeScenario {

    /*
Go to url
Use login page
add some username and password to config file
and do a negative login
 */
    LoginPage loginPage = new LoginPage();

    @Test
    public void negativeScenario(){
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));

    }


}
