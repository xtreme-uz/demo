package com.example.demo.service;

import com.example.demo.entity.MyUser;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.dto.MyUserDTO;
import com.example.demo.service.dto.MyUserProject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class MyUserService extends AbsService<MyUser, MyUserDTO, UserRepository> {

    private final Map<String, Object> myBean;

    protected MyUserService(UserRepository repository, @Qualifier("myBean") Map<String, Object> myBean) {
        super(repository);
        this.myBean = myBean;
    }

    public MyUserProject getByUsername(String username) {
        Optional<MyUserProject> found = repository.getByUsername(username);
        return found.orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    MyUserDTO toDto(MyUser entity) {
        MyUserDTO dto = new MyUserDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    @Override
    MyUser fromDto(MyUserDTO dto) {
        MyUser user = new MyUser();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }

}
