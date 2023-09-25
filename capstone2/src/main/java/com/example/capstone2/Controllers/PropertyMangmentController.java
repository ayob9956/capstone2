package com.example.capstone2.Controllers;


import com.example.capstone2.ApiResponse.ApiResponse;
import com.example.capstone2.Models.PropertyMangment;
import com.example.capstone2.Services.PropertyMangmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/propertymangment")
public class PropertyMangmentController {

    private final PropertyMangmentService propertyMangmentService;

    @GetMapping("/get")
    public ResponseEntity getall(){

        return ResponseEntity.status(200).body(propertyMangmentService.getAll());

    }
    @PostMapping("/add")
    public ResponseEntity addedProperty(@RequestBody @Valid PropertyMangment propertyMangment){
        propertyMangmentService.addBulding(propertyMangment);
        return ResponseEntity.status(200).body(new ApiResponse("Property is Added!"));

    }

    @PutMapping("update/{id}")
    public ResponseEntity updateProperty(@RequestBody @Valid PropertyMangment propertyMangment,
                                         @PathVariable Integer id){
        propertyMangmentService.updateProperty(id,propertyMangment);
        return ResponseEntity.status(200).body(new ApiResponse("Property is updated!"));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProperty(@PathVariable Integer id){
        propertyMangmentService.deleteProperty(id);
        return ResponseEntity.status(200).body(new ApiResponse("Property is Deleted!"));

    }
    @GetMapping("/serch/{nameofowner}")
    public ResponseEntity searchOwner(@PathVariable String nameofowner){
        return ResponseEntity.status(200).body(propertyMangmentService.searchProperty(nameofowner));
    }


    @GetMapping("/serchmorethan/{expectedincome}")
    public ResponseEntity searchincomemorethan(@PathVariable Integer expectedincome){
        return ResponseEntity.status(200).body(propertyMangmentService.searchPropertymorethan(expectedincome));
    }
}
