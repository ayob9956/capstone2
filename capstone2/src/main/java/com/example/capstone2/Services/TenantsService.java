package com.example.capstone2.Services;

import com.example.capstone2.ApiResponse.ApiException;
import com.example.capstone2.Models.PropertyMangment;
import com.example.capstone2.Models.Tenants;
import com.example.capstone2.Repostry.TenantsRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TenantsService {

    private final TenantsRepostry tenantsRepostry;

    public List<Tenants> getAll() {
        return tenantsRepostry.findAll();
    }

    public void addTenants(Tenants tenants) {
        tenantsRepostry.save(tenants);
    }

    public void updateTenants(String contract, Tenants tenants) {
        Tenants tenants1 = tenantsRepostry.findByContract(contract);

        if (tenants1 == null) {
            throw new ApiException("id is not found");
        }

        tenants1.setNameoftenant(tenants.getNameoftenant());
        tenants1.setStartdate(tenants.getStartdate());
        tenants1.setEnddate(tenants.getEnddate());
        tenants1.setBuildingcode(tenants.getBuildingcode());


        tenants1.setPrice(tenants.getPrice());
        tenants1.setNumberofflate(tenants.getNumberofflate());


        tenantsRepostry.save(tenants1);


    }


    public void deleteTenants(String contract) {
        Tenants tenants1 = tenantsRepostry.getById(contract);

        if (tenants1 == null) {
            throw new ApiException("id not found");
        }
        tenantsRepostry.deleteById(contract);
    }


    public List<Tenants> searchTenants(String buildingcode) {
        List<Tenants> tenants = tenantsRepostry.findAllByBuildingcode(buildingcode);
        if (tenants == null) {
            throw new ApiException("building is not found");
        }
        return tenants;
    }


    public List<Tenants> searchTenantsEndDate(String enddate) {
        List<Tenants> tenants = tenantsRepostry.findAllByEnddateAfter(enddate);

        if (tenants == null) {
            throw new ApiException("nobody is not found");
        }
        return tenants;
    }

    public List<Tenants> searchPriceInRange(Integer maxPrice, Integer minPrice) {
        List<Tenants> tenants = tenantsRepostry.findByPriceInRange(maxPrice, minPrice);
        return tenants;
    }

    public void rentFlate(String contract, Tenants tenants) {
        Tenants tenants1 = tenantsRepostry.findByContract(contract);

        if (tenants1 == null) {
            throw new ApiException("id is not found");
        }
        if(tenants1.getBalanceOfTenant()<tenants1.getPrice()){
            throw new ApiException("Balance Of Tenant is Not ");
        }
        tenants1.setBalanceOfTenant(tenants.getBalanceOfTenant() - tenants1.getPrice());
        tenants1.setBalnaceOfRenter(tenants.getBalnaceOfRenter() + tenants1.getPrice());

        tenantsRepostry.save(tenants1);
    }

    public void domatinance(String contract, Tenants tenants,Integer mant) {
        Tenants tenants1 = tenantsRepostry.findByContract(contract);

        if (tenants1 == null) {
            throw new ApiException("id is not found");
        }

        if(tenants1.getBalanceOfTenant()<mant){
            throw new ApiException("Balance Of Tenant is not found");
        }
        tenants1.setBalanceOfTenant( tenants.getBalanceOfTenant() - mant);
        tenants1.setBalnaceOfRenter(tenants.getBalnaceOfRenter() + mant);

        tenantsRepostry.save(tenants1);
    }

    public Tenants searchByContract(String contract){
        return tenantsRepostry.findByContract(contract);

    }

    public void ContractExtension(String contract,String startdatet,String enddate){
        Tenants tenants1 = tenantsRepostry.findByContract(contract);
        if (tenants1 == null) {
            throw new ApiException("id is not found");
        }
       tenants1.setStartdate(startdatet);
        tenants1.setEnddate(enddate);

        tenantsRepostry.save(tenants1);
    }
}
