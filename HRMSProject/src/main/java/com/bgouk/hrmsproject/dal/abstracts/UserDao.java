package com.bgouk.hrmsproject.dal.abstracts;

import com.bgouk.hrmsproject.entities.abstracts.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//@EnableJpaRepositories(basePackages = "com.bgouk.hrmsproject.dal.concretes", repositoryImplementationPostfix = "CustomImpl")
public interface UserDao<T extends User> extends JpaRepository<T,Integer>{

    Optional<T> findByEmail(String email); // bunla alakalı bişeyler denenecek

}
