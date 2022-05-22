package acme.features.inventor.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.ItemType;
import acme.entities.quantities.Quantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorQuantityShowService implements AbstractShowService<Inventor, Quantity>{
	
	//Internal State
	
	@Autowired
	protected InventorQuantityRepository repository;
		
	//AbstractShowService<Inventor, Item> interface
	
	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		 boolean result;
		 int quantityId;
		 Quantity quantity;
		 
		 quantityId = request.getModel().getInteger("id");
		 quantity = this.repository.findOneQuantityById(quantityId);
		 result = quantity.getToolkit().getInventor().getId()==request.getPrincipal().getActiveRoleId();
		
		return result; 
	}
	
	@Override
	public Quantity findOne(final Request<Quantity> request) {
		assert request != null;
		
		Quantity result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneQuantityById(id);
		
		return result;
	}
	
	@Override
	public void unbind (final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final String name = entity.getItem().getName().trim();
		final ItemType itemType = entity.getItem().getItemType();
		final String code = entity.getItem().getCode().trim();
		final String technology = entity.getItem().getTechnology().trim();
		final String description = entity.getItem().getDescription().trim();
		final Money retailPrice = entity.getItem().getRetailPrice();
		final String optionalLink = entity.getItem().getOptionalLink().trim();
		
		model.setAttribute("name", name);
		model.setAttribute("itemType", itemType);
        model.setAttribute("code", code);
        model.setAttribute("technology", technology);
        model.setAttribute("description", description);
        model.setAttribute("retailPrice", retailPrice);
        model.setAttribute("optionalLink", optionalLink);
        
		request.unbind(entity, model, "number");
		
	}

}
