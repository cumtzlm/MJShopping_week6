package shop.serlvet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.entity.Cart;

/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart() {
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
		HttpSession session =request.getSession();
		Cart cart=new Cart();
		cart.setUser_id((String)session.getAttribute("numb"));//获取当前用户id
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");//获取数据库的连接
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdemo","root","123456");
			//创建命令对象
			Statement stmt=(Statement) conn.createStatement();//执行命令
			ResultSet rs= stmt.executeQuery("select * from cart where user_id="+cart.getUser_id());
			List<Cart> list=new ArrayList<>();
	       while (rs.next()) {
	        	Cart cartt = new Cart();
	        	cartt.setUser_id(rs.getString("user_id"));
	        	cartt.setGname(rs.getString("gname"));
	        	cartt.setGnumber(rs.getString("gnumber"));
	        	list.add(cartt);
	        }
	        request.getSession().setAttribute("maplist", list);
	        response.sendRedirect("buy.jsp");
		}catch(SQLException | ClassNotFoundException e ){
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
