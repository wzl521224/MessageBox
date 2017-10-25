package com.gc.service;

import java.util.ArrayList;


import com.gc.model.SaveData;
import com.gc.util.SQLHelper;


public class SaveDataService {

	
public void addMessage(SaveData savedata){
//		String sql="insert into savedata (datetime,message,username) values("+savedata.getDateTime()+"," +
//				""+savedata.getMessage()+","+savedata.getUsername()+")";
	
	System.out.println(savedata.getDateTime());//测试是否放入savedata模型中（yes）
	System.out.println(savedata.getMessage());//测试是否放入savedata模型中（yes）
	System.out.println(savedata.getUsername());//测试是否放入savedata模型中（yes）
		SaveData savedata1=new SaveData();
		savedata1=savedata;
//		String sql="INSERT INTO `messageboard`.`savedate` ( `datetime`, `message`, `username`) VALUES ('2017-04-30 23:13:15', 'admin:123', 'admin');";
		String sql="INSERT INTO `messageboard`.`savedate` (`datetime`, `message`, `username`) VALUES (?, ?, ?);";
//		String sql ="INSERT INTO `messageboard`.`savedate` (`datetime`, `message`, `username`) VALUES ('2017-04-30 23:11:15', 'admin:曾经有一份真挚的爱情摆在我面前,我没有珍惜', 'admin')";
		
		String[]parameters={savedata1.getDateTime(),savedata1.getUsername()+":"+savedata1.getMessage(),savedata1.getUsername()};
		SQLHelper.executeUpdate(sql, parameters);
	}


public ArrayList<SaveData> getAllUser(){
	ArrayList<SaveData> al=new ArrayList<SaveData>();
	
	String sql="select * from savedate order by pank desc";
	String []parameters=null;
	
	al=SQLHelper.executeQuery2(sql, parameters);
	System.out.println(al.get(1).getMessage());
	System.out.println(al.get(2).getMessage());
	return al;
}




}
