package com.bl.controller;

import com.bl.domain.EmployeePayroll;
import com.bl.dto.EmployeePayrollDto;
import com.bl.dto.ResponseDto;
import com.bl.exceptions.PayrollException;
import com.bl.exceptions.UserNotFound;
import com.bl.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

    @Autowired
    EmployeePayrollService employeePayrollService;
    //http://localhost:8080/employee-payroll/create (dto)
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@RequestBody @Valid EmployeePayrollDto user){
        try{
            EmployeePayrollDto employeePayrollDto = employeePayrollService.CreateUser(user);
            return new ResponseEntity<ResponseDto>(new ResponseDto("Employee Added Successfully","200",employeePayrollDto),HttpStatus.CREATED);
        } catch (UserNotFound e){
            throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
        }
    }

    //http:localhost/employee-payroll/update (dto)
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@RequestBody EmployeePayrollDto user){
        try{
            EmployeePayrollDto employeePayrollDto = employeePayrollService.UpdateUser(user);
            return new ResponseEntity<ResponseDto>(new ResponseDto("Employee Updated Successfully","200",employeePayrollDto),HttpStatus.CREATED);
        } catch (UserNotFound e){
            throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
        }
    }

    //http://localhost:8080/employee-payroll/delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable("id")Long id){
        try{
            EmployeePayrollDto employeePayrollDto = employeePayrollService.deleteUser(id);
            return new ResponseEntity<ResponseDto>(new ResponseDto("Employee Deleted Successfully","200",employeePayrollDto),HttpStatus.CREATED);

        } catch (UserNotFound e){
            throw new PayrollException(PayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
        }
    }

    //http://localhost:8080/employee-payroll/get
    @GetMapping("/get")
    public ResponseEntity<List<EmployeePayrollDto>> getAllUser(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(employeePayrollService.getAllUser());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //localhost:8080/employe-payroll/getbyid/?id=id
    @GetMapping("/getbyid")
    public ResponseEntity<Optional<EmployeePayroll>> getById(@RequestParam long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(employeePayrollService.getById(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
