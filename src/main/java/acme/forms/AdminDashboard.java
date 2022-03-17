package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDashboard implements Serializable {
	
	// Serialisation identifier 

	protected static final long	serialVersionUID	= 1L;
	
	// Attributes 

	// Components
	Integer						numberOfComponents;
	
	Double						averageRetailPriceOfComponents;
	Double						deviationRetailPriceOfComponents;
	Double						minimumRetailPriceOfComponents;
	Double						maximumRetailPriceOfComponents;
	
	// Tools
	
	Integer						numberOfTools;
	
	Double						averageRetailPriceOfTools;
	Double						deviationRetailPriceOfTools;
	Double						minimumRetailPriceOfTools;
	Double						maximumRetailPriceOfTools;
	
	// Proposed Patronages
	
	Integer						numberOfProposedPatronages;
	
	Double						averageBudgetOfProposedPatronages;
	Double						deviationBudgetOfProposedPatronages;
	Double						minimumBudgetOfProposedPatronages;
	Double						maximumBudgetOfProposedPatronages;
	
	// Accepted Patronages
	
	Integer						numberOfAcceptedPatronages;
	
	Double						averageBudgetOfAcceptedPatronages;
	Double						deviationBudgetOfAcceptedPatronages;
	Double						minimumBudgetOfAcceptedPatronages;
	Double						maximumBudgetOfAcceptedPatronages;
	
	// Denied Patronages
	
	Integer						numberOfDeniedPatronages;
	
	Double						averageBudgetOfDeniedPatronages;
	Double						deviationBudgetOfDeniedPatronages;
	Double						minimumBudgetOfDeniedPatronages;
	Double						maximumBudgetOfDeniedPatronages;


}
