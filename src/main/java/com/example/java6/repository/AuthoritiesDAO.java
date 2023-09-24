package com.example.java6.repository;

import com.example.java6.entity.Account;
import com.example.java6.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AuthoritiesDAO extends JpaRepository<Authority,Integer> {
    Authority getAuthorityByAccount_Username(String user);

    @Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
    List<Authority> authoritiesOf(List<Account> accounts);

    @Query("Select a From Authority a where a.account.username like ?1")
    List<Authority> getOneByRole(String username);

    @Transactional
    @Modifying
    @Query("Delete from Authority where Username = ?1")
    void deleteByUserName(String username);
}
