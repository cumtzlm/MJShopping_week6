package shop.serlvet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTransientException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

import shop.entity.User;
import shop.service.GoodService;

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
		
		request.getSession().setAttribute("numb",0);
        User _user=new User();
        _user.setUser_name(request.getParameter("loginId"));
		request.setCharacterEncoding("UTf-8");
		String zhanghu=request.getParameter("loginId");
		String mima=request.getParameter("pwd");
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");//获取数据库的连接
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdemo","root","123456");
			//创建命令对象
			Statement stmt=(Statement) conn.createStatement();//执行命令
			ResultSet rs= stmt.executeQuery("select * from user where user_name='"+zhanghu+"' and user_pwd='"+mima+"'");
			//读取结果
			if(rs.next()){
				request.getSession().setAttribute("numb",rs.getString("user_id"));
				HttpSession session =request.getSession();
		        GoodService se=new GoodService();
		        se.setGoodDao();
		        session.setAttribute("shop", se.getAll());//读取数据库李的商品
				request.setAttribute("user_name", rs.getString(1));
				request.getRequestDispatcher("/shop.jsp").forward(request, response);
		}else{
			request.setAttribute("errorMessage", "用户名或密码错误，请重新输入！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
			}
		catch(ClassNotFoundException | SQLTransientException e){
			System.out.println("请配置驱动程序");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
