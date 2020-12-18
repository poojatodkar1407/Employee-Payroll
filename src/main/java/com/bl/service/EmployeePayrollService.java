package com.bl.service;

import com.bl.domain.EmployeePayroll;
import com.bl.dto.EmployeePayrollDto;
import com.bl.exceptions.DetailsNotProvidedExceptions;
import com.bl.exceptions.UserNotFound;
import com.bl.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public EmployeePayrollDto CreateUser(EmployeePayrollDto employeePayrollDto) {

        if (Objects.nonNull(employeePayrollDto.getName()) && Objects.nonNull(employeePayrollDto.getSalary())) {
            EmployeePayroll employeePayroll = new EmployeePayroll(employeePayrollDto.getName(), employeePayrollDto.getSalary(),employeePayrollDto.getGender(),employeePayrollDto.getDepartments(),employeePayrollDto.getStartDate());
            return new EmployeePayrollDto(employeePayrollRepository.save(employeePayroll));
        }

        throw new DetailsNotProvidedExceptions("Invalid Data..!!! Enter Valid Data");
    }

    public EmployeePayrollDto UpdateUser(EmployeePayrollDto employeePayrollDto){

        return employeePayrollRepository.findById(employeePayrollDto.getId()).map(employeePayroll -> {
            if(Objects.nonNull(employeePayrollDto.getName())){
                employeePayroll.setName(employeePayrollDto.getName());
            }
            if(Objects.nonNull(employeePayrollDto.getSalary())){
                employeePayroll.setSalary(employeePayrollDto.getSalary());
            }
            if(Objects.nonNull(employeePayrollDto.getGender())){
                employeePayroll.setGender(employeePayrollDto.getGender());
            }
            if(Objects.nonNull(employeePayrollDto.getDepartments())){
                employeePayroll.setDepartments(employeePayrollDto.getDepartments());
            }
            if(Objects.nonNull(employeePayrollDto.getStartDate())){
                employeePayroll.setStartDate(employeePayrollDto.getStartDate());
            }

           return new EmployeePayrollDto(employeePayrollRepository.save(employeePayroll));
        }).orElseThrow(()-> new UserNotFound("UserNotFound"));
    }

    public EmployeePayrollDto deleteUser(Long id){
        return employeePayrollRepository.findById(id).map(employeePayroll -> {
            employeePayrollRepository.deleteById(employeePayroll.getId());
            return new EmployeePayrollDto(employeePayroll);
        }).orElseThrow(()-> new UserNotFound("UserNotFound"));
    }


    public List<EmployeePayrollDto> getAllUser(){
        return employeePayrollRepository.findAll()
                .stream()
                .map(employeePayroll -> new EmployeePayrollDto(employeePayroll))
                .collect(Collectors.toList());
    }

    public Optional<EmployeePayroll> getById(long id) {
        System.out.println("in get");
        System.out.println(employeePayrollRepository.findById(id));
        return employeePayrollRepository.findById(id);
    }
}
