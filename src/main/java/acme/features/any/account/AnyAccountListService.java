package acme.features.any.account;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyAccountListService implements AbstractListService<Any, UserAccount>{
	@Autowired
	protected AnyAccountRepository repository;
	 
	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;
		return true;
	}

	@Override
	public Collection<UserAccount> findMany(final Request<UserAccount> request) {
		assert request != null;
		Collection<UserAccount> result;

        result = this.repository.findUserAccounts();
        for (final UserAccount userAccount:result) {
        	userAccount.getRoles().forEach(r -> {;});
        }
		return result;
	}

	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		model.setAttribute("ua", entity);
		request.unbind(entity, model, "username", "ua.roles");
	}
	
	

}
