package com.example.demo.service.impl;

import com.example.demo.entity.Accounts;
import com.example.demo.mapper.AccountsMapper;
import com.example.demo.projections.AccountsNameColumnProject;
import com.example.demo.repository.AccountsRepository;
import com.example.demo.service.AccountsService;
import com.example.demo.service.dto.AccountsDTO;
import com.example.demo.web.rest.vm.AccountsCreateVM;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsServiceImpl extends AbsServiceImpl<Accounts, AccountsDTO, AccountsRepository, AccountsMapper>
        implements AccountsService {

    private final SalesRepServiceImpl salesService;

    public AccountsServiceImpl(AccountsRepository repository, AccountsMapper mapper, SalesRepServiceImpl salesService) {
        super(repository, mapper);
        this.salesService = salesService;
    }
    @Override
    public AccountsDTO create(AccountsCreateVM vm){
        AccountsDTO dto = new AccountsDTO();
        dto.setName(vm.getName());
        dto.setWebsite(vm.getWebsite());
        dto.setPContact(vm.getPContact());
        dto.setSales(salesService.get(vm.getSales()));
        return create(dto);
    }

    @Override
    public List<AccountsNameColumnProject> getIdAndName(){
        List<AccountsNameColumnProject> names = repository.getIdAndName();
        return names;
    }


}
