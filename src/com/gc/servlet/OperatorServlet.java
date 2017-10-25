package com.gc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gc.model.SaveData;
import com.gc.service.SaveDataService;
import com.gc.service.UserService;

public class OperatorServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//获取当前系统日期 并以标准个格式放入 datetime中
		SimpleDateFormat datetime2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(datetime.format(new Date()));//测试获取日期（yes）
		String dateTime =datetime2.format(new Date());  //将获取的系统时间放入字符串中
		String message =request.getParameter("message");
//		System.out.println(d);  //测试string（yes）
//		System.out.println(message);  //测试上一个页面是否传递来参数（yes）
		SaveData savedata =new SaveData();
		SaveDataService saveDateservice =new SaveDataService();
		String username = request.getParameter("username");
//		System.out.println(username);//测试上一个页面是否传递来参数（yes）
		savedata.setUsername(username);
		savedata.setMessage(message);
		savedata.setDateTime(dateTime);
		System.out.println(savedata.getDateTime());//测试是否放入savedata模型中（yes）
		System.out.println(savedata.getMessage());//测试是否放入savedata模型中（yes）
		System.out.println(savedata.getUsername());//测试是否放入savedata模型中（yes）
		if (savedata.getUsername()!=null){
			saveDateservice.addMessage(savedata);
			}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("/PageServlet").forward(request, response);
	
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
