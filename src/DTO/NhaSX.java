package DTO;

public class NhaSX {
	private String maNSX;
	private String tenNSX;
	private String diaChi;
	private String dienThoai;
	private String eMail;
	
	
	
	public NhaSX(String maNSX) {
		super();
		this.maNSX = maNSX;
	}
	public NhaSX() {
		super();
	}
	
	public NhaSX(String maNSX, String tenNSX, String diaChi, String dienThoai, String eMail) {
		super();
		this.maNSX = maNSX;
		this.tenNSX = tenNSX;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.eMail = eMail;
	}
	
	public String getMaNSX() {
		return maNSX;
	}
	public void setMaNSX(String maNSX) {
		this.maNSX = maNSX;
	}
	public String getTenNSX() {
		return tenNSX;
	}
	public void setTenNSX(String tenNSX) {
		this.tenNSX = tenNSX;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNSX == null) ? 0 : maNSX.hashCode());
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
		NhaSX other = (NhaSX) obj;
		if (maNSX == null) {
			if (other.maNSX != null)
				return false;
		} else if (!maNSX.equals(other.maNSX))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return maNSX;
	}
	
	

}
