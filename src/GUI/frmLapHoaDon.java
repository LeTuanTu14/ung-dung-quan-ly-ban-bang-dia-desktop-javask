package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import DAL.AlbumDAL;
import DAL.ChiTietHoaDon_DAL;
import DAL.HoaDonDAL;
import DAL.MuaBanDAL;
import DAL.NhaSXDAL_cbo;
import DAL.TheLoaiDAL_cbo;
import DTO.AlbumDTO;
import DTO.ChiTietBangDia_HoaDonDTO;
import DTO.ChiTietHoaDon_dto;
import DTO.KhachHang_dto;
import DTO.LapHoaDon_dto;
import DTO.NhaSXDTO_cbo;
import DTO.NhanVienDTO;
import DTO.TheLoaiDTO_cbo;

public class frmLapHoaDon extends JFrame implements ActionListener, TableModelListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private JFrame frame;
	private JTextField txtmahd;
	private JTextField txttenNV;
	private JTextField txttenKH;
	private JTextField txtsoDT;
	private JTextField txtdiachi;
	private JTextField txtemailkh;
	private DefaultTableModel modelTable;
	private JTable tblBangDia;
	private JTextField txttongtien;
	private JTextField txttienthue;
	private JTextField txtsotientra;
	private JTextField txtngayLapHD;
	private JTextField txtmaKH;
	private JDateChooser dtNgaySinhKH;
	private JButton btntimKH;
	private JComboBox cboAlbum;
	private JComboBox cbotheloai;
	private JComboBox cbonhaSX;
	private JLabel lbltenHD;

	private JTextField txttimtheoten;

	private JButton btntimtheoten;

	private static frmLapHoaDon getfrmLHD=null;
	private JButton btnTinhTien;
	private JButton btnchotdia;
	private JButton btnLuu;
	public static frmLapHoaDon getGetfrmLHD() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {
		if(getfrmLHD==null)
		{
			getfrmLHD=new frmLapHoaDon();
		}
		return getfrmLHD;
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private frmLapHoaDon() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private void initialize() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, Exception {
		//frame = new JFrame();
		this.setBounds(100, 100, 1288, 678);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setDefaultCloseOperation(frmKhachHang.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		
		JPanel pnltop = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnltop.getLayout();
		flowLayout.setAlignOnBaseline(true);
		pnltop.setBounds(0, 0, 1274, 48);
		pnltop.setBackground(new Color(240, 255, 240));
		this.getContentPane().add(pnltop);
		
		lbltenHD = new JLabel("Hóa Đơn Thuê Đĩa CD");
		lbltenHD.setHorizontalAlignment(SwingConstants.CENTER);
		lbltenHD.setFont(new Font("Sitka Heading", Font.BOLD, 30));
		pnltop.add(lbltenHD);
		
		JPanel pnlweast = new JPanel();
		pnlweast.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 1, true), "Thi\u00EAn H\u00E0:", TitledBorder.CENTER, TitledBorder.BOTTOM, null, Color.RED));
		pnlweast.setBounds(0, 48, 408, 170);
		
		pnlweast.setLayout(null);
		this.getContentPane().add(pnlweast);
		
		JLabel lblNewLabel = new JLabel("Mã HĐ:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 10, 97, 28);
		pnlweast.add(lblNewLabel);
		
		txtmahd = new JTextField();
		txtmahd.setEditable(false);
		txtmahd.setBounds(103, 11, 272, 28);
		
		txtmahd.setColumns(10);
		pnlweast.add(txtmahd);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày Lập HĐ:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 65, 87, 21);
		pnlweast.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mã NV:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 108, 97, 21);
		pnlweast.add(lblNewLabel_2);
		
		txttenNV = new JTextField();
		txttenNV.setEditable(false);
		txttenNV.setColumns(10);
		txttenNV.setBounds(103, 105, 272, 28);
		pnlweast.add(txttenNV);
		
		
		txtngayLapHD = new JTextField();
		txtngayLapHD.setEditable(false);
		txtngayLapHD.setBounds(103, 62, 272, 28);
		txtngayLapHD.setColumns(10);
		pnlweast.add(txtngayLapHD);
		
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLUE);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 2, true), "Kh\u00E1ch h\u00E0ng:", TitledBorder.CENTER, TitledBorder.BOTTOM, null, Color.BLUE));
		panel.setBounds(417, 48, 857, 170);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Mã KH:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 2, 97, 28);
		panel.add(lblNewLabel_3);
		
		txtmaKH = new JTextField();
		txtmaKH.setEditable(false);
		txtmaKH.setBounds(96, 3, 272, 28);
		panel.add(txtmaKH);
		txtmaKH.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tên KH:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 47, 45, 13);
		panel.add(lblNewLabel_4);
		
		txttenKH = new JTextField();
		txttenKH.setBounds(96, 40, 272, 28);
		panel.add(txttenKH);
		txttenKH.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Số điện thoại:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 85, 76, 13);
		panel.add(lblNewLabel_5);
		
		txtsoDT = new JTextField();
		txtsoDT.setBounds(96, 78, 272, 28);
		panel.add(txtsoDT);
		txtsoDT.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Địa chỉ:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 122, 45, 13);
		panel.add(lblNewLabel_6);
		
		txtdiachi = new JTextField();
		txtdiachi.setBounds(96, 115, 272, 28);
		panel.add(txtdiachi);
		txtdiachi.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(540, 17, 45, 13);
		panel.add(lblNewLabel_7);
		
		txtemailkh = new JTextField();
		txtemailkh.setBounds(595, 10, 252, 28);
		panel.add(txtemailkh);
		txtemailkh.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Ngày sinh:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(526, 62, 59, 13);
		panel.add(lblNewLabel_8);
		
		dtNgaySinhKH = new JDateChooser();
		dtNgaySinhKH.getCalendarButton().setSize(21, 28);
		dtNgaySinhKH.setBounds(595, 54, 252, 28);
		panel.add(dtNgaySinhKH);
		
		btntimKH = new JButton("Tìm KH");
		btntimKH.addActionListener(this);
		btntimKH.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		btntimKH.setBounds(374, 2, 76, 28);
		panel.add(btntimKH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 228, 1274, 297);
		
		panel_1.setLayout(null);
		
		cboAlbum = new JComboBox(); 
		cboAlbum.addItem("  -");
		List<AlbumDTO> listAlbum=AlbumDAL.getGetAlbum().getAllAlbum();
		for (AlbumDTO a : listAlbum) {
			cboAlbum.addItem(a.getMaAlbum()+"-"+a.getTenAlbum());
		}
		cboAlbum.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				DeleteAlltable();
				try {
					List<ChiTietBangDia_HoaDonDTO> listCTHD=MuaBanDAL.getMuaBanDAL().getListMuaBan(cboAlbum.getSelectedItem().toString().substring(0, cboAlbum.getSelectedItem().toString().indexOf('-')), cbonhaSX.getSelectedItem().toString().substring(0, cbonhaSX.getSelectedItem().toString().indexOf('-')), cbotheloai.getSelectedItem().toString().substring(0, cbotheloai.getSelectedItem().toString().indexOf('-')));
				
						readDatatojtable(listCTHD);
						setForCK();
						btnTinhTien.setEnabled(false);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(cboAlbum, e1.getMessage());
				}
				
			}
		});
		cboAlbum.setBounds(116, 11, 286, 29);
		panel_1.add(cboAlbum);
		
		JLabel lblNewLabel_9 = new JLabel("Album:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(38, 15, 79, 18);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Thể Loại:");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(451, 15, 93, 18);
		panel_1.add(lblNewLabel_10);
		
		cbotheloai = new JComboBox();
		cbotheloai.addItem("  -");
		List<TheLoaiDTO_cbo> listTheLoai=TheLoaiDAL_cbo.getGetTheLoaiDAL().getAllTheLoai();
		for (TheLoaiDTO_cbo tl : listTheLoai) {
			cbotheloai.addItem(tl.getMaTL()+"-"+tl.getTenTL());
		}
	
		cbotheloai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteAlltable();
				try {
					List<ChiTietBangDia_HoaDonDTO> listCTHD=MuaBanDAL.getMuaBanDAL().getListMuaBan(cboAlbum.getSelectedItem().toString().substring(0, cboAlbum.getSelectedItem().toString().indexOf('-')), cbonhaSX.getSelectedItem().toString().substring(0, cbonhaSX.getSelectedItem().toString().indexOf('-')), cbotheloai.getSelectedItem().toString().substring(0, cbotheloai.getSelectedItem().toString().indexOf('-')));
				
					readDatatojtable(listCTHD);
					setForCK();
					btnTinhTien.setEnabled(false);
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
		});
		cbotheloai.setBounds(531, 11, 286, 29);
		panel_1.add(cbotheloai);
		
		JLabel lblNewLabel_11 = new JLabel("Nhà sản xuất:");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(864, 14, 120, 21);
		panel_1.add(lblNewLabel_11);
		
		cbonhaSX = new JComboBox();
		cbonhaSX.addItem("  -");
		List<NhaSXDTO_cbo> listNSX=NhaSXDAL_cbo.getGetNSX_CBO().getAllNhaSX();
		for (NhaSXDTO_cbo nsx : listNSX) {
			cbonhaSX.addItem(nsx.getMaNSX()+"-"+nsx.getTenNSX());
		}
		
		cbonhaSX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteAlltable();
				try {
					List<ChiTietBangDia_HoaDonDTO> listCTHD=MuaBanDAL.getMuaBanDAL().getListMuaBan(cboAlbum.getSelectedItem().toString().substring(0, cboAlbum.getSelectedItem().toString().indexOf('-')), cbonhaSX.getSelectedItem().toString().substring(0, cbonhaSX.getSelectedItem().toString().indexOf('-')), cbotheloai.getSelectedItem().toString().substring(0, cbotheloai.getSelectedItem().toString().indexOf('-')));
					
					readDatatojtable(listCTHD);
					setForCK();
					btnTinhTien.setEnabled(false);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cbonhaSX.setBounds(962, 11, 286, 29);
		panel_1.add(cbonhaSX);
		
		
		
		modelTable=new DefaultTableModel(new String[] {"Chọn","Mã Băng Đĩa","Tên Băng Đĩa","Số lượng","Đơn giá","Số ngày mượn"}, 0) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
	         public Class getColumnClass(int columnIndex) {
				if(columnIndex==0)
				{
					return Boolean.class;
				}
				else
				{
					return String.class;
				}
	         }
		};
		
		tblBangDia=new JTable(modelTable);
		//tblBangDia.setBounds(0, 285, 1274, -211);
		
		tblBangDia.getModel().addTableModelListener(this);
		JScrollPane scrollPane = new JScrollPane(tblBangDia);
		scrollPane.setBounds(0, 125, 1274, 162);
		panel_1.add(scrollPane);
		
		

		
		
		JLabel lblNewLabel_15 = new JLabel("Tìm kiếm:");
		lblNewLabel_15.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(38, 88, 79, 18);
		panel_1.add(lblNewLabel_15);
		
		txttimtheoten = new JTextField();
		txttimtheoten.setBounds(116, 79, 286, 29);
		
		txttimtheoten.setColumns(10);
		panel_1.add(txttimtheoten);
		
		btntimtheoten = new JButton("Tìm theo tên");
		btntimtheoten.addActionListener(this);
		btntimtheoten.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btntimtheoten.setBounds(412, 75, 120, 36);
		panel_1.add(btntimtheoten);
		
		this.getContentPane().add(panel_1);
		
		btnTinhTien = new JButton("Tính Tiền");
		btnTinhTien.setBounds(1143, 75, 105, 31);
		panel_1.add(btnTinhTien);
		
		btnchotdia = new JButton("Chốt đĩa");
		btnchotdia.setBounds(1014, 75, 93, 29);
		panel_1.add(btnchotdia);
		txttongtien=new JTextField();
		txttongtien.setEditable(false);
		txttongtien.setBounds(138, 535, 235, 33);
		txttongtien.setColumns(10);
		this.getContentPane().add(txttongtien);
		
		
		JLabel lblNewLabel_13 = new JLabel("Tiền thuê:");
		lblNewLabel_13.setForeground(Color.RED);
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(444, 539, 66, 23);
		this.getContentPane().add(lblNewLabel_13);
		
		txttienthue = new JTextField();
		txttienthue.setEditable(false);
		txttienthue.setBounds(520, 535, 235, 33);
		txttienthue.setColumns(10);
		this.getContentPane().add(txttienthue);
		
		
		JLabel lblNewLabel_14 = new JLabel("Số tiền trả lại (Sau khi trả đĩa đúng hạn):");
		lblNewLabel_14.setForeground(Color.RED);
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(804, 534, 235, 33);
		this.getContentPane().add(lblNewLabel_14);
		
		txtsotientra = new JTextField();
		txtsotientra.setEditable(false);
		txtsotientra.setBounds(1037, 535, 186, 33);
		txtsotientra.setColumns(10);
		this.getContentPane().add(txtsotientra);
		
		
		
		///
		txtmahd.setText(HoaDonDAL.getHoaDonDAL().getMaHD());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		 LocalDateTime now = LocalDateTime.now();  
		txtngayLapHD.setText(dtf.format(now));
		
		JLabel lblNewLabel_12 = new JLabel("Tổng tiền:");
		lblNewLabel_12.setForeground(Color.RED);
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(62, 545, 66, 13);
		this.getContentPane().add(lblNewLabel_12);
		
		btnchotdia.addActionListener(this);
		btnTinhTien.setEnabled(false);
		
		btnLuu = new JButton("Lưu HĐ");
		btnLuu.addActionListener(this);
		btnLuu.setBounds(1037, 589, 97, 42);
	
		getContentPane().add(btnLuu);
		btnTinhTien.addActionListener(this);
		
		btnLuu.setEnabled(false);
		txttenNV.setText(frmLogin.taiKhoan);
		
	}
	private void chotDia() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		DeleteAlltable();
		List<ChiTietBangDia_HoaDonDTO> dsct=frmLayout_final.dsCT;
		readDatatojtable(dsct);
		setForCK();
	}
	private void readDatatojtable(List<ChiTietBangDia_HoaDonDTO> listCTHD) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		
		
		if(listCTHD.size()==0)
		{
			JOptionPane.showMessageDialog(this, "Không có đĩa CD phù hợp");
		}
		else
		{
			
			for (ChiTietBangDia_HoaDonDTO ct : listCTHD) {
				Object[] obj=new Object[6];
				obj[1]=ct.getMaBD();
				obj[2]=ct.getTenBD();
				obj[4]=ct.getDonGia();
				
				//modelTable.addRow(new Object[] {ct.getMaBD(),ct.getTenBD(),ct.getDonGia(),ct.getNgayTra()});
				modelTable.addRow(obj);
				
			}
		}
		
	}
	
	private void DeleteAlltable()
	{
		DefaultTableModel dm=(DefaultTableModel)tblBangDia.getModel();
		dm.getDataVector().removeAllElements();
	}

	public void setForKH()
	{
		txtmaKH.setText(frmLayout_final.khlayout.getMaKH());
		txttenKH.setText(frmLayout_final.khlayout.getTenKH());
		txtsoDT.setText(frmLayout_final.khlayout.getSoDT());
		txtdiachi.setText(frmLayout_final.khlayout.getDiaChi());
		txtemailkh.setText(frmLayout_final.khlayout.geteMail());
		dtNgaySinhKH.setDate(frmLayout_final.khlayout.getNgaySinh());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source=e.getSource();
		if(source.equals(btntimKH))
		{
			frmKhachHang frmKH;
			try {
				frmKH = frmKhachHang.getFrmKh();
				frmKH.setVisible(true);
				btnTinhTien.setEnabled(false);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(source.equals(btntimtheoten))
		{
			
			List<ChiTietBangDia_HoaDonDTO> cthd;
			try {
				cthd = MuaBanDAL.getMuaBanDAL().getBDbyName(txttimtheoten.getText());
				DeleteAlltable();
				readDatatojtable(cthd);
				setForCK();
				btnTinhTien.setEnabled(false);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(source.equals(btnchotdia))
		{
			try {
				chotDia();
				btnTinhTien.setEnabled(true);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(source.equals(btnTinhTien))
		{
			try {
				
				Double tongTien=(double) 0;
				for(int i=0;i<tblBangDia.getRowCount();i++)
				{
					long songaymuon=Long.parseLong(tblBangDia.getValueAt(i, 5).toString());
					if(songaymuon<=0 || songaymuon>=60)
					{
						JOptionPane.showMessageDialog(this, "Số ngày mượn phải lớn hơn 0 và <60 ngày");
						return;
					}
					int soLuong=Integer.parseInt( tblBangDia.getModel().getValueAt(i, 3).toString());
					if(soLuong>MuaBanDAL.getMuaBanDAL().getSoLuongBD(tblBangDia.getValueAt(i, 1).toString()))
					{
						JOptionPane.showMessageDialog(this, "Số lượng tối đa của băng đĩa "+tblBangDia.getValueAt(i, 1).toString()+" chỉ còn lại "+MuaBanDAL.getMuaBanDAL().getSoLuongBD(tblBangDia.getValueAt(i, 1).toString()));
						return;
					}
					Double dongia=Double.parseDouble(tblBangDia.getModel().getValueAt(i, 4).toString());
					tongTien+=(Double)((soLuong*dongia)+(soLuong*dongia*songaymuon/100));
				}
				Locale localeVN = new Locale("vi", "VN");
			    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
			    String str1 = currencyVN.format(tongTien);
				txttongtien.setText(str1);
				
				Double tienThue=tongTien-(tongTien*0.2);
				
			    String tienthue = currencyVN.format(tienThue);
			    txttienthue.setText(tienthue);
			    
			    Double soTienTL=tongTien-tienThue;
			    String tienthua=currencyVN.format(soTienTL);
			    txtsotientra.setText(tienthua);
			    
			   
				btnTinhTien.setEnabled(false);
				btnLuu.setEnabled(true);
				
				
			} catch (NumberFormatException e3)
			{
				JOptionPane.showMessageDialog(this, e3);
				return;
			}
			
			catch (Exception e2) {
				JOptionPane.showMessageDialog(this, e2.getMessage());
				return;
			}
			
			
		}
		if(source.equals(btnLuu))
		{
			for(int i=0;i<tblBangDia.getRowCount();i++)
			{
				try {
					int soluong=Integer.parseInt(tblBangDia.getValueAt(i, 3).toString());
					long songaymuon=Long.parseLong(tblBangDia.getValueAt(i, 5).toString());
					if(songaymuon<=0 || songaymuon>=60)
					{
						JOptionPane.showMessageDialog(this, "Số ngày mượn phải lớn hơn 0 và <60 ngày");
						return;
					}
					if(soluong<=0 || soluong>MuaBanDAL.getMuaBanDAL().getSoLuongBD(tblBangDia.getValueAt(i, 1).toString()))
					{
						JOptionPane.showMessageDialog(this, "Số lượng tối đa của băng đĩa "+tblBangDia.getValueAt(i, 1).toString()+" chỉ còn lại "+MuaBanDAL.getMuaBanDAL().getSoLuongBD(tblBangDia.getValueAt(i, 1).toString()));
						return;
					}
				}catch (NumberFormatException o) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, "Số lượng và số ngày mượn phải là số nguyên");
					return;
				} 
				catch (Exception e2) {
					JOptionPane.showMessageDialog(this, e2.getMessage());
					return;
				}
			}
			LapHoaDon_dto lhd=new LapHoaDon_dto(txtmahd.getText(), lbltenHD.getText(),Date.valueOf(LocalDate.now()), new NhanVienDTO(txttenNV.getText()), new KhachHang_dto(txtmaKH.getText()));
			boolean themHD;
	
			try {
				themHD = HoaDonDAL.getHoaDonDAL().themHD(lhd);

				if(themHD)
				{
					
					ChiTietHoaDon_dto cthd;
					LocalDate local=LocalDate.now();
					for(int i=0;i<tblBangDia.getRowCount();i++)
					{
						local=local.plusDays(Long.parseLong(tblBangDia.getValueAt(i, 5).toString()));
						 cthd=new ChiTietHoaDon_dto(new LapHoaDon_dto(lhd.getMaHD()), new ChiTietBangDia_HoaDonDTO(tblBangDia.getValueAt(i, 1).toString()), Integer.parseInt(tblBangDia.getValueAt(i, 3).toString()), Date.valueOf(local));
						 local=LocalDate.now();
						 boolean themCTHD=ChiTietHoaDon_DAL.getCTHD_DAL().themCTHD(cthd);
						 if(!themCTHD)
						 {
							 JOptionPane.showMessageDialog(this, "Không thêm được chi tiết hóa đơn, vui lòng kiểm tra lại");
						
						 }
						 MuaBanDAL.getMuaBanDAL().updateSLBangDia(tblBangDia.getValueAt(i, 1).toString(),MuaBanDAL.getMuaBanDAL().getSoLuongBD(tblBangDia.getValueAt(i, 1).toString())-Integer.parseInt(tblBangDia.getValueAt(i, 3).toString()));
					}
					txtmahd.setText(HoaDonDAL.getHoaDonDAL().getMaHD());
					JOptionPane.showMessageDialog(this, "Đã tạo thành công hóa đơn: "+lhd.getMaHD());
					frmLayout_final.dsCT.clear();
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
					LocalDateTime now = LocalDateTime.now();  
					txtngayLapHD.setText(dtf.format(now));
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Tạo hóa đơn thất bại");
				}
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, e1.getMessage());
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày trả là 1 số nguyên");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
			
		}
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
	    int column = e.getColumn();
	    if (column == 0) {
	        TableModel model = (TableModel) e.getSource();
	        String columnName = model.getColumnName(column);
	        Boolean checked = (Boolean) model.getValueAt(row, column);
	        if (checked) {
	        	
	        	ChiTietBangDia_HoaDonDTO dtoct=new ChiTietBangDia_HoaDonDTO();
	        	dtoct.setMaBD((String) model.getValueAt(row, 1));
	        	dtoct.setTenBD((String) model.getValueAt(row, 2));
	        	dtoct.setDonGia(Double.parseDouble(model.getValueAt(row, 4).toString()));
	        	if(!frmLayout_final.dsCT.contains(dtoct))
	        	{
	        		frmLayout_final.dsCT.add(dtoct);
	        	}
	        	
	        	
	           
	        } else {
	        	String maBD=model.getValueAt(row, 1).toString();
	        	ChiTietBangDia_HoaDonDTO cthd=new ChiTietBangDia_HoaDonDTO(maBD);
	        	if(frmLayout_final.dsCT.contains(cthd))
	        	{
	        		frmLayout_final.dsCT.remove(cthd);
	        	}
	        	
	        
	        }
	    }
		
	}
	private void setForCK()
	{
		for(int i=0;i<tblBangDia.getRowCount();i++)
		{
			ChiTietBangDia_HoaDonDTO dtoct=new ChiTietBangDia_HoaDonDTO(tblBangDia.getValueAt(i, 1).toString());
			if(frmLayout_final.dsCT.contains(dtoct))
        	{
        		tblBangDia.getModel().setValueAt(true, i, 0);
        	}
        	
		}
	}
}

