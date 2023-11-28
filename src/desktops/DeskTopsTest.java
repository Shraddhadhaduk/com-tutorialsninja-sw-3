package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeskTopsTest extends Utility {
    String baseurl = " http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseurl);}

    @Test
    public void verifyProductArrangeInAlphabeticalOrder(){
        //1.1 Mouse hover on Desktops Tab.and click
       mouseHoverToElementAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));

       //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

       //1.3 Select Sort By position "Name: Z to A"*/
       // mouseHoverToElementAndClick(By.linkText("Desktops"));
        //clickOnElement(By.linkText("Show All Desktops"));
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // 1.3 Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // 1.4 After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        Assert.assertEquals("Product not sorted into Z to A order",
                originalProductsName, afterSortByZToAProductsName);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){
        //2.1 Mouse hover on Currency Dropdown and click
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        //2.2 Mouse hover on £Pound Sterling and click
        clickOnElement(By.xpath("//button[@name='GBP']"));
        //2.3  Mouse hover on Desktops Tab.
        mouseHoverToElementAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
        //2.4  Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //2.5 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (A - Z)");
        //2.6 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));
        //2.7 Verify the Text "HP LP3065
        verifyTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']"), "HP LP3065");
        //2.8 Select Delivery Date "2023-11-27"
        String year = "2023";
        String month = "November";
        String date = "27";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
        // 2.9 Enter Qty "1” using Select class
        //sendTextToElement(By.name("quantity"), Keys.DELETE + "1");
        // 2.10 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!
        verifyTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Success: You have added HP LP3065 to your shopping cart!\n×");
        //2.12  Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //2.13  Verify the text "Shopping Cart"
        //verifyTextFromElement(By.xpath("//a[normalize-space()='shopping cart']"), "shopping cart ");
        //2.14 Verify the Product name "HP LP3065"
        verifyTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']"), "HP LP3065");
        //2.15 Verify the Delivery Date "2023-11-27"
        verifyTextFromElement(By.xpath("//input[@id='input-option225']"), "2023-11-27");
        //2.16 Verify the Model "Product21"
        verifyTextFromElement(By.xpath("//li[normalize-space()='Product Code:Product 21']"), "Product 21");
        //2.17 Verify the Total "£74.73"
        verifyTextFromElement(By.xpath("//h2[normalize-space()='£74.73']"), "£74.73");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}

