package com.xmw.component.unit.entity;

import lombok.Data;

@Data
public class SaveResp {
    Integer errcode;
    String errmsg;
    private Item data;

    @Data
    static class Item {
        Integer ok;
        Integer nModified;
        Integer n;
    }
}
