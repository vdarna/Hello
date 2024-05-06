package com.example.department.service;

import com.example.department.entity.*;
import com.example.department.exception.ErrorCode;
import com.example.department.exception.NotFoundException;
import com.example.department.exception.NotFoundException2;
import com.example.department.repository.DepartmentRepository;
import com.example.department.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;



    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> findDepartmentById(Integer departmentId) {
      //  return new Department(1,"A","B","C");
        System.out.println("Hello Buddy , i am in findById");
       return departmentRepository.findById(departmentId);
    }

    public EmployeeEntity findEmployeeById(Integer employeeId) throws NotFoundException, NotFoundException2 {
        //  return new Department(1,"A","B","C");
        Optional<EmployeeEntity> emp= employeeRepository.findById(employeeId);
        if(emp.isPresent()){
            EmployeeEntity employee = emp.get();
            try{

                String m = employee.getFirstName().substring(3,20);
                employee.setFirstName(m);
            }catch (Exception e){
                throw new NotFoundException2(ErrorCode.RESOURCE_NOT_FOUND,employeeId.toString(),e);
            }
            return employee;
        }else {
            throw new NotFoundException(ErrorCode.INVALID_INPUT,employeeId.toString());
        }
    }

    public List<Department> findAllDepartments() throws IOException {
        List<Department> depts = departmentRepository.findAll();
        for(int i=0;i<5;i++) {
            try {
               System.out.println("getCalc started for ::"+i);
                String s = getCalc("venu" + i);
                s = getCalc2("venu" + i);
                System.out.println("getCalc ended for ::"+s);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return depts;
    }

    @Async("asyncExecutor")
    public String getCalc(String val) throws InterruptedException {
        System.out.println("inside getCalc started for ::"+val);
        Thread.sleep(10000);
        System.out.println("inside getCalc ended for ::"+val);
        return val;
    }
    @Async("asyncExecutor")
    public String getCalc2(String val) throws InterruptedException {
        System.out.println("inside getCalc2 started for ::"+val);
        Thread.sleep(10000);
        System.out.println("inside getCalc2 ended for ::"+val);
        return val;
    }
    public List<Department> findAllBySort(String sortBy) {
        return departmentRepository.findAll(Sort.by(Sort.Direction.ASC,sortBy));
    }

    public Page<Department> findAllByPaging(PageParam pageParam) {
        List<Integer> deptIds= new ArrayList<>();
        deptIds.add(6);
        deptIds.add(7);
        deptIds.add(8);
        deptIds.add(9);
     //   PageRequest.of(1,10, Sort.Direction.ASC,"name");
        return departmentRepository.findAllByIdN(deptIds,PageRequest.of(pageParam.getPage(), pageParam.pageSize));
    }

    public List<Department> findAllByPagingAndSort(Integer pageNo, Integer pageSize,
                                                   String sortDirection,String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.ASC, sortBy);

        Page<Department> pagedResult = departmentRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Department>();
        }
    }

    public List<Department> findAllByoffsetAndSort(Integer offset, Integer pageSize,
                                                   String sortDirection,String sortBy)
    {


        Sort.Direction direction = Sort.Direction.ASC;
        if(sortDirection.equalsIgnoreCase("DESC"))
            direction = Sort.Direction.DESC;
       // Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.ASC, sortBy);
        Pageable paging = new OffsetBasedPageRequest(offset,pageSize,direction, sortBy);
        Page<Department> pagedResult = departmentRepository.findAll(paging);

        AccountEntity account1 = new AccountEntity();
        account1.setAccountNumber("Account detail 1");

        AccountEntity account2 = new AccountEntity();
        account2.setAccountNumber("Account detail 2");

        AccountEntity account3 = new AccountEntity();
        account3.setAccountNumber("Account detail 3");

//Add new Employee object
        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmail("demo-user-first@mail.com");
        employee.setFirstName("demo-one");
        employee.setLastName("user-one");

        Set<AccountEntity> accountList = new HashSet<AccountEntity>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        employee.setAccounts(accountList);

        employeeRepository.save(employee);



        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Department>();
        }
    }

    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

}
