package com.example.demospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demospring.model.User;

import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

  @Query(value = "SELECT * FROM users", nativeQuery = true)
  List<User> findAllUsers();

  @Query(value = "SELECT * FROM users WHERE id = :id", nativeQuery = true)
  User findUserByID(String id);


  @Modifying
  @Transactional
  @Query(value = "INSERT INTO users (id, username, email) VALUES (:id, :username, :email)", nativeQuery = true)
  int insertUser(String id, String username, String email);


  @Modifying
  @Transactional
  @Query(value = "DELETE FROM users WHERE users.id = :id", nativeQuery = true)
  int deleteUserByID(@Param("id") String id);
}
