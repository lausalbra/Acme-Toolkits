package acme.testing.inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolkitDeleteTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/list-mine.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex,final String code, final String title, final String draft) {
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "List my Toolkits");
		super.checkListingExists();
		
		// Por terminar
		
		super.signOut();
	}
	
}
