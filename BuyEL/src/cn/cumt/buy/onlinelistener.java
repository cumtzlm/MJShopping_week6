package cn.cumt.buy;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class onlinelistener
 *
 */
@WebListener
public class onlinelistener implements HttpSessionListener {
private static int count=0;
    /**
     * Default constructor. 
     */
    public onlinelistener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	count++;
    	se.getSession().getServletContext().setAttribute("count", count);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	count--;
    	se.getSession().getServletContext().setAttribute("count", count);
    }

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		onlinelistener.count = count;
	}
	
}
