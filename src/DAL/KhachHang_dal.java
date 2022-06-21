package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.KhachHang_dto;
import Database.Connection_DB;

public class KhachHang_dal {
	private Connection con=null;
	private static KhachHang_dal khdal=null;
	private KhachHang_dal() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		con=Connection_DB.getDb().connect();
	}
	public static KhachHang_dal getKhdal() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if(khdal==null)
		{
			khdal=new KhachHang_dal();
		}
		return khdal;
	}
	public List<KhachHang_dto> getAllKH() throws SQLException
	{
		Statement stt=con.createStatement();
		String sql="select * from tbKhachHang";
		ResultSet rs=stt.executeQuery(sql);
		List<KhachHang_dto> listKh=new ArrayList<KhachHang_dto>();
		while(rs.next())
		{
			KhachHang_dto khdto=new KhachHang_dto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
			listKh.add(khdto);
		}
		return listKh;
	}
	public List<KhachHang_dto> getKHbySDT(String sodienthoai) throws SQLException
	{
		List<KhachHang_dto> dskh=new ArrayList<KhachHang_dto>();
		String sql="select * from tbKhachHang where soDT=? or soDT like ?";
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1, sodienthoai);
		pre.setString(2, "%"+sodienthoai);
		ResultSet rs=pre.executeQuery();
		while(rs.next())
		{
			KhachHang_dto khdto=new KhachHang_dto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
			dskh.add(khdto);
		}
		return dskh;
	}
	
}
