package DTO;

import java.sql.Date;

public class LapHoaDon_dto {
		private String maHD;
		private String tenHD;
		private Date ngayLapHD;
		private NhanVienDTO nv;
		private KhachHang_dto kh;
		public LapHoaDon_dto(String mahd)
		{
			this.maHD=mahd;
		}
		
		public LapHoaDon_dto(String maHD, String tenHD, Date ngayLapHD, NhanVienDTO nv, KhachHang_dto kh) {
			this.maHD = maHD;
			this.tenHD = tenHD;
			this.ngayLapHD = ngayLapHD;
			this.nv = nv;
			this.kh = kh;
		}
		
		
		public LapHoaDon_dto() {
	
		
		}


		public String getMaHD() {
			return maHD;
		}
		public void setMaHD(String maHD) {
			this.maHD = maHD;
		}
		public String getTenHD() {
			return tenHD;
		}
		public void setTenHD(String tenHD) {
			this.tenHD = tenHD;
		}
		public Date getNgayLapHD() {
			return ngayLapHD;
		}
		public void setNgayLapHD(Date ngayLapHD) {
			this.ngayLapHD = ngayLapHD;
		}
		public NhanVienDTO getNv() {
			return nv;
		}
		public void setNv(NhanVienDTO nv) {
			this.nv = nv;
		}
		public KhachHang_dto getKh() {
			return kh;
		}
		public void setKh(KhachHang_dto kh) {
			this.kh = kh;
		}
		
		
		
}
