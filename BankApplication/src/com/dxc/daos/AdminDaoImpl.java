package com.dxc.daos;

public class AdminDaoImpl {
	
	
	public boolean authenticateAdmin(String user, String pass)
	{
		if(user.equals(pass))
			return true;
		else 
			return false;
	}
	
	
	//other methods

}
