package com.example.demo.repository;

import com.example.demo.entity.MyUser;
import com.example.demo.service.dto.MyUserProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long> {

    Optional<MyUser> findByUsername(String username);

    @Query(value = "select u.id as id, u.username as username from users u where username like :username", nativeQuery = true)
    Optional<MyUserProject> getByUsername(String username);

}
