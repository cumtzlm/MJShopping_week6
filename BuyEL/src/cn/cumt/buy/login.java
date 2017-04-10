package cn.cumt.buy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		Cookie c = new Cookie("loginId",name);
		c.setMaxAge(24*3600);
		response.addCookie(c);
		
		if(request.getParameter("loginId").toString().equals("zhangliming")&&request.getParameter("pwd").toString().equals("80231212")){
			System.out.println("登录成功");
			request.getRequestDispatcher("shop.jsp").forward(request, response);
		}else{
			System.out.println("登录失败,请重新输入您的账户与密码");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		doGet(request, response);
	}

}
