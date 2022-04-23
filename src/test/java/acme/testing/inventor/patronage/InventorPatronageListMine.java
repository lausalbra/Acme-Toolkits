package acme.testing.inventor.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageListMine extends TestHarness {

	@ParameterizedTest	
	@CsvFileSource(resources = "/inventor/patronage/list-mine.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String code, final String startPeriod, final String endPeriod) {
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "List my patronages");
		
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, startPeriod);
		super.checkColumnHasValue(recordIndex, 2, endPeriod);
		super.signOut();
	}
}