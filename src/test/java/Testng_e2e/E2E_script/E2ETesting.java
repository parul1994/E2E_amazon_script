package Testng_e2e.E2E_script;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E2ETesting {

	public static void main(String args[]) throws InterruptedException
	{
		
	//WebDriver driver=new ChromeDriver();
	WebDriver driver=new EdgeDriver();
	jbjdriver.manage().window().maximize(); 	
	driver.manage().deleteAllCookies();
	String baseurl=("https://www.amazon.in/");
	driver.get(baseurl);
	
	driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
	driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("parul.ridhima@gmail.com");
    driver.findElement(By.xpath("//span[@id=\"continue\"]")).click();
    driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Parul@123");
    driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
    
    //Search box functionality
	 driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("LAPTOP");
	 driver.findElement(By.xpath("//span[@id='nav-search-submit-text']")).click();
    
	//new window opening functionality
	  driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span[1]")).click();
     
	 Set<String> s =  driver.getWindowHandles();
	 ArrayList ar = new ArrayList(s);
	 System.out.println("First tab id: " + ar.get(0));
	 System.out.println("First tab id: " + ar.get(1));
	 
	 driver.switchTo().window((String)ar.get(1));
	 
	// Select the quantity statement by index value, visible text, by value
	 
	 WebElement qty=driver.findElement(By.xpath("//select[@id='quantity']"));
	 Select sel=new Select(qty);
	 sel.selectByIndex(2);
	
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\"]")).click();
			
	 //Proceed to checkout
			
	 WebDriverWait wait= new WebDriverWait(driver,  Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']"))).click();		
	 			
	 
	 // Log out from account
	 		Thread.sleep(2000);
	 		driver.navigate().back();		 
	 		Actions action = new Actions(driver);
	 
			 WebElement hover = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
			 action.moveToElement(hover).build().perform();
			 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Sign Out']"))).click();
			 
			// WebElement hover2 = driver.findElement(By.xpath("//span[normalize-space()='Sign Out']"));
			 //action.moveToElement(hover2);
			 //action.click().build().perform();
			
	
	}
}
