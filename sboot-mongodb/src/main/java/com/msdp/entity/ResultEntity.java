package com.msdp.entity;

/**
 * Created by shixk1 on 2017/7/5.
 */
public class ResultEntity {
    private Integer code;
    private String msg;


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

    public ResultEntity(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public ResultEntity(){

    }
}
