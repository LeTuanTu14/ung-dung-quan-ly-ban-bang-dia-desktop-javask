package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorListener;

import DTO.ChiTietBangDia_HoaDonDTO;
import DTO.KhachHang_dto;
import DTO.NhaSX;

public class frmLayout_final extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static KhachHang_dto khlayout=null;
	public static List<ChiTietBangDia_HoaDonDTO> dsCT=new ArrayList<ChiTietBangDia_HoaDonDTO>();
	//private JFrame frame;
	private JButton btnkhachhang;
	private JButton btnlaphoadon;
	private JButton btnbangdia;
	private JButton btnalbum;
	private JButton btnTheLoai;
	private JButton btnnhaSX;
	private JButton btnHD;
	private JButton btnclose;
	private JButton btnnhanvien;



	/**
	 * Create the application.
	 */
	public frmLayout_final() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.getContentPane().setBackground(new Color(0, 139, 139));
		getContentPane().setLayout(null);
		
		JPanel pnlmenu = new JPanel();
		pnlmenu.setBounds(0, 0, 300, 743);
		pnlmenu.setBackground(new Color(0, 139, 139));
		this.getContentPane().add(pnlmenu);
		
		btnkhachhang=new JButton("Khách Hàng");
		btnkhachhang.setBounds(0, 486, 292, 58);
		btnkhachhang.addActionListener(this);
		try {
			BufferedImage images=ImageIO.read(new File("img/customer.png"));
			ImageIcon icon=new ImageIcon(images.getScaledInstance(25, 25, images.SCALE_SMOOTH));
			btnkhachhang.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		pnlmenu.setLayout(null);
		btnkhachhang.setBackground(new Color(0, 0, 128));
		
		btnkhachhang.setForeground(new Color(230, 230, 250));
		btnkhachhang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnlmenu.add(btnkhachhang);
		
		btnHD = new JButton("Hóa Đơn");
		btnHD.setBounds(0, 350, 292, 58);
		btnHD.addActionListener(this);
		try {
			BufferedImage images=ImageIO.read(new File("img/bill.jpg"));
			ImageIcon icon=new ImageIcon(images.getScaledInstance(25, 25, images.SCALE_SMOOTH));
			btnHD.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		btnHD.setBackground(new Color(0, 0, 128));
		btnHD.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHD.setForeground(new Color(230, 230, 250));
		pnlmenu.add(btnHD);
		
		btnnhaSX = new JButton("Nhà Sản Xuất");
		btnnhaSX.setBounds(0, 282, 292, 58);
		btnnhaSX.addActionListener(this);
		try {
			BufferedImage images=ImageIO.read(new File("img/nhasx.png"));
			ImageIcon icon=new ImageIcon(images.getScaledInstance(25, 25, images.SCALE_SMOOTH));
			btnnhaSX.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		btnnhaSX.setBackground(new Color(0, 0, 128));
		btnnhaSX.setForeground(new Color(230, 230, 250));
		btnnhaSX.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnlmenu.add(btnnhaSX);
		
		btnTheLoai = new JButton("Thể Loại");
		btnTheLoai.setBounds(0, 214, 292, 58);
		btnTheLoai.addActionListener(this);
		try {
			BufferedImage images=ImageIO.read(new File("img/theloai.png"));
			ImageIcon icon=new ImageIcon(images.getScaledInstance(25, 25, images.SCALE_SMOOTH));
			btnTheLoai.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		btnTheLoai.setBackground(new Color(0, 0, 128));
		btnTheLoai.setForeground(new Color(230, 230, 250));
		btnTheLoai.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnlmenu.add(btnTheLoai);
		
		btnalbum = new JButton("Album");
		btnalbum.setBounds(0, 146, 292, 58);
		btnalbum.addActionListener(this);
		try {
			BufferedImage images=ImageIO.read(new File("img/album.jpg"));
			ImageIcon icon=new ImageIcon(images.getScaledInstance(25, 25, images.SCALE_SMOOTH));
			btnalbum.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		btnalbum.setBackground(new Color(0, 0, 128));
		btnalbum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnalbum.setForeground(new Color(230, 230, 250));
		pnlmenu.add(btnalbum);
		
		btnbangdia = new JButton("Băng Đĩa");
		btnbangdia.setBounds(0, 78, 292, 58);
		btnbangdia.addActionListener(this);
		try {
			BufferedImage images=ImageIO.read(new File("img/disk.jpg"));
			ImageIcon icon=new ImageIcon(images.getScaledInstance(25, 25, images.SCALE_SMOOTH));
			btnbangdia.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		btnbangdia.setBackground(new Color(0, 0, 128));
		btnbangdia.setForeground(new Color(230, 230, 250));
		btnbangdia.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnlmenu.add(btnbangdia);
		
		btnlaphoadon = new JButton("Lập Hóa Đơn");
		btnlaphoadon.setBounds(0, 10, 292, 58);
		try {
			BufferedImage images=ImageIO.read(new File("img/invoice.png"));
			ImageIcon icon=new ImageIcon(images.getScaledInstance(25, 25, images.SCALE_SMOOTH));
			btnlaphoadon.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		btnlaphoadon.setBackground(new Color(0, 0, 128));
		btnlaphoadon.setForeground(new Color(230, 230, 250));
		btnlaphoadon.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnlmenu.add(btnlaphoadon);
		try {
			BufferedImage images=ImageIO.read(new File("img/close.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		btnnhanvien = new JButton("Nhân Viên");
		try {
			BufferedImage images=ImageIO.read(new File("img/nhanvien.png"));
			ImageIcon icon=new ImageIcon(images.getScaledInstance(25, 25, images.SCALE_SMOOTH));
			btnnhanvien.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		btnnhanvien.setForeground(Color.WHITE);
		btnnhanvien.setBounds(0, 418, 292, 58);
		pnlmenu.add(btnnhanvien);
		btnnhanvien.addActionListener(this);
		btnnhanvien.setBackground(new Color(0, 0, 205));
		btnnhanvien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("CỬA HÀNG BĂNG ĐĨA THIÊN HÀ");
		lblNewLabel.setBounds(507, 0, 674, 75);
		lblNewLabel.setBackground(new Color(240, 255, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 20, 147));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblimage = new JLabel("");
		lblimage.setBounds(822, 67, 88, 69);
		try {
			BufferedImage images=ImageIO.read(new File("img/nathana-reboucas-m-_m8FLscDg-unsplash.jpg"));
			ImageIcon icon=new ImageIcon(images.getScaledInstance(lblimage.getSize().width, lblimage.getSize().height, images.SCALE_SMOOTH));
			lblimage.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		this.getContentPane().add(lblimage);
		
		btnclose = new JButton("");
		btnclose.setBounds(310, 10, 88, 31);
		getContentPane().add(btnclose);
		try {
			BufferedImage images=ImageIO.read(new File("img/close.png"));
			ImageIcon icon=new ImageIcon(images.getScaledInstance(btnclose.getSize().width, btnclose.getSize().height, images.SCALE_SMOOTH));
			btnclose.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		btnclose.addActionListener(this);
		this.setBounds(100, 100, 1000, 554);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnlaphoadon.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source=e.getSource();
		if(source.equals(btnlaphoadon))
		{
		
			try {
				frmLapHoaDon frm = frmLapHoaDon.getGetfrmLHD();
				frm.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
		if(source.equals(btnclose))
		{
			int question=JOptionPane.showConfirmDialog(this, "Bạn muốn thoát?","Thoát",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(question==JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}
		if(source.equals(btnbangdia))
		{
			BangDia_GUI frmbd;
			try {
				frmbd = new BangDia_GUI();
				frmbd.setVisible(true);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException
					| SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(source.equals(btnkhachhang))
		{
			KhachHang_Gui khgui;
			try {
				khgui = new KhachHang_Gui();
				khgui.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(source.equals(btnalbum))
		{
			try {
				Album_GUI album=new Album_GUI();
				album.setVisible(true);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException
					| SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(source.equals(btnTheLoai))
		{
			try {
				TheLoai_GUI tlgui=new TheLoai_GUI();
				tlgui.setVisible(true);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException
					| SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(source.equals(btnnhaSX))
		{
			NhaSX_Gui nsxgui=new NhaSX_Gui();
			nsxgui.setVisible(true);
		}
		if(source.equals(btnnhanvien))
		{
			NhanVien_Gui frmnv=new NhanVien_Gui();
			frmnv.setVisible(true);
		}
		if(source.equals(btnHD))
		{
			frmHoaDon frmhd;
			try {
				frmhd = new frmHoaDon();
				frmhd.setVisible(true);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
}
