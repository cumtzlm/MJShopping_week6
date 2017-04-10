package shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.dbutil.Dbutil;
import shop.entity.Good;

public class GoodDaoimpl implements GoodDao {

	@Override
	public List<Good> getAll() {
		List<Good> newsList=new ArrayList();
		try{
			ResultSet rs=Dbutil.executeQuery("select * from good", new Object[]{});
			while(rs.next()){
				Good good=new Good();
				good.setGname(rs.getString("gname"));
				good.setSuk(rs.getInt("suk"));
				newsList.add(good);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return newsList;
		
	}

}
