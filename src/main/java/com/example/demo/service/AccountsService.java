package com.example.demo.service;

import com.example.demo.entity.Accounts;
import com.example.demo.mapper.AccountsMapper;
import com.example.demo.repository.AccountsRepository;
import com.example.demo.service.dto.AccountsDTO;
import com.example.demo.web.rest.vm.AccountsCreateVM;
import org.springframework.stereotype.Service;

@Service
public class AccountsService extends AbsService<Accounts, AccountsDTO, AccountsRepository, AccountsMapper> {

    private final SalesRepService salesService;

    public AccountsService(AccountsRepository repository, AccountsMapper mapper, SalesRepService salesService) {
        super(repository, mapper);
        this.salesService = salesService;
    }

//    public AccountsProject getByUsername(String accounts) {
//        Optional<AccountsProject> found = repository.getByUsername(accounts);
//        return found.orElseThrow(() -> new RuntimeException("User not found"));
//    }

    public AccountsDTO create(AccountsCreateVM vm){
        AccountsDTO dto = new AccountsDTO();
        dto.setName(vm.getName());
        dto.setWebsite(vm.getWebsite());
        dto.setPrimaryContactPerson(vm.getPrimaryContactPerson());
        dto.setSalesId(salesService.get(vm.getSalesId()));
        return create(dto);
    }

}
