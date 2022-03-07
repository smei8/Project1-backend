package service;

import java.util.List;

import dao.UserDao;
import dao.UserDaoImpl;
import pojo.UserPojo;

public class UserServiceImpl implements UserService {

	UserDao userDao;
	

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public List<UserPojo> fetchAllAccounts() {
		return userDao.fetchAllAccounts();
	}

	@Override
	public UserPojo fetchAAccount(int userId) {
		return userDao.fetchAAccount(userId);
	}

	@Override
	public UserPojo updateAccount(UserPojo userpojo) {
		return userDao.updateAccount(userpojo);
	}

	@Override
	public UserPojo login(UserPojo user) {
		return userDao.login(user);
	}
}
