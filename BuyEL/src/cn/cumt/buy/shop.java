package cn.cumt.buy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session=request.getSession();
		//取出session范围内itemMap属性
		Map<String,Integer> itemMap=(Map<String,Integer>)session.getAttribute("itemMap");
		//如果Map对象伟空则自动初始化Map对象
		if(itemMap==null){
			itemMap=new HashMap<String,Integer>();
			itemMap.put("书籍",0);
			itemMap.put("电脑",0);
			itemMap.put("汽车",0);
		}
		//获取上一个页面的请求参数
		String[] buys =request.getParameterValues("item");
		//遍历数组的各元素
		for (String item:buys){
				//如果item为book则表示选择购买书籍
			if(item.equals("book")){
				int num1 =itemMap.get("书籍").intValue();
				//将书籍key对应的数量加1
				itemMap.put("书籍",num1+1);
		}
				//如果item伟computer则表示选择购买电脑
			else if(item.equals("computer")){
				int num2=itemMap.get("电脑").intValue();
				//将电脑key对应的数量加1
				itemMap.put("电脑",num2+1);
			}
				//如果item伟car则表示选择购买汽车
			else if(item.equals("car")){
				int num3=itemMap.get("汽车").intValue();
				//将汽车key对应的数量加1
				itemMap.put("汽车",num3+1);
			}	
		}
		//将itemMap对象放到设置成session范围的itenmMap属性
		session.setAttribute("itemMap",itemMap);
		request.getRequestDispatcher("buy.jsp").forward(request, response);
		doGet(request, response);
	}

}
