package service;

import java.util.List;

import pojo.UserPojo;

public interface UserService {
	
	List<UserPojo> fetchAllAccounts();
	
	UserPojo fetchAAccount(int userId);
	
	UserPojo updateAccount(UserPojo userpojo);
	
	UserPojo login(UserPojo user);
}
