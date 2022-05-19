package acme.features.inventor.xx1;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.xx1s.Xx1;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorXx1Repository extends AbstractRepository {
	
	@Query("select x from Xx1 x")
	Collection<Xx1> findMineXx1(String username);
	
	@Query("select x from Xx1 x where x.id = :id")
	Xx1 findOneXx1(int id);

}
