package com.example.demo.repository;

import com.example.demo.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

//    Optional<Accounts> findByUsername(String username);
//
//    @Query(value = "select u.id as id, u.username as username from users u where username like :username", nativeQuery = true)
//    Optional<AccountsProject> getByUsername(String username);

}
