/**
 * @copyright Copyright 1999-2015 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.spring.common.utils;

import com.spring.component.Application;
import org.springframework.context.support.MessageSourceAccessor;


public class MessageUtil {

    /**
     * @return
     */
    public static MessageSourceAccessor getMessageSourceAccessor() {
        return Application.getApplicationContext().getBean(MessageSourceAccessor.class);
    }

    /**
     * @param code
     * @return
     */
    public static String getMessage(String code) {
        return getMessageSourceAccessor().getMessage(code);
    }

    /**
     * @param code
     * @param args
     * @return
     */
    public static String getMessage(String code, Object[] args) {
        return getMessageSourceAccessor().getMessage(code, args);
    }

    /**
     * @param code
     * @param defaultMessage
     * @return
     */
    public static String getMessage(String code, String defaultMessage) {
        return getMessageSourceAccessor().getMessage(code, defaultMessage);
    }
}
