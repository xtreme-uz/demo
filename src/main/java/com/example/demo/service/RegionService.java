package com.example.demo.service;

import com.example.demo.entity.Region;
import com.example.demo.mapper.RegionMapper;
import com.example.demo.repository.RegionRepository;
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
public class RegionService extends AbsService<Region, RegionDTO, RegionRepository, RegionMapper> {

    protected RegionService(RegionRepository repository, RegionMapper mapper) {
        super(repository, mapper);
    }

    public RegionDTO imgUpload(Long id, MultipartFile file){
        Optional<Region> byId = repository.findById(id);
        if(byId.isPresent()){
            //
            Region region = byId.get();
            region.setImage(saveFile(file));
            Region save = repository.save(region);
            return mapper.toDto(save);
        }
        throw new RuntimeException("User not found");
    }

    public Resource load(String filePath){
        try {
            Path path = Paths.get(filePath.replace("|", "/")).normalize();
            return new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("exception while loading file");
    }

    private String saveFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String newFileName = System.currentTimeMillis() + fileName;
        Path filePath = Path.of("profile", "img", newFileName);
        if(!Files.exists(filePath)){
            try {
                Files.createDirectories(filePath);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                return filePath.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("exception while uploading file");
    }
}