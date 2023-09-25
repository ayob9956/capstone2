package com.example.capstone2.Repostry;


import com.example.capstone2.Models.PropertyMangment;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PropertyMangmentRepostry extends JpaRepository<PropertyMangment,Integer> {



    List<PropertyMangment> findPropertyMangmentByNameofowner(String nameofowner);

    List<PropertyMangment> findPropertyMangmentByExpectedincomeGreaterThanEqual(Integer expectedincome);



    PropertyMangment findPropertyMangmentById(Integer id);

    PropertyMangment findPropertyMangmentRepostryBycode(String code);
}
