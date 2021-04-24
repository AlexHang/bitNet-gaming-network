package com.bitnet.bitnetgamingnetwork.repositories;


import com.bitnet.bitnetgamingnetwork.model.User;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Repository
public interface userRepository extends CrudRepository<User, Integer> {

    User findUserByEmailAndPassword(String email, String password);
    List<User> findAll();
    User findUserById(Integer id);
    User findUserByEmail(String email);

    <S extends User> S save(S entity);

    void deleteUserByEmail(String email);


}
