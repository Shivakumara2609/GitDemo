package reusableComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reusableComponents {

	protected WebDriver driver;
	public reusableComponents(WebDriver driver) {
		this.driver=driver;
	}
	
	public List<WebElement> ListOfElementsByCssSelector(String cssselector){
		return driver.findElements(By.cssSelector(cssselector));
	}
	
	public void WaitUntilVisibilityOfElementLocatedByID(String toasterMessage) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(toasterMessage)));
	}
	public void WaitUntilInvisibilityOfElementLocatedByCssSelector(String element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(element))));
	}
	public List<WebElement> WaitUntilVisibilityOfAllElementsLocated(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    return wait.until(
	        ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)
	    );
	}
		
}
