package cairo360.cairo360;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CartAssertions {
	ChromeDriver Register;
  @Test
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
			
				
  }
  @Test
  public void validate() throws InterruptedException {
  WebElement popup= Register.findElementByXPath("//strong[text()='Total']/parent::td/following-sibling::td");
	String total = popup.getText();
	Assert.assertEquals(total, "$2,404.00");
	System.out.println("Total Passed");
	WebElement unitprice= Register.findElementByXPath("//strong[text()='Sub-Total']/parent::td/following-sibling::td");
	String productprice = unitprice.getText();
	Assert.assertEquals(productprice,  "$2,000.00");
	System.out.println("unitprice Passed");
	
	
  }
  
  @Test
  public void validate1() throws InterruptedException {
  WebElement productname= Register.findElementByXPath("//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[2]/a");
	String name = productname.getText();
	Assert.assertEquals(name,  "Sony VAIO");
	System.out.println("name Passed");
	
	WebElement productquantity= Register.findElementByXPath("//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[3]");
	String quantity = productquantity.getText();
	Assert.assertEquals(quantity,  "x 2");
	System.out.println("quantity Passed");
	
  }
 
  
  @BeforeTest
  
	  public void openbrowser() throws IOException {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+
					"\\Driver\\chromedriver.exe");
			Register=new ChromeDriver();
			Register.get("http://tutorialsninja.com/demo/");	
			Register.manage().window().maximize();
  }
  

  @AfterTest
  public void afterTest() {
  }

}
