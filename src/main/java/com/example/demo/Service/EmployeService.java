package com.example.demo.Service;

import com.example.demo.Entity.Employe;
import com.example.demo.Repository.EmployeRepository;
import com.example.demo.dto.DepartamentDto;
import com.example.demo.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeService {
    private final EmployeRepository employeRepository;
    private final RestTemplate restTemplate;


    public Employe saveEmploye(Employe employe){
        return employeRepository.save(employe);
    }
    public List<Employe> findAll() {
        return employeRepository.findAll();
    }
    public ResponseDTO getEmployeeByID(Integer id){
        ResponseDTO responseDTO = new ResponseDTO();
        Employe employe = new Employe();
        employe = employeRepository.findById(id).get();

        ResponseEntity<DepartamentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/Departamentos/" + employe.getDepartmentId(),
                DepartamentDto.class);
        DepartamentDto departmentDTO = responseEntity.getBody();
        responseDTO.setEmploye(employe);
        responseDTO.setDepartamentDto(departmentDTO);
        return responseDTO;
    }
}
