package bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.service.Service;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
	Service s=Service.getInstance();
	boolean result = s.login(id,pwd);
	
	
	if(result)
	{
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		HttpUtil.forward(request, response, "/menu.jsp");
	}
	else
	{
		HttpUtil.forward(request, response, "/index.jsp");
	}

}
}
