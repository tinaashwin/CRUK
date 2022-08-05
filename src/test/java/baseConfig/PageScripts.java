package baseConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.databind.ObjectMapper;

import pageObjects.Donor;

/**
 * Base class for all the page scripts
 * 
 * @author Tina
 *
 */
public class PageScripts {

	private static final String TEST_DATA_JSON = "test_data_json";

	private static final String CONFIG_PROPERTIES = "config.properties";

	private Properties prop;

	private WebDriver driver;

	ExtentHtmlReporter htmlReporter;
	protected ExtentReports report;
	protected ExtentTest logger;

	public PageScripts() throws IOException {
		super();
		prop = new Properties();
		URL url = this.getClass().getClassLoader().getResource(CONFIG_PROPERTIES);
		prop.load(new FileInputStream(url.getFile()));
	}

	/**
	 * Initializes the chrome driver
	 * 
	 * @throws IOException
	 */
	public void initializeDriver() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				this.getClass().getClassLoader().getResource(prop.getProperty("driver")).getPath());
		driver = new ChromeDriver();
	}

	/**
	 * Reads data from the json test data file
	 * 
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@DataProvider
	public Object[][] getData() throws IOException, URISyntaxException {
		// read json file data to String
		URL url = this.getClass().getClassLoader().getResource(prop.getProperty(TEST_DATA_JSON));
		byte[] jsonData = Files.readAllBytes(Paths.get(url.toURI()));
		ObjectMapper objectMapper = new ObjectMapper();

		Donor donor = objectMapper.readValue(jsonData, Donor.class);
		Object[][] returnValue = new Object[1][1];
		returnValue[0][0] = donor;

		return returnValue;

	}

	/**
	 * Launches the browser
	 * 
	 * @throws IOException
	 */
	public void launchBrowser() throws IOException {
		initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	/**
	 * Gets the driver instance
	 * 
	 * @return
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * To generate final report
	 * 
	 * @throws InterruptedException
	 */
	@BeforeSuite
	public void startReport() throws InterruptedException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Report/STMExtentReport" + dateName + ".html");
		report = new ExtentReports();

		report.attachReporter(htmlReporter);
		htmlReporter.config().setTheme(Theme.DARK);
	}

	/**
	 * @param result
	 * @throws IOException
	 */
	@AfterMethod
	public void AgetResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenShotPath = capture(driver, result.getName());
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.fail("Snapshot below: " + logger.addScreenCaptureFromPath(screenShotPath));

		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			String screenShotPath = capture(driver, result.getName());
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
			logger.pass("Snapshot below: " + logger.addScreenCaptureFromPath(screenShotPath));
		}
		report.flush();
	}

	@AfterMethod
	public void endReport() {
		report.flush();

	}

	@AfterSuite
	public void teardown() {
		driver.quit();

	}

	/**
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public static String capture(WebDriver driver, String screenShotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/Report/screen/" + screenShotName + "_" + dateName + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);

		return dest;
	}

}
