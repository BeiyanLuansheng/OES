package org.oes.start.controller;

import org.oes.common.entity.OesHttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(path = "config", method = RequestMethod.GET)
    public OesHttpResponse config() {
        return OesHttpResponse.getSuccess();
    }
}
