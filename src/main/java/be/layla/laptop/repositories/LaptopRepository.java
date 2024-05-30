package be.layla.laptop.repositories;

import be.layla.laptop.model.Laptop;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LaptopRepository extends CrudRepository<Laptop, Integer> {


    Optional<Laptop> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Laptop> findFirstByOrderByIdDesc();

    Optional<Laptop> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Laptop> findFirstByOrderByIdAsc();
}
