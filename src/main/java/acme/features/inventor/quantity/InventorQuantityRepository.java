package acme.features.inventor.quantity;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.quantities.Quantity;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorQuantityRepository extends AbstractRepository{
	
	@Query("select q from Quantity q where q.id = :id")
	Quantity findOneQuantityById(int id);
	
//	@Query("select t from Toolkit t where t.inventor.userAccount.username = :username")
//	Collection<Toolkit> findToolkitsByInventorUsername(String username);
//	
	@Query("select q from Quantity q where q.toolkit.id = :id")
	Collection<Quantity> findManyQuantitiesByToolkitId(int id);
//
//	@Query("select q.item from Quantity q where q.id = :id")
//	Collection<Item> findManyItemsByQuantityId(int id);
//	
//	@Query("select sum(q.item.retailPrice.amount * q.number) from Quantity q where q.toolkit.id = :id")
//	Double findRetailPriceByToolkitId(int id);
//	
//	@Query("select q.item.retailPrice.currency from Quantity q where q.toolkit.id = :id group by q.item.retailPrice.currency")
//	List<String> findAllCurrenciesByToolkitId(int id);
//	
//	@Query("select i from Inventor i where i.id = :id")
//	Inventor findOneInventorById(int id);
//	
//	@Query("select t from Toolkit t where t.code = :code")
//	Toolkit findOneToolkitByCode(String code);
	
}
