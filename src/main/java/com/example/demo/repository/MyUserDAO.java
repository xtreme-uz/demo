package com.example.demo.repository;

import com.example.demo.entity.MyUser;
import com.example.demo.repository.criteria.SearchCriteria;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MyUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<MyUser> searchUser(List<SearchCriteria> params) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MyUser> query = builder.createQuery(MyUser.class);
        Root<MyUser> root = query.from(MyUser.class);

        Predicate predicate = builder.conjunction();
        UserSearchQueryCriteriaConsumer searchConsumer = new UserSearchQueryCriteriaConsumer(predicate, builder, root);
        params.forEach(searchConsumer);
        predicate = searchConsumer.getPredicate();
        query.where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    public void save(MyUser user) {
        entityManager.persist(user);
    }

}