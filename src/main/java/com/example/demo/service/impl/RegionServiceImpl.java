package com.example.demo.service.impl;

import com.example.demo.entity.Region;
import com.example.demo.mapper.RegionMapper;
import com.example.demo.repository.RegionRepository;
import com.example.demo.service.RegionService;
import com.example.demo.service.dto.RegionDTO;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class RegionServiceImpl extends AbsServiceImpl<Region, RegionDTO, RegionRepository, RegionMapper>
        implements RegionService {

    protected RegionServiceImpl(RegionRepository repository, RegionMapper mapper) {
        super(repository, mapper);
    }


}