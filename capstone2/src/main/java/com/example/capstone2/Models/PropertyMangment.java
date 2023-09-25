package com.example.capstone2.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PropertyMangment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "put the code")
    private String code;
    @NotEmpty(message = "put rhe Name")
    @Column(nullable = false,columnDefinition = "varchar(25)")
    private String nameofowner;

    @Column(nullable = false,columnDefinition = "int")
    private Integer expectedincome;


    @Column(nullable = false,columnDefinition = "int")
    private Integer price;







}
