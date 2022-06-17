package com.example.springbootjdk18.repository;

import com.example.springbootjdk18.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
// @RepositoryRestResource(path = "customers")
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findAllByEmailContains(@Param("email") String email, Pageable pageable);
}
