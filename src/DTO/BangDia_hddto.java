package DTO;

public class BangDia_hddto {
			private String maBD;
		
			private int slTon;

			
			public BangDia_hddto(String mabd)
			{
				this.maBD=mabd;
			}
			public BangDia_hddto(String maBD, int slTon) {
	
				this.maBD = maBD;
				this.slTon = slTon;
			}
			
			

			public BangDia_hddto() {
			
			}



			public String getMaBD() {
				return maBD;
			}

			public void setMaBD(String maBD) {
				this.maBD = maBD;
			}

			public int getSlTon() {
				return slTon;
			}

			public void setSlTon(int slTon) {
				this.slTon = slTon;
			}
			
	
}
