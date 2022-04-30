package acme.features.administrator.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Configuration;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorConfigurationUpdateService implements AbstractUpdateService<Administrator, Configuration> {

	@Autowired
		protected AdministratorConfigurationRepository repository;
	@Override
	public boolean authorise(final Request<Configuration> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Configuration> request, final Configuration entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "defaultCurrency","acceptedCurrencies","strongSpamTerms","strongSpamThreshold","weakSpamTerms","weakSpamThreshold");
		
	}

	@Override
	public void unbind(final Request<Configuration> request, final Configuration entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "defaultCurrency","acceptedCurrencies","strongSpamTerms","strongSpamThreshold","weakSpamTerms","weakSpamThreshold");
		
		
	}

	@Override
	public Configuration findOne(final Request<Configuration> request) {
		assert request != null;
		Configuration result = null;
		final Optional<Configuration> resOpt = this.repository.findConfiguration().stream().findFirst();
		if(resOpt.isPresent()) {
			result = resOpt.get();
		}
		return result;
	}

	@Override
	public void validate(final Request<Configuration> request, final Configuration entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		if(!errors.hasErrors("defaultCurrency")) {
			errors.state(request, entity.getDefaultCurrency()!=null, "defaultCurrency", "administrator.configuration.error-default-currency");
		
		}
		if(!errors.hasErrors("acceptedCurrencies")) {
			errors.state(request, entity.getAcceptedCurrencies()!=null, "acceptedCurrencies", "administrator.configuration.error-accepted-currencies");
		
		}
		if(!errors.hasErrors("strongSpamTerms")) {
			errors.state(request, entity.getStrongSpamTerms()!=null, "strongSpamTerms", "administrator.configuration.error-strong-spamTerms");
			
		}
		if(!errors.hasErrors("strongSpamThreshold")) {
			errors.state(request, entity.getStrongSpamThreshold()>=0&&entity.getStrongSpamThreshold()<=100, "strongSpamThreshold", "administrator.configuration.strong-spam-threshold");
		
		}
		if(!errors.hasErrors("weakSpamTerms")) {
		errors.state(request, entity.getWeakSpamTerms()!=null, "weakSpamTerms", "administrator.configuration.weak-spam-terms");
		
		}
		if(!errors.hasErrors("weakSpamThreshold")) {
			errors.state(request, entity.getStrongSpamThreshold()>=0&&entity.getStrongSpamThreshold()<=100, "weakSpamThreshold", "administrator.configuration.weak-spam-threshold");
		}
	}

	@Override
	public void update(final Request<Configuration> request, final Configuration entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
		
	}
}
