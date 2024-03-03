package be.thomasmore.party.repositories;

import be.thomasmore.party.model.Venue;
import org.springframework.data.repository.CrudRepository;

public interface BeverageRepository extends CrudRepository<Venue,Integer> {
}
