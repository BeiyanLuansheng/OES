package org.oes.start.controller.admin;

import org.oes.biz.entity.Category;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = URIs.CATEGORY)
public class CategoryController {

    @RequestMapping(method = RequestMethod.GET)
    public OesHttpResponse getCategory(@RequestBody Category category) {
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.POST)
    public OesHttpResponse addCategory(@RequestBody Category category) {
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public OesHttpResponse removeCategory(@RequestBody Category category) {
        return OesHttpResponse.getSuccess();
    }
}
