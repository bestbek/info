package com.dao;

import java.util.HashMap;
import java.util.Map;

import com.model.User;
/**
 * 
 * @author Mickey
 *
 */
public class UserDAO extends GenericDAO<User>
{

	private static final long serialVersionUID = 1L; // required by Serializable

	public UserDAO()
	{
		super(User.class);
	}

	/**
	 * search user by email address
	 * @param email 
	 * 			assumes email is not null
	 * @return return first matching user by email
	 */
	public User findUserByEmail(String email)
	{
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		return super.findOneResult(User.FIND_BY_EMAIL, parameters); // User.FIND_BY_EMAIL
																	// is named
																	// query
	}

	public void delete(User user)
	{
		super.delete(user.getId(), User.class);
	}

}
