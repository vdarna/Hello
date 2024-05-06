package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.entity.PageParam;
import com.example.department.service.DepartmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class DepartmentControllerTest222 {
    @Mock
    DepartmentService departmentService;
    @Mock
    Logger log;
    @InjectMocks
    DepartmentController departmentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveDepartment() {
        when(departmentService.saveDepartment(any())).thenReturn(new Department(Integer.valueOf(0), "departmentName", "departmentAddress", "departmentCode"));

        Department result = departmentController.saveDepartment(new Department(Integer.valueOf(0), "departmentName", "departmentAddress", "departmentCode"));
        Assertions.assertEquals(new Department(Integer.valueOf(0), "departmentName", "departmentAddress", "departmentCode"), result);
    }

    @Test
    void testFindDepartmentById() {
        when(departmentService.findDepartmentById(anyInt())).thenReturn(null);

        Optional<Department> result = departmentController.findDepartmentById(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testFindAllDepartments() throws IOException {
        when(departmentService.findAllDepartments()).thenReturn(Arrays.<Department>asList(new Department(Integer.valueOf(0), "departmentName", "departmentAddress", "departmentCode")));

        List<Department> result = departmentController.findAllDepartments();
        Assertions.assertEquals(Arrays.<Department>asList(new Department(Integer.valueOf(0), "departmentName", "departmentAddress", "departmentCode")), result);
    }

    @Test
    void testFindAllBySort() {
        when(departmentService.findAllBySort(anyString())).thenReturn(Arrays.<Department>asList(new Department(Integer.valueOf(0), "departmentName", "departmentAddress", "departmentCode")));

        List<Department> result = departmentController.findAllBySort("sortBy");
        Assertions.assertEquals(Arrays.<Department>asList(new Department(Integer.valueOf(0), "departmentName", "departmentAddress", "departmentCode")), result);
    }

    @Test
    void testFindAllBySort2() {
        when(departmentService.findAllByPaging(any())).thenReturn(null);

        Page<Department> result = departmentController.findAllBySort(new PageParam(0, 0, "sorting", "field"), 0, "pageSize1");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testFindAllByPagingAndSort() {
        when(departmentService.findAllByPagingAndSort(anyInt(), anyInt(), anyString(), anyString())).thenReturn(Arrays.<Department>asList(new Department(Integer.valueOf(0), "departmentName", "departmentAddress", "departmentCode")));

        List<Department> result = departmentController.findAllByPagingAndSort(Integer.valueOf(0), Integer.valueOf(0), "sortField", "sortDirection");
        Assertions.assertEquals(Arrays.<Department>asList(new Department(Integer.valueOf(0), "departmentName", "departmentAddress", "departmentCode")), result);
    }

    @Test
    void testFindAllByoffsetAndSort() {
        when(departmentService.findAllByoffsetAndSort(anyInt(), anyInt(), anyString(), anyString())).thenReturn(Arrays.<Department>asList(new Department(Integer.valueOf(0), "departmentName", "departmentAddress", "departmentCode")));

        List<Department> result = departmentController.findAllByoffsetAndSort(Integer.valueOf(0), Integer.valueOf(0), "sortField", "sortDirection");
        Assertions.assertEquals(Arrays.<Department>asList(new Department(Integer.valueOf(0), "departmentName", "departmentAddress", "departmentCode")), result);
    }




}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme