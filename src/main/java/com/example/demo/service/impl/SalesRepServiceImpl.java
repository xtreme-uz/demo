package com.example.demo.service.impl;

import com.example.demo.entity.SalesRep;
import com.example.demo.mapper.SalesMapper;
import com.example.demo.repository.SalesRepRepository;
import com.example.demo.service.SalesRepService;
import com.example.demo.service.dto.SalesRepDTO;
import com.example.demo.web.rest.vm.SalesRepCreateVM;
import org.springframework.stereotype.Service;

@Service
public class SalesRepServiceImpl extends AbsServiceImpl<SalesRep, SalesRepDTO, SalesRepRepository, SalesMapper>
        implements SalesRepService {

    private final RegionServiceImpl regionService;

    protected SalesRepServiceImpl(SalesRepRepository repository, SalesMapper mapper, RegionServiceImpl regionService) {
        super(repository, mapper);
        this.regionService = regionService;
    }
    @Override
    public SalesRepDTO create(SalesRepCreateVM vm) {
        SalesRepDTO dto = new SalesRepDTO();
        dto.setName(vm.getName());
        dto.setRegion(regionService.get(vm.getRegionId()));

        return create(dto);
    }
}
