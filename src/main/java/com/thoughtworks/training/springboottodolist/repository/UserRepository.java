package com.thoughtworks.training.springboottodolist.repository;

import com.thoughtworks.training.springboottodolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByName(String name);

}
