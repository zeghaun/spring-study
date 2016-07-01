/**
 * @copyright Copyright 1999-2015 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.spring.common.utils;

import com.spring.component.Application;
import org.springframework.context.support.MessageSourceAccessor;


public class MessageUtil {

    /**
     * 取application 全局的bean
     *
     * @return
     */
    public static MessageSourceAccessor getMessageSourceAccessor() {
        return Application.getApplicationContext().getBean(MessageSourceAccessor.class);
    }


    public static String getMessage(String code) {
        return getMessageSourceAccessor().getMessage(code);
    }


    public static String getMessage(String code, Object[] args) {
        return getMessageSourceAccessor().getMessage(code, args);
    }


    public static String getMessage(String code, String defaultMessage) {
        return getMessageSourceAccessor().getMessage(code, defaultMessage);
    }
}
