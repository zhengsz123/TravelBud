package com.travel.core.repository;


import com.travel.core.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    @Query ("select u from User u where u.username = ?1 or u.email=?1")
    Optional<User> findByEmailOrUsername(String keyword);
}
