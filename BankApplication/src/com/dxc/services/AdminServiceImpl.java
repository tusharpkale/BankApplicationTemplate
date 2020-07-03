package com.dxc.services;

import com.dxc.daos.AdminDaoImpl;

public class AdminServiceImpl {
	
	AdminDaoImpl adminDao=new AdminDaoImpl();
	
	public boolean authenticateAdmin(String user, String pass)
	{
		return adminDao.authenticateAdmin(user,pass);
	}
	

}
