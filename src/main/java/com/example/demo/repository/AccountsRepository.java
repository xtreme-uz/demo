package com.example.demo.repository;

import com.example.demo.entity.Accounts;
import com.example.demo.projections.AccountsNameColumnProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    @Query(value = "SELECT a.id, a.name, a.p_contact AS pcontact FROM accounts a ORDER BY a.id", nativeQuery = true)
    List<AccountsNameColumnProject> getIdAndName();

}