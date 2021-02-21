package com.example.demo.service.impl;

import com.example.demo.entity.MyUser;
import com.example.demo.service.MyUserService;
import com.example.demo.service.exception.ObjectNotFoundException;
import com.example.demo.service.mapper.MyUserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.dto.MyUserDTO;
import com.example.demo.service.dto.MyUserProject;
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
public class MyUserServiceImpl extends AbsServiceImpl<MyUser, MyUserDTO, UserRepository, MyUserMapper> implements MyUserService {

    protected MyUserServiceImpl(UserRepository repository, MyUserMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public MyUserProject getByUsername(String username) {
        Optional<MyUserProject> found = repository.getByUsername(username);
        return found.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    @Override
    public MyUserDTO imgUpload(Long id, MultipartFile file) {
        Optional<MyUser> byId = repository.findById(id);
        if (byId.isPresent()) {
            MyUser user = byId.get();
            user.setImg(saveFile(file));
            MyUser save = repository.save(user);
            return mapper.toDto(save);
        } else {
            throw new ObjectNotFoundException("User not found");
        }

    }

    @Override
    public Resource load(String filePath) {
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
        Path filePath = Path.of("profile","img", newFileName);
        if (!Files.exists(filePath)) {
            try {
                // profile yoki img paplar yaratilmagan bo'lsa yaratyapti
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
