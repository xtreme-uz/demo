package com.example.demo.service.mapper;

import com.example.demo.entity.MyUser;
import com.example.demo.service.dto.MyUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MyUserMapper extends BaseMapper<MyUser, MyUserDTO> {

    MyUserMapper INSTANCE = Mappers.getMapper(MyUserMapper.class);

}
