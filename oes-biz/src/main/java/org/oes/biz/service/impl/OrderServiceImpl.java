package org.oes.biz.service.impl;

import org.oes.biz.entity.Order;
import org.oes.biz.entity.UserCourse;
import org.oes.biz.mapper.OrderMapper;
import org.oes.biz.mapper.UserCourseMapper;
import org.oes.biz.service.OrderService;
import org.oes.common.enums.OrderStatusEnum;
import org.oes.common.exception.OesServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserCourseMapper userCourseMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Order createOrder(Order order) {
        order.setStatus(OrderStatusEnum.WAITING.getStatus());
        order.setGmtCreate(new Date());
        orderMapper.insert(order);
        return order;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void payOrder(Order order) {
        if (OrderStatusEnum.WAITING.getStatus().equals(order.getStatus())) {
            order.setStatus(OrderStatusEnum.PAID.getStatus());
        } else {
            throw new OesServiceException("支付订单状态异常");
        }
        orderMapper.updateById(order);

        Order paidOrder = findOrderById(order.getOrderId());
        UserCourse userCourse = new UserCourse();
        userCourse.setUserId(paidOrder.getUserId());
        userCourse.setCourseId(paidOrder.getCourseId());
        userCourseMapper.insert(userCourse);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancelOrder(Order order) {
        if (OrderStatusEnum.WAITING.getStatus().equals(order.getStatus())) {
            order.setStatus(OrderStatusEnum.CANCEL.getStatus());
        } else {
            throw new OesServiceException("取消订单状态异常");
        }
    }

    @Override
    public List<Order> findUserOrder(Long userId) {
        Order order = new Order();
        order.setUserId(userId);
        return orderMapper.findOrderList(order);
    }

    @Override
    public Order findOrderById(Long orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        List<Order> orderList = orderMapper.findOrderList(order);
        return orderList != null && orderList.get(0) != null ? orderList.get(0) : null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean isPurchase(Long userId, Long courseId) {
        Order order = new Order();
        order.setCourseId(courseId);
        order.setUserId(userId);
        List<Order> orderList = orderMapper.findOrderList(order);
        for (Order o: orderList) {
            if (OrderStatusEnum.PAID.getStatus().equals(o.getStatus())) {
                return true;
            }
        }
        return false;
    }
}
