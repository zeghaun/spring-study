package com.spring.common.exception;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/6/29
 */

public class ErrorMessage implements Serializable {
    private static final long serialVersionUID = -5401402542472113075L;

    private String code;
    private String message;
    private String detail;
    private Date serverTime = new Date();

    public ErrorMessage() {
    }

    public ErrorMessage(String code) {
        this(code, null);
    }

    public ErrorMessage(String code, String message) {
        this(code, message, null);
    }

    public ErrorMessage(String code, String message, String detail) {
        this.message = message;
        this.code = code;
        this.detail = detail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String toString() {
        return "<" + "code:" + getCode() + ", message:" + getMessage() + ", host_id:" + ", server_time:" + serverTime + ", detail:" + getDetail() + ">";
    }

}