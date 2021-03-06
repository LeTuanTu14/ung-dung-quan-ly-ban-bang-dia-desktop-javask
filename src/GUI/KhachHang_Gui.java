package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.table.DefaultTableModel;


import DAL.KhachHang_DAO;
import DTO.KhachHang;

public class KhachHang_Gui extends JFrame implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	private JTable tableKhachHang;
	private JTextField txtTim;
	private JButton bttTim;
	private JButton bttThem;
	private JButton bttXoa;
	private JButton bttSua;
	
	private KhachHang_DAO kh_dao;
	
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSoDT;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtNgaySinh;
	private DefaultTableModel modelKhachHang;
	private JButton bttXoaTrang;
	private JLabel lblNgaySinh;
	private JTextField txtMess;
	private Image img;



	public KhachHang_Gui() throws IOException{

		
		img = Toolkit.getDefaultToolkit().createImage("Image/test2.gif");
		this.setContentPane(new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
	         public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(img, 0, 0, this);
	         }
	      });
		kh_dao = new KhachHang_DAO();
		
		setTitle("Quản lý khách hàng");
		setSize(1065, 800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel lblTieuDe;
		lblTieuDe = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.green);

		Box b = Box.createVerticalBox();

		Box b11, b1, b2, b3, b4;
		JLabel lblMaKH, lblTenKH, lblDiaChi, lblEmail;
		
		b.add(Box.createRigidArea(new Dimension(30,30)));
		b.add(b11 = Box.createHorizontalBox());
		b.add(Box.createRigidArea(new Dimension(20,20)));
		b11.add(lblTieuDe);
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaKH = new JLabel("Mã Khách Hàng"));
		lblMaKH.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaKH.setForeground(Color.red);
		b1.add(txtMaKH = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblTenKH = new JLabel("Tên Khách Hàng"));
		lblTenKH.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenKH.setForeground(Color.red);
		b2.add(txtTenKH = new JTextField());
		JLabel lblsoDT;
		b2.add(lblsoDT =new JLabel(" Số DT"));
		lblsoDT.setFont(new Font("Arial", Font.BOLD, 14));
		lblsoDT.setForeground(Color.red);
		b2.add(txtSoDT = new JTextField());

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblDiaChi = new JLabel("Địa chỉ"));
		lblDiaChi.setFont(new Font("Arial", Font.BOLD, 14));
		lblDiaChi.setForeground(Color.red);
		b3.add(txtDiaChi = new JTextField());
		b3.add(lblEmail = new JLabel(" Email"));
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setForeground(Color.red);
		b3.add(txtEmail = new JTextField());
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblNgaySinh = new JLabel("Ngày Sinh"));
		lblNgaySinh.setFont(new Font("Arial", Font.BOLD, 14));
		lblNgaySinh.setForeground(Color.red);
		b4.add(txtNgaySinh = new JTextField());
		
		lblMaKH.setPreferredSize(lblTenKH.getPreferredSize());
		lblDiaChi.setPreferredSize(lblTenKH.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblTenKH.getPreferredSize());
		
		b.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 14));
		
		b.add(Box.createVerticalStrut(10));
		add(b, BorderLayout.NORTH);

		String[] colHeader = { "Mã Khách Hàng", "Tên Khách Hàng", "Số DT", "Địa chỉ", "Email", "Ngày sinh"};
		modelKhachHang = new DefaultTableModel(colHeader, 0);
		tableKhachHang = new JTable(modelKhachHang);
		tableKhachHang.addMouseListener(this);
		tableKhachHang.setForeground(Color.magenta);
		add(new JScrollPane(tableKhachHang), BorderLayout.CENTER);
		
		b.add(Box.createRigidArea(new Dimension(20,20)));
		b.add(new JScrollPane(tableKhachHang));
		b.add(Box.createRigidArea(new Dimension(10,10)));
		// =================================
		// doc du lieu tu database SQL vao Jtable
		DocDuLieuDatabaseVaoTable();
		
		// =================================

		b3=Box.createHorizontalBox();
		b3.add(Box.createRigidArea(new Dimension(5,5)));
		b3.add(txtTim = new JTextField(10));
		AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,2,9,0);
		txtTim.setBorder(brdr);
		
		b3.add(Box.createRigidArea(new Dimension(5,5)));
		b3.add(bttTim = new JButton("Tìm", new ImageIcon("Image/icon1.png")));
		bttTim.addActionListener(this);
		b3.add(Box.createRigidArea(new Dimension(30,30)));
		b3.add(bttThem = new JButton("Thêm", new ImageIcon("Image/icon2.png")));
		bttThem.addActionListener(this);
		b3.add(Box.createRigidArea(new Dimension(10,10)));
		b3.add(bttXoa = new JButton("Xóa", new ImageIcon("Image/icon3.png")));
		bttXoa.addActionListener(this);
		b3.add(Box.createRigidArea(new Dimension(10,10)));
		b3.add(bttSua = new JButton("Sửa", new ImageIcon("Image/icon4.png")));
		bttSua.addActionListener(this);
		b3.add(Box.createRigidArea(new Dimension(10,10)));
		b3.add(bttXoaTrang = new JButton("Xóa trắng", new ImageIcon("Image/icon5.png")));
		bttXoaTrang.addActionListener(this);
		b.add(Box.createRigidArea(new Dimension(10,10)));
		b.add(b3);
		b.add(Box.createVerticalStrut(10));
		add(b, BorderLayout.NORTH);
		
		setVisible(true);
	}
	public void DocDuLieuDatabaseVaoTable() {
		List<KhachHang> list = kh_dao.getallbdKhachHang();
		for(KhachHang kh:list) {
			modelKhachHang.addRow(new Object[] {kh.getMaKH(),kh.getTenKH(),kh.getSoDT(),kh.getDiaChi(),kh.geteMail(),kh.getNgaySinh()});
		}
	}
	public void XoaHetDuLieuDfTableMd() {
		DefaultTableModel dm = (DefaultTableModel) tableKhachHang.getModel();
		dm.getDataVector().removeAllElements();
	}
	public boolean KTTrungMa() {
		String ma = txtMaKH.getText();
		List<KhachHang> list = kh_dao.getallbdKhachHang();
		for(KhachHang kh:list) {
			if(kh.getMaKH().equals(ma))
			{
				return false;
			}
		}
		return true;
	}
	public boolean KTNgay(String t) {
		try {
			int i=0;
			String a = null,b=null,c=null;
			int a1=0,a2=0,a3=0;
			String word[]=t.split("-");
			for(String w:word)
			{
				if(i==0)
					a=w;
				else if(i==1)
					b=w;
				else if(i==2)
					c=w;
				else
					return false;
				i++;
			}
			a1=Integer.parseInt(a);
			a2=Integer.parseInt(b);
			a3=Integer.parseInt(c);
			if(a1/4==0 && a2==2 && a3>29)
						return false;
			if(a1/4!=0 && a2==2 && a3>28)
						return false;
			if((a2==1|| a2==3||a2==5||a2==7||a2==8||a2==10||a2==12)&& a3>31)
				return false;
			if((a2==4|| a2==6||a2==5||a2==9||a2==11)&& a3>30)
				return false;
			if(a1<1900 || a1>=2100)
				return false;
			if(a2>12)
				return false;
			if(a1==0 || a2==0 || a3==0)
				return false;
			return true;
			} catch (Exception e) {
				return false;
			}
	}
	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);		
	}
	public boolean ktRegex() {
		//không để rỗng //chữ thường in hoa hoặc số bất kỳ // không có ký tự nào và khoảng trắng
		if(!(txtMaKH.getText().length()>0 && txtMaKH.getText().matches("[a-zA-Z0-9]+"))){
			showMessage("Error: Ma KH không để trống và chứa khoảng trắng !!!", txtMaKH);
			return false;
		}
		//không để rỗng //chữ thường in hoa, số bất kỳ, ký tự ', chữ có dấu, khoảng trắng // Không có có tự đặc biệt trừ dấu '
		if(!(txtTenKH.getText().length()>0 && txtTenKH.getText().matches("( *[a-zA-Z0-9'Ạ-ỹÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+ *)+"))){
			showMessage("Error: Tên KH không để rỗng, là chữ thường in hoa, số bất kỳ, ký tự ', chữ có dấu, khoảng trắng, Không có có tự đặc biệt trừ dấu ' !!!", txtTenKH);
			return false;
		}
		//số điện thoại ở việt nam: +84 .... hoặc 0....
		if(!(txtSoDT.getText().length()>0 && txtSoDT.getText().matches("[(+84)0][0-9]{9}"))){
			showMessage("Error: Số điện thoại gồm 10 số và bắt đầu bằng : +84 .... hoặc 0.... !!!", txtSoDT);
			return false;
		}
		// ký tự bất kỳ không được để trống
		if(!(txtDiaChi.getText().length()>0))
		{
		showMessage("Error: Địa chỉ không để trống !!!", txtDiaChi);
		return false;
		}
		//chữ và ký tự đặc biệt là gạch dưới ,tiếp đó là @ , bất kỳ ký tự nào, dấu . , bất kỳ ký tự nào
		if(!(txtEmail.getText().length()>0 && txtEmail.getText().matches("[a-z0-9_]{3,30}@[a-z]+\\.[a-z]+"))){
			showMessage("Error: Email gồm chữ và ký tự đặc biệt là gạch dưới ,tiếp đó là @ , bất kỳ ký tự nào, dấu . , bất kỳ ký tự nào !!!", txtEmail);
			return false;
		}
			
		//không để rỗng // có dạng từ năm 1900 đến năm 2100-12-31, hàm KTNgay để tránh người dùng nhập sai ngày, Ngày hết hạn không được nhỏ hơn ngày hiện tại trên máy tính
		if(!(txtNgaySinh.getText().length()>0 && txtNgaySinh.getText().matches("[12][09][0-9][0-9]-[0-9]{1,2}-[0-9]{1,2}")  && KTNgay(txtNgaySinh.getText()))){
			showMessage("Error: Ngày sinh không để rỗng, có dạng từ năm 1900 đến năm 2100-12-31, hàm KTNgay để tránh người dùng nhập sai ngày, Ngày hết hạn không được nhỏ hơn ngày hiện tại trên máy tính !!!", txtNgaySinh);
			return false;
		}
			
	return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int dongClick = tableKhachHang.getSelectedRow();
		txtMaKH.setText((String) modelKhachHang.getValueAt(dongClick, 0));
		txtTenKH.setText((String) modelKhachHang.getValueAt(dongClick, 1));
		txtSoDT.setText((String) modelKhachHang.getValueAt(dongClick, 2));
		txtDiaChi.setText(modelKhachHang.getValueAt(dongClick, 3).toString());
		txtEmail.setText((String)modelKhachHang.getValueAt(dongClick, 4));
		txtNgaySinh.setText((String) modelKhachHang.getValueAt(dongClick, 5));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(bttThem))
		{
		try {
			if(ktRegex()){
				String maKH = txtMaKH.getText();
				String tenKH = txtTenKH.getText();
				String soDT = txtSoDT.getText();
				String diachi = txtDiaChi.getText();
				String email = txtEmail.getText();
				String nhaysinh = txtNgaySinh.getText();
				
				KhachHang kh = new KhachHang(maKH, tenKH, soDT, diachi, email, nhaysinh);
				if(KTTrungMa())
				{
					kh_dao.createKH(kh);
					modelKhachHang.addRow(new Object[] {kh.getMaKH(),kh.getTenKH(),kh.getSoDT(),kh.getDiaChi(),kh.geteMail(),kh.getNgaySinh()});
					txtMaKH.setText("");
					txtTenKH.setText("");
					txtSoDT.setText("");
					txtDiaChi.setText("");
					txtEmail.setText("");
					txtNgaySinh.setText("");
				}
				else
					JOptionPane.showMessageDialog(this, "Bị trùng mã thể loại!");
			}
			else
				JOptionPane.showMessageDialog(this, "Dữ liệu sai");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Lỗi !!");
			}
			
		}
		if(o.equals(bttXoa))
		{
			if(tableKhachHang.getSelectedRowCount()==0)
			{
				JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
			}
			int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa","Cảnh báo",JOptionPane.YES_NO_OPTION);
			if(check == JOptionPane.YES_OPTION)
			for(int i = modelKhachHang.getRowCount();i>=0;i--)
			{
				if(tableKhachHang.isRowSelected(i))
				{
					try {
						kh_dao.deleteKH((String) modelKhachHang.getValueAt(i, 0));
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					modelKhachHang.removeRow(i);
				}
			}
		}
		if(o.equals(bttXoaTrang))
		{
			txtMaKH.setEnabled(true);
			txtMaKH.setText("");
			txtTenKH.setText("");
			txtSoDT.setText("");
			txtDiaChi.setText("");
			txtEmail.setText("");
			txtNgaySinh.setText("");
			
		}
		if(o.equals(bttSua))
		{
			if(tableKhachHang.getSelectedRowCount()==0)
			{
				JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
			}
			else
			{
				if(ktRegex())
				{
				String maKH = txtMaKH.getText();
				String tenKH = txtTenKH.getText();
				String soDT = txtSoDT.getText();
				String diachi =txtDiaChi.getText();
				String email = txtEmail.getText();
				String ngaysinh = txtNgaySinh.getText();
				
				KhachHang kh = new KhachHang(maKH, tenKH, soDT, diachi, email, ngaysinh);
				try {
					JOptionPane.showMessageDialog(this, "Đã sửa "+kh_dao.updateKH(kh)+" dòng");
				} catch (HeadlessException | InstantiationException | IllegalAccessException | ClassNotFoundException
						| SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				XoaHetDuLieuDfTableMd();
				DocDuLieuDatabaseVaoTable();
				}
				else if(!ktRegex())
					JOptionPane.showMessageDialog(this, "Dữ liệu sai");
			}
		}
		if(o.equals(bttTim))
		{
			
			int flag=0;
			XoaHetDuLieuDfTableMd();
			String ma = txtTim.getText();
			List<KhachHang> list=null;
			try {
				list = kh_dao.getKhachHangTheoMaKH(ma);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(txtTim.getText().length()==0)
			{
				XoaHetDuLieuDfTableMd();
				DocDuLieuDatabaseVaoTable();
				flag=2;
				tableKhachHang.clearSelection();
			}
			for(KhachHang kh:list) {
				if(kh.getMaKH().equals(ma))
				{
					modelKhachHang.addRow(new Object[] {kh.getMaKH(),kh.getTenKH(),kh.getSoDT(),kh.getDiaChi(),kh.geteMail(),kh.getNgaySinh()});
					flag=1;
				}
			}
			if(flag==1)
				JOptionPane.showMessageDialog(this, "Đã tìm thấy");
			else if(flag==2)
				JOptionPane.showMessageDialog(this, "Trả về toàn bộ dữ liệu");
			else
				JOptionPane.showMessageDialog(this, "Không tìm thấy");
		}
		
	}

	
}
