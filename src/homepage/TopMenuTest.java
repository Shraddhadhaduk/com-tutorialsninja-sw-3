package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseurl = " http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseurl);}

    //1.1,1.2 create method with name selectMenu
     public void selectMenu(By by, String menu){
         WebElement click = driver.findElement(by);
         click.sendKeys(menu);
     }
     @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        //1.1 mouse hover on Desktops and click
         mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

        //1.2 call select menu method and pass the menu = "Show All Desktops"
         clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));

        //1.3 verify the text
        verifyTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]"),"Desktops");
     }

     @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        //2.1 mouse hover on laptop and notebook tab and click
         mouseHoverToElementAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"));

         //2.2 call select menu method and pass the menu = "Show All Laptops & Notebooks"
         clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));

       //2.3 verify text
       verifyTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"),"Laptops & Notebooks");
     }

     @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        //3.1 mouse hover on component tab and click
        mouseHoverToElementAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Components']"));

       //3.2 call select menu and pass = "“Show All Components"
         clickOnElement(By.xpath("//a[contains(text(),'Show AllComponents')]"));

       //3.3 verify text
        verifyTextFromElement(By.xpath("//h2[contains(text(),'Components')]"), "Components");
     }
     @After
    public void tearDown(){
        closeBrowser();
     }

}
