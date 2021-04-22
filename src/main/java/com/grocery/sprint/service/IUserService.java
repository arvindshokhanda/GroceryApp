package com.grocery.sprint.service;


import com.grocery.sprint.beans.Holder;
import com.grocery.sprint.beans.User;


public interface IUserService {
	
	User addUser(Holder hold);
	
	User updateUser(User user);
	
	boolean deleteUser(String id);
	
	User findById(long id);
	
	User findByLoginId(String loginId);
	
	boolean changePassword(String loginId, String oldPassword, String newPassword);
	
	boolean forgotPassword(String loginId, String answer, String newPassword);
	
	User login(String loginId, String password);
	
}