
package acme.features.patron.patronDashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronPatronDashboardRepository extends AbstractRepository {

	@Query("select count(p) from Patronage p where p.status = 'PROPOSED'")
	int numberOfProposedPatronages();
	
	@Query("select count(p) from Patronage p where p.status = 'ACCEPTED'")
	int numberOfAcceptedPatronages();
	
	@Query("select count(p) from Patronage p where p.status = 'DENIED'")
	int numberOfDeniedPatronages();

	@Query("select concat(p.budget.currency,':', p.status,':', avg(p.budget.amount),':', stddev(p.budget.amount),':', min(p.budget.amount),':', max(p.budget.amount)) from Patronage p group by p.status, p.budget.currency")
	List<String> statsBudgetOfStatusPatronages();

}
