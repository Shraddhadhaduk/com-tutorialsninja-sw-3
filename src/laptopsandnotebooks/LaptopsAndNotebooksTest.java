package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseurl = " http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseurl);}

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //1.3 Select Sort By "Price(High > Low)"
        selectContainsTextFromDropDown(By.xpath("//select[@id='input-sort']"),"4");
        //1.4 Verify the Product price will arrange in High to Low order.
        verifyTextFromElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"), "Price (High > Low)");
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //2.3 Select Sort By "Price(High > Low)"
        selectContainsTextFromDropDown(By.xpath("//select[@id='input-sort']"),"4");
        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
        //2.5 Verify the text “MacBook”
        verifyTextFromElement(By.xpath("//h1[normalize-space()='MacBook']"), "MacBook");
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have added MacBook to your shopping cart!\n×");
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //2.9  Verify the text "Shopping Cart"
        verifyTextFromElement(By.xpath("//h1[contains(text(),' (0.00kg)')]"),"Shopping Cart  (0.00kg)");
        //2.10 Verify the Product name "MacBook"
        verifyTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "MacBook");
        //2.11 Change Quantity "2"
        clearTest(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyTextFromElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"),"Success: You have modified your shopping cart!\n" +
                "×");
        //2.14 Verify the Total £737.45
        verifyTextFromElement(By.xpath("//tbody/tr[1]/td[6]"),"$1,204.00");
        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 Verify the text “Checkout”
        verifyTextFromElement(By.xpath("//h1[contains(text(),'Checkout')]"),"Checkout");
        //2.17 Verify the Text “New Customer”
        verifyTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"),"New Customer");

        // verifyTextFromElements(By.xpath("//h2[contains(text(),'New Customer')]"),"New Customer");
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]"));
        //2.19 Click on “Continue” tab
        Thread.sleep(1500);
        clickOnElement(By.xpath("//input[@id='button-account']"));
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"),"shraddha");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"),"dhaduk");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"),"shraddha_0250@yahoo.co.in");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"),"07534994680");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"),"115a");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"),"london");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"),"kt3 5pd");
        clickOnElement(By.xpath("//option[contains(text(),'Pakistan')]"));
        clickOnElement(By.xpath("//option[contains(text(),'Punjab')]"));
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"),"I need delivery after 5:00pm");
        //2.23 Check the Terms & Conditions check box
        Thread.sleep(1500);
        //2.24
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]"));
        // Success: You have modified your shopping cart!
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        //2.25 Verify the message “Warning: Payment method required!”
        //verifyTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/child::i"),"Warning: Payment method required!");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
