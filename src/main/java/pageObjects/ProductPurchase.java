package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import reusableComponents.reusableComponents;

public class ProductPurchase extends reusableComponents{
	
	
	public ProductPurchase(WebDriver driver) {
		super(driver);
		
	}
	
	public void AddToCart() {
		
		String ProductName="ZARA COAT 3";
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		List<WebElement> products=WaitUntilVisibilityOfAllElementsLocated(By.cssSelector(".mb-3"));
		WebElement product=products.stream().filter(s->s.findElement(By.cssSelector("b")).getText()
        		.equals("ZARA COAT 3")).findFirst().orElse(null);
        product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        WaitUntilVisibilityOfElementLocatedByID("toast-container");
		WaitUntilInvisibilityOfElementLocatedByCssSelector(".ng-animating");
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		List<WebElement> cardProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		boolean match=cardProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(ProductName));
		//Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder*='Select Country']")), "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'ta-item')]")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".action__submit"))));
		driver.findElement(By.cssSelector(".action__submit")).click();
		String ConfirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		//Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("Thankyou for the order."));
	}

}
