package com.murat.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.murat.auth.model.Car;




public interface CarRepository extends CrudRepository<Car, String> {
    
    @Query(value = "SELECT c FROM Car c WHERE c.make LIKE '%' || :keyword || '%'"            
            + " OR c.model LIKE '%' || :keyword || '%'"
            + " OR c.color LIKE '%' || :keyword || '%'"
            + " OR c.year LIKE '%' || :keyword || '%'")
    public List<Car> search(@Param("keyword") String keyword);
    
    @Query(value="SELECT c FROM Car c JOIN c.salesRep s WHERE s.name LIKE %?1%")
//	@Query(value="SELECT * FROM customer c JOIN salesrep s ON c.salesRep_id = s.id WHERE s.name LIKE %?1%",
//			nativeQuery=true)
	List<Car> findBySalesRepName(String salesRepName);
}
