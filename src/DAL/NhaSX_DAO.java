package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.NhaSX;
import Database.Connection_DB;

public class NhaSX_DAO {
	
	public ArrayList<NhaSX> getallbdNhaSX(){
		ArrayList<NhaSX> dsNhaSX = new ArrayList<NhaSX>();
		try {
			Connection con = Connection_DB.getDb().connect();
			
			String sql="Select * from tbNhaSX";
			Statement statement= con.createStatement();
			
			//Thuc thi cau lenh SQL tra ve doi tuong ResultSet.
			ResultSet rs=statement.executeQuery(sql);
			
			//Duyet ket qua tra ve.
			while(rs.next()) {
				String maSX=rs.getString(1);
				String tenNhaSX=rs.getString(2);
				String diaChi=rs.getString(3);
				String dienThoai=rs.getString(4);
				String email=rs.getString(5);
				
				NhaSX p= new NhaSX(maSX, tenNhaSX, diaChi, dienThoai, email);
				dsNhaSX.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsNhaSX;
	}
	public ArrayList<NhaSX> getNhaSXTheoMaNSX(String masx){
		ArrayList<NhaSX> dsNhaSX = new ArrayList<NhaSX>();
		try {
			Connection con = Connection_DB.getDb().connect();
			PreparedStatement statement=null;
			
			String sql="Select * from tbNhaSX where maNSX=?";
			statement= con.prepareStatement(sql);
			statement.setString(1, masx);
			
			//Thuc thi cau lenh SQL tra ve doi tuong ResultSet.
			ResultSet rs=statement.executeQuery(sql);
			
			//Duyet ket qua tra ve.
			while(rs.next()) {
				String maSX=rs.getString(1);
				String tenNhaSX=rs.getString(2);
				String diaChi=rs.getString(3);
				String dienThoai=rs.getString(4);
				String email=rs.getString(5);
				
				NhaSX p= new NhaSX(maSX, tenNhaSX, diaChi, dienThoai, email);
				dsNhaSX.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsNhaSX;
	}
	public ArrayList<NhaSX> getNhaSXTheoTenNSX(String tennsx){
		ArrayList<NhaSX> dsNhaSX = new ArrayList<NhaSX>();
		try {
			Connection con = Connection_DB.getDb().connect();
			PreparedStatement statement=null;
			
			String sql="Select * from tbNhaSX where tenNSX=?";
			statement= con.prepareStatement(sql);
			statement.setString(1, tennsx);
			//Thuc thi cau lenh SQL tra ve doi tuong ResultSet.
			ResultSet rs=statement.executeQuery(sql);
		
			//Duyet ket qua tra ve.
			while(rs.next()) {
				String maSX=rs.getString(1);
				String tenNhaSX=rs.getString(2);
				String diaChi=rs.getString(3);
				String dienThoai=rs.getString(4);
				String email=rs.getString(5);
				
				NhaSX p= new NhaSX(maSX, tenNhaSX, diaChi, dienThoai, email);
				dsNhaSX.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsNhaSX;
	}
	public boolean createNSX (NhaSX nsx) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt= null;
		int n=0;
		try {
			stmt= con.prepareStatement("insert into"+" tbNhaSX values(?,?,?,?,?)");
			stmt.setString(1, nsx.getMaNSX());
			stmt.setString(2, nsx.getTenNSX());
			stmt.setString(3, nsx.getDiaChi());
			stmt.setString(4, nsx.getDienThoai());
			stmt.setString(5, nsx.geteMail());
			n= stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	public int updateNSX (NhaSX nsx) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt= null;
		int n=0;
		try {
			stmt= con.prepareStatement("update tbNhaSX set tenNSX=?, diaChi=?, dienThoai=?, email=? where maNSX=?");
			stmt.setString(1, nsx.getTenNSX());
			stmt.setString(2, nsx.getDiaChi());
			stmt.setString(3, nsx.getDienThoai());
			stmt.setString(4, nsx.geteMail());
			stmt.setString(5, nsx.getMaNSX());
			n= stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return n;
		}
	public boolean deleteNSX (String mansx) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt= null;
		int n=0;
		try {
			stmt= con.prepareStatement("delete from tbNhaSX where maNSX=?");
			stmt.setString(1, mansx);
			n= stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

}

