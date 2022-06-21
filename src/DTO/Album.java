package DTO;

public class Album {
	private String maAlbum;
	private String tenAlbum;
	private String ngayRaMat;
	
	
	public Album() {
		super();
	}
	public Album(String maAlbum) {
		super();
		this.maAlbum = maAlbum;
	}
	public Album(String maAlbum, String tenAlbum, String ngayRaMat) {
		super();
		this.maAlbum = maAlbum;
		this.tenAlbum = tenAlbum;
		this.ngayRaMat = ngayRaMat;
	}
	public String getMaAlbum() {
		return maAlbum;
	}
	public void setMaAlbum(String maAlbum) {
		this.maAlbum = maAlbum;
	}
	public String getTenAlbum() {
		return tenAlbum;
	}
	public void setTenAlbum(String tenAlbum) {
		this.tenAlbum = tenAlbum;
	}
	public String getNgayRaMat() {
		return ngayRaMat;
	}
	public void setNgayRaMat(String ngayRaMat) {
		this.ngayRaMat = ngayRaMat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maAlbum == null) ? 0 : maAlbum.hashCode());
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
		Album other = (Album) obj;
		if (maAlbum == null) {
			if (other.maAlbum != null)
				return false;
		} else if (!maAlbum.equals(other.maAlbum))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return maAlbum;
	}
	
	
}
