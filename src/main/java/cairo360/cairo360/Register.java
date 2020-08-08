package cairo360.cairo360;

import org.testng.annotations.Test;

//import testngpackage.maventestng.definetestdataandcount;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Register {
	ChromeDriver Register;
	
	// JavascriptExecutor js = (JavascriptExecutor) Register;
	
	
	
	public void Addtocart() throws InterruptedException {
		Register.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		Register.findElementByXPath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a").click();
		Register.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		Register.findElement(By.linkText("Show All Desktops")).click();
		Register.findElementByXPath("//*[@id=\"content\"]/div[4]/div[12]/div/div[2]/div[1]/h4/a").click();
		Register.findElementByXPath("//*[@id=\"input-quantity\"]").clear();
		Register.findElementByXPath("//*[@id=\"input-quantity\"]").sendKeys("2");
		Register.findElementByXPath("//*[@id=\"button-cart\"]").click();
		Register.findElementByXPath("//*[@id=\"cart\"]/button").click();

		Register.findElementByXPath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong").click();
		Thread.sleep(1000);
		Register.findElementByXPath("//*[@id=\"button-account\"]").click();

	

	}

	
	public void Billingdetails() throws InterruptedException, InvalidFormatException, FileNotFoundException, IOException {
		Thread.sleep(1000);
		 //Getting the current date
	      Date date = new Date();
	      //This method returns the time in millis
	      long timeMilli = date.getTime();
	      
		Register.findElementByName("firstname").sendKeys("hend");
		Register.findElementByName("lastname").sendKeys("mohamed");
		Register.findElementByName("address_1").sendKeys("address" +timeMilli );
		Register.findElementByXPath("//*[@id=\"input-payment-email\"]").sendKeys(timeMilli+ "@gmail.com");
		Register.findElementByName("telephone").sendKeys("1234567");

		
		Register.findElementByName("city").sendKeys("cairo");
		Register.findElementByName("postcode").sendKeys("+20");
		JavascriptExecutor js = (JavascriptExecutor) Register;
		js.executeScript("window.scrollBy(0,200)", "");
		// Thread.sleep(2000);
		Register.findElementByXPath("//*[@id=\"input-payment-password\"]").sendKeys("123456");
		Register.findElementByXPath("//*[@id=\"input-payment-confirm\"]").sendKeys("123456");
		Select country = new Select(Register.findElement(By.name("country_id")));
		country.selectByVisibleText("Afghanistan");
		Select Region = new Select(Register.findElement(By.name("zone_id")));
		Region.selectByVisibleText("Badakhshan");
		Register.findElementByXPath("//*[@id=\"collapse-payment-address\"]/div/div[4]/div/input[1]").click();
		Register.findElementByXPath("//*[@id=\"button-register\"]").click();

	}


	public void DeliveryDetails() {
		try {
			Thread.sleep(1000);
			Register.findElementByXPath("//*[@id=\"button-shipping-address\"]").click();
		}

		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	
	public void DeliveryMethod() throws InterruptedException {
		Thread.sleep(1000);
		Register.findElementByXPath("//*[@id=\"collapse-shipping-method\"]/div/p[4]/textarea").sendKeys("test");
		Register.findElementByXPath("//*[@id=\"button-shipping-method\"]").click();
	}

	
	public void PaymentMethod() throws InterruptedException {
		Thread.sleep(1000);
		Register.findElementByXPath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]").click();
		Register.findElementByXPath("//*[@id=\"button-payment-method\"]").click();
	}

	
	public void ConfirmOrder() throws InterruptedException {

		System.out.println("Inside confirm order");
		Thread.sleep(7000);
		Register.findElementByXPath("//*[@id=\"button-confirm\"]").click();
		Register.findElementByXPath("//*[@id=\"content\"]/div/div/a").click();

	}
	
	@Test
	public void RegisterClient()
	{
		try
		{
			Addtocart();
			Billingdetails();
			DeliveryDetails();
			DeliveryMethod();
			PaymentMethod();
			ConfirmOrder();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			
		}
	}

	
	@BeforeTest
	public void openbrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		Register = new ChromeDriver();
		Register.get("http://tutorialsninja.com/demo/");
		Register.manage().window().maximize();
	}

	
	@AfterTest
	public void afterTest() {

	}

}
