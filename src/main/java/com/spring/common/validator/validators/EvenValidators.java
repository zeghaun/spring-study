package com.spring.common.validator.validators;

import com.spring.common.validator.constraint.Even;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/7/25
 */
public class EvenValidators implements ConstraintValidator<Even, Integer> {
    @Override
    public void initialize(Even constraintAnnotation) {
        constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value % 2 == 0;
    }
}
