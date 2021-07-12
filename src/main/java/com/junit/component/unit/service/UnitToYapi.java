package com.junit.component.unit.service;

import com.alibaba.fastjson.JSON;
import com.junit.component.unit.entity.ResponseData;
import com.junit.component.unit.feignService.YapiFeignService;
import com.junit.component.unit.common.UnitSpringUtil;
import com.junit.component.unit.common.YapiTokenConst;
import com.junit.component.unit.entity.SaveReq;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
public class UnitToYapi<T> {
    private T request;

    private List<SaveReq.BodyForm> requestForm;

    private String method;

    private String comment;

    private String route;

    private String title;

    private Integer project;

    private Integer cat;

    private Boolean document;

    /**
     * 断言后生成接口文档
     *
     * @param responseData
     * @param actual
     * @param expect
     */
    public void assertEqualAndDoc(ResponseData responseData, Object actual, Object expect) {
        assert actual.equals(expect);
        YapiFeignService yapiFeignService = UnitSpringUtil.getBean(YapiFeignService.class);
        if (expect != null) {
            if (responseData != null && this.document) {
                SaveReq entity = new SaveReq();
                entity.setCatid(this.cat);
                entity.setDesc(this.comment);
                entity.setToken(YapiTokenConst.dualToken.getToken());
                entity.setPath(this.route);
                entity.setTitle(this.title);
                if (method.equals("POST")) {
                    entity.setReqBodyForm(requestForm);
                }
                if (method.equals("GET")) {
                    entity.setReqQuery(requestForm);
                }
                entity.setResBody(JSON.toJSONString(responseData));
                entity.setMethod(this.method);
                log.info("api请求 {}", JSON.toJSONString(entity));
                String saveResp = yapiFeignService.saveApi(JSON.toJSONString(entity));
                log.info("api生成结果 {}", saveResp);
            }
        }
        log.info("结果 {}", responseData);
    }
}
