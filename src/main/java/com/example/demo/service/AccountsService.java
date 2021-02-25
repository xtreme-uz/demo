package com.example.demo.service;

import com.example.demo.entity.Accounts;
import com.example.demo.projections.AccountsNameColumnProject;
import com.example.demo.service.dto.AccountsDTO;
import com.example.demo.web.rest.vm.AccountsCreateVM;

import java.util.List;

public interface AccountsService extends
        AbsService<Accounts, AccountsDTO>{

    AccountsDTO create(AccountsCreateVM vm);

    List<AccountsNameColumnProject> getIdAndName();

}
