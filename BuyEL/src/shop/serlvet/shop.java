package shop.serlvet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.cartDaoimpl;
import shop.entity.Cart;
import shop.service.CartService;

/**
 * Servlet implementation class shop
 */
@WebServlet("/shop")
public class shop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shop() {
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
		HttpSession session =request.getSession();
		String name=request.getParameter("gname");
		Cart ccart=new Cart();
		ccart.setGname(name);
		ccart.setUser_id((String)session.getAttribute("numb"));//获取当前用户id
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");//获取数据库的连接
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdemo","root","123456");
			//创建命令对象
			PreparedStatement stmt=conn.prepareStatement("select * from cart where user_id=? AND gname=?");
			stmt.setString(1,ccart.getUser_id());
			stmt.setString(2,ccart.getGname());
			ResultSet rs= stmt.executeQuery();//执行命令
			//List<Cart> list=new ArrayList<>();
			String b=null;
			while(rs.next()){
				b=rs.getString("gnumber");
			}
			if(b==null){
				request.setCharacterEncoding("UTF-8");
				String gname=request.getParameter("gname");
				String gnumber=request.getParameter("gnumber");
				Cart cart=new Cart();
				cart.setGname(gname);
				cart.setGnumber(gnumber);
				cart.setUser_id((String)session.getAttribute("numb"));//获取当前用户id
				CartService cartService=new CartService();
				cartDaoimpl es=new cartDaoimpl();
				cartService.setCartDao(es);
				cartService.addCart(cart);//添加数据到数据库
				request.getRequestDispatcher("cart").forward(request, response);
			}else{
				request.setCharacterEncoding("UTF-8");
				String gname=request.getParameter("gname");
				String gnumber=request.getParameter("gnumber");
				Cart newcart=new Cart();
				Cart oldcart=new Cart();
				newcart.setGname(gname);
				newcart.setGnumber(String.valueOf(Integer.parseInt(gnumber)+Integer.parseInt(b)));
				oldcart.setUser_id((String)session.getAttribute("numb"));
				newcart.setUser_id((String)session.getAttribute("numb"));//获取当前用户id
				CartService cartService=new CartService();
				cartDaoimpl es=new cartDaoimpl();
				cartService.setCartDao(es);
				cartService.updateCart(oldcart,newcart);//添加数据到数据库
				request.getRequestDispatcher("cart").forward(request, response);
	            
			}
		}catch(SQLException | ClassNotFoundException e ){
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
