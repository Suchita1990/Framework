package com.keywordframework.goibibo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords
{
  public static void OpenBrowser(String browserName)
  {
 switch (browserName)
   {
case "Chrome":
	   WebDriverManager.chromedriver().setup();
	   Constants.driver=new ChromeDriver();
	   Constants.driver.manage().window().maximize();
	// Constants.driver.manage().window().fullscreen();
	   break;
case "Firefox" :
	   WebDriverManager.firefoxdriver().setup();
	   Constants.driver=new FirefoxDriver();
	   break;
case "IE":
	  WebDriverManager.iedriver().setup();
	  Constants.driver=new InternetExplorerDriver();
	  break;
case "Opera":
	  WebDriverManager.operadriver().setup();
	  Constants.driver=new OperaDriver();
	  break;

default:
	 System.out.println("Invalid BrowserName Provided: "+browserName);
	 break;
}
  }
  public static void OpenUrl(String url)
  {
	  Constants.driver.get(url);
 }
 
  public static void clickOnMenuBar()
  {
   Constants.driver.findElement(By.cssSelector("#header")).click();
  }

  public static void clickOnElement(String locatorType,String locatorValue) 
  {
	switch (locatorType)
	{
	case "NAME":
		Constants.driver.findElement(By.className(locatorValue)).click();;
		break;
	case "CSS":
		Constants.driver.findElement(By.cssSelector(locatorValue)).click();;
		break;
	case "ID":
		Constants.driver.findElement(By.id(locatorValue)).click();;
		 break;
	case "LINK_TEXT":
		Constants.driver.findElement(By.linkText(locatorValue)).click();
		break;
	case "XPATH":
		Constants.driver.findElement(By.xpath(locatorValue)).click();
		break;
	case "CLASSNAME":
		Constants.driver.findElement(By.className(locatorValue)).click();
        break;
	default:System.out.println("Invalid locatorType");
		break;
	}
	  
  }
   public static String VerifyLogo()
   {
     return Constants.driver.findElement(By.cssSelector("a.hdrLogo")).getText();
  }
   public static void VerifySupportLink()
   {
      Constants.driver.findElement(By.xpath("//span[text()=' 24x7 goCare Support']k")).click();
	      
   }
 
public static boolean isElementPresent(By cssSelector)
{
	return true;
}
}

