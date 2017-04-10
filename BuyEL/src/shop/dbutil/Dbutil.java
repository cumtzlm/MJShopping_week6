package shop.dbutil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jdk.nashorn.internal.runtime.Context;
public class Dbutil {
	private static DataSource datasource=null;
	static {
	try	{
		javax.naming.Context initContext = new InitialContext();
		datasource = (DataSource)initContext.lookup("java:/comp/env/jdbc/shopdemo");
	}catch(Exception e){
		e.printStackTrace();
	}	
	}
	public static Connection getConnection(){
		Connection connection=null;
		try{
			connection=datasource.getConnection();
			}catch(SQLException e){
				e.printStackTrace();
			}
		return connection;
	}
	public static boolean executeUpdate(String sql,Object[]args){
		Connection conn=null;
		PreparedStatement pst=null;
		int rowsCount=0;
		try{
			conn=datasource.getConnection();
			pst=conn.prepareStatement(sql);
			if(args!=null&args.length>0){
				for(int i=0;i<args.length;i++){
					pst.setObject(i+1, args[i]);
				}
		}
		rowsCount=pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			}
		return rowsCount>0;
		}
	public static ResultSet executeQuery(String sql,Object[] args){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			conn=datasource.getConnection();
			pst=conn.prepareStatement(sql);
			if(args!=null&args.length>0){
				for(int i=0;i<args.length;i++){
					pst.setObject(i+1, args[i]);
				}
			}
			rs=pst.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
}


