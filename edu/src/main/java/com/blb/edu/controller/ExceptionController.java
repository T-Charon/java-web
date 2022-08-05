package com.blb.edu.controller;

/**
 * @Author Charon
 * @Date 2022/8/1
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理类
 */
@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionHander(Exception ex){
        log.error("==>"+ex);
        return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    };
}
