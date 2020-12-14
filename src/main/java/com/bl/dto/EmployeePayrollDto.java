package com.bl.dto;


import com.bl.domain.EmployeePayroll;
import lombok.Data;

@Data
public class EmployeePayrollDto {

    private Long id;

    private String name;
    private String salary;
    private String gender;
    private String department;
    private String startDate;


    public EmployeePayrollDto(){

    }

    public EmployeePayrollDto(EmployeePayroll user){
        this.id = user.getId();
        this.name = user.getName();
        this.salary = user.getSalary();
        this.gender = user.getGender();
        this.department = user.getDepartment();
        this.startDate = user.getStartDate();
    }
}
