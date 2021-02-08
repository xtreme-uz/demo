package com.example.demo.mapper;


import com.example.demo.entity.Orders;
import com.example.demo.service.dto.OrdersDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AccountsMapper.class})
public interface OrdersMapper extends BaseMapper<Orders, OrdersDTO>{

    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

}