package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.Connection_DB;

import DTO.Album;

public class Album_dao {
	public Album_dao() {
	}
	public ArrayList<Album> getalltbAlbum() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<Album> dsAlbum = new ArrayList<Album>();
		Connection con = Connection_DB.getDb().connect();
		
		try {
			Statement stt = con.createStatement();
			ResultSet rs = stt.executeQuery("Select * from tbAlbum");
			while(rs.next()) {
				Album al = new Album(rs.getString(1), rs.getNString(2),rs.getString(3));
				dsAlbum.add(al);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsAlbum;
	}
	
	public ArrayList<Album> getTheLoaitheoMaAlbum(String maAL) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<Album> dsAlbum = new ArrayList<Album>();
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("Select * from tbAlbum where maAlbum = ?");
			stmt.setString(1, maAL);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Album al = new Album(rs.getString(1), rs.getNString(2),rs.getString(3));
				dsAlbum.add(al);
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
		
		return dsAlbum;
	}
	public boolean create(Album al) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int n=0;
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into"+" tbAlbum values(?,?,?)");
			stmt.setString(1, al.getMaAlbum());
			stmt.setNString(2, al.getTenAlbum());
			stmt.setString(3, al.getNgayRaMat());
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
	public int update(Album al) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int n=0;
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("update tbAlbum set tenAlbum=?, ngayRaMat=? where maAlbum=?");
			stmt.setNString(1, al.getTenAlbum());
			stmt.setString(2, al.getNgayRaMat());
			stmt.setString(3, al.getMaAlbum());
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
			stmt = con.prepareStatement("delete from tbBangDia where maALbum=? delete from tbAlbum where maAlbum=?");
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
