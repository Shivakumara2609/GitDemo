package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void gotoURL(String URL) {
		driver.get(URL);
	}
	
	public void Login() {
		driver.findElement(By.id("userEmail")).sendKeys("shivakumaras314@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Change@123");
		driver.findElement(By.id("login")).click();
	}
	

}
