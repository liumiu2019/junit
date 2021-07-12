package com.junit.component.unit.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SaveReq {
    private String token;
    @JSONField(name = "req_query")
    private List<BodyForm> reqQuery = new ArrayList<>();
    @JSONField(name = "req_param")
    private List<Object> reqParam = new ArrayList<>();
    @JSONField(name = "req_headers")
    private List<Head> reqHeaders = new ArrayList<>();

    @Data
    static class Head {
        private String name = "Content-Type";
    }

    @JSONField(name = "req_body_form")
    private List<BodyForm> reqBodyForm = new ArrayList<>();
    @JSONField(name = "req_body_type")
    private String reqBodyType = "form";
    private String title;
    private Integer catid;
    private String path;
    private String status = "undone";
    @JSONField(name = "res_body_type")
    private String resBodyType = "json";
    @JSONField(name = "res_body")
    private String resBody;
    @JSONField(name = "res_body_form")
    List<BodyForm> resBodyForm;
    @JSONField(name = "switch_notice")
    private Boolean switchNotice = false;
    private String message = "自动生成";
    private String desc = "";
    private String method = "POST";
    private Integer id;
    @JSONField(name = "res_body_is_json_schema")
    private Boolean resBodyIsJsonSchema = false;

    @Data
    public static class BodyForm {
        private String name;
        private String type = "text";
        private String example;
        private String desc;
        private String required = "0";
    }
}
