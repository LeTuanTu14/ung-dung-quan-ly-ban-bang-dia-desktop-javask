package DTO;

public class TheLoai {
	private String maTheLoai;
	private String tenTheLoai;
	
	
	public TheLoai() {
		super();
	}
	public TheLoai(String maTheLoai) {
		super();
		this.maTheLoai = maTheLoai;
	}
	public TheLoai(String maTheLoai, String tenTheLoai) {
		super();
		this.maTheLoai = maTheLoai;
		this.tenTheLoai = tenTheLoai;
	}
	public String getMaTheLoai() {
		return maTheLoai;
	}
	public void setMaTheLoai(String maTheLoai) {
		this.maTheLoai = maTheLoai;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTheLoai == null) ? 0 : maTheLoai.hashCode());
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
		TheLoai other = (TheLoai) obj;
		if (maTheLoai == null) {
			if (other.maTheLoai != null)
				return false;
		} else if (!maTheLoai.equals(other.maTheLoai))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return maTheLoai;
	}
}
