package com.facade;

import java.util.List;

import com.dao.UserDAO;
import com.model.User;

/**
 * 
 * @author Mickey
 *
 */
public class UserFacade
{
	private UserDAO userDAO = new UserDAO();

	/**
	 * 
	 * @param email
	 * @param password
	 * @return User
	 * @see <a href=
	 *      "http://uaihebert.com/full-web-application-with-tomcat-jsf-primefaces-jpa-hibernate/">
	 *      http://uaihebert.com/full-web-application-with-tomcat-jsf-primefaces
	 *      -jpa -hibernate/</a>
	 */
	public User isValidLogin(String email, String password)
	{
		userDAO.beginTransaction();
		User user = userDAO.findUserByEmail(email);

		if (user == null || !user.getPassword().equals(password))
		{
			return null;
		}
		return user;
	}

	public void createUser(User user)
	{
		userDAO.beginTransaction();
		userDAO.save(user);
		userDAO.commitAndCloseTransaction();
	}

	public List<User> listAll()
	{
		userDAO.beginTransaction();
		List<User> result = userDAO.findAll();
		userDAO.closeTransaction();
		return result;
	}

	public void deleteUser(User user)
	{
		userDAO.beginTransaction();
		User userRefference = userDAO.findReferenceOnly(user.getId());
		userDAO.delete(userRefference);
		userDAO.commitAndCloseTransaction();
	}

	public void updateUser(User user)
	{
		userDAO.beginTransaction();
		User dbUser = userDAO.find(user.getId());
		dbUser.setEmail(user.getEmail());
		dbUser.setName(user.getName());
		dbUser.setPassword(user.getPassword());
		dbUser.setRole(user.getRole());
		userDAO.update(dbUser);
		userDAO.commitAndCloseTransaction();
	}

	public User findUser(Integer userId)
	{
		userDAO.beginTransaction();
		User user = userDAO.find(userId);
		userDAO.closeTransaction();
		return user;
	}
}