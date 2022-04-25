package acme.testing.authenticated.configuration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedConfigurationShowTest extends TestHarness {
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/configuration/show.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex,final String defaultCurrency, final String acceptedCurrencies) {
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Authenticated", "Show Configuration");
		super.checkListingExists();
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("defaultCurrency", defaultCurrency);
		super.checkInputBoxHasValue("acceptedCurrencies", acceptedCurrencies);
		
		
		super.signOut();
	}
}
