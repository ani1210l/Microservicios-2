package com.example.demo.dto;

import com.example.demo.Entity.Employe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    private Employe employe;
    private DepartamentDto departamentDto;
}
