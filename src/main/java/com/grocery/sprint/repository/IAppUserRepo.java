package com.grocery.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grocery.sprint.beans.AppUser;

@Repository
public interface IAppUserRepo extends JpaRepository<AppUser, Long>{

	@Modifying(clearAutomatically=true)
	@Query("update AppUser u set u.password= :givenPassword where u.userId= :givenUserId")
	int updatePassword(@Param("givenUserId")long userId, @Param("givenPassword")String newPassword);
	
}
