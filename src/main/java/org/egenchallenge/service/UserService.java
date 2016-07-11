package org.egenchallenge.service;

import java.util.List;
import org.egenchallenge.entity.*;
import org.egenchallenge.persistence.PersistenceLayer;

import static org.egenchallenge.util.JsonUtil.*;
public class UserService {
	
	public UserService(){
	}
	
	
	//Get All users from the database 
	public List<User> getAllUsers()
	 {
		List<User> users = PersistenceLayer.findAllUser();
		
		 return users;
	 }
	 
	//Get a user by user id from the database 
		public User getUser(String id)
		 {
			if(!PersistenceLayer.userExists(id))
			{
				return null;
			}
			else
			{
				User user = PersistenceLayer.findUser(id);
				return user;
			}
			
		 } 
	
		//Create user 
		public User createUser(String json)
		 {
			User user = fromJsonToUser(json, new User());
			
			if(PersistenceLayer.userExists(user.getId()))
			{
				return null;
			}
			else
			{
				if(PersistenceLayer.insertUser(user))
				{
					return user;
				}
				else
				{
					return null;
				}
				
			} 
			 
		 }
		
		//Update user 
		public User updateUser(String json)
		 {
			User user = fromJsonToUser(json, new User());
			
			if(!PersistenceLayer.userExists(user.getId()))
			{
				return null;
			}
			else
			{
				boolean success = PersistenceLayer.updateUser(user); 
				
				if (success)
					return user;
				else
					return null;
			} 
		 }
}
