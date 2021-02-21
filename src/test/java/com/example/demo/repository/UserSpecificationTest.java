package com.example.demo.repository;

import com.example.demo.entity.MyUser;
import com.example.demo.repository.criteria.SearchCriteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@Transactional
class UserSpecificationTest {

    @Autowired
    private UserRepository repository;

    private MyUser user1;

    private MyUser user2;

    @BeforeEach
    void init() {
        user1 = new MyUser();
        user1.setUsername("John");
        user1.setPassword("123456");
        repository.save(user1);

        user2 = new MyUser();
        user2.setUsername("Alex");
        user2.setPassword("654321");
        repository.save(user2);
    }

    @Test
    void givenUsernameWhenListOfUserThenCorrect() {
        UserSpecification spec = new UserSpecification(new SearchCriteria("username", ":", "Alex"));

        List<MyUser> all = repository.findAll(spec);

        assertThat(user1, not(is(in(all))));
        assertThat(user2, is(in(all)));
    }

    @Test
    void givenUsernameAndPasswordWhenListOfUserThenCorrect() {
        UserSpecification spec1 = new UserSpecification(new SearchCriteria("username", ":", "John"));
        UserSpecification spec2 = new UserSpecification(new SearchCriteria("password", ":", "123456"));

        List<MyUser> all = repository.findAll(Specification.where(spec1).and(spec2));

        assertThat(user1, is(in(all)));
        assertThat(user2, not(is(in(all))));
    }

    @Test
    void givenWrongUsernameWhenListOfUserThenCorrect() {
        UserSpecification spec = new UserSpecification(new SearchCriteria("username", ":", "Abduvali"));

        List<MyUser> all = repository.findAll(spec);

        assertThat(user1, not(is(in(all))));
        assertThat(user2, not(is(in(all))));
    }

}