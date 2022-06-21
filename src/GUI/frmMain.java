package GUI;

import java.io.IOException;
import java.sql.Date;

public class frmMain {
	public static void main(String[] args) {
		try {
			frmLogin frm= new frmLogin();
			frm.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
