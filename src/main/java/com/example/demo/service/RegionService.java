package com.example.demo.service;

import com.example.demo.entity.Region;
import com.example.demo.service.mapper.RegionMapper;
import com.example.demo.repository.RegionRepository;
import com.example.demo.service.dto.RegionDTO;
import org.springframework.stereotype.Service;

@Service
public class RegionService extends AbsService<Region, RegionDTO, RegionRepository, RegionMapper> {

    protected RegionService(RegionRepository repository, RegionMapper mapper) {
        super(repository, mapper);
    }

}
