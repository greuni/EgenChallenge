package org.egenchallenge.controller;

import static spark.Spark.*;
import org.egenchallenge.service.*;

import org.egenchallenge.entity.*;
import org.egenchallenge.exception.ResponseError;

import static org.egenchallenge.util.JsonUtil.*;

public class UserController {
	
	public UserController(final UserService userService)
	{
		//Route to get all users
		get("/users/getAllUsers", (request, response) -> userService.getAllUsers(), json());
		after((req, res) -> {res.type("application/json");});
		
		//Route to get a user with id
		get("/users/:id", 
			(request, response) -> {
				String id = request.params("id");
				User user = new UserService().getUser(id);
				
				if (user != null){
					return user;
				}
				response.status(404);
				return new ResponseError("User with id " + id + " not found.");
				
			},
			json()
		);
			
		//Route to get a user with id
		post("/users/createUser", 
			(request, response) -> {
				//User u = new Gson().fromJson(request.body(), User.class);
				
				User user = new UserService().createUser(request.body());
				
				if (user != null){
					return user;
				}
				response.status(404);
				return new ResponseError("User cannot be created.");
				
			},
			json()
		);
		
		//Route to get a user with id
		put("/users/updateUser", 
			(request, response) -> {
				User user = new UserService().updateUser(request.body());
				
				if (user != null){
					return user;
				}
				response.status(400);
				return new ResponseError("User not updated.");
			},
			json()
		);
			
	}
	
	
	
}
