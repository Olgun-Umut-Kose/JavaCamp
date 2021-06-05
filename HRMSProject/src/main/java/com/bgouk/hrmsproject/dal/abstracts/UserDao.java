package com.bgouk.hrmsproject.dal.abstracts;

import com.bgouk.hrmsproject.entities.abstracts.User;

import com.bgouk.hrmsproject.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserDao<T extends User> extends JpaRepository<T,Integer>{

    //@Query("select j from User u, #{#entityName} j where u.email = :email ") buda çalışıyor
    @Query("from #{#entityName} e where exists (select u from User u where u.email=:email)")
    Optional<T> findByMail(String email);


}
