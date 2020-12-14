package com.bl.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "employee")
public class EmployeePayroll implements Serializable {

    private static final long serialVersionUID = -8900492704842756948L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String salary;
    private String gender;
    private String department;
    private String startDate;

    public EmployeePayroll(){

    }


    public EmployeePayroll(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }
}
