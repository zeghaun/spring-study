package com.spring.common.exception;

import com.spring.common.utils.MessageUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/6/29
 */
public class FieldException extends RuntimeException {

    static final long serialVersionUID = -8134891351351531939L;
    ResponseEntity<ErrorMessage> responseEntity;

    public FieldException(FieldError field) {
        this(new ResponseEntity<>(
                new ErrorMessage(
                        field.getDefaultMessage().toUpperCase().replaceAll("\\{|\\}", "").replaceAll("\\.", "_"),
                        MessageUtil.getMessage("error." + field.getDefaultMessage().replaceAll("\\{|\\}", "")
                                , reverseArgs(field.getArguments()))), HttpStatus.BAD_REQUEST));
    }

    private FieldException(ResponseEntity<ErrorMessage> responseEntity) {
        super(responseEntity.getBody().getMessage());
        this.responseEntity = responseEntity;
    }

    private static Object[] reverseArgs(Object[] args) {
        // errors.getFieldError().getArguments()
        Object[] rsArgs = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            rsArgs[i] = args[args.length - 1 - i];;
        }
        return rsArgs;
    }
}
