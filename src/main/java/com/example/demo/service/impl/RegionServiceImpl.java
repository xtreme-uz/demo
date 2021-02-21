package com.example.demo.service.impl;

import com.example.demo.entity.Region;
import com.example.demo.service.RegionService;
import com.example.demo.service.mapper.RegionMapper;
import com.example.demo.repository.RegionRepository;
import com.example.demo.service.dto.RegionDTO;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends AbsServiceImpl<Region, RegionDTO, RegionRepository, RegionMapper> implements RegionService {

    protected RegionServiceImpl(RegionRepository repository, RegionMapper mapper) {
        super(repository, mapper);
    }

}
