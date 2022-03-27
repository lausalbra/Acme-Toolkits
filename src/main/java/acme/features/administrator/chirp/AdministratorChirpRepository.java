package acme.features.administrator.chirp;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.chirps.Chirp;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorChirpRepository extends AbstractRepository {
	
	@Query("select c from Chirp c where c.creationMoment > :deadline")
	Collection<Chirp> findRecentChirps(Date deadline);

}
