package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAL.NhanVienDAL;
import DTO.DangNhap_dto;
import javax.swing.JPasswordField;

public class frmLogin extends JFrame implements ActionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txttaikhoan;
	private JButton btndangnhap;
	private JButton btnthoat;
	public static String taiKhoan="";

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public frmLogin() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		
		this.setBounds(100, 100, 646, 464);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Tài khoản:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(139, 134, 81, 28);
		this.getContentPane().add(lblNewLabel);
		
		txttaikhoan = new JTextField();
		txttaikhoan.setBounds(219, 133, 281, 33);
		this.getContentPane().add(txttaikhoan);
		txttaikhoan.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(139, 190, 81, 28);
		this.getContentPane().add(lblNewLabel_1);
		
		btndangnhap = new JButton("Đăng nhập");
		btndangnhap.addActionListener(this);
		btndangnhap.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btndangnhap.setBounds(219, 274, 95, 39);
		this.getContentPane().add(btndangnhap);
		
		btnthoat = new JButton("Thoát");
		btnthoat.addActionListener(this);
		btnthoat.setBounds(370, 274, 95, 39);
		this.getContentPane().add(btnthoat);
		
		JLabel lblimg = new JLabel("");
		lblimg.setBounds(259, 10, 177, 97);
		BufferedImage images=ImageIO.read(new File("img/cd.jpg"));
		ImageIcon icon=new ImageIcon(images.getScaledInstance(lblimg.getSize().width, lblimg.getSize().height, images.SCALE_SMOOTH));
		lblimg.setIcon(icon);
		
		this.getContentPane().add(lblimg);
		
		txtmatkhau = new JPasswordField();
		txtmatkhau.setBounds(219, 189, 281, 33);
		getContentPane().add(txtmatkhau);
	}

	private static int count=0;
	private JPasswordField txtmatkhau;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source=e.getSource();
		
		if(source.equals(btndangnhap))
		{
			
			try {
				
				DangNhap_dto dn=new DangNhap_dto(txttaikhoan.getText(), txtmatkhau.getText());
				boolean dnbool=NhanVienDAL.getNhanVienDAL().dangNhap(dn);
				if(dnbool)
				{
					frmLayout_final frm=new frmLayout_final();
					frm.setVisible(true);
					taiKhoan=dn.getTaiKhoan();
					this.setVisible(false);
				}
				else
				{
					count++;
					JOptionPane.showMessageDialog(this, "Đăng nhập thất bại lần "+ count);
					if(count==4)
					{
						System.exit(0);
					}
				}
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, e1.getMessage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}
		if(source.equals(btnthoat))
		{
			System.exit(0);
		}
	}
}
