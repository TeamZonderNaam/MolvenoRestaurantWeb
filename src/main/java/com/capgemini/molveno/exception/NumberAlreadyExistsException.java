package com.capgemini.molveno.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="Table number already exists.")
public class NumberAlreadyExistsException extends RuntimeException {
}
