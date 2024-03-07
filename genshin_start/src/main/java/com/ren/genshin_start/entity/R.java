package com.ren.genshin_start.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: easc
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-07-12 14:30
 * @description:
 **/
@Data
public class R<T> implements Serializable {

    private String msg;

    private Integer code;

    private T data;


    private Map map = new HashMap(); //动态数据

    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
