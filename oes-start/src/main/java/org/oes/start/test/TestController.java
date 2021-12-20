package org.oes.start.test;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.oes.common.constans.URIConstant;
import org.oes.common.entity.OesHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(path = URIConstant.TEST, method = RequestMethod.GET)
    @RequiresPermissions("perms:test")
    public OesHttpResponse test() {
        return OesHttpResponse.getSuccess();
    }

    @GetMapping(URIConstant.GATE)
    public String log() {
        return URIConstant.GATE;
    }
}
