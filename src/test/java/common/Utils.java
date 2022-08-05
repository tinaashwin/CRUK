package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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
	 * @param seconds
	 */
	public static void waitFor(long seconds) {

		long milliseconds;
		try {
			milliseconds = seconds * 1000;

			Thread.sleep(milliseconds);
		} catch (Exception e) {

		}
	}

	/**
	 * @param driver
	 * @param webElement
	 */
	public static void jsCLick(JavascriptExecutor driver, WebElement webElement) {
		driver.executeScript("arguments[0].click()", webElement);
	}

}
