package cindyhj.com.flight_booking.exceptions;

import cindyhj.com.flight_booking.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error ="Resource Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse err = new ErrorResponse(status.value(),error);
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityException(
            DataIntegrityViolationException e,
            HttpServletRequest request) {
      String error = "Data Integrity Violation";
      HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
      ErrorResponse  err = new ErrorResponse(status.value(),error);
      return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(
            ConstraintViolationException e,
            HttpServletRequest request) {
        String error = "Constraint Violation:";
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponse  err = new ErrorResponse(status.value(),error);
        return ResponseEntity.status(status).body(err);
    }









}




