package com.example.demo.service;

import com.example.demo.entity.Orders;
import com.example.demo.service.dto.OrdersDTO;
import com.example.demo.web.rest.vm.OrdersCreateVM;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface OrderService
        extends AbsService<Orders, OrdersDTO>{

    OrdersDTO create(OrdersCreateVM vm);

    OrdersDTO imgUpload(Long id, MultipartFile file);

    Resource load(String filePath);
}
