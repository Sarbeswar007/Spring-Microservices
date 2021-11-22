package com.learning.Spring.Microservices.SpringMicroservices.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.Spring.Microservices.SpringMicroservices.Bean.User;


@Repository
public interface UserRepositoryDao extends JpaRepository<User, Integer> {

}
