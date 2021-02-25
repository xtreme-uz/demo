package com.example.demo.mapper;

import com.example.demo.entity.Region;
import com.example.demo.service.dto.RegionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RegionMapper extends BaseMapper<Region, RegionDTO> {

    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

}
