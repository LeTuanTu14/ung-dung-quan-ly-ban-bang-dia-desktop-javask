package DTO;

public class NhaSXDTO_cbo {
	private String maNSX;
	private String tenNSX;
	
	
	
	
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
		NhaSXDTO_cbo other = (NhaSXDTO_cbo) obj;
		if (maNSX == null) {
			if (other.maNSX != null)
				return false;
		} else if (!maNSX.equals(other.maNSX))
			return false;
		return true;
	}

	public NhaSXDTO_cbo(String ma) throws Exception
	{
			this(ma,"null");
	}
	
	public NhaSXDTO_cbo()
	{
		
	}
	
	public NhaSXDTO_cbo(String maNSX, String tenNSX) throws Exception {
	
		this.maNSX = maNSX;
		setTenNSX(tenNSX);
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
	public void setTenNSX(String tenNSX) throws Exception {
		if(tenNSX.trim().length()>0)
		this.tenNSX = tenNSX;
		else throw new Exception("Tên nhà sản xuất không được rỗng");
	}
	
}
