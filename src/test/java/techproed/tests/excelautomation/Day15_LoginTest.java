package techproed.tests.excelautomation;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.EmployeeDefaultPage;
import techproed.utilities.ConfigurationReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtil;
import techproed.pages.LoginPage;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;

public class Day15_LoginTest {

    /*
   * We will get the credentials from excel sheet
   * We will send multiple credentials from excel
    */
    //Create excel util object
    ExcelUtil excelUtil;
    //Create a list of map of string to store the username-password
    List<Map<String,String>> testData;
    //{user1,pass1}, {user2,pass2},{user3,pass3},...}

    LoginPage loginPage=new LoginPage();
            EmployeeDefaultPage employeeDefaultPage=new EmployeeDefaultPage();
    public void logIn() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        ReusableMethods.waitFor(1);
        loginPage.loginDropDown.click();
        ReusableMethods.waitFor(1);
        try{
            loginPage.signOut.click();
            ReusableMethods.waitFor(1);
            loginPage.loginDropDown.click();
           ReusableMethods.waitFor(1);
        }catch (Exception e){
            System.out.println("Sign out link is not exist");
        }
        loginPage.signInButton.click();
       // loginPage.username.sendKeys(ConfigurationReader.getProperty("employee_username"));
       // loginPage.passWord.sendKeys(ConfigurationReader.getProperty("employee_password"));
        //loginPage.loginButton.click();
    }



    @Test
    public void  employeeLoginTest() throws InterruptedException, IOException {
    //path of the excel sheet
             String path="/src/test/java/resources/mysmoketestdata.xlsx";
             //shet name on the excel sheet
        String sheetName ="employee_login_info";
        //Create the class object
        excelUtil= new ExcelUtil(path,sheetName);
        //Get the data using any proper  excel util method
        //getDataList()=>return the data list as list of map of string
        //System.out.println(excelUtil.getDataList);
        testData=excelUtil.getDataList();
        //System.out.println(testData);//Testing if username  password list accessable

        for (Map<String,String>eachData :testData){
         //   System.out.println(eachData);
            logIn();
            loginPage.username.sendKeys(eachData.get("username"));
            Thread.sleep(1000);
            loginPage.passWord.sendKeys(eachData.get("password"));
            Thread.sleep(1000);
            loginPage.loginButton.click();
             Thread.sleep(1000);
             //Asserting if log in is successful using my operation element
           // Assert.assertTrue(EmployeeDefaultPage.myOperationsDropdown.isDisplayed());
             ReusableMethods.getScreenshot("LoginSuccess");
        }
    }
@AfterMethod
    public void tearDown(){
        Driver.closeDriver();
}
    }

