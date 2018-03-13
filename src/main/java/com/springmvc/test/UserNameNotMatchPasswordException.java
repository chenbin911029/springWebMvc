package com.springmvc.test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author chenbin at 2018/3/13 8:20
 */
@ResponseStatus(value = HttpStatus.CONFLICT,reason = "非法参数")
public class UserNameNotMatchPasswordException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
}
