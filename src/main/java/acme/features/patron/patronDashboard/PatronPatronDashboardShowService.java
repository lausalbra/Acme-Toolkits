package acme.features.patron.patronDashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.PatronDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronPatronDashboardShowService implements AbstractShowService<Patron, PatronDashboard>{
	
	@Autowired
	protected PatronPatronDashboardRepository repository;
	 
	@Override
	public boolean authorise(final Request<PatronDashboard> request) {
		assert request != null;

		boolean result;
		result = request.getPrincipal().hasRole(Patron.class);
		
		return result;
	}

	@Override
	public PatronDashboard findOne(final Request<PatronDashboard> request) {
		assert request != null;
		
		final PatronDashboard result = new PatronDashboard();
		
		final int totalNumberOfProposedPatronages = this.repository.numberOfProposedPatronages();
		final int totalNumberOfAcceptedPatronages = this.repository.numberOfAcceptedPatronages();
		final int totalNumberOfDeniedPatronages = this.repository.numberOfDeniedPatronages();
		
		result.setTotalNumberOfProposedPatronages(totalNumberOfProposedPatronages);
		result.setTotalNumberOfAcceptedPatronages(totalNumberOfAcceptedPatronages);
		result.setTotalNumberOfDeniedPatronages(totalNumberOfDeniedPatronages);
		
//		final Map<Status,Stats> statsBudgetOfStatusPatronages = new HashMap<>();
//		final List<String> listStatsBudgetOfStatusPatronages = this.repository.statsBudgetOfStatusPatronages();
//		
//		for (int i=0; i<listStatsBudgetOfStatusPatronages.size(); i++) {
//			final String[] arrayList = listStatsBudgetOfStatusPatronages.get(i).split(":");
//			final Stats stat = new Stats();
//			stat.setAverage(Double.valueOf(arrayList[2]));
//			stat.setDeviation(Double.valueOf(arrayList[3]));
//			stat.setMinumun(Double.valueOf(arrayList[4]));
//			stat.setMaximun(Double.valueOf(arrayList[5]));
//			
//			statsBudgetOfStatusPatronages.put(Status.valueOf(arrayList[1]), stat);
//		}
		
		
		return result;
	}

	@Override
	public void unbind(final Request<PatronDashboard> request, final PatronDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "totalNumberOfProposedPatronages",
			"totalNumberOfAcceptedPatronages",
			"totalNumberOfDeniedPatronages");
		
	}
	
}
