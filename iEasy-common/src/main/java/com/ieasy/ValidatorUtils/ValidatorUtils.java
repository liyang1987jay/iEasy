package com.ieasy.ValidatorUtils;

import com.ieasy.exception.IEasyException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.ieasy.ValidatorUtils
 * @description
 * @className ValidatorUtils
 * @createDate 2019-03-19 10:22 PM
 */
public class ValidatorUtils {

    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     * @param object        待校验对象
     * @param groups        待校验的组
     * @throws IEasyException  校验不通过，则报RRException异常
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws IEasyException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            ConstraintViolation<Object> constraint = (ConstraintViolation<Object>)constraintViolations.iterator().next();
            throw new IEasyException(constraint.getMessage());
        }
    }
}
