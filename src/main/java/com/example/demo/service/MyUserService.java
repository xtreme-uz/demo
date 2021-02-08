package com.example.demo.service;

import com.example.demo.entity.MyUser;
import com.example.demo.service.exception.ObjectNotFoundException;
import com.example.demo.service.mapper.MyUserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.dto.MyUserDTO;
import com.example.demo.service.dto.MyUserProject;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserService extends AbsService<MyUser, MyUserDTO, UserRepository, MyUserMapper> {

    protected MyUserService(UserRepository repository, MyUserMapper mapper) {
        super(repository, mapper);
    }

    public MyUserProject getByUsername(String username) {
        Optional<MyUserProject> found = repository.getByUsername(username);
        return found.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

}
