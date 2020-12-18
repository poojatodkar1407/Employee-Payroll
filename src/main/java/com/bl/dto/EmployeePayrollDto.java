package com.bl.dto;


import com.bl.domain.EmployeePayroll;
import lombok.Data;

import java.util.List;

@Data
public class EmployeePayrollDto {

    private Long id;

    private String name;
    private String salary;
    private String gender;
    private List<String> departments;
    private String startDate;
    
    public EmployeePayrollDto(){

    }

    public EmployeePayrollDto(EmployeePayroll user){
        this.id = user.getId();
        this.name = user.getName();
        this.salary = user.getSalary();
        this.gender = user.getGender();
        this.departments = user.getDepartments();
        this.startDate = user.getStartDate();
    }
}
