package it.dstech.services;

import java.util.List;

import it.dstech.dao.UserDao;
import it.dstech.dao.UserDaoImpl;
import it.dstech.models.User;

public class UserServiceImpl implements UserService{

	UserDao userDao= new UserDaoImpl();
	
	@Override
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public List<User> getListUser() {
		return userDao.getListUser();
	}

	@Override
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public User deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}

	@Override
	public User selectUserByUsernamePassword(String username, String password) {
		return userDao.selectUserByUsernamePassword(username, password);
	}

}
