package com.example.capstone2.Repostry;

import com.example.capstone2.Models.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantsRepostry extends JpaRepository<Tenants,String> {


    Tenants findByContract(String contract);

    List<Tenants> findAllByBuildingcode(String buildingcode);



    List<Tenants> findAllByEnddateAfter(String enddate);

    @Query("SELECT p FROM Tenants p WHERE p.price > :minPrice AND p.price < :maxPrice")
    List<Tenants> findByPriceInRange(@Param("minPrice") Integer minPrice, @Param("maxPrice") Integer maxPrice);





}
