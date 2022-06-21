package DTO;

import java.sql.Date;
import java.time.LocalDate;

public class ChiTietHoaDon_dto {
		private LapHoaDon_dto hoadon;
		private ChiTietBangDia_HoaDonDTO bangdia;
		private int soLuong;
		private Date ngayTra;
		public ChiTietHoaDon_dto(LapHoaDon_dto hoadon, ChiTietBangDia_HoaDonDTO bangdia, int soLuong, Date ngayTra) throws Exception {
		
			this.hoadon = hoadon;
			this.bangdia = bangdia;
			setSoLuong(soLuong);
			setNgayTra(ngayTra);
		}

		public ChiTietHoaDon_dto() {
			
			// TODO Auto-generated constructor stub
		}
		public LapHoaDon_dto getHoadon() {
			return hoadon;
		}
		public void setHoadon(LapHoaDon_dto hoadon) {
			this.hoadon = hoadon;
		}
		public ChiTietBangDia_HoaDonDTO getBangdia() {
			return bangdia;
		}
		public void setBangdia(ChiTietBangDia_HoaDonDTO bangdia) {
			this.bangdia = bangdia;
		}
		public int getSoLuong() {
			return soLuong;
		}
		public void setSoLuong(int soLuong) throws Exception {
			if(soLuong>0)
			this.soLuong = soLuong;
			else throw new Exception("Số lượng phải lớn hơn 0");
		}
		public Date getNgayTra() {
			return ngayTra;
		}
		public void setNgayTra(Date ngayTra) throws Exception {
			if(ngayTra.after(Date.valueOf(LocalDate.now())))
				this.ngayTra = ngayTra;
			else
				throw new Exception("Ngày trả đĩa phải sau ngày hiện tại");
		}
		
		
		
}
