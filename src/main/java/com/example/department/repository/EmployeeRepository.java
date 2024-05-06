package com.example.department.repository;

import com.example.department.entity.Department;
import com.example.department.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

}
