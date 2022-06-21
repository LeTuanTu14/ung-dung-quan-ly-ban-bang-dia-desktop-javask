package DAL;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.KhachHang_dto;
import DTO.LapHoaDon_dto;
import DTO.NhanVienDTO;
import Database.Connection_DB;

public class HoaDonDAL {

	private Connection con=null;
	private static HoaDonDAL hoaDondal=null;
	private HoaDonDAL() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		con=Connection_DB.getDb().connect();
	}
	public static HoaDonDAL getHoaDonDAL() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		if(hoaDondal==null)
		{
			hoaDondal=new HoaDonDAL();
		}
		return hoaDondal;
	}
	public String getMaHD() throws SQLException
	{
		CallableStatement stmt=con.prepareCall("{call usp_tbHoaDon}");  
		ResultSet rs=stmt.executeQuery();
		String maHD="";
		if(rs.next())
		{
			maHD=rs.getString(1);
		}
		
		return maHD;
	}
	public boolean themHD(LapHoaDon_dto hd) throws SQLException
	{
		String sql="insert into tbHoaDon values(?,?,?,?,?)";
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1, hd.getMaHD());
		pre.setString(2, hd.getTenHD());
		pre.setDate(3, hd.getNgayLapHD());
		pre.setString(4, hd.getNv().getTaiKhoan());
		pre.setString(5, hd.getKh().getMaKH());
		int rs=pre.executeUpdate();
		if(rs>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean deleteHD(String mahd) throws SQLException
	{
		String sql="delete from tbHoaDon where maHD=? ";
		PreparedStatement stt=con.prepareStatement(sql);
		stt.setString(1, mahd);
		int rs=stt.executeUpdate();
		if(rs>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public List<LapHoaDon_dto>  getAllHD() throws SQLException
	{
		String sql="select * from tbHoaDon";
		Statement stt=con.createStatement();
		ResultSet rs=stt.executeQuery(sql);
		List<LapHoaDon_dto> dshd=new ArrayList<LapHoaDon_dto>();
		while(rs.next())
		{
			NhanVienDTO nv=new NhanVienDTO(rs.getString(4));
			KhachHang_dto kh=new KhachHang_dto(rs.getString(5));
			LapHoaDon_dto lhd=new LapHoaDon_dto(rs.getString(1), rs.getString(2), rs.getDate(3), nv, kh);
			dshd.add(lhd);
		}
		return dshd;
	}
	
}
