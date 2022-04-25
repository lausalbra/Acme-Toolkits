package acme.testing.inventor.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageShowTest extends TestHarness {

	@ParameterizedTest	
	@CsvFileSource(resources = "/inventor/patronage/show.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String status, final String code, final String legalStuff,
		final String budget, final String fullName, final String email, final String startPeriod,
		final String endPeriod, final String link) {
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "List my patronages");
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("fullName", fullName);
		super.checkInputBoxHasValue("email", email);
		super.checkInputBoxHasValue("startPeriod", startPeriod);
		super.checkInputBoxHasValue("endPeriod", endPeriod);
		super.checkInputBoxHasValue("link", link);
		
		super.signOut();
	}
}