package com.xmw.component.unit.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class ListResp {

    private Integer errcode;

    private String errmsg;

    @Data
    public static class Item {
        private Integer count;
        private Integer total;
        private List<Response> data;
    }

    @Data
    public static class Response {
        private Integer editUid;
        private String status;
        private Boolean apiOpened;
        @JSONField(name = "_id")
        private Integer id;
        private String method;
        private Integer catid;
        private String title;
        private String path;
        private Integer projectId;
        private Integer uid;
        private Integer addTime;
    }
}
