package it.dstech.dao;

import java.util.List;

import org.hibernate.Query;

import it.dstech.models.User;

public class UserDaoImpl extends HibernateDao implements UserDao{

	@Override
	public User saveUser(User user) {
		return (User) persist(user);
	}

	@Override
	public User getUserById(int id) {
		return (User) getById(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getListUser() {
		return select("SELECT u FROM User u").list();
	}

	@Override
	public User updateUser(User user) {
		return (User) update(user);
	}

	@Override
	public User deleteUserById(int id) {
		return (User) delete(getUserById(id));
	}

	@Override
	public User selectUserByUsernamePassword(String username, String password) {
		Query query= select("SELECT u FROM User u WHERE u.username=:username AND u.password=:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		return (User) query.uniqueResult();
	}

}
