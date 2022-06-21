package DTO;

public class TheLoaiDTO_cbo {
		private String maTL;
		private String tenTL;
		
		
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((maTL == null) ? 0 : maTL.hashCode());
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
			TheLoaiDTO_cbo other = (TheLoaiDTO_cbo) obj;
			if (maTL == null) {
				if (other.maTL != null)
					return false;
			} else if (!maTL.equals(other.maTL))
				return false;
			return true;
		}

		public TheLoaiDTO_cbo(String ma) throws Exception
		{
			this(ma,"null");
		}
		
		public TheLoaiDTO_cbo()
		{
			
		}
		
		public TheLoaiDTO_cbo(String maTL, String tenTL) throws Exception {
		
			this.maTL = maTL;
			setTenTL(tenTL);
		}
		public String getMaTL() {
			return maTL;
		}
		public void setMaTL(String maTL) {
			this.maTL = maTL;
		}
		public String getTenTL() {
			return tenTL;
		}
		public void setTenTL(String tenTL) throws Exception {
			if(tenTL.trim().length()>0)
			this.tenTL = tenTL;
			else throw new Exception("Tên thể loại không được null");
		}
		
}
