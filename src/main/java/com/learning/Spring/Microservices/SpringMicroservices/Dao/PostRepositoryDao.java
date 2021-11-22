package com.learning.Spring.Microservices.SpringMicroservices.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.Spring.Microservices.SpringMicroservices.Bean.Posts;


@Repository
public interface PostRepositoryDao extends JpaRepository<Posts, Integer> {

}
