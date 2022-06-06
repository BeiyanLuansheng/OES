package org.oes.biz.service;

import org.oes.biz.entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);

    void payOrder(Order order);

    void cancelOrder(Order order);

    List<Order> findUserOrder(Long userId);

    Order findOrderById(Long orderId);

    /**
     * 判断是否购买过课程
     *
     * @param userId 用户ID
     * @param courseId 课程ID
     * @return true 购买过
     */
    boolean isPurchase(Long userId, Long courseId);
}
