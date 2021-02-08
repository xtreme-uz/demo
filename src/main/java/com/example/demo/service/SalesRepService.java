package com.example.demo.service;

import com.example.demo.entity.SalesRep;
import com.example.demo.service.mapper.SalesMapper;
import com.example.demo.repository.SalesRepRepository;
import com.example.demo.service.dto.SalesRepDTO;
import com.example.demo.web.rest.vm.SalesRepCreateVM;
import org.springframework.stereotype.Service;

@Service
public class SalesRepService extends AbsService<SalesRep, SalesRepDTO, SalesRepRepository, SalesMapper> {

    private final RegionService regionService;

    protected SalesRepService(SalesRepRepository repository, SalesMapper mapper, RegionService regionService) {
        super(repository, mapper);
        this.regionService = regionService;
    }

    public SalesRepDTO create(SalesRepCreateVM vm) {
        SalesRepDTO dto = new SalesRepDTO();
        dto.setName(vm.getName());
        dto.setRegion(regionService.get(vm.getRegionId()));

        return create(dto);
    }
}
