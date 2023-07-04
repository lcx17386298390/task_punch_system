package com.acm.entity;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private boolean success;
    private T msg;

    public Result(int code, boolean success, T msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }

    public static <T> Result<T> success(){
        return new Result<>(200,true,null);
    }
    public static <T> Result<T> success(T data){
        return new Result<>(200,true,data);
    }
    public static <T> Result<T> failure(int code){
        return new Result<>(code,false,null);
    }
    public static <T> Result<T> failure(int code,T data){
        return new Result<>(code,false,data);
    }
}
