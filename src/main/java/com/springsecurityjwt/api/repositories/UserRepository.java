package com.springsecurityjwt.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.springsecurityjwt.api.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
	UserDetails findByLogin(String login);
}
