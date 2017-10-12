package it.dstech.services;

import java.util.List;

import it.dstech.models.User;

public interface UserService {

	User saveUser(User user);

	User getUserById(int id);

	List<User> getListUser();

	User updateUser(User user);

	User deleteUserById(int id);
	
	User selectUserByUsernamePassword(String username, String password);
}
