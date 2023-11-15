package ru.netology.coursework.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.coursework.exception.BadRequest;
import ru.netology.coursework.exception.ErrorTransfer;
import ru.netology.coursework.loger.Loger;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ErrorMessage> invalidDate(BadRequest exception) {
        Loger.write("ERROR", "Error input data");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(exception.getMessage()));
    }

    @ExceptionHandler(ErrorTransfer.class)
    public ResponseEntity<ErrorMessage> errorTransfer(BadRequest exception) {
        Loger.write("ERROR", "Error customer message");

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorMessage(exception.getMessage()));
    }
}
