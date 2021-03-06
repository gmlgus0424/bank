package bank.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class FrontController extends HttpServlet {
	HashMap<String,Controller> map = null;//참조형변수만 가지고 있음
@Override
public void init(ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
	map = new HashMap<String, Controller>();//실제로 hashmap 생성
	map.put("/join.do", new joinController());
	map.put("/login.do", new LoginController());
	map.put("/deposit.do", new DepositController());
	map.put("/withdrawal.do", new withdrawalController());
	map.put("/query.do", new QueryController());
	map.put("/search.do", new SearchController());
	map.put("/transfer.do", new TransferController());
	
}
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String uri =req.getRequestURI();
	String contextPath= req.getContextPath();
	String path = uri.substring(contextPath.length());
	
	Controller cont=  map.get(path);
	cont.execute(req, resp);
	
}
}
