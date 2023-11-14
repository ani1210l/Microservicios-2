package com.example.demo.Controller;

import com.example.demo.Entity.Employe;
import com.example.demo.Service.EmployeService;
import com.example.demo.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Empleados")
@AllArgsConstructor

public class EmployeController {

    private final EmployeService employeService;

   /// public EmployeController(EmployeService employeService) {
     ///   this.employeService = employeService;
  ///  }

    @PostMapping
    public Employe GuardarEmpleado(  @RequestBody Employe employe){
        return  employeService.saveEmploye(employe);
    }
    @GetMapping("/lista")
    public List<Employe> Listado ( Employe employe){
        return employeService.findAll();

    }
    @GetMapping("/{id}")
    public ResponseDTO getEmployeById(@PathVariable Integer id) {
        return employeService.getEmployeeByID(id);
    }
}
