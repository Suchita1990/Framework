package com.keywordframework.goibibo;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.axisbank.keywords.Keyword;
import com.keywordframework.browser.Utils;
import com.keywordframework.browser.constants;

public class TestScriptOfHomePage
{
  @Test
  public void Openhomepage()
  {
    Keywords.OpenBrowser("Chrome");
    Keywords.OpenUrl("https://www.goibibo.com/");
  }
  @Test
  public void goibiboLogoVerification() throws Exception 
  {
	Constants.driver.findElement(By.cssSelector(".hdrLogo>img")).click();
	Thread.sleep(3000);
	Assert.assertEquals(constants.driver.getTitle().contains("goibibo.com"),true);
  }
  @Test
  public void VerifyHomePageLogo()
  {
	String expectedLogo="goibibo.com";
	String actualLogo=Keywords.VerifyLogo();
	try {
          Assert.assertEquals(actualLogo, expectedLogo);
           System.out.println("Test Pass");
	    }catch(Throwable e)
	    {
	    	System.out.println("Test Fail");
	     }
  }
  @Test
  public void VerifyMenuItems()
  {
    WebElement flights=Constants.driver.findElement(By.xpath("//span[text()='Flights']"));
     flights.isDisplayed();
     
   WebElement hotels=Constants.driver.findElement(By.xpath("//span[contains(text(),'Hotels')]"));
     hotels.isDisplayed();
     
//   WebElement hotels1=Constants.driver.findElement(By.xpath("//span[contains(text(),'Hotels')]"));
//     hotels.isDisplayed();
     
   WebElement bus=Constants.driver.findElement(By.xpath("//span[text()='Bus']"));
     bus.isDisplayed();
     
    WebElement Irctctrain=Constants.driver.findElement(By.xpath("//span[text()='IRCTC Trains']"));
    Irctctrain.isDisplayed();
    
    WebElement cabs=Constants.driver.findElement(By.xpath("//span[text()='Cabs']"));
    cabs.isDisplayed();
    
    WebElement visa=Constants.driver.findElement(By.xpath("//span[text()='Visa']"));
    visa.isDisplayed();
  }
   @Test
    public void VerifySignIn() throws Exception 
    {
	    Keywords.clickOnElement("CSS", "#get_sign_in");
    	Actions actions = new Actions(Constants.driver);
    	WebElement sign = Constants.driver.findElement(By.cssSelector("#get_sign_in"));
        actions.moveToElement(sign).build().perform();
    	Thread.sleep(10000);
     // Constants.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void closePop_Up() 
    {
    	Keywords.clickOnElement("CSS", "div.popContent>a");
    	Actions actions = new Actions(Constants.driver);
      WebElement cross=Constants.driver.findElement(By.cssSelector("div.popContent>a"));
         actions.moveToElement(cross).build().perform();
    }
    
   @Test
    public void VerifySignUpPage()
    {
      Keywords.clickOnElement("CSS", "#get_sign_up");
      Actions actions= new Actions(Constants.driver);
      WebElement signup = Constants.driver.findElement(By.cssSelector("#get_sign_up"));
      actions.moveToElement(signup).build().perform();
    }
   @Test
   public void CloseSignUpPage() 
   {
     Keywords.clickOnElement("CSS", "div.popContent>a");
     Actions actions=new Actions(Constants.driver);
     WebElement close=constants.driver.findElement(By.cssSelector("div.popContent>a"));
     actions.moveToElement(close).build().perform();
   }
   @Test
   public void VerifygoCareSupport_link() throws Exception
   {
	 //Keywords.clickOnElement("XPATH", "//span[text()=' 24x7 goCare Support']k");
	 WebElement support=Constants.driver.findElement(By.xpath("//span[@class='txtCente dib']"));
	 new Actions(Constants.driver).moveToElement(support).click().build().perform();
   }
   @Test
   public void CheckEarncreditslink()
   {
     Constants.driver.findElement(By.xpath("//span[@class='fl ico13 lh1-2 padL5 posRel width100 txtCenter padT2']")).click();
   }
   @Test
   public void VerifyAlignItems() 
   {
      assertTrue(Keywords.isElementPresent(By.cssSelector("#oneway")));
      assertTrue(Keywords.isElementPresent(By.cssSelector("#roundTrip")));
      assertTrue(Keywords.isElementPresent(By.cssSelector("#multiCity")));
    	  
   }
}
  
