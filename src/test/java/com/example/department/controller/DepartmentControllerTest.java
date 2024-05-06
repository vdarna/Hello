package com.example.department.controller;

import com.example.department.entity.AccountEntity;
import com.example.department.entity.Department;
import com.example.department.entity.EmployeeEntity;
import com.example.department.entity.PageParam;
import com.example.department.exception.NotFoundException;
import com.example.department.exception.NotFoundException2;
import com.example.department.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentControllerTest {

    @Mock
    private DepartmentService mockDepartmentService;

    @InjectMocks
    private DepartmentController departmentControllerUnderTest;

    @Test
    void testSaveDepartment() {
        // Setup
        final Department department = new Department(0, "departmentName", "departmentAddress", "departmentCode");
        final Department expectedResult = new Department(0, "departmentName", "departmentAddress", "departmentCode");

        // Configure DepartmentService.saveDepartment(...).
        final Department department1 = new Department(0, "departmentName", "departmentAddress", "departmentCode");
        when(mockDepartmentService.saveDepartment(
                new Department(0, "departmentName", "departmentAddress", "departmentCode"))).thenReturn(department1);

        // Run the test
        final Department result = departmentControllerUnderTest.saveDepartment(department);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindDepartmentById() {
        // Setup
        final Optional<Department> expectedResult = Optional.of(
                new Department(0, "departmentName", "departmentAddress", "departmentCode"));

        // Configure DepartmentService.findDepartmentById(...).
        final Optional<Department> department = Optional.of(
                new Department(0, "departmentName", "departmentAddress", "departmentCode"));
        when(mockDepartmentService.findDepartmentById(0)).thenReturn(department);

        // Run the test
        final Optional<Department> result = departmentControllerUnderTest.findDepartmentById(0);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindDepartmentById_DepartmentServiceReturnsAbsent() {
        // Setup
        when(mockDepartmentService.findDepartmentById(0)).thenReturn(Optional.empty());

        // Run the test
        final Optional<Department> result = departmentControllerUnderTest.findDepartmentById(0);

        // Verify the results
        assertEquals(Optional.empty(), result);
    }

    @Test
    void testFindAllDepartments() throws Exception {
        // Setup
        final List<Department> expectedResult = Arrays.asList(
                new Department(0, "departmentName", "departmentAddress", "departmentCode"));

        // Configure DepartmentService.findAllDepartments(...).
        final List<Department> departments = Arrays.asList(
                new Department(0, "departmentName", "departmentAddress", "departmentCode"));
        when(mockDepartmentService.findAllDepartments()).thenReturn(departments);

        // Run the test
        final List<Department> result = departmentControllerUnderTest.findAllDepartments();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindAllDepartments_DepartmentServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockDepartmentService.findAllDepartments()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Department> result = departmentControllerUnderTest.findAllDepartments();

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testFindAllDepartments_DepartmentServiceThrowsIOException() throws Exception {
        // Setup
        when(mockDepartmentService.findAllDepartments()).thenThrow(IOException.class);

        // Run the test
        assertThrows(IOException.class, () -> departmentControllerUnderTest.findAllDepartments());
    }

    @Test
    void testFindAllBySort1() {
        // Setup
        final List<Department> expectedResult = Arrays.asList(
                new Department(0, "departmentName", "departmentAddress", "departmentCode"));

        // Configure DepartmentService.findAllBySort(...).
        final List<Department> departments = Arrays.asList(
                new Department(0, "departmentName", "departmentAddress", "departmentCode"));
        when(mockDepartmentService.findAllBySort("sortBy")).thenReturn(departments);

        // Run the test
        final List<Department> result = departmentControllerUnderTest.findAllBySort("sortBy");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindAllBySort1_DepartmentServiceReturnsNoItems() {
        // Setup
        when(mockDepartmentService.findAllBySort("sortBy")).thenReturn(Collections.emptyList());

        // Run the test
        final List<Department> result = departmentControllerUnderTest.findAllBySort("sortBy");

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testFindAllBySort2() {
        // Setup
        final PageParam pageParam = new PageParam(0, 0, "sorting", "field");

        // Configure DepartmentService.findAllByPaging(...).
        final Page<Department> departments = new PageImpl<>(
                Arrays.asList(new Department(0, "departmentName", "departmentAddress", "departmentCode")));
        when(mockDepartmentService.findAllByPaging(new PageParam(0, 0, "sorting", "field"))).thenReturn(departments);

        // Run the test
        final Page<Department> result = departmentControllerUnderTest.findAllBySort(pageParam, 0, "pageSize1");

        // Verify the results
    }

    @Test
    void testFindAllBySort2_DepartmentServiceReturnsNoItems() {
        // Setup
        final PageParam pageParam = new PageParam(0, 0, "sorting", "field");
        when(mockDepartmentService.findAllByPaging(new PageParam(0, 0, "sorting", "field")))
                .thenReturn(new PageImpl<>(Collections.emptyList()));

        // Run the test
        final Page<Department> result = departmentControllerUnderTest.findAllBySort(pageParam, 0, "pageSize1");

        // Verify the results
    }

    @Test
    void testFindAllByPagingAndSort() {
        // Setup
        final List<Department> expectedResult = Arrays.asList(
                new Department(0, "departmentName", "departmentAddress", "departmentCode"));

        // Configure DepartmentService.findAllByPagingAndSort(...).
        final List<Department> departments = Arrays.asList(
                new Department(0, "departmentName", "departmentAddress", "departmentCode"));
        when(mockDepartmentService.findAllByPagingAndSort(0, 0, "sortDirection", "sortField")).thenReturn(departments);

        // Run the test
        final List<Department> result = departmentControllerUnderTest.findAllByPagingAndSort(0, 0, "sortField",
                "sortDirection");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindAllByPagingAndSort_DepartmentServiceReturnsNoItems() {
        // Setup
        when(mockDepartmentService.findAllByPagingAndSort(0, 0, "sortDirection", "sortField"))
                .thenReturn(Collections.emptyList());

        // Run the test
        final List<Department> result = departmentControllerUnderTest.findAllByPagingAndSort(0, 0, "sortField",
                "sortDirection");

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testFindAllByoffsetAndSort() {
        // Setup
        final List<Department> expectedResult = Arrays.asList(
                new Department(0, "departmentName", "departmentAddress", "departmentCode"));

        // Configure DepartmentService.findAllByoffsetAndSort(...).
        final List<Department> departments = Arrays.asList(
                new Department(0, "departmentName", "departmentAddress", "departmentCode"));
        when(mockDepartmentService.findAllByoffsetAndSort(0, 0, "sortDirection", "sortField")).thenReturn(departments);

        // Run the test
        final List<Department> result = departmentControllerUnderTest.findAllByoffsetAndSort(0, 0, "sortField",
                "sortDirection");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindAllByoffsetAndSort_DepartmentServiceReturnsNoItems() {
        // Setup
        when(mockDepartmentService.findAllByoffsetAndSort(0, 0, "sortDirection", "sortField"))
                .thenReturn(Collections.emptyList());

        // Run the test
        final List<Department> result = departmentControllerUnderTest.findAllByoffsetAndSort(0, 0, "sortField",
                "sortDirection");

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testFindEmployeeById1() throws Exception {
        // Setup
        final EmployeeEntity expectedResult = new EmployeeEntity();
        expectedResult.setEmployeeId(0);
        final AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountId(0);
        accountEntity.setAccountNumber("accountNumber");
        accountEntity.setEmployeeId(0);
        expectedResult.setAccounts(new HashSet<>(Arrays.asList(accountEntity)));

        // Configure DepartmentService.findEmployeeById(...).
        final EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmployeeId(0);
        final AccountEntity accountEntity1 = new AccountEntity();
        accountEntity1.setAccountId(0);
        accountEntity1.setAccountNumber("accountNumber");
        accountEntity1.setEmployeeId(0);
        employeeEntity.setAccounts(new HashSet<>(Arrays.asList(accountEntity1)));
        when(mockDepartmentService.findEmployeeById(0)).thenReturn(employeeEntity);

        // Run the test
        final EmployeeEntity result = departmentControllerUnderTest.findEmployeeById(0);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindEmployeeById1_DepartmentServiceThrowsNotFoundException() throws Exception {
        // Setup
        when(mockDepartmentService.findEmployeeById(0)).thenThrow(NotFoundException.class);

        // Run the test
        final EmployeeEntity result = departmentControllerUnderTest.findEmployeeById(0);

        // Verify the results
        assertNull(result);
    }

    @Test
    void testFindEmployeeById1_DepartmentServiceThrowsNotFoundException2() throws Exception {
        // Setup
        when(mockDepartmentService.findEmployeeById(0)).thenThrow(NotFoundException2.class);

        // Run the test
        final EmployeeEntity result = departmentControllerUnderTest.findEmployeeById(0);

        // Verify the results
        assertNull(result);
    }

    @Test
    void testFindEmployeeById2() {
        // Setup
        final EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmployeeId(0);
        final AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountId(0);
        accountEntity.setAccountNumber("accountNumber");
        accountEntity.setEmployeeId(0);
        employeeEntity.setAccounts(new HashSet<>(Arrays.asList(accountEntity)));

        final EmployeeEntity expectedResult = new EmployeeEntity();
        expectedResult.setEmployeeId(0);
        final AccountEntity accountEntity1 = new AccountEntity();
        accountEntity1.setAccountId(0);
        accountEntity1.setAccountNumber("accountNumber");
        accountEntity1.setEmployeeId(0);
        expectedResult.setAccounts(new HashSet<>(Arrays.asList(accountEntity1)));

        // Configure DepartmentService.saveEmployee(...).
        final EmployeeEntity employeeEntity1 = new EmployeeEntity();
        employeeEntity1.setEmployeeId(0);
        final AccountEntity accountEntity2 = new AccountEntity();
        accountEntity2.setAccountId(0);
        accountEntity2.setAccountNumber("accountNumber");
        accountEntity2.setEmployeeId(0);
        employeeEntity1.setAccounts(new HashSet<>(Arrays.asList(accountEntity2)));
        final EmployeeEntity employeeEntity2 = new EmployeeEntity();
        employeeEntity2.setEmployeeId(0);
        final AccountEntity accountEntity3 = new AccountEntity();
        accountEntity3.setAccountId(0);
        accountEntity3.setAccountNumber("accountNumber");
        accountEntity3.setEmployeeId(0);
        employeeEntity2.setAccounts(new HashSet<>(Arrays.asList(accountEntity3)));
        when(mockDepartmentService.saveEmployee(employeeEntity2)).thenReturn(employeeEntity1);

        // Run the test
        final EmployeeEntity result = departmentControllerUnderTest.findEmployeeById(employeeEntity);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
