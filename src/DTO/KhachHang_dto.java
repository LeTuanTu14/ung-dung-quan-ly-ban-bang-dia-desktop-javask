package DTO;

import java.sql.Date;

public class KhachHang_dto {
		private String maKH;
		private String tenKH;
		private String soDT;
		private String diaChi;
		private String eMail;
		private Date ngaySinh;
		
		
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			KhachHang_dto other = (KhachHang_dto) obj;
			if (maKH == null) {
				if (other.maKH != null)
					return false;
			} else if (!maKH.equals(other.maKH))
				return false;
			return true;
		}


		public String getMaKH() {
			return maKH;
		}


		public void setMaKH(String maKH) {
			this.maKH = maKH;
		}


		public String getTenKH() {
			return tenKH;
		}


		public void setTenKH(String tenKH) {
			this.tenKH = tenKH;
		}


		public String getSoDT() {
			return soDT;
		}


		public void setSoDT(String soDT) {
			this.soDT = soDT;
		}


		public String getDiaChi() {
			return diaChi;
		}


		public void setDiaChi(String diaChi) {
			this.diaChi = diaChi;
		}


		public String geteMail() {
			return eMail;
		}


		public void seteMail(String eMail) {
			this.eMail = eMail;
		}


		public Date getNgaySinh() {
			return ngaySinh;
		}


		public void setNgaySinh(Date ngaySinh) {
			this.ngaySinh = ngaySinh;
		}


		public KhachHang_dto() {
	
		}

		public KhachHang_dto(String id)
		{
			this.maKH=id;
		}
		public KhachHang_dto(String maKH, String tenKH, String soDT, String diaChi, String eMail, Date ngaySinh) {

			this.maKH = maKH;
			this.tenKH = tenKH;
			this.soDT = soDT;
			this.diaChi = diaChi;
			this.eMail = eMail;
			this.ngaySinh = ngaySinh;
		}
		
}
