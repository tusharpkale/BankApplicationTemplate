package com.dxc.services;

import com.dxc.daos.AdminDaoImpl;
import com.dxc.daos.UserDaoImpl;

public class UserServiceImpl {
	
	UserDaoImpl userDao=new UserDaoImpl();
	
	public boolean authenticateUser(String user, String pass)
	{
		return userDao.authenticateUser(user,pass);
	}
}
