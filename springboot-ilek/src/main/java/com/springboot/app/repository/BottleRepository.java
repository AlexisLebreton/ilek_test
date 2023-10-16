package com.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.app.entity.Bottle;

public interface BottleRepository extends CrudRepository<Bottle, Integer> {
	
	
	//TODO make it take in acount only last price
	@Query(value = "SELECT Distinct b.* FROM bottle b " +
            "LEFT JOIN bottle_site_seller bss ON bss.fk_bottle_id = b.id " +
            "LEFT JOIN bottle_site_seller_price bssp ON bssp.fk_bottle_site_seller_id = bss.id " +
            "WHERE bssp.amount BETWEEN :minPrice AND :maxPrice ", nativeQuery = true)
    List<Bottle> findBottleWithPriceBetweenMaxAndMinPrice(@Param("maxPrice") Float maxPrice,
                                                            @Param("minPrice") Float minPrice);

}
