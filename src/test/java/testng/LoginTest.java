package testng;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test
	public void test1() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Automation Testing Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
	    Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30));
	    fluentWait.until(ExpectedConditions.visibilityOf(LoginLink));
	    
	    LoginLink.click();
	    
	   WebElement UserName = driver.findElement(By.name("user_login"));
	   UserName.sendKeys("abcd@rt.com");
	   
	   WebElement Password = driver.findElement(By.id("password"));
	   Password.sendKeys("Adcvvrrrrr123!!!!");
	   
	   WebElement Remember = driver.findElement(By.xpath("//label[@class='rememberMe']"));
	   Remember.click();
	   
	   WebElement LoginButton = driver.findElement(By.name("btn_login"));
	   LoginButton.click();
	   
	   WebElement Error = driver.findElement(By.id("msg_box"));
	   
	   String ActualMsg = Error.getText();
	   String ExpMsg = "The email or password you have entered is invalid."; 
	    
	   Assert.assertEquals(ActualMsg,ExpMsg);
	   
		driver.quit();
		
		
		
	}
	
	
}
