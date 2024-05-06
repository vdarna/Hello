package com.example.department.repository;

import com.example.department.entity.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository

public interface DepartmentRepository extends JpaRepository<Department,Integer> {



    @Query(value = "select d from Department d where d.departmentId IN (?1)")
    List<Department> findInfoByIds(Set<Integer> ids);

    Optional<Department> findByDepartmentId(Integer departmentId);


    @Query(value = "select d from Department d where d.departmentId IN (?1)")
    Page<Department> findAllByIdN(List<Integer> deptIds,PageRequest of);

    // Department findDepartmentById(Long departmentId);
}
