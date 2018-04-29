package com.example.demo.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Bob Simon
 * @Description：封装结果到页面的是实体类
 * @Date :Created in 2018-04-29 14:53
 * @Modified By
 **/
public class Result extends HashMap<String,Object> {

    private static final long serialVersionUID = 1L;

    public Result() {
        put("code",0);
    }

    /**
     * 错误
     * @return
     */
    public static Result error() {
        return error(500,"未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(500, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Object msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }


    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
