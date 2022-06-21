package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.TheLoaiDTO_cbo;
import Database.Connection_DB;

public class TheLoaiDAL_cbo {
			private Connection con=null;
			private TheLoaiDAL_cbo() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
			{
				con=Connection_DB.getDb().connect();
			}
			private static TheLoaiDAL_cbo getTheLoaiDAL=null;
			public static TheLoaiDAL_cbo getGetTheLoaiDAL() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
				if(getTheLoaiDAL==null)
				{
					getTheLoaiDAL=new TheLoaiDAL_cbo();
				}
				return getTheLoaiDAL;
			}
			public List<TheLoaiDTO_cbo> getAllTheLoai() throws Exception
			{
				String sql="select * from tbTheLoai";
				Statement state=con.createStatement();
				ResultSet rs=state.executeQuery(sql);
				 List<TheLoaiDTO_cbo> listTheLoai=new ArrayList<TheLoaiDTO_cbo>();
				 while(rs.next())
				 {
					 listTheLoai.add(new TheLoaiDTO_cbo(rs.getString(1), rs.getString(2)));
					 
				 }
				 
				 return listTheLoai;
			}
			
}
