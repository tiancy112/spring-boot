package com.samsundot.invoice.utils;

//import lombok.Data;

import java.io.Serializable;

//@Data
public class ResultVO<T> implements Serializable {


    private static final long serialVersionUID = -8655891345041740105L;

    /** 状态码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
