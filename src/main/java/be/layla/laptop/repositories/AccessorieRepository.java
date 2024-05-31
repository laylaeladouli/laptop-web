package be.layla.laptop.repositories;

import be.layla.laptop.model.Accessorie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccessorieRepository extends CrudRepository<Accessorie, Integer> {

    Optional<Accessorie> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Accessorie> findFirstByOrderByIdDesc();

    Optional<Accessorie> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Accessorie> findFirstByOrderByIdAsc();

}
