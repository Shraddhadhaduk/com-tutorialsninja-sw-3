package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    public void clickOnElement(By by) {

        driver.findElement(by).click();
    }

    public void verifyTextFromElement(By by, String expectedText) {
        WebElement actualText = driver.findElement(by);
        String actual = actualText.getText();
        Assert.assertEquals(expectedText, actual);
    }

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        actions.moveToElement(mouseHover).build().perform();
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);

    }
    public void sendTextToElement(By by,String text){

        driver.findElement(by).sendKeys(text);
    }
    public void selectContainsTextFromDropDown(By by, String text){
        WebElement dropdown = driver.findElement(by);
        //create the object of select class
        /*Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        for(WebElement option : options){
            System.out.println(option.getText());*/
        }
    public void clearTest(By by) {
        WebElement qty = driver.findElement(by);
        qty.clear();
    }

    }


