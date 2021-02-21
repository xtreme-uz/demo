package com.example.demo.service;

import com.example.demo.entity.MyUser;
import com.example.demo.service.dto.MyUserDTO;
import com.example.demo.service.dto.MyUserProject;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface MyUserService extends AbsService<MyUser, MyUserDTO> {
    MyUserProject getByUsername(String username);

    MyUserDTO imgUpload(Long id, MultipartFile file);

    Resource load(String filePath);
}
