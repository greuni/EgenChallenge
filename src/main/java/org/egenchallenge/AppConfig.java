package org.egenchallenge;

import org.egenchallenge.controller.UserController;
import org.egenchallenge.service.UserService;

public class AppConfig {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UserController(new UserService());
	}
}
