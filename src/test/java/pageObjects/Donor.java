package pageObjects;

/**
 * Holds the donor test data
 * 
 * @author Tina
 *
 */
public class Donor {
	private String amount;
	private String donationType;
	private String motivation;
	private String cancerType;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;

	private Address homeAddress;

	private String emailOptIn;
	private String cardNumber;
	private String cvv;
	private String cardExpiry;
	private String giftaid;

	public Donor() {
		super();
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public String getCancerType() {
		return cancerType;
	}

	public void setCancerType(String cancerType) {
		this.cancerType = cancerType;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getEmailOptIn() {
		return emailOptIn;
	}

	public void setEmailOptIn(String emailOptIn) {
		this.emailOptIn = emailOptIn;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getGiftaid() {
		return giftaid;
	}

	public void setGiftaid(String giftaid) {
		this.giftaid = giftaid;
	}

}
