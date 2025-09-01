package com.pracitce.basics.demo.repository;

import com.pracitce.basics.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

     User findByEmail(String email);
}
