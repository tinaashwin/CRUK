# CRUK
# Automated test for making a donation to Cancer Research UK (https://app.pws.int.cruk.org/support-us/your-donation)
Framework:

Java, Selenium, Testng

To Run:
1. Chromedriver.exe and test data is present under src/main/resources
2. src/test/java/config.properties contains the location of the driver exe file and test data file.
3. This project is configured to only run on chrome browser.
4. To execute the test case please run the src/test/java/DonationPageScripts.java file or testng.xml or
5. Execute by running the command "mvn test" on the terminal
6. A report will be generated under Report folder

 