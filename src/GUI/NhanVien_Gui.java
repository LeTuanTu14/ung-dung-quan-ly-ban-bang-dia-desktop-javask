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


import DAL.NhanVien_DAO;
import DTO.NhanVien;


public class NhanVien_Gui extends JFrame implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	private JTable tableBangDia;
	private JTextField txtTim;
	private JButton bttTim;
	private JButton bttThem;
	private JButton bttXoa;
	private JButton bttSua;
	
	private NhanVien_DAO nv_dao;
	private JTextField txtTaiKhoanID;
	private JTextField txtHoTen;
	private JTextField txtSoDT;
	private JTextField txtDiaChi;
	private JTextField txtMatKhau;
	private JTextField txtChucVu;
	private JTextField txtEmail;
	private DefaultTableModel modelNhanVien;
	private JButton bttXoaTrang;
	private JTextField txtMess;
	private Image img;
	private JButton bttQuayLai;
	private JButton bttNhaSX;

	public NhanVien_Gui() {

		
		img = Toolkit.getDefaultToolkit().createImage("Image/test2.gif");
		this.setContentPane(new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
	         public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(img, 0, 0, this);
	         }
	      });
		nv_dao = new NhanVien_DAO();
		
		setTitle("Quản lí nhân viên");
		setSize(1065, 800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel lblTieuDe;
		lblTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.green);

		Box b = Box.createVerticalBox();

		Box b11, b1, b2, b3, b4;
		JLabel lblMaTKID, lblTenNV, lblDiaChi, lblMatKhau, lblChucVu;
		b.add(Box.createRigidArea(new Dimension(20,20)));
		b.add(b11 = Box.createHorizontalBox());
		b.add(Box.createRigidArea(new Dimension(20,20)));
		b11.add(lblTieuDe);
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaTKID = new JLabel("Tài khoản ID"));
		lblMaTKID.setForeground(Color.red);
		lblMaTKID.setFont(new Font("Arial", Font.BOLD, 14));
		b1.add(txtTaiKhoanID = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblTenNV = new JLabel("Tên NV"));
		lblTenNV.setForeground(Color.red);
		lblTenNV.setFont(new Font("Arial", Font.BOLD, 14));
		b2.add(txtHoTen = new JTextField());
		JLabel lblSoDT;
		b2.add(lblSoDT= new JLabel("Số DT"));
		lblSoDT.setForeground(Color.red);
		lblSoDT.setFont(new Font("Arial", Font.BOLD, 14));
		b2.add(txtSoDT = new JTextField());

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblDiaChi = new JLabel("Địa chỉ"));
		lblDiaChi.setForeground(Color.red);
		lblDiaChi.setFont(new Font("Arial", Font.BOLD, 14));
		b3.add(txtDiaChi = new JTextField());
		b3.add(lblMatKhau = new JLabel("Mật khẩu"));
		lblMatKhau.setForeground(Color.red);
		lblMatKhau.setFont(new Font("Arial", Font.BOLD, 14));
		b3.add(txtMatKhau = new JTextField());

		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblChucVu = new JLabel("Chức vụ"));
		lblChucVu.setForeground(Color.red);
		lblChucVu.setFont(new Font("Arial", Font.BOLD, 14));
		b4.add(txtChucVu = new JTextField());
		JLabel lblEmail;
		b4.add(lblEmail = new JLabel("Email"));
		lblEmail.setForeground(Color.red);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		b4.add(txtEmail = new JTextField());
		
		b.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));
		
		b.add(Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		
		
		lblTenNV.setPreferredSize(lblMaTKID.getPreferredSize());
		lblMatKhau.setPreferredSize(lblMaTKID.getPreferredSize());
		lblChucVu.setPreferredSize(lblMaTKID.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMaTKID.getPreferredSize());
		lblEmail.setPreferredSize(lblMaTKID.getPreferredSize());
		b.add(Box.createVerticalStrut(10));
		add(b, BorderLayout.NORTH);

		String[] colHeader = { "Tài Khoản ID", "Tên Nhân Viên", "Số DT", "Địa chỉ", "Mật khẩu", "Chức vụ", "Email" };
		modelNhanVien = new DefaultTableModel(colHeader, 0);
		tableBangDia = new JTable(modelNhanVien);
		tableBangDia.addMouseListener(this);
		tableBangDia.setForeground(Color.magenta);
		b.add(Box.createRigidArea(new Dimension(10,10)));
		b.add(new JScrollPane(tableBangDia));
		b.add(Box.createRigidArea(new Dimension(10,10)));

		// =================================
		// doc du lieu tu database SQL vao Jtable
		DocDuLieuDatabaseVaoTable();
		
		// =================================

		b3=Box.createHorizontalBox();
		b3.add(bttQuayLai = new JButton("Quay Lại", new ImageIcon("Image/iconQuayLai.png")));
		bttQuayLai.addActionListener(this);
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
		b3.add(bttNhaSX = new JButton("Nhà sản xuất", new ImageIcon("Image/iconNhaSX.png")));
		bttNhaSX.addActionListener(this);
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
		List<NhanVien> list = nv_dao.getalltbNhanVien();
		for(NhanVien nv:list) {
			modelNhanVien.addRow(new Object[] {nv.getTaiKhoanID(),nv.getHoTen(),nv.getSoDT(),nv.getDiaChi(),nv.getMatKhau(),nv.getChucVu(),nv.geteMail()});
		}
	}
	public void XoaHetDuLieuDfTableMd() {
		DefaultTableModel dm = (DefaultTableModel) tableBangDia.getModel();
		dm.getDataVector().removeAllElements();
	}
	public boolean KTTrungMa() {
		String ma = txtTaiKhoanID.getText();
		List<NhanVien> list = nv_dao.getalltbNhanVien();
		for(NhanVien nv:list) {
			if(nv.getTaiKhoanID().equals(ma))
			{
				return false;
			}
		}
		return true;
	}
	private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);		
	}
	public boolean ktRegex() {
		//không để rỗng //chữ thường in hoa hoặc số bất kỳ // không có ký tự nào là khoảng trắng
		if(!(txtTaiKhoanID.getText().length()>0 && txtTaiKhoanID.getText().matches("[a-zA-Z0-9]+")))
			{
			showMessage("Error: Tài khoản ID không để rỗng, chữ thường in hoa hoặc số bất kỳ , không có ký tự nào là khoảng trắng !!!", txtTaiKhoanID);
			return false;
			}
		//không để rỗng //chữ thường in hoa, số bất kỳ, ký tự ', chữ có dấu, khoảng trắng // Không có có tự đặc biệt trừ dấu '
		if(!(txtHoTen.getText().length()>0 && txtHoTen.getText().matches("( *[a-zA-Z0-9'Ạ-ỹÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+ *)+")))
			{
			showMessage("Error: Họ tên không để rỗng ,chữ thường in hoa, số bất kỳ, ký tự ', chữ có dấu, khoảng trắng, Không có có tự đặc biệt trừ dấu ' !!!", txtHoTen);
			return false;
			}
		//số điện thoại ở việt nam: +84 .... hoặc 0....
		if(!(txtSoDT.getText().length()>0 && txtSoDT.getText().matches("[(+84)0][0-9]{9}")))
			{
			showMessage("Error: Số điện thoại gồm 10 số và bắt đầu bằng : +84 .... hoặc 0.... !!!", txtSoDT);
			return false;
			}
		// ký tự bất kỳ không được để trống
		if(!(txtDiaChi.getText().length()>0))
			{
			showMessage("Error: Địa chỉ không để trống !!!", txtDiaChi);
			return false;
			}
		//không để rỗng //chữ thường in hoa hoặc số bất kỳ // không có ký tự nào và khoảng trắng
		if(!(txtMatKhau.getText().length()>0 && txtMatKhau.getText().matches("[a-zA-Z0-9]+")))
			{
			showMessage("Error:Mật khẩu không để rỗng ,chữ thường in hoa hoặc số bất kỳ, không có ký tự nào và khoảng trắng !!!", txtMatKhau);
			return false;
			}
		// Quản lý hoặc là Nhân Viên
		if(!(txtChucVu.getText().length()>0 && txtChucVu.getText().matches("(Quản lý)|(Nhân Viên)")))
			{
			showMessage("Error: Chức vụ là Quản lý hoặc là Nhân Viên !!!", txtChucVu);
			return false;
			}
		//chữ và ký tự đặc biệt là gạch dưới ,tiếp đó là @ , bất kỳ ký tự nào, dấu . , bất kỳ ký tự nào
		if(!(txtEmail.getText().length()>0 && txtEmail.getText().matches("[a-z0-9_]{3,30}@[a-z]+\\.[a-z]+")))
		{
			showMessage("Error: Email gồm chữ và ký tự đặc biệt là gạch dưới ,tiếp đó là @ , bất kỳ ký tự nào, dấu . , bất kỳ ký tự nào !!!", txtEmail);
			return false;
		}
	return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int dongClick = tableBangDia.getSelectedRow();
		txtTaiKhoanID.setText((String) modelNhanVien.getValueAt(dongClick, 0));
		txtHoTen.setText((String) modelNhanVien.getValueAt(dongClick, 1));
		txtSoDT.setText((String) modelNhanVien.getValueAt(dongClick, 2));
		txtDiaChi.setText((String) modelNhanVien.getValueAt(dongClick, 3));
		txtMatKhau.setText((String) modelNhanVien.getValueAt(dongClick, 4));
		txtChucVu.setText((String) modelNhanVien.getValueAt(dongClick, 5));
		txtEmail.setText((String) modelNhanVien.getValueAt(dongClick, 6));
		
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
				String tk = txtTaiKhoanID.getText();
				String tenNV = txtHoTen.getText();
				String sodt = txtSoDT.getText();
				String diachi =txtDiaChi.getText();
				String mk = txtMatKhau.getText();
				String cv = txtChucVu.getText();
				String email = txtEmail.getText();
				
				NhanVien nv = new NhanVien(tk, tenNV, sodt, diachi, mk, cv, email);
				if(KTTrungMa())
				{
					nv_dao.createNV(nv);
					modelNhanVien.addRow(new Object[] {nv.getTaiKhoanID(),nv.getHoTen(),nv.getSoDT(),nv.getDiaChi(),nv.getMatKhau(),nv.getChucVu(),nv.geteMail()});
					txtTaiKhoanID.setText("");
					txtHoTen.setText("");
					txtSoDT.setText("");
					txtDiaChi.setText("");
					txtMatKhau.setText("");
					txtChucVu.setText("");
					txtEmail.setText("");
					
				}
				else
				{

					JOptionPane.showMessageDialog(this, "Bị trùng mã thể loại!");
				}
			}
			else
				JOptionPane.showMessageDialog(this, "Dữ liệu sai");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Lỗi !");
			}
			
		}
		if(o.equals(bttXoa))
		{
			if(tableBangDia.getSelectedRowCount()==0)
			{
				JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
			}
			int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa","Cảnh báo",JOptionPane.YES_NO_OPTION);
			if(check == JOptionPane.YES_OPTION)
			for(int i = modelNhanVien.getRowCount();i>=0;i--)
			{
				if(tableBangDia.isRowSelected(i))
				{
					try {
						nv_dao.deleteNV(modelNhanVien.getValueAt(i, 0).toString());
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					modelNhanVien.removeRow(i);
				}
			}
		}
		if(o.equals(bttXoaTrang))
		{
			txtTaiKhoanID.setEnabled(true);
			txtTaiKhoanID.setText("");
			txtHoTen.setText("");
			txtSoDT.setText("");
			txtDiaChi.setText("");
			txtMatKhau.setText("");
			txtChucVu.setText("");
			txtEmail.setText("");
			
		}
		if(o.equals(bttSua))
		{
			if(tableBangDia.getSelectedRowCount()==0)
			{
				JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
			}
			else
			{
				if(ktRegex())
				{
				String tk = txtTaiKhoanID.getText();
				String tenNV = txtHoTen.getText();
				String sodt = txtSoDT.getText();
				String diachi =txtDiaChi.getText();
				String mk = txtMatKhau.getText();
				String cv = txtChucVu.getText();
				String email = txtEmail.getText();
				
				NhanVien nv = new NhanVien(tk, tenNV, sodt, diachi, mk, cv, email);

				try {
					JOptionPane.showMessageDialog(this, "Đã sửa "+nv_dao.updateNV(nv)+" dòng");
				} catch (HeadlessException | InstantiationException | IllegalAccessException | ClassNotFoundException
						| SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				XoaHetDuLieuDfTableMd();
				DocDuLieuDatabaseVaoTable();
				}
				else
					JOptionPane.showMessageDialog(this, "Dữ liệu sai");
			}
		}
		if(o.equals(bttTim))
		{
			
			int flag=0;
			XoaHetDuLieuDfTableMd();
			String id = txtTim.getText();
			List<NhanVien> list=null;
			try {
				list = nv_dao.getNhanVienTheoTKID(id);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(NhanVien nv:list) {
				if(nv.getTaiKhoanID().equals(id))
				{
					modelNhanVien.addRow(new Object[] {nv.getTaiKhoanID(),nv.getHoTen(),nv.getSoDT(),nv.getDiaChi(),nv.getMatKhau(),nv.getChucVu(),nv.geteMail()});
					flag=1;
				}
			}
			if(flag==1)
				JOptionPane.showMessageDialog(this, "Đã tìm thấy");
			else
				JOptionPane.showMessageDialog(this, "Không tìm thấy");
		}
		
		if(o.equals(bttNhaSX))
		{
			this.setVisible(false);
			new NhaSX_Gui();
		}
	}

	
}
