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
		
		//��ȡ��ǰϵͳ���� ���Ա�׼����ʽ���� datetime��
		SimpleDateFormat datetime2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(datetime.format(new Date()));//���Ի�ȡ���ڣ�yes��
		String dateTime =datetime2.format(new Date());  //����ȡ��ϵͳʱ������ַ�����
		String message =request.getParameter("message");
//		System.out.println(d);  //����string��yes��
//		System.out.println(message);  //������һ��ҳ���Ƿ񴫵���������yes��
		SaveData savedata =new SaveData();
		SaveDataService saveDateservice =new SaveDataService();
		String username = request.getParameter("username");
//		System.out.println(username);//������һ��ҳ���Ƿ񴫵���������yes��
		savedata.setUsername(username);
		savedata.setMessage(message);
		savedata.setDateTime(dateTime);
		System.out.println(savedata.getDateTime());//�����Ƿ����savedataģ���У�yes��
		System.out.println(savedata.getMessage());//�����Ƿ����savedataģ���У�yes��
		System.out.println(savedata.getUsername());//�����Ƿ����savedataģ���У�yes��
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
