package com.example.demo.service.mapper;

import com.example.demo.entity.SalesRep;
import com.example.demo.service.dto.SalesRepDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {RegionMapper.class})
public interface SalesMapper extends BaseMapper<SalesRep, SalesRepDTO> {

    SalesMapper INSTANCE = Mappers.getMapper(SalesMapper.class);

//    @Mapping(target = "regionId", source = "region.id")
//    SalesRepCreateVM toVm(SalesRepDTO dto);

}
