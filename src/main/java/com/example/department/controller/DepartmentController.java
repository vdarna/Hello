package com.example.department.controller;


import com.example.department.entity.EmployeeEntity;
import com.example.department.entity.PageParam;
import com.example.department.entity.Department;
import com.example.department.exception.NotFoundException;
import com.example.department.exception.NotFoundException2;
import com.example.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private HttpServletRequest request;
    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        String header = request.getHeader("test");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Optional<Department> findDepartmentById(@PathVariable("id") Integer departmentId){
        return departmentService.findDepartmentById(departmentId);
    }

    @GetMapping("/all")
    public List<Department> findAllDepartments() throws IOException {
        return departmentService.findAllDepartments();
    }

    @GetMapping("/sortBy/{field}")
    public List<Department> findAllBySort(@PathVariable("field") String sortBy){
        return departmentService.findAllBySort(sortBy);
    }

    @GetMapping("/pagination/{page1}/{pageSize1}")
    public Page<Department> findAllBySort(@Valid PageParam pageParam, @PathVariable int page1, @PathVariable String pageSize1){
        return departmentService.findAllByPaging(pageParam);
    }

    @GetMapping("/pagingandsorting")
    public List<Department> findAllByPagingAndSort(@RequestParam(defaultValue = "0") Integer pageNo,
                                          @RequestParam(defaultValue = "10") Integer pageSize,
                                          @RequestParam(defaultValue = "id") String sortField,
                                                   @RequestParam(defaultValue = "ASC") String sortDirection)
    {
        return departmentService.findAllByPagingAndSort(pageNo,pageSize,sortDirection,sortField);
    }

    @GetMapping("/offsetandpaging")
    public List<Department> findAllByoffsetAndSort(@RequestParam(defaultValue = "0", required=true) Integer offset,
                                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                                   @RequestParam(defaultValue = "id") String sortField,
                                                   @RequestParam(defaultValue = "ASC") String sortDirection)
    {
        return departmentService.findAllByoffsetAndSort(offset,pageSize,sortDirection,sortField);
    }

    @GetMapping("find-employee/{id}")
    public EmployeeEntity findEmployeeById(@PathVariable("id") Integer employeeId) throws NotFoundException, NotFoundException2 {
       try {
           return departmentService.findEmployeeById(employeeId);
       }catch (NotFoundException ex1){

       }catch (Exception e){

       }
        return null;
    }

    @GetMapping("save-employee/")
    public EmployeeEntity findEmployeeById(@RequestBody EmployeeEntity employeeEntity){
        return departmentService.saveEmployee(employeeEntity);
    }



}
