package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// GoF의 디자인 패턴 중 
		// ㄴ 생성 패턴인 Singleton Pattern
		// ㄴ 생성 패턴인 Factory Method Pattern 
		// ㄴ 행위 패턴인 Command Pattern 
		
		String command = request.getParameter("command");	// input type hidden 
	
		ActionFactory af = ActionFactory.getIntance();
		Action action = af.getAction(command);
		
		if(action != null) {
			action.execute(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
