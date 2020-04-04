package com.thomas.pma.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thomas.pma.entities.UserAccount;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long>{

}
