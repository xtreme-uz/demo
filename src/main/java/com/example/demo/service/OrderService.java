package com.example.demo.service;

import com.example.demo.entity.Orders;
import com.example.demo.service.dto.OrdersDTO;
import com.example.demo.web.rest.vm.OrdersCreateVM;

public interface OrderService
        extends AbsService<Orders, OrdersDTO>{

    OrdersDTO create(OrdersCreateVM vm);
}
