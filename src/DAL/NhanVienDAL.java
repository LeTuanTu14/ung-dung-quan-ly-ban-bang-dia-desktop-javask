package DAL;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.DangNhap_dto;
import DTO.NhanVienDTO;
import Database.Connection_DB;

public class NhanVienDAL {
	private Connection con=null;
	private NhanVienDAL() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		con=Connection_DB.getDb().connect();
	}
	private static NhanVienDAL nvDAL=null;
	public static NhanVienDAL getNhanVienDAL() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		if(nvDAL==null)
		{
			nvDAL=new NhanVienDAL();
		}
		return nvDAL;
	}
	
	public List<NhanVienDTO> getALLNhanVien() throws SQLException
	{
		Statement stmt=con.createStatement();
		String sql="select * from tbNhanVien";
		ResultSet rs=stmt.executeQuery(sql);
		
		List<NhanVienDTO> listNV=new ArrayList<NhanVienDTO>();
		while(rs.next())
		{
			NhanVienDTO nv=new NhanVienDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			listNV.add(nv);
		}
	
		return listNV;
	}
	public boolean dangNhap(DangNhap_dto dtodn) throws SQLException
	{
		PreparedStatement pre=con.prepareStatement("select * from tbNhanVien where taiKhoanID=? and matKhau=?");
		pre.setString(1, dtodn.getTaiKhoan());
		pre.setString(2, dtodn.getMatKhau());
		ResultSet rs=pre.executeQuery();
		if(rs.next())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
