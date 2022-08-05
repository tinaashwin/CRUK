package baseConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.databind.ObjectMapper;

import pageObjects.Donor;

/**
 * Base class for all the page scripts
 * 
 * @author Tina
 *
 */
public class PageScripts {

	private static final String CONFIG_PROPERTIES = "config.properties";

	private Properties prop;

	private WebDriver driver;

	public PageScripts() throws IOException {
		super();
		prop = new Properties();
		URL url = this.getClass().getClassLoader().getResource(CONFIG_PROPERTIES);
		prop.load( new FileInputStream(url.getFile()));
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
		URL url = this.getClass().getClassLoader().getResource(prop.getProperty("test_data_json"));
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
	}

	/**
	 * Gets the driver instance
	 * 
	 * @return
	 */
	public WebDriver getDriver() {
		return driver;
	}
}
