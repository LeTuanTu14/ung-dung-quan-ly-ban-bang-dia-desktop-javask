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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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


import DAL.Album_dao;
import DAL.BangDia_dao;
import DAL.NhaSX_DAO;
import DAL.TheLoai_dao;
import DTO.Album;
import DTO.BangDia;
import DTO.NhaSX;
import DTO.TheLoai;

public class BangDia_GUI extends JFrame implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	private JTable tableBangDia;
	private JTextField txtTim;
	private JButton bttTim;
	private JButton bttThem;
	private JButton bttXoa;
	private JButton bttSua;
	
	private TheLoai_dao tl_dao;
	private Album_dao al_dao;
	private JTextField txtMaBD;
	private JTextField txttenBD;
	private JTextField txtsoLuong;
	private JTextField txtdonGia;
	private JTextField txtnoiDung;
	private JTextField txtngaySX;
	private JTextField txtngayHH;
	private DefaultTableModel modelBangDia;
	private BangDia_dao bd_dao;
	private JComboBox<String> cboTheLoai;
	private JComboBox<String> cboALbum;
	private NhaSX_DAO nsx_dao;
	private JComboBox<String> cboNhaSX;
	private JButton bttXoaTrang;
	private JDateChooser dtcNgaySX;
	private JDateChooser dtcNgayHH;
	private Image img;
	private JButton bttQuayLai;
	private JButton bttQLTheLoai;
	
	public BangDia_GUI() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		
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
		al_dao = new Album_dao();
		bd_dao = new BangDia_dao();
		nsx_dao = new NhaSX_DAO();
		setTitle("Quản Lý Băng Đĩa");
		setSize(1065, 800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel lblTieuDe;
		lblTieuDe = new JLabel("THÔNG TIN BĂNG ĐĨA");
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.green);

		Box b = Box.createVerticalBox();

		Box b11, b1, b2, b3, b4,b5;
		JLabel lblMaBD, lbltenBD, lbldonGia, lblnoiDung, lblngaySX;
		
		b.add(Box.createRigidArea(new Dimension(20,20)));
		b.add(b11 = Box.createHorizontalBox());
		b.add(Box.createRigidArea(new Dimension(20,20)));
		b11.add(lblTieuDe);
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lblMaBD = new JLabel("Mã Băng đĩa"));
		lblMaBD.setForeground(Color.red);
		lblMaBD.setFont(new Font("Arial", Font.BOLD, 14));
		b1.add(txtMaBD = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lbltenBD = new JLabel("Tên Băng đĩa"));
		lbltenBD.setForeground(Color.red);
		lbltenBD.setFont(new Font("Arial", Font.BOLD, 14));
		b2.add(txttenBD = new JTextField());
		JLabel lblsoLuong;
		b2.add(lblsoLuong = new JLabel("Số Lượng"));
		lblsoLuong.setForeground(Color.red);
		lblsoLuong.setFont(new Font("Arial", Font.BOLD, 14));
		b2.add(txtsoLuong = new JTextField());

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lbldonGia = new JLabel("Đơn giá"));
		lbldonGia.setForeground(Color.red);
		lbldonGia.setFont(new Font("Arial", Font.BOLD, 14));
		b3.add(txtdonGia = new JTextField());
		b3.add(lblnoiDung = new JLabel("Nội dung"));
		lblnoiDung.setForeground(Color.red);
		lblnoiDung.setFont(new Font("Arial", Font.BOLD, 14));
		b3.add(txtnoiDung = new JTextField());

		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lblngaySX = new JLabel("Ngày sản xuất "));
		b4.add(txtngaySX = new JTextField());
		lblngaySX.setForeground(Color.red);
		lblngaySX.setFont(new Font("Arial", Font.BOLD, 14));
		txtngaySX.setEnabled(false);
		txtngaySX.setFont(new Font("Arial", Font.BOLD, 14));
		b4.add(dtcNgaySX = new JDateChooser());
		dtcNgaySX.setDateFormatString("dd-MM-yyyy");
		JLabel lblngayHH;
		b4.add(lblngayHH = new JLabel("Ngày hết hạn"));
		lblngayHH.setForeground(Color.red);
		lblngayHH.setFont(new Font("Arial", Font.BOLD, 14));
		b4.add(txtngayHH = new JTextField());
		txtngayHH.setEnabled(false);
		txtngayHH.setFont(new Font("Arial", Font.BOLD, 14));
		b4.add(dtcNgayHH = new JDateChooser());
		dtcNgayHH.setDateFormatString("dd-MM-yyyy");
		
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		
		JLabel lblmaTL;
		b5.add(lblmaTL = new JLabel("Mã thể loại: "));
		lblmaTL.setForeground(Color.red);
		lblmaTL.setFont(new Font("Arial", Font.BOLD, 14));
		b5.add(cboTheLoai = new JComboBox<String>());
		ArrayList<TheLoai> listDB = tl_dao.getalltbTheLoai();
		for(TheLoai tl:listDB) {
			cboTheLoai.addItem(tl.getMaTheLoai());
		}
		
		JLabel lblNhaSX;
		b5.add(lblNhaSX=new JLabel("Mã Nhà sản xuất: "));
		lblNhaSX.setForeground(Color.red);
		lblNhaSX.setFont(new Font("Arial", Font.BOLD, 14));
		b5.add(cboNhaSX = new JComboBox<String>());
		ArrayList<NhaSX> listDB1 = nsx_dao.getallbdNhaSX();
		for(NhaSX nsx:listDB1) {
			cboNhaSX.addItem(nsx.getMaNSX());
		}
		
		JLabel lblALbum;
		b5.add(lblALbum=new JLabel("Mã Album: "));
		lblALbum.setForeground(Color.red);
		lblALbum.setFont(new Font("Arial", Font.BOLD, 14));
		b5.add(cboALbum = new JComboBox<String>());
		ArrayList<Album> listDB2 = al_dao.getalltbAlbum();
		for(Album al:listDB2) {
			cboALbum.addItem(al.getMaAlbum());
		}
		lblMaBD.setPreferredSize(lblngaySX.getPreferredSize());
		lbltenBD.setPreferredSize(lblngaySX.getPreferredSize());
		lblngaySX.setPreferredSize(lblngaySX.getPreferredSize());
		lbldonGia.setPreferredSize(lblngaySX.getPreferredSize());
		lblngayHH.setPreferredSize(lblngaySX.getPreferredSize());
		lblmaTL.setPreferredSize(lblngaySX.getPreferredSize());
		b.add(Box.createVerticalStrut(10));
		add(b, BorderLayout.NORTH);

		String[] colHeader = { "Mã Băng đĩa", "Tên Băng đĩa", "Số Lượng", "Đơn giá", "Nội dung", "Ngày SX", "Ngày hết hạn", "Mã thể loại", "Mã nhà sản xuất", "Mã album" };
		modelBangDia = new DefaultTableModel(colHeader, 0);
		tableBangDia = new JTable(modelBangDia);
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
		b3.add(bttQLTheLoai = new JButton("QL thể loại", new ImageIcon("Image/iconQLTL.png")));
		bttQLTheLoai.addActionListener(this);
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
		List<BangDia> list = bd_dao.getalltbBangDia();
		for(BangDia bd:list) {
			modelBangDia.addRow(new Object[] {bd.getMaBD(),bd.getTenBD(),bd.getSoLuong(),bd.getDonGia(),bd.getNoiDung(),bd.getNgaySX(),bd.getNgayHH(),bd.getMaTL(),bd.getMaNSX(),bd.getMaALbum()});
		}
	}
	public void XoaHetDuLieuDfTableMd() {
		DefaultTableModel dm = (DefaultTableModel) tableBangDia.getModel();
		dm.getDataVector().removeAllElements();
	}
	public boolean KTTrungMa() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String ma = txtMaBD.getText();
		List<BangDia> list = bd_dao.getalltbBangDia();
		for(BangDia bd:list) {
			if(bd.getMaBD().equals(ma))
			{
				return false;
			}
		}
		return true;
	}
	public boolean KTNgaySanXuatSauNgayRaMatAlbum() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String ngayRaMat = null;
		String maALbum = cboALbum.getSelectedItem().toString();
		List<Album> list1 = al_dao.getTheLoaitheoMaAlbum(maALbum);
		for(Album al:list1) {
			ngayRaMat=al.getNgayRaMat();
		}
		try {
			int i=0, k =0;
			String a = null,b=null,c=null;
			String d = null,e=null,f=null;
			int a1=0,a2=0,a3=0;
			int b1=0,b2=0,b3=0;
			String word1[]=txtngaySX.getText().split("-");
			String word2[]=ngayRaMat.split("-");
			for(String w:word1)
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
			for(String w:word2)
			{
				if(k==0)
					d=w;
				else if(k==1)
					e=w;
				else if(k==2)
					f=w;
				else
					return false;
				k++;
			}
			b1=Integer.parseInt(d);
			b2=Integer.parseInt(e);
			b3=Integer.parseInt(f);
			if(a1<b1)
				return false;
			if(a1==b1 && a2<b2)
				return false;
			if(a1==b1 && a2==b2 && a3<b3)
				return false;
			return true;
			} catch (Exception e) {
				return false;
			}
	}
	public boolean KTNgaySX() {
		
		try {
			int i=0;
			String a = null,b=null,c=null;
			int a1=0,a2=0,a3=0;
			String word[]=txtngaySX.getText().split("-");
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
	public boolean KTNgayHH() {
		
		try {
			int i=0;
			String a = null,b=null,c=null;
			int a1=0,a2=0,a3=0;
			String word[]=txtngayHH.getText().split("-");
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
			if(a1<LocalDate.now().getYear())
				return false;
			if(a1==LocalDate.now().getYear() && a2<LocalDate.now().getMonthValue())
				return false;
			if(a1==LocalDate.now().getYear() && a2==LocalDate.now().getMonthValue() && a3<LocalDate.now().getDayOfMonth())
				return false;
			return true;
			} catch (Exception e) {
				return false;
			}
	}	
public boolean ktRegex() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		//không để rỗng //chữ thường in hoa hoặc số bất kỳ // không có ký tự nào và khoảng trắng
		if(!(txtMaBD.getText().length()>0 && txtMaBD.getText().matches("[a-zA-Z0-9]+")))
			return false;
		//không để rỗng //chữ thường in hoa, số bất kỳ, ký tự ', chữ có dấu, khoảng trắng // Không có có tự đặc biệt trừ dấu '
		if(!(txttenBD.getText().length()>0 && txttenBD.getText().matches("( *[a-zA-Z0-9'Ạ-ỹÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+ *)+")))
			return false;
		//Chỉ được nhập số(Giải quyết ở nút thêm)// Số lớn hơn 0
		if(Integer.parseInt(txtsoLuong.getText())<=0)
			return false;
		//Chỉ được nhập số(Giải quyết ở nút thêm)// Số lớn hơn 0
		if(Double.parseDouble(txtdonGia.getText())<=0)
			return false;
		//Ký tự bất kỳ, Không được để rỗng
		if(!(txtnoiDung.getText().length()>0))
			return false;
		//không để rỗng // có dạng từ năm 1900 đến năm 2100-12-31, hàm KTNgay để tránh người dùng nhập sai ngày, Ngày sản xuất không được lớn hơn ngày hiện tại trên máy tính
		if(!(txtngaySX.getText().length()>0 && txtngaySX.getText().matches("[12][09][0-9][0-9]-[0-9]{1,2}-[0-9]{1,2}")  && KTNgaySX()))
			return false;
		//không để rỗng // có dạng từ năm 1900 đến năm 2100-12-31, hàm KTNgay để tránh người dùng nhập sai ngày, Ngày hết hạn không được nhỏ hơn ngày hiện tại trên máy tính
		if(!(txtngayHH.getText().length()>0 && txtngayHH.getText().matches("[12][09][0-9][0-9]-[0-9]{1,2}-[0-9]{1,2}")  && KTNgayHH()))
			return false;
		if(!KTNgaySanXuatSauNgayRaMatAlbum())
			return false;
	return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int dongClick = tableBangDia.getSelectedRow();
		txtMaBD.setText((String) modelBangDia.getValueAt(dongClick, 0));
		txttenBD.setText((String) modelBangDia.getValueAt(dongClick, 1));
		txtsoLuong.setText(modelBangDia.getValueAt(dongClick, 2).toString());
		txtdonGia.setText(modelBangDia.getValueAt(dongClick, 3).toString());
		txtnoiDung.setText((String) modelBangDia.getValueAt(dongClick, 4));
		txtngaySX.setText((String) modelBangDia.getValueAt(dongClick, 5));
		txtngayHH.setText((String) modelBangDia.getValueAt(dongClick, 6));
		cboTheLoai.setSelectedItem(modelBangDia.getValueAt(dongClick, 7).toString());
		cboNhaSX.setSelectedItem(modelBangDia.getValueAt(dongClick, 8).toString());
		cboALbum.setSelectedItem(modelBangDia.getValueAt(dongClick, 9).toString());
		txtMaBD.setEnabled(false);
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
				DateFormat dfNgaySX = new SimpleDateFormat("yyyy-MM-dd");
				txtngaySX.setText(dfNgaySX.format(dtcNgaySX.getDate()));
			} catch (Exception e2) {
				flag = 1;
				
			}
			
			try {
				DateFormat dfNgayHH = new SimpleDateFormat("yyyy-MM-dd");
				txtngayHH.setText(dfNgayHH.format(dtcNgayHH.getDate()));
			} catch (Exception e2) {
				flag = 2;
				
			}
			
			try {
				if(ktRegex() && flag ==0)
				{
					try {
						String maBD = txtMaBD.getText();
						String tenBD = txttenBD.getText();
						int soLuong = Integer.parseInt(txtsoLuong.getText());
						double donGia = Double.parseDouble(txtdonGia.getText());
						String noiDung = txtnoiDung.getText();
						String ngaySX = txtngaySX.getText();
						String ngayHH = txtngayHH.getText();
						String maTL = cboTheLoai.getSelectedItem().toString();
						String maNSX = cboNhaSX.getSelectedItem().toString();
						String maALbum = cboALbum.getSelectedItem().toString();
						BangDia bd = new BangDia(maBD, tenBD, soLuong, donGia, noiDung, ngaySX, ngayHH, new TheLoai(maTL), new NhaSX(maNSX), new Album(maALbum));
						if(KTTrungMa())
						{
							bd_dao.create(bd);
							modelBangDia.addRow(new Object[] {bd.getMaBD(),bd.getTenBD(),bd.getSoLuong(),bd.getDonGia(),bd.getNoiDung(),bd.getNgaySX(),bd.getNgayHH(),bd.getMaTL(),bd.getMaNSX(),bd.getMaALbum()});
							txtMaBD.setText("");
							txttenBD.setText("");
							txtsoLuong.setText("");
							txtdonGia.setText("");
							txtnoiDung.setText("");
							txtngaySX.setText("");
							txtngayHH.setText("");
							cboTheLoai.setSelectedIndex(0);
							cboNhaSX.setSelectedIndex(0);
							cboALbum.setSelectedIndex(0);
						}
					else
						JOptionPane.showMessageDialog(this, "Bị trùng mã băng đĩa");
				
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(this, "Dữ liệu bị sai");
					}
				}
				else if(!ktRegex() && flag ==0)
					JOptionPane.showMessageDialog(this, "Dữ liệu sai");
				else if(flag == 1)
					JOptionPane.showMessageDialog(this, "Bạn chưa chọn ngày sản xuất");
				else
					JOptionPane.showMessageDialog(this, "Bạn chưa chọn ngày hết hạn");
			} catch (HeadlessException | InstantiationException | IllegalAccessException | ClassNotFoundException
					| SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
			for(int i = modelBangDia.getRowCount();i>=0;i--)
			{
				if(tableBangDia.isRowSelected(i))
				{
					try {
						bd_dao.delete(modelBangDia.getValueAt(i, 0).toString());
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					modelBangDia.removeRow(i);
				}
			}
			
			
		}
		if(o.equals(bttXoaTrang))
		{
			txtMaBD.setEnabled(true);
			txtMaBD.setText("");
			txttenBD.setText("");
			txtsoLuong.setText("");
			txtdonGia.setText("");
			txtnoiDung.setText("");
			txtngaySX.setText("");
			txtngayHH.setText("");
			cboTheLoai.setSelectedIndex(0);
			cboNhaSX.setSelectedIndex(0);
			cboALbum.setSelectedIndex(0);
		}
		if(o.equals(bttSua))
		{
			int flag = 0;
			
			try {
				DateFormat dfNgaySX = new SimpleDateFormat("yyyy-MM-dd");
				txtngaySX.setText(dfNgaySX.format(dtcNgaySX.getDate()));
			} catch (Exception e2) {
				flag = 1;
			}
			
			try {
				DateFormat dfNgayHH = new SimpleDateFormat("yyyy-MM-dd");
				txtngayHH.setText(dfNgayHH.format(dtcNgayHH.getDate()));
			} catch (Exception e2) {
				flag = 2;
			}
			
			if(tableBangDia.getSelectedRowCount()==0)
			{
				JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
			}
			else
			{
				try {
					if(ktRegex() && flag == 0)
					{
					String maBD = txtMaBD.getText();
					String tenBD = txttenBD.getText();
					int soLuong = Integer.parseInt(txtsoLuong.getText());
					double donGia = Double.parseDouble(txtdonGia.getText());
					String noiDung = txtnoiDung.getText();
					String ngaySX = txtngaySX.getText();
					String ngayHH = txtngayHH.getText();
					String maTL = cboTheLoai.getSelectedItem().toString();
					String maNSX = cboNhaSX.getSelectedItem().toString();
					String maALbum = cboALbum.getSelectedItem().toString();
					BangDia bd = new BangDia(maBD, tenBD, soLuong, donGia, noiDung, ngaySX, ngayHH, new TheLoai(maTL), new NhaSX(maNSX), new Album(maALbum));
					try {
						JOptionPane.showMessageDialog(this, "Đã sửa "+bd_dao.update(bd)+" dòng");
					} catch (HeadlessException | InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					XoaHetDuLieuDfTableMd();
					try {
						DocDuLieuDatabaseVaoTable();
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tableBangDia.clearSelection();
					}
					else if(!ktRegex() && flag ==0)
						JOptionPane.showMessageDialog(this, "Dữ liệu sai");
					else if(flag == 1)
						JOptionPane.showMessageDialog(this, "Bạn chưa chọn ngày sản xuất");
					else
						JOptionPane.showMessageDialog(this, "Bạn chưa chọn ngày hết hạn");
				} catch (NumberFormatException | HeadlessException | InstantiationException | IllegalAccessException
						| ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(o.equals(bttTim))
		{
			
			int flag=0;
			XoaHetDuLieuDfTableMd();
			String ma = txtTim.getText();
			List<BangDia> list=null;
			try {
				list = bd_dao.getTheLoaitheoMaBangDia(ma);
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
			}
			for(BangDia bd:list) {
				if(bd.getMaBD().equals(ma))
				{
					modelBangDia.addRow(new Object[] {bd.getMaBD(),bd.getTenBD(),bd.getSoLuong(),bd.getDonGia(),bd.getNoiDung(),bd.getNgaySX(),bd.getNgayHH(),bd.getMaTL(),bd.getMaNSX(),bd.getMaALbum()});
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
		if(o.equals(bttQLTheLoai))
		{
			this.setVisible(false);
			try {
				new TheLoai_GUI();
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
