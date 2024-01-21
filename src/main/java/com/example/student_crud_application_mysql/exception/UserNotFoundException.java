package com.example.student_crud_application_mysql.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Could not found the user with id "+id);
    }
}
