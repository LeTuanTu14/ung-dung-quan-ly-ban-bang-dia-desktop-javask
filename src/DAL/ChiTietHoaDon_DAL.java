package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.ChiTietBangDia_HoaDonDTO;
import DTO.ChiTietHoaDon_dto;
import DTO.LapHoaDon_dto;
import Database.Connection_DB;

public class ChiTietHoaDon_DAL {
	private Connection con=null;
	private static ChiTietHoaDon_DAL ctHD_DAL=null;
	private ChiTietHoaDon_DAL() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		con=Connection_DB.getDb().connect();
	}
	public static ChiTietHoaDon_DAL getCTHD_DAL() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		if(ctHD_DAL==null)
		{
			ctHD_DAL=new ChiTietHoaDon_DAL();
		}
		return ctHD_DAL;
	}
	
	public boolean themCTHD(ChiTietHoaDon_dto cthd) throws SQLException
	{
		String sql="insert into tbCT_HoaDon values(?,?,?,?)";
		PreparedStatement state=con.prepareStatement(sql);
		state.setString(1, cthd.getHoadon().getMaHD());
		state.setString(2, cthd.getBangdia().getMaBD());
		state.setInt(3, cthd.getSoLuong());
		state.setDate(4, cthd.getNgayTra());
		int exec=state.executeUpdate();
		if(exec>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public List<ChiTietHoaDon_dto> getCTHDByHD(String maHD) throws Exception
	{
		String sql="select * from tbCT_HoaDon where maHD=?";
		PreparedStatement stt=con.prepareStatement(sql);
		stt.setString(1, maHD);
		ResultSet rs=stt.executeQuery();
		List<ChiTietHoaDon_dto> dscthd=new ArrayList<ChiTietHoaDon_dto>();
		while(rs.next())
		{
			ChiTietHoaDon_dto cthd=new ChiTietHoaDon_dto(new LapHoaDon_dto(rs.getString(1)), new ChiTietBangDia_HoaDonDTO(rs.getString(2)), rs.getInt(3), rs.getDate(4));
			dscthd.add(cthd);
		}
		return dscthd;
	}
	public boolean updateCTHD(String maHD, String maBD, int soLuong) throws SQLException
	{
		String sql="update tbCT_HoaDon set soLuong=? where maHD=? and maBD=?";
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setInt(1, soLuong);
		pre.setString(2, maHD);
		pre.setString(3, maBD);
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
	
}
