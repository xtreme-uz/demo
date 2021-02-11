package com.example.demo.service;

import com.example.demo.entity.Accounts;
import com.example.demo.mapper.AccountsMapper;
import com.example.demo.projections.AccountsNameColumnProject;
import com.example.demo.repository.AccountsRepository;
import com.example.demo.service.dto.AccountsDTO;
import com.example.demo.web.rest.vm.AccountsCreateVM;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService extends AbsService<Accounts, AccountsDTO, AccountsRepository, AccountsMapper> {

    private final SalesRepService salesService;

    public AccountsService(AccountsRepository repository, AccountsMapper mapper, SalesRepService salesService) {
        super(repository, mapper);
        this.salesService = salesService;
    }

    public AccountsDTO create(AccountsCreateVM vm){
        AccountsDTO dto = new AccountsDTO();
        dto.setName(vm.getName());
        dto.setWebsite(vm.getWebsite());
        dto.setPContact(vm.getPContact());
        dto.setSales(salesService.get(vm.getSales()));
        return create(dto);
    }

    public List<AccountsNameColumnProject> getIdAndName(){
        List<AccountsNameColumnProject> names = repository.getIdAndName();
        return names;
    }


}
