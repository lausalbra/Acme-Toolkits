package acme.features.inventor.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronages.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorPatronageShowService implements AbstractShowService<Inventor, Patronage>{
	
	@Autowired
	protected InventorPatronageRepository repository;
	 
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;

		boolean result;
		result = request.getPrincipal().hasRole(Inventor.class);
		
		return result;
	}

	@Override
	public Patronage findOne(final Request<Patronage> request) {
		assert request != null;
		
		Patronage result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOnePatronage(id);
		
		return result;
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "status","code","legalStuff","budget","startPeriod","endPeriod","link");
		
		final String fullName = entity.getPatron().getUserAccount().getIdentity().getFullName();
		model.setAttribute("fullName", fullName);
		
		final String email = entity.getPatron().getUserAccount().getIdentity().getEmail();
		model.setAttribute("email", email);
		
		model.setAttribute("confirmation", false);
		model.setAttribute("readonly", true);
		
	}
	
}
