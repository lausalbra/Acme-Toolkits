package acme.features.anonymous.item;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.entities.items.ItemType;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousItemListService implements AbstractListService<Anonymous, Item>{
	
	//Internal State
	
	@Autowired
	protected AnonymousItemRepository repository;
	
	//AbstractListService<Anonymous, Item> interface 
	
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		
		return true; 
	}

	@Override
	public Collection<Item> findMany(final Request<Item> request){
		assert request != null;
		
		Collection<Item> result;
		String aux;		
		ItemType type;
		
		aux = request.getModel().getString("type");
		type = ItemType.valueOf(aux);
		result = this.repository.findAllItem(type);
		
		return result;
	}
	
	@Override
	public void unbind (final Request<Item> request, final Item entity, final Model model) {
		
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "name", "code", "technology", "retailPrice");
		
	}
}
