package com.grocery.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grocery.sprint.beans.User;
@Repository
public interface IUserDao extends JpaRepository<User, Long>  {

	User findByLoginId(String loginId);
	
}