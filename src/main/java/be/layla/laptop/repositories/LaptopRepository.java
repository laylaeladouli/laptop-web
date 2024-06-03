package be.layla.laptop.repositories;

import be.layla.laptop.model.Laptop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LaptopRepository extends CrudRepository<Laptop, Integer> {



    @Query("SELECT l FROM Laptop l WHERE " +
            "(:brandName IS NULL OR :brandName = 'all' OR l.brandName = :brandName) AND" +
            "(:priceRange IS NULL OR :priceRange = 'all' OR " +
            "(CASE WHEN :priceRange = 'less' THEN l.price < 400 ELSE l.price >= 400 END)) AND " +
            "(:ramRange IS NULL OR :ramRange = 'all' OR " +
            "(CASE WHEN :ramRange = 'less' THEN l.ram < 16 ELSE l.ram >= 16 END))")
    List<Laptop> findByFilter(@Param("brandName") String brandName,
                              @Param("priceRange") String priceRange,
                              @Param("ramRange") String ramRange);



    Optional<Laptop> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Laptop> findFirstByOrderByIdDesc();

    Optional<Laptop> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Laptop> findFirstByOrderByIdAsc();
}
