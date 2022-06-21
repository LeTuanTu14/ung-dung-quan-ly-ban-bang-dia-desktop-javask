package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

import com.toedter.calendar.JDateChooser;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;

import DAL.Album_dao;
import DTO.Album;

public class Album_GUI extends JFrame implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	private JTable tableAlbum;
	private DefaultTableModel modelAlbum;
	private JTextField txtMaAlbum;
	private JTextField txtTenAlbum;
	private JTextField txtTim;
	private JButton bttTim;
	private JButton bttThem;
	private JButton bttXoa;
	private JButton bttSua;
	
	private JTextField txtNgayRaMat;
	private Album_dao al_dao;
	private JButton bttXoaTrang;
	private JDateChooser dtcNgayRaMat;
	private Image img;
	private JButton bttQuayLai;

	public Album_GUI() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		img = Toolkit.getDefaultToolkit().createImage("Image/test2.gif");
		this.setContentPane(new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
	         public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(img, 0, 0, this);
	         }
	      });
		al_dao = new Album_dao();
		setTitle("Quản Lý Album");
		setSize(1065, 800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel lblTieuDe;
		lblTieuDe = new JLabel("THÔNG TIN ALBUM");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.green);
		Box b = Box.createVerticalBox();

		Box b11, b1, b2,b3;
		JLabel lblMaAlbum, lblTenAlbum;
		
		b.add(Box.createRigidArea(new Dimension(40,40)));
		b.add(b11 = Box.createHorizontalBox());
		b.add(Box.createRigidArea(new Dimension(40,40)));
		b11.add(lblTieuDe);
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaAlbum = new JLabel("Mã album:   "));
		lblMaAlbum.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaAlbum.setForeground(Color.red);
		b1.add(txtMaAlbum = new JTextField());
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lblTenAlbum = new JLabel("Tên album:  "));
		b2.add(txtTenAlbum = new JTextField());
		lblTenAlbum.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenAlbum.setForeground(Color.red);
		JLabel lblNgayRaMat;
		b2.add(lblNgayRaMat = new JLabel("Ngày ra mắt "));
		b2.add(txtNgayRaMat = new JTextField());
		lblNgayRaMat.setFont(new Font("Arial", Font.BOLD, 14));
		lblNgayRaMat.setForeground(Color.red);
		txtNgayRaMat.setEnabled(false);
		txtNgayRaMat.setFont(new Font("Arial", Font.BOLD, 14));
		b2.add(dtcNgayRaMat = new JDateChooser());
		dtcNgayRaMat.setDateFormatString("dd-MM-yyyy");
		
		lblMaAlbum.setPreferredSize(lblTenAlbum.getPreferredSize());

		String[] colHeader = { "Mã Album", "Tên album", "Ngày ra mắt"};
		modelAlbum = new DefaultTableModel(colHeader, 0);
		tableAlbum = new JTable(modelAlbum);
		tableAlbum.addMouseListener(this);
		tableAlbum.setForeground(Color.magenta);
		
		b.add(Box.createRigidArea(new Dimension(40,40)));
		b.add(new JScrollPane(tableAlbum));
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
		List<Album> list = al_dao.getalltbAlbum();
		for(Album al:list) {
			modelAlbum.addRow(new Object[] {al.getMaAlbum(),al.getTenAlbum(),al.getNgayRaMat()});
		}
	}
	public void XoaHetDuLieuDfTableMd() {
		DefaultTableModel dm = (DefaultTableModel) tableAlbum.getModel();
		dm.getDataVector().removeAllElements();
	}
	public boolean KTNgayRaMat() {
		
		try {
			int i=0;
			String a = null,b=null,c=null;
			int a1=0,a2=0,a3=0;
			String word[]=txtNgayRaMat.getText().split("-");
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
			if(a1>LocalDate.now().getYear())
				return false;
			if(a1==LocalDate.now().getYear() && a2>LocalDate.now().getMonthValue())
				return false;
			if(a1==LocalDate.now().getYear() && a2==LocalDate.now().getMonthValue() && a3>LocalDate.now().getDayOfMonth())
				return false;
			return true;
			} catch (Exception e) {
				return false;
			}
	}
	public boolean KTTrungMa() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String ma = txtMaAlbum.getText();
		List<Album> list = al_dao.getalltbAlbum();
		for(Album al:list) {
			if(al.getMaAlbum().equals(ma))
			{
				return false;
			}
		}
		return true;
	}
	public boolean ktRegex() {
		//không để rỗng //chữ thường in hoa hoặc số bất kỳ // không có ký tự nào và khoảng trắng
		if(!(txtMaAlbum.getText().length()>0 && txtMaAlbum.getText().matches("[a-zA-Z0-9]+")))
			return false;
		//không để rỗng //chữ thường in hoa, số bất kỳ, ký tự ', chữ có dấu, khoảng trắng // Không có có tự đặc biệt trừ dấu '
		if(!(txtTenAlbum.getText().length()>0 && txtTenAlbum.getText().matches("( *[a-zA-Z0-9'Ạ-ỹÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+ *)+")))
			return false;
		//không để rỗng // có dạng từ năm 1900 đến năm 2100-12-31, hàm KTNgay để tránh người dùng nhập sai ngày, Ngày ra mắt không được lớn hơn ngày hiện tại trên máy tính
		if(!(txtNgayRaMat.getText().length()>0 && txtNgayRaMat.getText().matches("[12][09][0-9][0-9]-[0-9]{1,2}-[0-9]{1,2}") && KTNgayRaMat()))
			return false;
	return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
			int dongClick = tableAlbum.getSelectedRow();
			txtMaAlbum.setText((String)modelAlbum.getValueAt(dongClick, 0));
			txtTenAlbum.setText((String)modelAlbum.getValueAt(dongClick, 1));
			txtNgayRaMat.setText((String)modelAlbum.getValueAt(dongClick, 2));

		txtMaAlbum.setEnabled(false);
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
			int flag = 0;
			try {
				DateFormat dfNgayRaMat = new SimpleDateFormat("yyyy-MM-dd");
				txtNgayRaMat.setText(dfNgayRaMat.format(dtcNgayRaMat.getDate()));
			} catch (Exception e2) {
				flag = 1;
			}
			if(ktRegex() && flag ==0)
			{
				try {
					String maAlbum = txtMaAlbum.getText();
					String tenAlbum = txtTenAlbum.getText();
					String ngayRaMat = txtNgayRaMat.getText();
					Album al = new Album(maAlbum, tenAlbum, ngayRaMat);
					if(KTTrungMa())
					{
						al_dao.create(al);
						modelAlbum.addRow(new Object[] {al.getMaAlbum(),al.getTenAlbum(),al.getNgayRaMat()});
						txtMaAlbum.setText("");
						txtTenAlbum.setText("");
						txtNgayRaMat.setText("");
					}
					else
						JOptionPane.showMessageDialog(this, "Bị trùng mã thể loại!");
				}catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Bị trùng mã thể loại!");
				}
			}
			else if(!ktRegex() && flag ==0)
				JOptionPane.showMessageDialog(this, "Dữ liệu sai");
			else
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn ngày ra mắt");
		}
		if(o.equals(bttXoa))
		{
			if(tableAlbum.getSelectedRowCount()==0)
			{
				JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
			}
			int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa","Cảnh báo",JOptionPane.YES_NO_OPTION);
			if(check == JOptionPane.YES_OPTION)
			for(int i = modelAlbum.getRowCount();i>=0;i--)
			{
				if(tableAlbum.isRowSelected(i))
				{
					try {
						al_dao.delete(modelAlbum.getValueAt(i, 0).toString());
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					modelAlbum.removeRow(i);
				}
			}
		}
		//
		if(o.equals(bttXoaTrang))
		{
			txtMaAlbum.setEnabled(true);
			txtMaAlbum.setText("");
			txtTenAlbum.setText("");
			txtNgayRaMat.setText("");
		}
		if(o.equals(bttSua))
		{
			int flag = 0;
			try {
				DateFormat dfNgayRaMat = new SimpleDateFormat("yyyy-MM-dd");
				txtNgayRaMat.setText(dfNgayRaMat.format(dtcNgayRaMat.getDate()));
			} catch (Exception e2) {
				flag =1;
			}
			if(tableAlbum.getSelectedRowCount()==0)
			{
				JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
			}
			else
			{
				if(ktRegex() && flag == 0)
				{
					String maAlbum = txtMaAlbum.getText();
					String tenAlbum = txtTenAlbum.getText();
					String ngayRaMat = txtNgayRaMat.getText();
					Album al = new Album(maAlbum, tenAlbum, ngayRaMat);
					try {
						JOptionPane.showMessageDialog(this, "Đã sửa "+al_dao.update(al)+" dòng");
					} catch (HeadlessException | InstantiationException | IllegalAccessException
							| ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					XoaHetDuLieuDfTableMd();
					try {
						DocDuLieuDatabaseVaoTable();
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tableAlbum.clearSelection();
				}
				else if(!ktRegex() && flag ==0)
					JOptionPane.showMessageDialog(this, "Dữ liệu sai");
				else
					JOptionPane.showMessageDialog(this, "Bạn chưa chọn ngày ra mắt");
			}
		}
		if(o.equals(bttTim))
		{
			int flag=0;
			XoaHetDuLieuDfTableMd();
			String ma = txtTim.getText();
			List<Album> list=null;
			try {
				list = al_dao.getTheLoaitheoMaAlbum(ma);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(txtTim.getText().length()==0)
			{
				XoaHetDuLieuDfTableMd();
				try {
					DocDuLieuDatabaseVaoTable();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flag=2;
				tableAlbum.clearSelection();
			}
			for(Album al:list) {
				if(al.getMaAlbum().equals(ma))
				{
					modelAlbum.addRow(new Object[] {al.getMaAlbum(),al.getTenAlbum(),al.getNgayRaMat()});
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
