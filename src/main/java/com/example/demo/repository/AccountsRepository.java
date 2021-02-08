package com.example.demo.repository;

import com.example.demo.entity.Accounts;
import com.example.demo.service.dto.AccountsProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

//    Optional<Accounts> findByUsername(String accounts);

//    @Query(value = "select a.id as id, a.name as name from accounts a where name like :name",
//            nativeQuery = true)
//    Optional<AccountsProject> getByUsername(String name);

}
