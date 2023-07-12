package com.acm.regandlogin.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private int code;
    private boolean success;
    private T msg;
    private String role;

    public Result(int code, boolean success, T msg,String role) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.role= role;
    }

    public static <T> Result<T> success(T data){
        return new Result<>(200,true,null,null);
    }
    public static <T> Result<T> success(T data,String role){
        return new Result<>(200,true,data,role);
    }
    public static <T> Result<T> failure(int code){
        return new Result<>(code,false,null,null);
    }
    public static <T> Result<T> failure(int code,T data){
        return new Result<>(code,false,data,null);
    }
}
