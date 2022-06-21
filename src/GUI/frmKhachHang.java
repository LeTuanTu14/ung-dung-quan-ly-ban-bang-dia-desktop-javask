package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAL.KhachHang_dal;
import DTO.KhachHang_dto;

public class frmKhachHang extends JFrame implements MouseListener, ActionListener {

	private static frmKhachHang frmKH=null;
	public static frmKhachHang getFrmKh() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		if(frmKH==null)
		{
			frmKH=new frmKhachHang();
		}
		return frmKH;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtmakh;
	private JTextField txttenkh;
	private JTextField txtsodienthoai;
	private JTextField txtdiachi;
	private JTextField txtemail;
	private JTable tblKhachHang;
	private DefaultTableModel modelKH;
	private JTextField txttimsodt;
	private JButton btntimSDT;
	private JDateChooser dtngaysinh;
	private JButton btnChonKH;

	
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private frmKhachHang() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private void initialize() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		this.setBounds(100, 100, 938, 546);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Danh Sách Khách Hàng");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		this.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Mã KH:");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label.setBounds(49, 22, 97, 28);
		panel_1.add(label);
		
		txtmakh = new JTextField();
		txtmakh.setEditable(false);
		txtmakh.setColumns(10);
		txtmakh.setBounds(135, 23, 272, 28);
		panel_1.add(txtmakh);
		
		JLabel label_1 = new JLabel("Tên KH:");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_1.setBounds(49, 67, 45, 13);
		panel_1.add(label_1);
		
		txttenkh = new JTextField();
		txttenkh.setEditable(false);
		txttenkh.setColumns(10);
		txttenkh.setBounds(135, 60, 272, 28);
		panel_1.add(txttenkh);
		
		JLabel label_2 = new JLabel("Số điện thoại:");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_2.setBounds(49, 105, 76, 13);
		panel_1.add(label_2);
		
		txtsodienthoai = new JTextField();
		txtsodienthoai.setEditable(false);
		txtsodienthoai.setColumns(10);
		txtsodienthoai.setBounds(135, 98, 272, 28);
		panel_1.add(txtsodienthoai);
		
		JLabel label_3 = new JLabel("Địa chỉ:");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_3.setBounds(49, 142, 45, 13);
		panel_1.add(label_3);
		
		txtdiachi = new JTextField();
		txtdiachi.setEditable(false);
		txtdiachi.setColumns(10);
		txtdiachi.setBounds(135, 135, 272, 28);
		panel_1.add(txtdiachi);
		
		txtemail = new JTextField();
		txtemail.setEditable(false);
		txtemail.setColumns(10);
		txtemail.setBounds(634, 30, 252, 28);
		panel_1.add(txtemail);
		
		JLabel label_4 = new JLabel("Email:");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_4.setBounds(579, 37, 45, 13);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Ngày sinh:");
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label_5.setBounds(565, 82, 59, 13);
		panel_1.add(label_5);
		
		dtngaysinh = new JDateChooser();
		dtngaysinh.setBounds(634, 74, 252, 28);
		panel_1.add(dtngaysinh);
		modelKH=new DefaultTableModel(new String[] {"Mã khách hàng","Tên KH","Số điện thoại","Địa chỉ","Email","Ngày sinh"},0);
				
		List<KhachHang_dto> dskh=KhachHang_dal.getKhdal().getAllKH();
		readAllKHtoTable(dskh);
		tblKhachHang=new JTable(modelKH);
		tblKhachHang.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(tblKhachHang);
		scrollPane.setBounds(10, 208, 904, 235);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(502, 177, 67, 13);
		panel_1.add(lblNewLabel_1);
		
		txttimsodt = new JTextField();
		txttimsodt.setBounds(579, 170, 217, 28);
		panel_1.add(txttimsodt);
		txttimsodt.setColumns(10);
		
		btntimSDT = new JButton("Tìm SDT");
		btntimSDT.addActionListener(this);
		btntimSDT.setBounds(801, 167, 97, 31);
		panel_1.add(btntimSDT);
		
		btnChonKH = new JButton("Chọn KH");
		btnChonKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				KhachHang_dto kh=new KhachHang_dto();
				kh.setMaKH(tblKhachHang.getModel().getValueAt(tblKhachHang.getSelectedRow(), 0).toString());
				kh.setTenKH(tblKhachHang.getModel().getValueAt(tblKhachHang.getSelectedRow(), 1).toString());
				kh.setSoDT(tblKhachHang.getModel().getValueAt(tblKhachHang.getSelectedRow(), 2).toString());
				kh.setDiaChi(tblKhachHang.getModel().getValueAt(tblKhachHang.getSelectedRow(), 3).toString());
				kh.seteMail(tblKhachHang.getModel().getValueAt(tblKhachHang.getSelectedRow(), 4).toString());
				kh.setNgaySinh((Date)(tblKhachHang.getModel().getValueAt(tblKhachHang.getSelectedRow(), 5)));
				frmLayout_final.khlayout=kh;
				JOptionPane.showMessageDialog(btnChonKH,"Bạn đã chọn khách hàng có mã: "+ frmLayout_final.khlayout.getMaKH());
				try {
					frmLapHoaDon.getGetfrmLHD().setForKH();
					frmKhachHang.getFrmKh().setVisible(false);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnChonKH.setBounds(135, 177, 85, 21);
		panel_1.add(btnChonKH);
	}
	private void readAllKHtoTable(List<KhachHang_dto> dskh)
	{
		if(dskh.size()==0)
		{
			JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng phù hợp");
			return;
		}
		for (KhachHang_dto kh : dskh) {
			modelKH.addRow(new Object[] {kh.getMaKH(),kh.getTenKH(),kh.getSoDT(),kh.getDiaChi(),kh.geteMail(),kh.getNgaySinh()});
		}
	}
	private void DeleteAlltable()
	{
		DefaultTableModel dm=(DefaultTableModel)tblKhachHang.getModel();
		dm.getDataVector().removeAllElements();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		txtmakh.setText(tblKhachHang.getModel().getValueAt(tblKhachHang.getSelectedRow(), 0).toString());
		txttenkh.setText(tblKhachHang.getModel().getValueAt(tblKhachHang.getSelectedRow(), 1).toString());
		txtsodienthoai.setText(tblKhachHang.getModel().getValueAt(tblKhachHang.getSelectedRow(), 2).toString());
		txtdiachi.setText(tblKhachHang.getModel().getValueAt(tblKhachHang.getSelectedRow(), 3).toString());
		txtemail.setText(tblKhachHang.getModel().getValueAt(tblKhachHang.getSelectedRow(), 4).toString());
		String datevalue=tblKhachHang.getModel().getValueAt(tblKhachHang.getSelectedRow(), 5).toString();
		try {
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(datevalue);
			dtngaysinh.setDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		
		// TODO Auto-generated method stub
		Object source=e.getSource();
		if(source.equals(btntimSDT))
		{
			DeleteAlltable();
			try {
				List<KhachHang_dto> dskh=KhachHang_dal.getKhdal().getKHbySDT(txttimsodt.getText());
				readAllKHtoTable(dskh);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
