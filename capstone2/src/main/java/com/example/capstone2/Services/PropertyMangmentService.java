package com.example.capstone2.Services;


import com.example.capstone2.ApiResponse.ApiException;
import com.example.capstone2.Models.PropertyMangment;
import com.example.capstone2.Repostry.PropertyMangmentRepostry;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class PropertyMangmentService {

    private final PropertyMangmentRepostry propertyMangmentRepostry;

    public List<PropertyMangment> getAll() {
        return propertyMangmentRepostry.findAll();
    }

    public void addBulding(PropertyMangment propertyMangment) {
        propertyMangmentRepostry.save(propertyMangment);
    }

    public void updateProperty(Integer id, PropertyMangment propertyMangment) {
        PropertyMangment propertyMangment1 = propertyMangmentRepostry.getReferenceById(id);

        if (propertyMangment1 == null) {
            throw new ApiException("id is not found");
        }
        propertyMangment1.setCode(propertyMangment.getCode());
        propertyMangment1.setNameofowner(propertyMangment.getNameofowner());
        propertyMangmentRepostry.save(propertyMangment1);

    }


    public void deleteProperty(Integer id){
        PropertyMangment propertyMangment1 = propertyMangmentRepostry.getById(id);

        if (propertyMangment1 == null ){
            throw new ApiException("id not found");
        }
        propertyMangmentRepostry.delete(propertyMangment1);
    }


    public List<PropertyMangment> searchProperty(String nameofowner){
        List<PropertyMangment> propertyMangment1 = propertyMangmentRepostry.findPropertyMangmentByNameofowner(nameofowner);
        if (propertyMangment1==null){
            throw new ApiException("Owner is not found");
        }
        return propertyMangment1;
    }

    public List<PropertyMangment> searchPropertymorethan(Integer expectedincome){
        List<PropertyMangment> propertyMangment1 = propertyMangmentRepostry.findPropertyMangmentByExpectedincomeGreaterThanEqual(expectedincome);
        if (propertyMangment1==null){
            throw new ApiException("is not found");
        }
        return propertyMangment1;
    }

}
