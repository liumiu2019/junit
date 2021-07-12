package com.junit.component.unit.feignService;

import com.junit.component.unit.entity.ListResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://yapi.xiaomawang.com", name = "yapi")
public interface YapiFeignService {

    @GetMapping(value = "/api/interface/list", headers = {"Content-Type=application/json;charset=UTF-8"})
    ListResp getApiList(@RequestParam("token") String token, @RequestParam("page") Integer page, @RequestParam("limit") Integer limit);

    @PostMapping(value = "/api/interface/save", headers = {"Content-Type=application/json;charset=UTF-8"})
    String saveApi(String saveReq);
}
