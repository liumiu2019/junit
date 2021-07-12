package com.xmw.component.unit.service;

import com.alibaba.fastjson.JSON;
import com.xmw.component.unit.annotation.UnitApi;
import com.xmw.component.unit.annotation.YapiEntityAttributes;
import com.xmw.component.unit.entity.SaveReq;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public abstract class UnitApiTest {

    protected static ConcurrentHashMap<String, UnitToYapi> map = new ConcurrentHashMap<>();

    protected static <T> UnitToYapi<T> getArguments(Class<T> data, Method method) {
        //设置入参字段
        Map<String, Object> kv = new HashMap<>();
        List<SaveReq.BodyForm> requestForm = new ArrayList<>();
        for (Field field : data.getDeclaredFields()) {
            YapiEntityAttributes attributes = field.getAnnotation(YapiEntityAttributes.class);
            if (attributes == null) {
                continue;
            }
            if (attributes.value().length > 0) {
                for (String s : attributes.value()) {
                    SaveReq.BodyForm form = new SaveReq.BodyForm();
                    form.setName(field.getName());
                    form.setDesc(attributes.desc());
                    form.setExample(s);
                    form.setRequired(attributes.required());
                    requestForm.add(form);
                    kv.put(field.getName(), s);
                }
            }
        }
        T instance = JSON.parseObject(JSON.toJSONString(kv), data);
        UnitToYapi<T> toYapi = new UnitToYapi<>();
        toYapi.setDocument(false);
        toYapi.setRequest(instance);
        if (method.getAnnotation(UnitApi.class) != null) {
            toYapi.setRequestForm(requestForm);
            UnitApi unitApi = method.getAnnotation(UnitApi.class);
            toYapi.setComment(unitApi.comment());
            toYapi.setMethod(unitApi.method());
            toYapi.setRoute(unitApi.route());
            toYapi.setDocument(true);
            toYapi.setCat(unitApi.catId());
            toYapi.setTitle(unitApi.title());
        }
        map.putIfAbsent(method.getName(), toYapi);
        return toYapi;
    }

}
