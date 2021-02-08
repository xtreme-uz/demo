package com.example.demo.mapper;

import com.example.demo.entity.Accounts;
import com.example.demo.service.dto.AccountsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {SalesMapper.class})
public interface AccountsMapper extends BaseMapper<Accounts, AccountsDTO> {

    AccountsMapper INSTANCE = Mappers.getMapper(AccountsMapper.class);

}
