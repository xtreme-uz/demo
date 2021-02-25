package com.example.demo.service;

import com.example.demo.entity.SalesRep;
import com.example.demo.service.dto.SalesRepDTO;
import com.example.demo.web.rest.vm.SalesRepCreateVM;

public interface SalesRepService
        extends AbsService<SalesRep, SalesRepDTO>{

    SalesRepDTO create(SalesRepCreateVM vm);
}
