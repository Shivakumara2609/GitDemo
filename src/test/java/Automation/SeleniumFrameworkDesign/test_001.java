package Automation.SeleniumFrameworkDesign;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.ProductPurchase;
import reusableComponents.reusableComponents;

public class test_001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		String URL="https://rahulshettyacademy.com/client/#/auth/login";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingPage landingpage=new LandingPage(driver);
		reusableComponents reuse=new reusableComponents(driver);
		ProductPurchase purchase=new ProductPurchase(driver);
		
		landingpage.gotoURL(URL);
		landingpage.Login();
		purchase.AddToCart();
		
		System.out.println("Updated the code after git push");
		
		
		

        
       
        
	}

}
