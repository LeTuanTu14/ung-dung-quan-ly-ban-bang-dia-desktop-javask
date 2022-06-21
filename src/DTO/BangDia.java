package DTO;

public class BangDia {
	private String maBD;
	private String tenBD;
	private int soLuong;
	private double donGia;
	private String noiDung;
	private String ngaySX;
	private String ngayHH;
	private TheLoai maTL;
	private NhaSX maNSX;
	private Album maALbum;
	
	
	public BangDia() {
		super();
	}
	public BangDia(String maBD) {
		super();
		this.maBD = maBD;
	}
	public BangDia(String maBD, String tenBD, int soLuong, double donGia, String noiDung, String ngaySX, String ngayHH,
			TheLoai maTL, NhaSX maNSX, Album maALbum) {
		super();
		this.maBD = maBD;
		this.tenBD = tenBD;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.noiDung = noiDung;
		this.ngaySX = ngaySX;
		this.ngayHH = ngayHH;
		this.maTL = maTL;
		this.maNSX = maNSX;
		this.maALbum = maALbum;
	}
	public String getMaBD() {
		return maBD;
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
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getNgaySX() {
		return ngaySX;
	}
	public void setNgaySX(String ngaySX) {
		this.ngaySX = ngaySX;
	}
	public String getNgayHH() {
		return ngayHH;
	}
	public void setNgayHH(String ngayHH) {
		this.ngayHH = ngayHH;
	}
	public TheLoai getMaTL() {
		return maTL;
	}
	public void setMaTL(TheLoai maTL) {
		this.maTL = maTL;
	}
	public NhaSX getMaNSX() {
		return maNSX;
	}
	public void setMaNSX(NhaSX maNSX) {
		this.maNSX = maNSX;
	}
	public Album getMaALbum() {
		return maALbum;
	}
	public void setMaALbum(Album maALbum) {
		this.maALbum = maALbum;
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
		BangDia other = (BangDia) obj;
		if (maBD == null) {
			if (other.maBD != null)
				return false;
		} else if (!maBD.equals(other.maBD))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BangDia [maBD=" + maBD + ", tenBD=" + tenBD + ", soLuong=" + soLuong + ", donGia=" + donGia
				+ ", noiDung=" + noiDung + ", ngaySX=" + ngaySX + ", ngayHH=" + ngayHH + ", maTL=" + maTL + ", maNSX="
				+ maNSX + ", maALbum=" + maALbum + "]";
	}
	
}
