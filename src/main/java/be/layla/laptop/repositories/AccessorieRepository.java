package be.layla.laptop.repositories;

import be.layla.laptop.model.Accessorie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccessorieRepository extends CrudRepository<Accessorie, Integer> {



    @Query("SELECT a FROM Accessorie a WHERE " +
            "(:productName IS NULL OR :productName = 'all' OR a.productName = :productName) AND" +
            "(:priceRange IS NULL OR :priceRange = 'all' OR " +
            "(CASE WHEN :priceRange = 'less' THEN a.price < 30 ELSE a.price >= 30 END))")
    List<Accessorie> findByFilter(@Param("productName") String productName,
                                  @Param("priceRange") String priceRange);



    Optional<Accessorie> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Accessorie> findFirstByOrderByIdDesc();

    Optional<Accessorie> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Accessorie> findFirstByOrderByIdAsc();

}
