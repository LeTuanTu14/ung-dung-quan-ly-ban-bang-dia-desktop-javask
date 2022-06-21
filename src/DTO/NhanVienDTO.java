package DTO;

public class NhanVienDTO {
	private String taiKhoan;
	private String hoTen;
	private String soDT;
	private String diaChi;
	private String matKhau;
	private String chucVu;
	private String eMail;
	
	public NhanVienDTO(String taikhoan)
	{
		this.taiKhoan=taikhoan;
	}
	
	@Override
	public String toString() {
		return String.format("NhanVienDTO [taiKhoan=%s, hoTen=%s, soDT=%s, diaChi=%s, matKhau=%s, chucVu=%s, eMail=%s]",
				taiKhoan, hoTen, soDT, diaChi, matKhau, chucVu, eMail);
	}
	public NhanVienDTO() {
	
	}
	public NhanVienDTO(String taiKhoan, String hoTen, String soDT, String diaChi, String matKhau, String chucVu,
			String eMail) {
		this.taiKhoan = taiKhoan;
		this.hoTen = hoTen;
		this.soDT = soDT;
		this.diaChi = diaChi;
		this.matKhau = matKhau;
		this.chucVu = chucVu;
		this.eMail = eMail;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
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
	
	
}
