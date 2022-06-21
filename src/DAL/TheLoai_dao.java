package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import DTO.TheLoai;
import Database.Connection_DB;

public class TheLoai_dao {
	public TheLoai_dao() {
	}
	public ArrayList<TheLoai> getalltbTheLoai() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<TheLoai> dsTheLoai = new ArrayList<TheLoai>();
		Connection con = Connection_DB.getDb().connect();
		
		try {
			Statement stt = con.createStatement();
			ResultSet rs = stt.executeQuery("Select * from tbTheLoai");
			while(rs.next()) {
				TheLoai tl = new TheLoai(rs.getString(1), rs.getNString(2));
				dsTheLoai.add(tl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTheLoai;
	}
	
	public ArrayList<TheLoai> getTheLoaitheoMaTheLoai(String ma) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<TheLoai> dsTheLoai = new ArrayList<TheLoai>();
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("Select * from tbTheLoai where maTheLoai = ?");
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maTheLoai = rs.getString(1);
				String tenTheLoai = rs.getString(2);
				TheLoai tl = new TheLoai(maTheLoai, tenTheLoai);
				dsTheLoai.add(tl);
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
		
		return dsTheLoai;
	}
	public boolean create(TheLoai tl) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int n=0;
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into"+" tbTheLoai values(?,?)");
			stmt.setString(1, tl.getMaTheLoai());
			stmt.setNString(2, tl.getTenTheLoai());
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
	public int update(TheLoai tl) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int n=0;
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("update tbTheLoai set tenTheLoai=? where maTheLoai=?");
			stmt.setNString(1, tl.getTenTheLoai());
			stmt.setString(2, tl.getMaTheLoai());
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
			stmt = con.prepareStatement("delete from tbBangDia where maTL=? delete from tbTheLoai where maTheLoai=?");
			stmt.setString(1, ma);
			stmt.setString(2, ma);
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
