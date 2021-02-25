package com.example.demo.mapper;

import com.example.demo.entity.WebEvents;
import com.example.demo.service.dto.WebEventsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AccountsMapper.class})
public interface WebEventsMapper extends BaseMapper<WebEvents, WebEventsDTO> {

    WebEventsMapper INSTANCE = Mappers.getMapper(WebEventsMapper.class);

}
