package pageAction_Scripts;

import static common.Utils.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseConfig.PageScripts;
import common.Utils;
import pageObjects.DonationPage;
import pageObjects.Donor;

/**
 * Class containing test scripts for Donation page
 * 
 * @author Tina
 * 
 */
public class DonationPageScripts extends PageScripts {

	public DonationPageScripts() throws IOException {
		super();
	}

	private DonationPage donationLocators;

	@Override
	public void launchBrowser() throws IOException {
		super.launchBrowser();
		donationLocators = new DonationPage(getDriver());
	}

	/**
	 * @param data
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(dataProvider = "getData")
	public void makeDonation(Donor data) throws InterruptedException, IOException {
		launchBrowser();
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (donationLocators.getAlert().isDisplayed()) {
			donationLocators.getAlert().click();
		}
		Utils.waitFor(10);
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getAmount());
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getDonationType());

		Select motivationSel = new Select(donationLocators.getMotivation());
		motivationSel.selectByIndex(1);
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getChooseType());
		Select cancerTypeSel = new Select(donationLocators.getCancerType());
		cancerTypeSel.selectByIndex(1);

		donationLocators.getSubmit().click();
		donationLocators.getFirstName().click();
		donationLocators.getFirstName().sendKeys(data.getFirstname());
		donationLocators.getLastName().click();
		donationLocators.getLastName().sendKeys(data.getLastname());
		donationLocators.getEmail().click();
		donationLocators.getEmail().sendKeys(data.getEmail());
		donationLocators.getPhone().click();
		donationLocators.getPhone().sendKeys(data.getPhone());
		donationLocators.getEnterAddress().click();

		donationLocators.getAddress1().click();
		donationLocators.getAddress1().sendKeys(data.getHomeAddress().getAddress1());
		donationLocators.getTown().click();
		donationLocators.getTown().sendKeys(data.getHomeAddress().getTown());
		donationLocators.getPostcode().click();
		donationLocators.getPostcode().sendKeys(data.getHomeAddress().getPostcode());
		donationLocators.getCountry().click();
		donationLocators.getCountry().sendKeys(data.getHomeAddress().getCountry());

		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getEmailOptIn());
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getSubmit());
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getSelectCard());

		Utils.waitFor(20);
		getDriver().switchTo().frame(donationLocators.getiFrame());
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getCardNumber());
		donationLocators.getCardNumber().sendKeys(data.getCardNumber());

		Utils.waitFor(5);
		getDriver().switchTo().defaultContent();
		getDriver().switchTo().frame(donationLocators.getFrameExpiry());

		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getCardExpiry());
		donationLocators.getCardExpiry().sendKeys(data.getCardExpiry());

		Utils.waitFor(5);
		getDriver().switchTo().defaultContent();
		getDriver().switchTo().frame(donationLocators.getFrameCvv());
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getCvv());
		donationLocators.getCvv().sendKeys(data.getCvv());

		getDriver().switchTo().defaultContent();
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getGiftaid());

		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getCardholderName());
		donationLocators.getCardholderName().sendKeys(data.getFirstname());

		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getSubmit());

	}

}
