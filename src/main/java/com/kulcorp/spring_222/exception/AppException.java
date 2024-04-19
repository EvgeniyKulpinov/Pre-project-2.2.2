package com.kulcorp.spring_222.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.LOCKED, reason = "Сортировка выключена")
public class AppException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}
