package com.bl.repository;

import com.bl.domain.EmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll,Long> {

}

