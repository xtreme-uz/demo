package com.example.demo.repository;

import com.example.demo.entity.MyUser;
import com.example.demo.repository.criteria.SearchCriteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@Transactional
class MyUserDAOTest {

    @Autowired
    private MyUserDAO myUserDAO;

    private MyUser user1;

    private MyUser user2;

    @BeforeEach
    public void init() {
        user1 = new MyUser();
        user1.setUsername("John");
        user1.setPassword("123456");
        myUserDAO.save(user1);

        user2 = new MyUser();
        user2.setUsername("Alex");
        user2.setPassword("654321");
        myUserDAO.save(user2);
    }

    @Test
    void givenUsernameWhenEqualsThenTrue() {
        List<SearchCriteria> params = new ArrayList<>();
        params.add(new SearchCriteria("username", ":", "John"));

        List<MyUser> result = myUserDAO.searchUser(params);
        assertThat(user1, is(in(result)));
        assertThat(user2, not(is(in(result))));
    }

}