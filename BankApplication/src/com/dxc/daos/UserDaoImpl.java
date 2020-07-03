package com.dxc.daos;

public class UserDaoImpl {
	
	public boolean authenticateUser(String user, String pass)
	{
			if(user.equals(pass))
				return true;
			else 
				return false;
	}
	
	
	
	//other methods

}
