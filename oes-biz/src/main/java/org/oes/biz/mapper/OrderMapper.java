package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.Order;

import java.util.List;

public interface OrderMapper {

    int insert(@Param("order") Order order);

    int updateById(@Param("order") Order order);

    List<Order> findOrderList(@Param("order") Order order);
}
