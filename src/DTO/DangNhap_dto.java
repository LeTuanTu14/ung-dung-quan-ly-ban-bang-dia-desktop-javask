package DTO;

public class DangNhap_dto {

	private String taiKhoan;
	private String matKhau;
	
	public DangNhap_dto()
	{
		
	}
	public DangNhap_dto(String tk, String mk) throws Exception
	{
		setTaiKhoan(tk);
		setMatKhau(mk);
	}
	
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) throws Exception {
		if(taiKhoan.trim().length()>0)
		this.taiKhoan = taiKhoan;
		else throw new Exception("Tài khoản không được để trống");
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) throws Exception {
		if(matKhau.trim().length()>0)
		this.matKhau = matKhau;
		else
			 throw new Exception("Mật khẩu không được để trống");
	}
	
	
}
