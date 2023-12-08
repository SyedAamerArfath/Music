package com.girus.Music.exception;

import com.girus.Music.entity.Music;
import com.girus.Music.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.concurrent.RejectedExecutionException;

@RestControllerAdvice
public class MusicExceptionHandler extends RejectedExecutionException {


    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ResponseStructure<String>>  sQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException sq){
        ResponseStructure<String> structure=new ResponseStructure<>();
        structure.setData("you cannot perform this operation");
        structure.setMessage(sq.getMessage());
        structure.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MusicNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> musicNotFoundException(MusicNotFoundException mu){
        ResponseStructure<String> structure=new ResponseStructure<>();
        structure.setStatus(HttpStatus.NOT_FOUND.value());
        structure.setMessage(mu.getMessage());
        structure.setData("song not found");

        return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
    }
}
