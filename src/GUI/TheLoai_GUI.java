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


import DAL.TheLoai_dao;
import DTO.TheLoai;

public class TheLoai_GUI extends JFrame implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	private JTable tableTheLoai;
	private DefaultTableModel modelTheLoai;
	private JTextField txtMaTL;
	private JTextField txtTenTL;
	private JTextField txtTim;
	private JButton bttTim;
	private JButton bttThem;
	private JButton bttXoa;
	private JButton bttSua;
	
	private TheLoai_dao tl_dao;
	private JButton bttXoaTrang;
	private Image img;
	private JButton bttQuayLai;

	public TheLoai_GUI() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		
		img = Toolkit.getDefaultToolkit().createImage("Image/test2.gif");
		this.setContentPane(new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
	         public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(img, 0, 0, this);
	         }
	      });
		tl_dao = new TheLoai_dao();
		setTitle("Quản Lý Thể Loại");
		setSize(1065, 800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel lblTieuDe;
		lblTieuDe = new JLabel("THÔNG TIN THỂ LOẠI");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.green);

		Box b = Box.createVerticalBox();

		Box b11, b1, b2,b3;
		JLabel lblMaTL, lblTenTL;

		b.add(Box.createRigidArea(new Dimension(40,40)));
		b.add(b11 = Box.createHorizontalBox());
		b.add(Box.createRigidArea(new Dimension(40,40)));
		b11.add(lblTieuDe);
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaTL = new JLabel("Mã Thể loại:   "));
		lblMaTL.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaTL.setForeground(Color.red);
		b1.add(txtMaTL = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblTenTL = new JLabel("Tên thể loại "));
		lblTenTL.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenTL.setForeground(Color.red);
		b2.add(txtTenTL = new JTextField());
		
		lblTenTL.setPreferredSize(lblMaTL.getPreferredSize());
		
		b.add(Box.createVerticalStrut(10));
		add(b, BorderLayout.NORTH);

		String[] colHeader = { "Mã Thể loại", "Tên thể loại"};
		modelTheLoai = new DefaultTableModel(colHeader, 0);
		tableTheLoai = new JTable(modelTheLoai);
		tableTheLoai.addMouseListener(this);
		tableTheLoai.setForeground(Color.magenta);
		
		b.add(Box.createRigidArea(new Dimension(40,40)));
		b.add(new JScrollPane(tableTheLoai));
		b.add(Box.createRigidArea(new Dimension(30,30)));

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
		b3.add(bttXoaTrang = new JButton("Xóa trắng", new ImageIcon("Image/icon5.png")));
		bttXoaTrang.addActionListener(this);
		
		b.add(Box.createRigidArea(new Dimension(10,10)));
		b.add(b3);
		b.add(Box.createVerticalStrut(10));
		add(b, BorderLayout.NORTH);
		setVisible(true);
	}
	public void DocDuLieuDatabaseVaoTable() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		List<TheLoai> list = tl_dao.getalltbTheLoai();
		for(TheLoai tl:list) {
			modelTheLoai.addRow(new Object[] {tl.getMaTheLoai(),tl.getTenTheLoai()});
		}
	}
	public void XoaHetDuLieuDfTableMd() {
		DefaultTableModel dm = (DefaultTableModel) tableTheLoai.getModel();
		dm.getDataVector().removeAllElements();
	}
	public boolean KTTrungMa() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String ma = txtMaTL.getText();
		List<TheLoai> list = tl_dao.getalltbTheLoai();
		for(TheLoai tl:list) {
			if(tl.getMaTheLoai().equals(ma))
			{
				return false;
			}
		}
		return true;
	}
	public boolean ktRegex() {
		//không để rỗng //chữ thường in hoa hoặc số bất kỳ // không có ký tự nào và khoảng trắng
		if(!(txtMaTL.getText().length()>0 && txtMaTL.getText().matches("[a-zA-Z0-9]+")))
		{
			return false;
		}
		//không để rỗng //chữ thường in hoa, số bất kỳ, ký tự ', chữ có dấu, khoảng trắng // Không có có tự đặc biệt trừ dấu '
		if(!(txtTenTL.getText().length()>0 && txtTenTL.getText().matches("( *[a-zA-Z0-9'Ạ-ỹÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+ *)+")))
		{
			return false;
		}
	return true;
	}
	public static void main(String[] args) throws Exception{
		new TheLoai_GUI();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		txtMaTL.setEnabled(false);
		int dongClick = tableTheLoai.getSelectedRow();
		txtMaTL.setText((String)modelTheLoai.getValueAt(dongClick, 0));
		txtTenTL.setText((String)modelTheLoai.getValueAt(dongClick, 1));	
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
			if(ktRegex())
			{
			try {
			String maTheLoai = txtMaTL.getText();
			String tenTheLoai = txtTenTL.getText();
			TheLoai tl = new TheLoai(maTheLoai, tenTheLoai);
				if(KTTrungMa())
				{
				tl_dao.create(tl);
				modelTheLoai.addRow(new Object[] {tl.getMaTheLoai(),tl.getTenTheLoai()});
				txtMaTL.setText("");
				txtTenTL.setText("");
				}
				else
					JOptionPane.showMessageDialog(this, "Bị trùng mã thể loại!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Dữ liệu bị sai");
				}
			}
			else
				JOptionPane.showMessageDialog(this, "Dữ liệu bị sai");
		}
		if(o.equals(bttXoa))
		{
			if(tableTheLoai.getSelectedRowCount()==0)
			{
				JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
			}
			int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa","Cảnh báo",JOptionPane.YES_NO_OPTION);
			if(check == JOptionPane.YES_OPTION)
			for(int i = modelTheLoai.getRowCount();i>=0;i--)
			{
				if(tableTheLoai.isRowSelected(i))
				{
					try {
						tl_dao.delete(modelTheLoai.getValueAt(i, 0).toString());
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					modelTheLoai.removeRow(i);
				}
			}
			
		}
		if(o.equals(bttXoaTrang))
		{
			txtMaTL.setEnabled(true);
			txtMaTL.setText("");
			txtTenTL.setText("");
		}
		if(o.equals(bttSua))
		{
			if(tableTheLoai.getSelectedRowCount()==0)
			{
				JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
			}
			else
			{
				TheLoai tl = new TheLoai(txtMaTL.getText(), txtTenTL.getText());
				try {
					JOptionPane.showMessageDialog(this, "Đã sửa "+tl_dao.update(tl)+" dòng");
				} catch (HeadlessException | InstantiationException | IllegalAccessException | ClassNotFoundException
						| SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				XoaHetDuLieuDfTableMd();
				try {
					DocDuLieuDatabaseVaoTable();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tableTheLoai.clearSelection();
			}
		}
		if(o.equals(bttTim))
		{
				int flag=0;
				XoaHetDuLieuDfTableMd();
				String ma = txtTim.getText();
				List<TheLoai> list=null;
				try {
					list = tl_dao.getTheLoaitheoMaTheLoai(ma);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(txtTim.getText().length()==0)
				{
					XoaHetDuLieuDfTableMd();
					try {
						DocDuLieuDatabaseVaoTable();
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					flag=2;
				}
				for(TheLoai tl:list) {
					if(tl.getMaTheLoai().equals(ma))
					{
						modelTheLoai.addRow(new Object[] {tl.getMaTheLoai(),tl.getTenTheLoai()});
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
		if(o.equals(bttQuayLai))
		{
			this.setVisible(false);
			try {
				new BangDia_GUI();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	
}
