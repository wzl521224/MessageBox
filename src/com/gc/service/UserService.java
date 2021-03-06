package com.gc.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.gc.model.User;
import com.gc.util.SQLHelper;

public class UserService {

	
	
	public boolean checkUser(User user){
		boolean flag=false;
		
		String sql="select * from Muserlogin where username=? and password=?";
		String []parameters={user.getUsername(),user.getPassword()};
		
		try {
			ResultSet rs=SQLHelper.executeQuery(sql, parameters);
			if(rs.next()){
				 flag=true;
			}else{
				flag=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SQLHelper.close(SQLHelper.getRs(), SQLHelper.getPs(), SQLHelper.getCt());
		}
		
		return flag;
	}
	
	
	public void addUser(User user){
		String sql ="INSERT INTO `messageboard`.`muserlogin` (`username`, `password`) VALUES (?, ?);";
		String[] parameters={user.getUsername(),user.getPassword()};
		
		SQLHelper.executeUpdate(sql, parameters);
		
	}
}
