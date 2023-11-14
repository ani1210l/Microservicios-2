package com.example.demo.Repository;

import com.example.demo.Entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository  extends JpaRepository<Employe,Integer> {
}
