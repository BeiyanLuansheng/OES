package org.oes.start.controller.course;

import org.oes.biz.entity.Order;
import org.oes.biz.service.OrderService;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.oes.start.controller.BaseController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = URIs.ORDER)
public class OrderController extends BaseController {

    @Resource
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public OesHttpResponse getOrder() {
        List<Order> orderList = orderService.findUserOrder(this.getCurrentUser().getUserId());
        return OesHttpResponse.getSuccess(orderList);
    }

    @RequestMapping(method = RequestMethod.POST)
    public OesHttpResponse createOrder(@RequestBody Order order) {
        order.setUserId(this.getCurrentUser().getUserId());
        return OesHttpResponse.getSuccess(orderService.createOrder(order));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public OesHttpResponse payOrder(@RequestBody Order order) {
        orderService.payOrder(order);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public OesHttpResponse cancelOrder(@RequestBody Order order) {
        orderService.cancelOrder(order);
        return OesHttpResponse.getSuccess();
    }
}
