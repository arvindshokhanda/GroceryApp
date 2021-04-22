package com.grocery.sprint.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.sprint.beans.AppUser;
import com.grocery.sprint.beans.Holder;
import com.grocery.sprint.beans.User;
import com.grocery.sprint.repository.IAppUserRepo;
import com.grocery.sprint.repository.IUserDao;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IAppUserRepo appUserRepo;
	
	
	
	@Override
	public User addUser(Holder hold) {

		User user=new User();
		user.setFirstName(hold.getFirstName());
		user.setLastName(hold.getLastName());
		user.setEmail(hold.getEmail());
		user.setLoginId(hold.getLoginId());
		String temp = user.getLoginId();
		user.setMobileNo(hold.getMobileNo());
		user.setQuestion(hold.getQuestion());
		user.setAnswer(hold.getAnswer());
		userDao.save(user);
		
		user = userDao.findByLoginId(temp);
		AppUser appUser=new AppUser();
		appUser.setUserId(user.getUserId());
		appUser.setPassword(hold.getPassword());
		appUser.setUserType("Customer");
		appUserRepo.save(appUser);

		return user;
	}

	
	@Override
	public User updateUser(User user) {

		if(userDao.findById(user.getUserId())!=null)
		{
			User oldUser=userDao.findById(user.getUserId()).get();
			oldUser.setFirstName(user.getFirstName());
			oldUser.setLastName(user.getLastName());
			oldUser.setLoginId(user.getLoginId());
			oldUser.setEmail(user.getEmail());
			oldUser.setMobileNo(user.getMobileNo());
			oldUser.setQuestion(user.getQuestion());
			oldUser.setAnswer(user.getAnswer());
			
			return oldUser;
		}
		
		return null;
	}

	@Override
	public boolean deleteUser(String id) {

		if(userDao.findByLoginId(id)!=null)
		{
			User user=userDao.findByLoginId(id);
			appUserRepo.delete(appUserRepo.findById(user.getUserId()).get());
			userDao.delete(user);
			return true;
		}
		
		return false;
	}
	
	@Override
	public User login(String loginId, String password) {
		
		if(userDao.findByLoginId(loginId)!=null)
		{
			User user=userDao.findByLoginId(loginId);
			AppUser appUser=appUserRepo.findById(user.getUserId()).get();
			
			if(appUser.getPassword().equals(password))
				return user;
			else
				return null;
		}
		
		return null;
	}

	@Override
	public User findById(long id) {

		return userDao.findById(id).get();
	}

	@Override
	public User findByLoginId(String loginId) {

		return userDao.findByLoginId(loginId);
	}

	@Override
	public boolean changePassword(String loginId, String oldPassword, String newPassword) {
		
		if(userDao.findByLoginId(loginId)!=null)
		{
			User user=userDao.findByLoginId(loginId);
			AppUser appUser=appUserRepo.findById(user.getUserId()).get();
			
			if(appUser.getPassword().equals(oldPassword))
			{
				int update=appUserRepo.updatePassword(appUser.getUserId(), newPassword);
				
				if(update>0)
					return true;
				else
					return false;
			}
			else
				return false;		
		}
		return false;
	}

	@Override
	public boolean forgotPassword(String loginId, String answer, String newPassword) {
		
		if(userDao.findByLoginId(loginId)!=null)
		{
			User user=userDao.findByLoginId(loginId);
			AppUser appUser=appUserRepo.findById(user.getUserId()).get();
			
			if(user.getAnswer().equals(answer))
			{
				int update=appUserRepo.updatePassword(appUser.getUserId(), newPassword);
				
				if(update>0)
					return true;
				else
					return false;
			}
			return false;
		}
		return false;
	}

}