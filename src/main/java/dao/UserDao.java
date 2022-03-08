package dao;

import java.util.List;

import pojo.UserPojo;

public interface UserDao {
	
	List<UserPojo> fetchAllAccounts();
	
	UserPojo fetchAAccount(int userId);
	
	UserPojo updateAccount(UserPojo userpojo);
	
	UserPojo login(UserPojo user);
	
	
}
