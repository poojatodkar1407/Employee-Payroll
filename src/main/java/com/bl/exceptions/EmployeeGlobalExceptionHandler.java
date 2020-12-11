package com.bl.exceptions;

import com.bl.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class EmployeeGlobalExceptionHandler {

        @ExceptionHandler(PayrollException.class)
        public ResponseEntity<ResponseDto> handleCMSException(PayrollException payrollException){
            //log.error(codinClubUserException.getMessage());
            return new ResponseEntity<ResponseDto>(new ResponseDto(null, payrollException.exceptionTypes.errorMessage),
                    HttpStatus.BAD_REQUEST);
        }


}
