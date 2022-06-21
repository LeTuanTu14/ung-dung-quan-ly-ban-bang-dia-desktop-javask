package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import DTO.NhanVien;
import Database.Connection_DB;

public class NhanVien_DAO {
	public ArrayList<NhanVien> getTheLoaitheoTaiKhoanNhanVien(String tk) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("Select * from tbNhanVien where taiKhoanID = ?");
			stmt.setString(1, tk);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				NhanVien nv = new NhanVien(rs.getString(1), rs.getNString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				dsNhanVien.add(nv);
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
		
		return dsNhanVien;
	}
	public ArrayList<NhanVien> getalltbNhanVien(){
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		try {
			Connection con = Connection_DB.getDb().connect();
			
			String sql="Select * from tbNhanVien";
			Statement statement= con.createStatement();
			
			//Thuc thi cau lenh SQL tra ve doi tuong ResultSet.
			ResultSet rs=statement.executeQuery(sql);
			
			//Duyet ket qua tra ve.
			while(rs.next()) {
				String taiKhoan=rs.getString(1);
				String hoTen=rs.getString(2);
				String sodt=rs.getString(3);
				String diaChi=rs.getString(4);
				String matKhau=rs.getString(5);
				String chucVu= rs.getString(6);
				String email=rs.getString(7);
				
				NhanVien p= new NhanVien(taiKhoan, hoTen, sodt, diaChi, matKhau, chucVu, email);
				
				dsNhanVien.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsNhanVien;
	}
	public ArrayList<NhanVien> getNhanVienTheoTKID(String id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement statement=null;
		try {
			
		
			String sql="Select * from tbNhanVien where taiKhoanID = ?";
			statement= con.prepareStatement(sql);
			statement.setString(1, id);
		
		//Thuc thi cau lenh SQL tra ve doi tuong ResultSet.
			ResultSet rs=statement.executeQuery(sql);
		
		//Duyet ket qua tra ve.
			while(rs.next()) {
				String taiKhoan=rs.getString(1);
				String hoTen=rs.getString(2);
				String sodt=rs.getString(3);
				String diaChi=rs.getString(4);
				String matKhau=rs.getString(5);
				String chucVu= rs.getString(6);
				String email=rs.getString(7);
				
				NhanVien p= new NhanVien(taiKhoan, hoTen, sodt, diaChi, matKhau, chucVu, email);
				
				dsNhanVien.add(p);
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
	
		return dsNhanVien;
	}
	public ArrayList<NhanVien> getNhanVienTheoHoTen(String ten) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement statement=null;
		try {
			
		
			String sql="Select * from tbNhanVien where hoTen = ?";
			statement= con.prepareStatement(sql);
			statement.setString(1, ten);
		//Thuc thi cau lenh SQL tra ve doi tuong ResultSet.
			ResultSet rs=statement.executeQuery(sql);
		
		//Duyet ket qua tra ve.
			while(rs.next()) {
				String taiKhoan=rs.getString(1);
				String hoTen=rs.getString(2);
				String sodt=rs.getString(3);
				String diaChi=rs.getString(4);
				String matKhau=rs.getString(5);
				String chucVu= rs.getString(6);
				String email=rs.getString(7);
				
				NhanVien p= new NhanVien(taiKhoan, hoTen, sodt, diaChi, matKhau, chucVu, email);
				
				dsNhanVien.add(p);
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
	
		return dsNhanVien;
	}
	public boolean createNV (NhanVien nv) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt= null;
		int n=0;
		try {
			stmt= con.prepareStatement("insert into"+" tbNhanVien values(?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getTaiKhoanID());
			stmt.setString(2, nv.getHoTen());
			stmt.setString(3, nv.getSoDT());
			stmt.setString(4, nv.getDiaChi());
			stmt.setString(5, nv.getMatKhau());
			stmt.setString(6, nv.getChucVu());
			stmt.setString(7, nv.geteMail());
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
	public int updateNV(NhanVien nv) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt= null;
		int n=0;
		try {
			stmt= con.prepareStatement("update tbNhanVien set  hoTen=?, soDT=?,diaChi=?,matKhau=?,chucVu=?,eMail=? where taiKhoanID=?");
			stmt.setString(1, nv.getHoTen());
			stmt.setString(2, nv.getSoDT());
			stmt.setString(3, nv.getDiaChi());
			stmt.setString(4, nv.getMatKhau());
			stmt.setString(5, nv.getChucVu());
			stmt.setString(6, nv.geteMail());
			stmt.setString(7, nv.getTaiKhoanID());
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
	public boolean deleteNV(String manv) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection con = Connection_DB.getDb().connect();
		PreparedStatement stmt= null;
		int n=0;
		try {
			stmt= con.prepareStatement("delete from tbNhanVien where taiKhoan=?");
			stmt.setString(1, manv);
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
