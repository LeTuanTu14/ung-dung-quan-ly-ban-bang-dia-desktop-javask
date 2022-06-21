package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.Connection_DB;

import DTO.KhachHang;

public class KhachHang_DAO {
	
	public ArrayList<KhachHang> getallbdKhachHang(){
		ArrayList<KhachHang> dsKhachHang= new ArrayList<KhachHang>();
		try {
			Connection con = Connection_DB.getDb().connect();
			
			String sql="Select * from tbKhachHang";
			Statement statement= con.createStatement();
			
			//Thuc thi cau lenh SQL tra ve doi tuong ResultSet.
			ResultSet rs=statement.executeQuery(sql);
			
			//Duyet ket qua tra ve.
			while(rs.next()) {
				String maKH=rs.getString(1);
				String tenKH=rs.getString(2);
				String dienThoai=rs.getString(3);
				String diaChi=rs.getString(4);
				String email=rs.getString(5);
				String ngaySinh=rs.getString(6);
				
				KhachHang p= new KhachHang(maKH, tenKH, dienThoai, diaChi, email, ngaySinh);
				dsKhachHang.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsKhachHang;
	}
	public ArrayList<KhachHang> getKhachHangTheoMaKH(String ma) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		ArrayList<KhachHang> dsKhachHang= new ArrayList<KhachHang>();
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement statement=null;
		try {
			
		
			String sql="Select * from tbKhachHang where makh = ?";
			statement= con.prepareStatement(sql);
			statement.setString(1, ma);
		
		//Thuc thi cau lenh SQL tra ve doi tuong ResultSet.
			ResultSet rs=statement.executeQuery(sql);
		
		//Duyet ket qua tra ve.
			while(rs.next()) {
				String maKH=rs.getString(1);
				String tenKH=rs.getString(2);
				String dienThoai=rs.getString(3);
				String diaChi=rs.getString(4);
				String email=rs.getString(5);
				String ngaySinh=rs.getString(6);
				
				KhachHang p= new KhachHang(maKH, tenKH, dienThoai, diaChi, email, ngaySinh);
				dsKhachHang.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return dsKhachHang;
	}
	public ArrayList<KhachHang> getKhachHangTheoHoTen(String hoten) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		ArrayList<KhachHang> dsKhachHang= new ArrayList<KhachHang>();
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement statement=null;
		try {
			
		
			String sql="Select * from tbKhachHang where tenKH = ?";
			statement= con.prepareStatement(sql);
			statement.setString(1, hoten);
			//Thuc thi cau lenh SQL tra ve doi tuong ResultSet.
			ResultSet rs=statement.executeQuery(sql);
		
		//Duyet ket qua tra ve.
			while(rs.next()) {
				String maKH=rs.getString(1);
				String tenKH=rs.getString(2);
				String dienThoai=rs.getString(3);
				String diaChi=rs.getString(4);
				String email=rs.getString(5);
				String ngaySinh=rs.getString(6);
				
				KhachHang p= new KhachHang(maKH, tenKH, dienThoai, diaChi, email, ngaySinh);
				dsKhachHang.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return dsKhachHang;
	}
	public boolean createKH (KhachHang kh) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt= null;
		int n=0;
		try {
			stmt= con.prepareStatement("insert into"+" tbKhachHang values(?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setString(3, kh.getSoDT());
			stmt.setString(4, kh.getDiaChi());
			stmt.setString(5, kh.geteMail());
			stmt.setString(6, kh.getNgaySinh());
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
	public int updateKH (KhachHang kh) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt= null;
		int n=0;
		try {
			stmt= con.prepareStatement("update tbKhachHang set  tenKH=?, soDT=?,diaChi=?,eMail=?,ngaySinh=? where maKH=?");
			stmt.setString(1, kh.getTenKH());
			stmt.setString(2, kh.getSoDT());
			stmt.setString(3, kh.getDiaChi());
			stmt.setString(4, kh.geteMail());
			stmt.setString(5, kh.getNgaySinh());
			stmt.setString(6, kh.getMaKH());
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
	public boolean deleteKH(String makh) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt= null;
		int n=0;
		try {
			stmt= con.prepareStatement("delete from tbKhachHang where maKH=?");
			stmt.setString(1, makh);
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
