package acme.features.inventor.toolkit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowService implements AbstractShowService<Inventor, Toolkit>{
	
	//Internal State
	
	@Autowired
	protected InventorToolkitRepository repository;
		
	//AbstractShowService<Inventor, Toolkit> interface
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		
		return true; 
	}
	
	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;
		
		Toolkit result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneToolkitById(id);
		
		return result;
	}
	
	@Override
	public void unbind (final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		int id;
		id = request.getModel().getInteger("id");
		
		final List<String> retailList = this.repository.findRetailPriceByToolkitId(id);
		
//		final List<Integer> quantity = new ArrayList<>();
//		final List<String> currency = new ArrayList<>();
//		
//		for(final String e : retailList) {
//			final String[] trozos = e.split(":");
//			quantity.add(Integer.valueOf(trozos[0].trim()));
//			currency.add(trozos[1].trim());
//		}
		
		model.setAttribute("retailPrice", retailList);
		
		request.unbind(entity, model, "code", "title", "description", "assemblyNote", "retailPrice", "optionalLink");
	}

}
