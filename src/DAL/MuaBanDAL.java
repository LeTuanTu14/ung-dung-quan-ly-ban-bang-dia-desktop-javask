package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.ChiTietBangDia_HoaDonDTO;
import Database.Connection_DB;

public class MuaBanDAL {
		private Connection con=null;
		private static MuaBanDAL muaban=null;
		private MuaBanDAL() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
		{
			con=Connection_DB.getDb().connect();
		}
		public static MuaBanDAL getMuaBanDAL() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
		{
			if(muaban==null)
			{
				muaban=new MuaBanDAL();
			}
			return muaban;
		}
		public List<ChiTietBangDia_HoaDonDTO> getListMuaBan(String maAlbum, String maNSX, String maTheLoai) throws SQLException
		{
			List<ChiTietBangDia_HoaDonDTO> listCT=new ArrayList<ChiTietBangDia_HoaDonDTO>();
			if(maAlbum.trim().length()>0 && maNSX.trim().length()>0 && maTheLoai.trim().length()>0)
			{
				listCT.clear();
				String sql="select bd.maBD,tenBD,donGia from tbBangDia bd"
						+ "where bd.maALbum=? and bd.maNSX=? and bd.maTL=?";
					PreparedStatement state=con.prepareStatement(sql);
					state.setString(1, maAlbum);
					state.setString(2, maNSX);
					state.setString(3, maTheLoai);
					ResultSet rs=state.executeQuery();
					
					while(rs.next())
					{
						listCT.add(new ChiTietBangDia_HoaDonDTO(rs.getString(1), rs.getString(2), rs.getDouble(3)));
						
					}
			}
			else if(maAlbum.trim().length()>0 && maNSX.trim().length()>0 && maTheLoai.trim().length()==0)
			{
				listCT.clear();
				String sql="select bd.maBD,tenBD,donGia from tbBangDia bd"
						+ "where bd.maALbum=? and bd.maNSX=?";
					PreparedStatement state=con.prepareStatement(sql);
					state.setString(1, maAlbum);
					state.setString(2, maNSX);
					ResultSet rs=state.executeQuery();
					
					while(rs.next())
					{
						listCT.add(new ChiTietBangDia_HoaDonDTO(rs.getString(1), rs.getString(2), rs.getDouble(3)));
						
					}
			}
			else if(maAlbum.trim().length()>0 && maNSX.trim().length()==0 && maTheLoai.trim().length()==0)
			{
				listCT.clear();
				String sql="select bd.maBD,tenBD,donGia from tbBangDia bd "
						+ "where bd.maALbum=?";
					PreparedStatement state=con.prepareStatement(sql);
					state.setString(1, maAlbum);

					ResultSet rs=state.executeQuery();
					
					while(rs.next())
					{
						listCT.add(new ChiTietBangDia_HoaDonDTO(rs.getString(1), rs.getString(2), rs.getDouble(3)));
						
					}
			}
			else if(maAlbum.trim().length()==0 && maNSX.trim().length()==0 && maTheLoai.trim().length()==0)
			{
				listCT.clear();
				String sql="select bd.maBD,tenBD,donGia from tbBangDia bd ";

					PreparedStatement state=con.prepareStatement(sql);
					ResultSet rs=state.executeQuery();
					
					while(rs.next())
					{
						listCT.add(new ChiTietBangDia_HoaDonDTO(rs.getString(1), rs.getString(2), rs.getDouble(3)));
						
					}
			}
			else if(maAlbum.trim().length()==0 && maNSX.trim().length()>0 && maTheLoai.trim().length()>0)
			{
				listCT.clear();
				String sql="select bd.maBD,tenBD,donGia from tbBangDia bd"
						+ "where bd.maNSX=? and bd.maTL=?";
					PreparedStatement state=con.prepareStatement(sql);
					state.setString(1, maNSX);
					state.setString(2, maTheLoai);
					ResultSet rs=state.executeQuery();
					while(rs.next())
					{
						listCT.add(new ChiTietBangDia_HoaDonDTO(rs.getString(1), rs.getString(2), rs.getDouble(3)));
						
					}
			}
			else if(maAlbum.trim().length()==0 && maNSX.trim().length()==0 && maTheLoai.trim().length()>0)
			{
				listCT.clear();
				String sql="select bd.maBD,tenBD,donGia from tbBangDia bd  "
						+ "where bd.maTL=?";
					PreparedStatement state=con.prepareStatement(sql);
					state.setString(1, maTheLoai);
					ResultSet rs=state.executeQuery();
					while(rs.next())
					{
						listCT.add(new ChiTietBangDia_HoaDonDTO(rs.getString(1), rs.getString(2), rs.getDouble(3)));
						
					}
			}
			else
			{
				listCT.clear();
				String sql="select bd.maBD,tenBD,donGia from tbBangDia bd "
						+ "where bd.maALbum=? and  bd.maTL=?";
					PreparedStatement state=con.prepareStatement(sql);
					state.setString(1, maAlbum);
					state.setString(2, maTheLoai);
					ResultSet rs=state.executeQuery();
					
					while(rs.next())
					{
						listCT.add(new ChiTietBangDia_HoaDonDTO(rs.getString(1), rs.getString(2), rs.getDouble(3)));
						
					}
			}

			return listCT;
		}
		public List<ChiTietBangDia_HoaDonDTO> getBDbyName(String ten) throws SQLException
		{
			String sql="select maBD,tenBD,donGia from tbBangDia where tenBD like ?";
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, "%"+ten+"%");
			ResultSet rs =pre.executeQuery();
			List<ChiTietBangDia_HoaDonDTO> listCTHD=new ArrayList<ChiTietBangDia_HoaDonDTO>();
			while(rs.next())
			{
				listCTHD.add(new ChiTietBangDia_HoaDonDTO(rs.getString(1), rs.getString(2), rs.getDouble(3)));
			}

			return listCTHD;
			
		}
		public int getSoLuongBD(String maBD) throws SQLException
		{
			String sql="select maBD, soLuong from tbBangDia where maBD=?";
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, maBD);
			ResultSet rs=pre.executeQuery();
			int soLuong=0;
			while(rs.next())
			{
				soLuong=rs.getInt(2);
			}
			return soLuong;
			
		}
		public boolean updateSLBangDia(String maBD, int sol) throws SQLException
		{
			PreparedStatement pre=con.prepareStatement("update tbBangDia set soLuong=? where maBD=?");
			pre.setInt(1, sol);
			pre.setString(2, maBD);
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
