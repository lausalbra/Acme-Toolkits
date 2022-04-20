package acme.features.administrator.dashboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.entities.Status;
import acme.entities.items.ItemType;
import acme.forms.AdminDashboard;
import acme.forms.Stats;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, AdminDashboard>{
	
	//Internal State
	
	@Autowired
	protected AdministratorDashboardRepository repository;
			
	//AbstractShowService<Administrator, AdminDashboard>
	
	@Override
	public boolean authorise(final Request<AdminDashboard> request) {
		assert request != null;
		
		return true; 
	}
	
	@Override
	public AdminDashboard findOne(final Request<AdminDashboard> request) {
		assert request != null;
		final AdminDashboard result = new AdminDashboard();
		
		final int numberOfComponents = this.repository.numberOfItem(ItemType.COMPONENT);
		final int numberOfTools = this.repository.numberOfItem(ItemType.TOOL);
		final int numberOfPropsedPatronages = this.repository.numberOfStatusPatronages(Status.PROPOSED);
		final int numberOfAcceptedPatronages = this.repository.numberOfStatusPatronages(Status.ACCEPTED);
		final int numberOfDeniedPatronages =  this.repository.numberOfStatusPatronages(Status.DENIED);
		
		final Map<Pair<String,String>, Stats> statsRetailPriceOfComponents = new HashMap<>();
		final List<String> listStatsRetailPriceOfComponents = this.repository.statsRetailPriceOfItem(ItemType.COMPONENT);
		
		for (int i=0; i<listStatsRetailPriceOfComponents.size(); i++) {
			final String[] arrayList = listStatsRetailPriceOfComponents.get(i).split(":");
			final Pair<String, String> pareja = Pair.of(arrayList[0], arrayList[1]);
			final Stats stat = new Stats();
			stat.setAverage(Double.valueOf(arrayList[2]));
			stat.setDeviation(Double.valueOf(arrayList[3]));
			stat.setMinumun(Double.valueOf(arrayList[4]));
			stat.setMaximun(Double.valueOf(arrayList[5]));
			
			statsRetailPriceOfComponents.put(pareja, stat);
		}
		
		
		final Map<Pair<String,String>, Stats> statsRetailPriceOfTools = new HashMap<>();
		final List<String> listStatsRetailPriceOfTools = this.repository.statsRetailPriceOfItem(ItemType.TOOL);
		
		for (int i=0; i<listStatsRetailPriceOfTools.size(); i++) {
			final String[] arrayList = listStatsRetailPriceOfTools.get(i).split(";");
			final Pair<String, String> pareja = Pair.of(arrayList[0], arrayList[1]);
			final Stats stat = new Stats();
			stat.setAverage(Double.valueOf(arrayList[2]));
			stat.setDeviation(Double.valueOf(arrayList[3]));
			stat.setMinumun(Double.valueOf(arrayList[4]));
			stat.setMaximun(Double.valueOf(arrayList[5]));
			
			statsRetailPriceOfTools.put(pareja, stat);
		}
		
		
		final Map<Status,Stats> statsBudgetOfStatusPatronages = new HashMap<>();
		final List<String> listStatsBudgetOfStatusPatronages = this.repository.statsBudgetOfStatusPatronages();
		
		for (int i=0; i<listStatsBudgetOfStatusPatronages.size(); i++) {
			final String[] arrayList = listStatsBudgetOfStatusPatronages.get(i).split(":");
			final Stats stat = new Stats();
			stat.setAverage(Double.valueOf(arrayList[1]));
			stat.setDeviation(Double.valueOf(arrayList[2]));
			stat.setMinumun(Double.valueOf(arrayList[3]));
			stat.setMaximun(Double.valueOf(arrayList[4]));
			
			statsBudgetOfStatusPatronages.put(Status.valueOf(arrayList[0]), stat);
		}
		

		result.setNumberOfComponents(numberOfComponents);
		result.setNumberOfTools(numberOfTools);
		result.setStatsRetailPriceOfComponents(statsRetailPriceOfComponents);
		result.setStatsRetailPriceOfTools(statsRetailPriceOfTools);
		
		result.setNumberOfAcceptedPatronages(numberOfAcceptedPatronages);
		result.setNumberOfPropsedPatronages(numberOfPropsedPatronages);
		result.setNumberOfDeniedPatronages(numberOfDeniedPatronages);
		result.setStatsBudgetOfStatusPatronages(statsBudgetOfStatusPatronages);
		
		return result;
	}
	
	@Override
	public void unbind (final Request<AdminDashboard> request, final AdminDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, 	"numberOfComponents", 
										"numberOfTools", 
										"statsRetailPriceOfComponents", 
										"statsRetailPriceOfTools", 
										"numberOfPropsedPatronages", 
										"numberOfAcceptedPatronages", 
										"numberOfDeniedPatronages", 
										"statsBudgetOfStatusPatronages");
	}
}
