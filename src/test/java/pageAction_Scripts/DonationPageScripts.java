package pageAction_Scripts;

import static common.Utils.explicitWait;
import static common.Utils.jsCLick;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseConfig.PageScripts;
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
		logger = report.createTest("makeDonation");
		launchBrowser();

		if (donationLocators.getAlert().isDisplayed()) {
			donationLocators.getAlert().click();
		}

		/// Donation page
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getDonationType());

		Select motivationSel = new Select(donationLocators.getMotivation());
		motivationSel.selectByVisibleText(data.getMotivation());
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getChooseType());
		Select cancerTypeSel = new Select(donationLocators.getCancerType());
		cancerTypeSel.selectByVisibleText(data.getCancerType());
		donationLocators.getSubmit().click();

		// check for validation error
		Assert.assertEquals(donationLocators.getAmountValidationMsg().getText(),
				"Please select or type in the amount you'd like to donate.");
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getAmount());
		donationLocators.getSubmit().click();

		/// Personal Details page
		explicitWait(getDriver(), donationLocators.getFirstName(), 10);
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

		/// Payment page
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getSelectCard());
		explicitWait(getDriver(), donationLocators.getCardholderName(), 10);
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getCardholderName());
		donationLocators.getCardholderName().sendKeys(data.getFirstname());
		getDriver().switchTo().frame(donationLocators.getiFrame());
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getCardNumber());
		donationLocators.getCardNumber().sendKeys(data.getCardNumber());
		getDriver().switchTo().defaultContent();
		getDriver().switchTo().frame(donationLocators.getFrameExpiry());
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getCardExpiry());
		donationLocators.getCardExpiry().sendKeys(data.getCardExpiry());
		getDriver().switchTo().defaultContent();
		getDriver().switchTo().frame(donationLocators.getFrameCvv());
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getCvv());
		donationLocators.getCvv().sendKeys(data.getCvv());
		getDriver().switchTo().defaultContent();
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getGiftaid());
		jsCLick((JavascriptExecutor) getDriver(), donationLocators.getSubmit());

		/// Verify payment success
		explicitWait(getDriver(), donationLocators.getFinalPage(), 10);
		String expectedTxt = "Thank you" + " " + data.getFirstname() + " " + "for your donation of £"
				+ data.getAmount();
		Assert.assertEquals(donationLocators.getFinalPage().getText(), expectedTxt);

	}

}
