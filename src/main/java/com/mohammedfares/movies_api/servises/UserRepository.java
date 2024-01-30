package com.mohammedfares.movies_api.servises;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohammedfares.movies_api.models.AppUser;

public interface UserRepository extends JpaRepository<AppUser,Long>{
	Optional<AppUser> findByUserName(String userName);
}
