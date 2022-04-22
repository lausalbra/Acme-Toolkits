package acme.features.inventor.toolkit;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolkits.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorToolkitRepository extends AbstractRepository{
	
	@Query("select t from Toolkit t where t.id = :id")
	Toolkit findOneToolkitById(int id);
	
	@Query("select distinct(q.toolkit) from Quantity q where q.item.inventor.userAccount.username = :username")
	Collection<Toolkit> findToolkitsByInventorUsername(String username);
	
	@Query("select concat(sum(q.item.retailPrice.amount * q.number), ':', i.retailPrice.currency) from Quantity q where q.toolkit.id = :id group by q.item.retailPrice.currency")
	List<String> findRetailPriceByToolkitId(int id);
	
	
}
