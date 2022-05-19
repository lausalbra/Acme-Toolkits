package acme.testing.inventor.patronageReport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportListMineTest extends TestHarness {

	@ParameterizedTest	
	@CsvFileSource(resources = "/inventor/patronage-report/list-mine.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String sequenceNumber, final String creationMoment) {
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "List my patronage reports");
		
		super.checkListingExists();
		
		super.checkColumnHasValue(recordIndex, 0, sequenceNumber);
		super.checkColumnHasValue(recordIndex, 1, creationMoment);
		super.signOut();
	}
}