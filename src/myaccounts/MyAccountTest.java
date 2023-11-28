package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.Random;

public class MyAccountTest extends Utility {
    String baseurl = " http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseurl);}
    public void selectMyAccountOptions(String option) {
        if (option.equalsIgnoreCase("Register")) {
            clickOnElement(By.xpath("//li[@class='dropdown open']/ul/li[1]"));
        } else if (option.equalsIgnoreCase("Login")) {
            clickOnElement(By.xpath("//li[@class='dropdown open']/ul/li[2]"));
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
      //1.1 click on my account link
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
      //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        clickOnElement(By.xpath("//a[normalize-space()='Register']"));
      //1.3 Verify the text “Register Account”.
      verifyTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"), "Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
      //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
      //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));
      //2.3 Verify the text “Returning Customer”
        verifyTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']"), "Returning Customer");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        //3.1 click on my account link
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        clickOnElement(By.xpath("//a[normalize-space()='Register']"));
        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Shraddha");
        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "dhaduk");
        //3.5 Enter Email
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        sendTextToElement(By.xpath("//input[@id='input-email']"), "Happy"+ randomInt +"@gmail.com");
        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "0987654321");
        //3.7  Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "1234");
        //3.8 confirm password
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "1234");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        //3.12 Verify the message “Your Account Has Been Created!”
        verifyTextFromElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"), "Your Account Has Been Created!");
        //3.13 click on continue
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
        //3.16 Verify the text “Account Logout”
        verifyTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"), "Account Logout");
        //3.17 click on continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));
        //4.3 Enter email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "happy@gmail.com");
        //4.5 enter password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "1234");
        //4.6 click on login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //4.7 Verify text “My Account”
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
        //3.16 Verify the text “Account Logout”
        verifyTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"), "Account Logout");
        //3.17 click on continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
    }

    @After
    public void tearDown(){
        closeBrowser();
    }



}
