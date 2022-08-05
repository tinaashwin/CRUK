package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Holds common methods
 * 
 * @author Tina
 *
 */
public class Utils {

	private Utils() {
	}

	/**
	 * @param driver
	 * @param webElement
	 */
	public static void jsCLick(JavascriptExecutor driver, WebElement webElement) {
		driver.executeScript("arguments[0].click()", webElement);
	}

	/**
	 * @param driver
	 * @param webElement
	 */
	public static void explicitWait(WebDriver driver, WebElement webElement, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(webElement));

	}

}
