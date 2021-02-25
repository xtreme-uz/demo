package com.example.demo.service.impl;

import com.example.demo.entity.Orders;
import com.example.demo.mapper.OrdersMapper;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.service.OrderService;
import com.example.demo.service.dto.OrdersDTO;
import com.example.demo.web.rest.vm.OrdersCreateVM;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl extends AbsServiceImpl<Orders, OrdersDTO, OrdersRepository, OrdersMapper>
        implements OrderService {

    private final AccountsServiceImpl service;

    public OrdersServiceImpl(OrdersRepository repository, OrdersMapper mapper, AccountsServiceImpl service) {
        super(repository, mapper);
        this.service = service;
    }
    @Override
    public OrdersDTO create(OrdersCreateVM vm){
        OrdersDTO dto = new OrdersDTO();
        dto.setAccounts(service.get(vm.getAccounts()));
        dto.setStandardQty(vm.getStandardQty());
        dto.setPosterQty(vm.getPosterQty());
        dto.setGlossyQty(vm.getGlossyQty());
        dto.setTotal(vm.getTotal());
        dto.setDate(vm.getDate());
        dto.setStandardAmountUsd(vm.getStandardAmountUsd());
        dto.setGlossyAmountUsd(vm.getGlossyAmountUsd());
        dto.setPosterAmountUsd(vm.getPosterAmountUsd());
        dto.setTotalAmountUsd(vm.getTotalAmountUsd());
        return create(dto);
    }
}