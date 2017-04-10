package shop.serlvet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dao.userDaoimpl;
import shop.entity.User;
import shop.service.UserService;

/**
 * Servlet implementation class enroll
 */
@WebServlet("/enroll")
public class enroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enroll() {
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
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String id=request.getParameter("id");
		User user = new User();
		user.setUser_name(username);
		user.setUser_pwd(pwd);
		user.setUser_id(id);
		UserService usersService=new UserService();
		userDaoimpl es = new userDaoimpl();
		usersService.setUserDao(es);
		usersService.addUser(user);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		doGet(request, response);
	}

}
