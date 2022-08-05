package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Holds the web elements of Donation page
 * 
 * @author Tina
 *
 */
public class DonationPage {

	public DonationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "amount10")
	private WebElement amount;

	@FindBy(xpath = "//*[@id='typeRadioGroup0' and @value='yes']")
	private WebElement donationType;

	@FindBy(xpath = "//*[@name=\"motivation\"]")
	private WebElement motivation;

	@FindBy(id = "destinationRadioGroup1")
	private WebElement chooseType;

	@FindBy(xpath = "//*[@name =\"restriction\"]")
	private WebElement cancerType;

	@FindBy(id = "forename")
	private WebElement firstName;

	@FindBy(id = "surname")
	private WebElement lastName;

	@FindBy(id = "emailAddress")
	private WebElement email;

	@FindBy(id = "phoneNumber")
	private WebElement phone;

	@FindBy(xpath = "//button[contains(text(),\"Enter address manually\")]")
	private WebElement enterAddress;

	@FindBy(xpath = "//*[@name=\"addressLine1\"]")
	private WebElement address1;

	@FindBy(xpath = "//*[@name=\"city\"]")
	private WebElement town;

	@FindBy(xpath = "//*[@name=\"postalCode\"]")
	private WebElement postcode;

	@FindBy(xpath = "//*[@name=\"country\"]")
	private WebElement country;

	@FindBy(xpath = "//input[@name=\"emailOptIn\" and @value=\"no\"]")
	private WebElement emailOptIn;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement submit;

	@FindBy(id = "bt0")
	private WebElement selectCard;

	@FindBy(id = "credit-card-number")
	private WebElement cardNumber;

	@FindBy(xpath = "//*[@name=\"braintree-hosted-field-number\"]")
	private WebElement iframe;

	@FindBy(id = "braintree-hosted-field-expirationDate")
	private WebElement frameExpiry;

	@FindBy(id = "braintree-hosted-field-cvv")
	private WebElement frameCvv;

	@FindBy(id = "cardholderName")
	private WebElement cardholderName;

	@FindBy(xpath = "//*[@class=\"expirationDate\"]")
	private WebElement cardExpiry;

	@FindBy(id = "cvv")
	private WebElement cvv;

	@FindBy(xpath = "//input[@id=\"giftAid1\" and @name=\"giftAid\"]")
	private WebElement giftaid;

	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement alert;

	@FindBy(xpath = "//*[@id=\"main\"]/div[2]/div[1]/div/h2")
	private WebElement finalPage;

	@FindBy(xpath = "//*[@id=\"donationAmount-error\"]/p")
	private WebElement amountValidationMsg;

	public WebElement getAmountValidationMsg() {
		return amountValidationMsg;
	}

	public WebElement getChooseType() {
		return chooseType;
	}

	public WebElement getCancerType() {
		return cancerType;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEnterAddress() {
		return enterAddress;
	}

	public WebElement getAddress1() {
		return address1;
	}

	public WebElement getTown() {
		return town;
	}

	public WebElement getPostcode() {
		return postcode;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getEmailOptIn() {
		return emailOptIn;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getSelectCard() {
		return selectCard;
	}

	public WebElement getCardNumber() {
		return cardNumber;
	}

	public WebElement getIframe() {
		return iframe;
	}

	public WebElement getCardExpiry() {
		return cardExpiry;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getGiftaid() {
		return giftaid;
	}

	public WebElement getAlert() {
		return alert;
	}

	public WebElement getAmount() {
		return amount;
	}

	public WebElement getDonationType() {
		return donationType;
	}

	public WebElement getMotivation() {
		return motivation;
	}

	public WebElement getiFrame() {
		return iframe;
	}

	public WebElement getFrameExpiry() {
		return frameExpiry;
	}

	public WebElement getFrameCvv() {
		return frameCvv;
	}

	public WebElement getCardholderName() {
		return cardholderName;
	}

	public WebElement getFinalPage() {
		return finalPage;
	}

	public WebElement g() {
		return cardholderName;
	}
}
