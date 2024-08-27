package com.sparta.springindividual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparta.springindividual.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {



}
