package DTO;



public class AlbumDTO {
		private String maAlbum;
		private String tenAlbum;
		
		
		
		
		
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
			AlbumDTO other = (AlbumDTO) obj;
			if (maAlbum == null) {
				if (other.maAlbum != null)
					return false;
			} else if (!maAlbum.equals(other.maAlbum))
				return false;
			return true;
		}
		public AlbumDTO()
		{
			
		}
		public AlbumDTO(String ma, String ten) throws Exception
		{
			this.maAlbum=ma;
			setTenAlbum(ten);
		
		}
		public AlbumDTO(String ma) throws Exception
		{
			this(ma,"null");
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
		public void setTenAlbum(String tenAlbum) throws Exception {
			if(tenAlbum.trim().length()>0)
			this.tenAlbum = tenAlbum;
			else throw new Exception("Tên album không được rỗng");
		}
		
		
}
