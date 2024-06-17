package be.layla.laptop.repositories;

import be.layla.laptop.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    
}
