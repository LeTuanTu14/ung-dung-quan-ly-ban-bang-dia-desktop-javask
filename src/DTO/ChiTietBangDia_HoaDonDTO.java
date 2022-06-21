package DTO;

import java.sql.Date;;

public class ChiTietBangDia_HoaDonDTO {
			private String maBD;
			private String tenBD;
			private double donGia;
			
			//private final Date DATENOW=new Date(System.currentTimeMillis());
			
			
			
			public String getMaBD() {
				return maBD;
			}
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((maBD == null) ? 0 : maBD.hashCode());
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
				ChiTietBangDia_HoaDonDTO other = (ChiTietBangDia_HoaDonDTO) obj;
				if (maBD == null) {
					if (other.maBD != null)
						return false;
				} else if (!maBD.equals(other.maBD))
					return false;
				return true;
			}
			
			
			public void setMaBD(String maBD) {
				this.maBD = maBD;
			}
			public String getTenBD() {
				return tenBD;
			}
			public void setTenBD(String tenBD) {
				this.tenBD = tenBD;
			}
			public double getDonGia() {
				return donGia;
			}
			public void setDonGia(double donGia) {
				this.donGia = donGia;
			}
			
			
			public ChiTietBangDia_HoaDonDTO(String maBD)
			{
				this.maBD=maBD;
			}
			public ChiTietBangDia_HoaDonDTO()
			{
				
			}
			public ChiTietBangDia_HoaDonDTO(String maBD, String tenBD, double donGia) {

				this.maBD = maBD;
				this.tenBD = tenBD;
				this.donGia = donGia;
			
			}
			
			
			
			
}
