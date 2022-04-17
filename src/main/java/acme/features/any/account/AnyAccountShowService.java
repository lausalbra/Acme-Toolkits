package acme.features.any.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyAccountShowService implements AbstractShowService<Any, UserAccount>{
	
	//Internal State
	
	@Autowired
	protected AnyAccountRepository repository;
		
	//AbstractShowService<Inventor, Item> interface
	
	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;
		
		return true; 
	}
	
	@Override
	public UserAccount findOne(final Request<UserAccount> request) {
		assert request != null;
		
		UserAccount result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneUserAccount(id);
		
		return result;
	}
	
	@Override
	public void unbind (final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		final String fullName = entity.getIdentity().getFullName();
        model.setAttribute("fullName", fullName);
        final String email = entity.getIdentity().getEmail();
        model.setAttribute("email", email);
        
		request.unbind(entity, model, "username");
	}

}
