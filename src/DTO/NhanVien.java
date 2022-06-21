package DTO;

public class NhanVien {
	private String taiKhoanID;
	private String hoTen;
	private String soDT;
	private String diaChi;
	private String matKhau;
	private String chucVu;
	private String eMail;
	
	
	
	public NhanVien() {
		super();
	}
	public NhanVien(String taiKhoanID) {
		super();
		this.taiKhoanID = taiKhoanID;
	}
	public NhanVien(String taiKhoanID, String hoTen, String soDT, String diaChi, String matKhau, String chucVu,
			String eMail) {
		super();
		this.taiKhoanID = taiKhoanID;
		this.hoTen = hoTen;
		this.soDT = soDT;
		this.diaChi = diaChi;
		this.matKhau = matKhau;
		this.chucVu = chucVu;
		this.eMail = eMail;
	}
	
	public String getTaiKhoanID() {
		return taiKhoanID;
	}
	public void setTaiKhoanID(String taiKhoanID) {
		this.taiKhoanID = taiKhoanID;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	@Override
	public String toString() {
		return "NhanVien [taiKhoanID=" + taiKhoanID + ", hoTen=" + hoTen + ", soDT=" + soDT + ", diaChi=" + diaChi
				+ ", matKhau=" + matKhau + ", chucVu=" + chucVu + ", eMail=" + eMail + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taiKhoanID == null) ? 0 : taiKhoanID.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (taiKhoanID == null) {
			if (other.taiKhoanID != null)
				return false;
		} else if (!taiKhoanID.equals(other.taiKhoanID))
			return false;
		return true;
	}
	
}
