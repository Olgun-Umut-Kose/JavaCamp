package com.bgouk.hrmsproject.dal.abstracts;

import com.bgouk.hrmsproject.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
public interface UserDao<T extends User> extends JpaRepository<T,Integer> {
    Optional<T> findByEmail(String email);

}
