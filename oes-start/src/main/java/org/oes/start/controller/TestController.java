package org.oes.start.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.oes.common.entity.OesHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(path = "config", method = RequestMethod.GET)
    @RequiresPermissions("course:watch")
    public OesHttpResponse config() {
        return OesHttpResponse.getSuccess();
    }

    @GetMapping("gate")
    public String log() {
        return "gate";
    }
}
