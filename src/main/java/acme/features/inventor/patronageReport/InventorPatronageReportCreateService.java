package acme.features.inventor.patronageReport;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronages.Patronage;
import acme.entities.patronages.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportCreateService implements AbstractCreateService<Inventor, PatronageReport>{
	
	@Autowired
	protected InventorPatronageReportRepository repository;
	 
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;
		
		boolean result;
		result = request.getPrincipal().hasRole(Inventor.class);
		
		return result;
	}

	@Override
	public void bind(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
        assert entity != null;
        assert errors != null;
        
        request.bind(entity, errors, "memorandum", "link");
        
        final String code = request.getModel().getString("code");
        
        final Patronage patronage = this.repository.findOnePatronage(code);
        entity.setPatronage(patronage);
		
	}
	
	@Override
	public void validate(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
        assert entity != null;
        assert errors != null;
        
        if(!errors.hasErrors("code")) {
        	final String code = request.getModel().getString("code");
        	final Patronage patronage = this.repository.findOnePatronage(code);
        	errors.state(request, !code.equals(""), "code", "inventor.patronage-report.form.error.code-null");
        	if (!code.equals("")) {
        		errors.state(request, patronage != null, "code", "inventor.patronage-report.form.error.code-does-not-exist");
        	}
        }
        
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "memorandum", "link");
		
		model.setAttribute("confirmation", false);
		
	}
	
	@Override
	public PatronageReport instantiate(final Request<PatronageReport> request) {
		assert request != null;
		
		PatronageReport result;
		result = new PatronageReport();
		
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		result.setCreationMoment(moment);
		
		return result;
	}
	
	@Override
	public void create(final Request<PatronageReport> request, final PatronageReport entity) {
		assert request != null;
        assert entity != null;
        
        final Collection<PatronageReport> patronagesReports = this.repository.findPatronagesReportsByPatronages(entity.getPatronage().getCode());
        
        this.repository.save(entity);
	}
	
}
