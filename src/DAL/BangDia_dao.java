package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.Connection_DB;

import DTO.Album;
import DTO.BangDia;
import DTO.NhaSX;
import DTO.TheLoai;

public class BangDia_dao {
	public BangDia_dao() {
	}
	public ArrayList<BangDia> getalltbBangDia() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<BangDia> dsBangDia = new ArrayList<BangDia>();
		Connection con = Connection_DB.getDb().connect();
		
		try {
			Statement stt = con.createStatement();
			ResultSet rs = stt.executeQuery("Select * from tbBangDia");
			while(rs.next()) {
				BangDia bd = new BangDia(rs.getString(1), rs.getNString(2), rs.getInt(3), rs.getDouble(4), rs.getNString(5),rs.getString(6),rs.getString(7), new TheLoai(rs.getString(8)),new NhaSX(rs.getString(9)), new Album(rs.getString(10)));
				dsBangDia.add(bd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsBangDia;
	}
	
	public ArrayList<BangDia> getTheLoaitheoMaBangDia(String maBD) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<BangDia> dsBangDia = new ArrayList<BangDia>();
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("Select * from tbBangDia where maBD = ?");
			stmt.setString(1, maBD);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				BangDia bd = new BangDia(rs.getString(1), rs.getNString(2), rs.getInt(3), rs.getDouble(4), rs.getNString(5),rs.getString(6),rs.getString(7), new TheLoai(rs.getString(8)),new NhaSX(rs.getString(9)), new Album(rs.getString(10)));
				dsBangDia.add(bd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dsBangDia;
	}
	public boolean create(BangDia bd) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int n=0;
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into"+" tbBangDia values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, bd.getMaBD());
			stmt.setString(2, bd.getTenBD());
			stmt.setInt(3, bd.getSoLuong());
			stmt.setDouble(4, bd.getDonGia());
			stmt.setString(5, bd.getNoiDung());
			stmt.setString(6, bd.getNgayHH());
			stmt.setString(7, bd.getNgaySX());
			stmt.setString(8, bd.getMaTL().getMaTheLoai());
			stmt.setString(9, bd.getMaNSX().getMaNSX());
			stmt.setString(10, bd.getMaALbum().getMaAlbum());
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public int update(BangDia bd) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int n=0;
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("update tbBangDia set tenBD=?, soLuong=?, donGia=?, noiDung=?, ngaySX=?, ngayHH=?, maTL=?, maNSX=?, maALbum=? where maBD=?");
			stmt.setString(1, bd.getTenBD());
			stmt.setInt(2, bd.getSoLuong());
			stmt.setDouble(3, bd.getDonGia());
			stmt.setString(4, bd.getNoiDung());
			stmt.setString(5, bd.getNgaySX());
			stmt.setString(6, bd.getNgayHH());
			stmt.setString(7, bd.getMaTL().getMaTheLoai());
			stmt.setString(8, bd.getMaNSX().getMaNSX());
			stmt.setString(9, bd.getMaALbum().getMaAlbum());
			stmt.setString(10, bd.getMaBD());
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n;
	}
	public boolean delete(String ma) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int n=0;
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("delete from tbBangDia where maBD=? ");
			stmt.setString(1, ma);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
}
