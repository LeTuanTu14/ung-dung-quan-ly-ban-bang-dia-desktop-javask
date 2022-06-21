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


import DAL.NhaSX_DAO;
import DTO.NhaSX;

public class NhaSX_Gui extends JFrame implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	private JTable tableNhaSX;
	private JTextField txtTim;
	private JButton bttTim;
	private JButton bttThem;
	private JButton bttXoa;
	private JButton bttSua;
	
	private NhaSX_DAO nSX_dao;
	
	private JTextField txtMaNSX;
	private JTextField txtTenNSX;
	private JTextField txtDiaChi;
	private JTextField txtDT;
	private JTextField txtEmail;
	
	private DefaultTableModel modelNhaSX;
	private NhaSX_DAO nSX_Dao;
	private JButton bttXoaTrang;
	private JTextField txtMess;
	private Image img;
	private JButton bttQuayLai;

	public NhaSX_Gui() {

		
		img = Toolkit.getDefaultToolkit().createImage("Image/test2.gif");
		this.setContentPane(new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
	         public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(img, 0, 0, this);
	         }
	      });
		nSX_dao = new NhaSX_DAO();
		
		setTitle("Quản lí nhà sản xuất");
		setSize(1065, 800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel lblTieuDe;
		lblTieuDe = new JLabel("THÔNG TIN NHÀ SẢN XUẤT");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.green);

		Box b = Box.createVerticalBox();

		Box b11, b1, b2, b3;
		JLabel lblMaBD, lblTenNSX, lblSoDT, lblEmail;
		
		b.add(Box.createRigidArea(new Dimension(30,30)));
		b.add(b11 = Box.createHorizontalBox());
		b.add(Box.createRigidArea(new Dimension(30,30)));
		b11.add(lblTieuDe);
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaBD = new JLabel("Mã Nhà SX"));
		lblMaBD.setForeground(Color.red);
		lblMaBD.setFont(new Font("Arial", Font.BOLD, 14));
		b1.add(txtMaNSX = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblTenNSX = new JLabel("Tên Nhà SX"));
		lblTenNSX.setForeground(Color.red);
		lblTenNSX.setFont(new Font("Arial", Font.BOLD, 14));
		b2.add(txtTenNSX = new JTextField());
		JLabel lblDiaChi;
		b2.add(lblDiaChi =new JLabel("Địa chỉ"));
		lblDiaChi.setForeground(Color.red);
		lblDiaChi.setFont(new Font("Arial", Font.BOLD, 14));
		b2.add(txtDiaChi = new JTextField());

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lblSoDT = new JLabel("Số DT"));
		lblSoDT.setForeground(Color.red);
		lblSoDT.setFont(new Font("Arial", Font.BOLD, 14));
		b3.add(txtDT = new JTextField());
		b3.add(lblEmail = new JLabel("Email"));
		lblEmail.setForeground(Color.red);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		b3.add(txtEmail = new JTextField());

		b.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));
		
		lblMaBD.setPreferredSize(lblTenNSX.getPreferredSize());
		lblSoDT.setPreferredSize(lblTenNSX.getPreferredSize());
		
		b.add(Box.createVerticalStrut(10));
		add(b, BorderLayout.NORTH);

		String[] colHeader = { "Mã Nhà SX", "Tên Nhà SX", "Địa chỉ", "Số DT", "Email" };
		modelNhaSX = new DefaultTableModel(colHeader, 0);
		tableNhaSX = new JTable(modelNhaSX);
		tableNhaSX.addMouseListener(this);
		tableNhaSX.setForeground(Color.magenta);

		b.add(Box.createRigidArea(new Dimension(20,20)));
		b.add(new JScrollPane(tableNhaSX));
		b.add(Box.createRigidArea(new Dimension(20,20)));

		// =================================
		// doc du lieu tu database SQL vao Jtable
		DocDuLieuDatabaseVaoTable();
		
		// =================================

		b3=Box.createHorizontalBox();
		b3.add(bttQuayLai = new JButton("Quay Lại", new ImageIcon("Image/iconQuayLai.png")));
		bttQuayLai.addActionListener(this);
		b3.add(Box.createRigidArea(new Dimension(10,10)));
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
		b.add(Box.createRigidArea(new Dimension(20,20)));
		b.add(b3);
		b.add(Box.createVerticalStrut(10));
		add(b, BorderLayout.NORTH);

		setVisible(true);
		
	}
	public void DocDuLieuDatabaseVaoTable() {
		List<NhaSX> list = nSX_dao.getallbdNhaSX();
		for(NhaSX nsx:list) {
			modelNhaSX.addRow(new Object[] {nsx.getMaNSX(),nsx.getTenNSX(),nsx.getDiaChi(),nsx.getDienThoai(),nsx.geteMail()});
		}
	}
	public void XoaHetDuLieuDfTableMd() {
		DefaultTableModel dm = (DefaultTableModel) tableNhaSX.getModel();
		dm.getDataVector().removeAllElements();
	}
	public boolean KTTrungMa() {
		String ma = txtMaNSX.getText();
		List<NhaSX> list = nSX_dao.getallbdNhaSX();
		for(NhaSX msx:list) {
			if(msx.getMaNSX().equals(ma))
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
		//không để rỗng //chữ thường in hoa hoặc số bất kỳ // không có ký tự nào và khoảng trắng
		if(!(txtMaNSX.getText().length()>0 && txtMaNSX.getText().matches("[a-zA-Z0-9]+")))
		{
			showMessage("Error: Mã NSX không để rỗng, chữ thường in hoa hoặc số bất kỳ , không có ký tự nào là khoảng trắng !!!", txtMaNSX);
			return false;
			}
		//không để rỗng //chữ thường in hoa, số bất kỳ, ký tự ', chữ có dấu, khoảng trắng // Không có có tự đặc biệt trừ dấu '
		if(!(txtTenNSX.getText().length()>0 && txtTenNSX.getText().matches("( *[a-zA-Z0-9'Ạ-ỹÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+ *)+")))
		{
			showMessage("Error: Tên NSX không để rỗng ,chữ thường in hoa, số bất kỳ, ký tự ', chữ có dấu, khoảng trắng, Không có có tự đặc biệt trừ dấu ' !!!", txtTenNSX);
			return false;
			}
		//số điện thoại ở việt nam: +84 .... hoặc 0....
		if(!(txtDT.getText().length()>0 && txtDT.getText().matches("[(+84)0][0-9]{9}")))
		{
			showMessage("Error: Số điện thoại gồm 10 số và bắt đầu bằng : +84 .... hoặc 0.... !!!", txtDT);
			return false;
			}
		// ký tự bất kỳ không được để trống
		if(!(txtDiaChi.getText().length()>0))
		{
			showMessage("Error: Địa chỉ không để trống !!!", txtDiaChi);
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
		int dongClick = tableNhaSX.getSelectedRow();
		txtMaNSX.setText((String) modelNhaSX.getValueAt(dongClick, 0));
		txtTenNSX.setText((String) modelNhaSX.getValueAt(dongClick, 1));
		txtDiaChi.setText((String) modelNhaSX.getValueAt(dongClick, 2));
		txtDT.setText((String) modelNhaSX.getValueAt(dongClick, 3));
		txtEmail.setText((String) modelNhaSX.getValueAt(dongClick, 4));
		
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
				String mansx = txtMaNSX.getText();
				String tennsx = txtTenNSX.getText();
				String diachi = txtDiaChi.getText();
				String sodt = txtDT.getText();
				String email = txtEmail.getText();
				
				NhaSX nsx = new NhaSX(mansx, tennsx, diachi, sodt, email);
				if(KTTrungMa())
				{
					nSX_Dao.createNSX(nsx);
					modelNhaSX.addRow(new Object[] {nsx.getMaNSX(),nsx.getTenNSX(),nsx.getDiaChi(),nsx.getDienThoai(),nsx.geteMail()});
					txtMaNSX.setText("");
					txtTenNSX.setText("");
					txtDiaChi.setText("");
					txtDT.setText("");
					txtEmail.setText("");
				}
				else
				{

					JOptionPane.showMessageDialog(this, "Bị trùng mã!");
				}
			}
			else
			JOptionPane.showMessageDialog(this, "Dữ liệu sai");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Bị trùng mã!");
			}
			
		}
		if(o.equals(bttXoa))
		{
			if(tableNhaSX.getSelectedRowCount()==0)
			{
				JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
			}
			for(int i = modelNhaSX.getRowCount();i>=0;i--)
			{
				if(tableNhaSX.isRowSelected(i))
				{
					try {
						nSX_Dao.deleteNSX((String) modelNhaSX.getValueAt(i, 0));
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					modelNhaSX.removeRow(i);
				}
			}
		}
		if(o.equals(bttXoaTrang))
		{
			txtMaNSX.setEnabled(true);
			txtMaNSX.setText("");
			txtTenNSX.setText("");
			txtDiaChi.setText("");
			txtDT.setText("");
			txtEmail.setText("");
			
		}
		if(o.equals(bttSua))
		{
			if(tableNhaSX.getSelectedRowCount()==0)
			{
				JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
			}
			else
			{
				if(ktRegex())
				{
				String mansx = txtMaNSX.getText();
				String tennsx = txtTenNSX.getText();
				String diachi = txtDiaChi.getText();
				String sodt = txtDT.getText();
				String email = txtEmail.getText();
				
				NhaSX nsx = new NhaSX(mansx, tennsx, diachi, sodt, email);
				try {
					JOptionPane.showMessageDialog(this, "Đã sửa "+nSX_Dao.updateNSX(nsx)+" dòng");
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
			String ma = txtTim.getText();
			List<NhaSX> list = nSX_Dao.getallbdNhaSX();
			for(NhaSX nsx:list) {
				if(nsx.getMaNSX().equals(ma))
				{
					modelNhaSX.addRow(new Object[] {nsx.getMaNSX(),nsx.getTenNSX(),nsx.getDiaChi(),nsx.getDienThoai(),nsx.geteMail()});
					flag=1;
				}
			}
			if(flag==1)
				JOptionPane.showMessageDialog(this, "Đã tìm thấy");
			else
				JOptionPane.showMessageDialog(this, "Không tìm thấy");
		}
		if(o.equals(bttQuayLai))
		{
			this.setVisible(false);
			new NhanVien_Gui();
		}
	}

	
}
