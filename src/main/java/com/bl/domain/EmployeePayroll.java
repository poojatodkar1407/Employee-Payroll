package com.bl.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Lazy
@Data
@Entity
@Table
public class EmployeePayroll implements Serializable {

    private static final long serialVersionUID = -8900492704842756948L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String salary;
    private String gender;
    @JsonIgnore
    @ElementCollection
    @CollectionTable(joinColumns = @JoinColumn(name = "id"))
    private List<String> departments;
    private String startDate;

    public EmployeePayroll(){

    }


    public EmployeePayroll(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }

    public EmployeePayroll(String name, String salary, String gender, List<String> department, String startDate) {
        this.name = name;
        this.salary = salary;
          this.gender = gender;
        this.departments = department;
        this.startDate = startDate;
    }
}
