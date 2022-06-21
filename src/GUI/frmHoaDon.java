package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
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

import DAL.ChiTietHoaDon_DAL;
import DAL.HoaDonDAL;
import DAL.MuaBanDAL;
import DTO.ChiTietHoaDon_dto;
import DTO.LapHoaDon_dto;

public class frmHoaDon extends JFrame implements MouseListener, ActionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtmaHD;
	private JTextField txttenhd;
	private JTextField txtngayLapHD;
	private JTextField txtmanv;
	private JTextField txtkhachhang;
	private JTable tblHoaDon;
	private DefaultTableModel modelCTHD;
	private JTable tblChiTiet;
	private DefaultTableModel modelHD;
	private JButton btnupdateCTHD;
	private JButton btnxoaHoaDon;
	private JTextField txttimhoadon;


	public frmHoaDon() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private void initialize() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	
		this.setBounds(100, 100, 971, 818);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		this.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Quản lý hóa đơn");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		this.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(103, 29, 92, 34);
		panel_1.add(lblNewLabel_1);
		
		txtmaHD = new JTextField();
		txtmaHD.setEditable(false);
		txtmaHD.setBounds(190, 31, 230, 34);
		panel_1.add(txtmaHD);
		txtmaHD.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên hóa đơn:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(103, 97, 92, 34);
		panel_1.add(lblNewLabel_2);
		
		txttenhd = new JTextField();
		txttenhd.setEditable(false);
		txttenhd.setBounds(190, 99, 230, 34);
		panel_1.add(txttenhd);
		txttenhd.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày lập HD:");
		lblNewLabel_3.setBounds(526, 30, 113, 34);
		panel_1.add(lblNewLabel_3);
		
		txtngayLapHD = new JTextField();
		txtngayLapHD.setEditable(false);
		txtngayLapHD.setBounds(613, 31, 230, 34);
		panel_1.add(txtngayLapHD);
		txtngayLapHD.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nhân Viên:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(528, 104, 75, 22);
		panel_1.add(lblNewLabel_4);
		
		txtmanv = new JTextField();
		txtmanv.setEditable(false);
		txtmanv.setBounds(613, 99, 230, 34);
		panel_1.add(txtmanv);
		txtmanv.setColumns(10);
		
		txtkhachhang = new JTextField();
		txtkhachhang.setEditable(false);
		txtkhachhang.setBounds(190, 158, 230, 34);
		panel_1.add(txtkhachhang);
		txtkhachhang.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Khách Hàng:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(93, 161, 102, 24);
		panel_1.add(lblNewLabel_5);
		
		
		modelHD=new DefaultTableModel(new String[] {"Mã hóa đơn","Tên hóa đơn","Ngày lập hóa đơn","Mã nhân viên","Mã khách hàng"},0);
		List<LapHoaDon_dto> dshd=HoaDonDAL.getHoaDonDAL().getAllHD();
		readDatatoTableHD(dshd);
		tblHoaDon = new JTable(modelHD);
		tblHoaDon.addMouseListener(this);
		
		JScrollPane scrollPane = new JScrollPane(tblHoaDon);
		scrollPane.setBounds(103, 229, 812, 213);
		panel_1.add(scrollPane);
		
		modelCTHD=new DefaultTableModel(new String[] {"Mã HD","Mã BĐ","Số lượng","Ngày trả"},0);
		tblChiTiet=new JTable(modelCTHD);
		
		
		
		
		
		JScrollPane scrolltblchitiet = new JScrollPane(tblChiTiet);
		scrolltblchitiet.setBounds(103, 506, 812, 213);
		panel_1.add(scrolltblchitiet);
		
		btnupdateCTHD = new JButton("Cập nhật chi tiết");
		btnupdateCTHD.addActionListener(this);
		btnupdateCTHD.setBounds(94, 462, 124, 34);
		panel_1.add(btnupdateCTHD);
		
		btnxoaHoaDon = new JButton("Xóa hóa đơn");
		btnxoaHoaDon.addActionListener(this);
		btnxoaHoaDon.setBounds(813, 185, 102, 34);
		panel_1.add(btnxoaHoaDon);
		
		txttimhoadon = new JTextField();
		txttimhoadon.setBounds(562, 184, 195, 34);
		panel_1.add(txttimhoadon);
		txttimhoadon.setColumns(10);
		
		JButton btntimkiem = new JButton("Tìm kiếm MaHD");
		btntimkiem.setBounds(430, 185, 124, 34);
		panel_1.add(btntimkiem);
	}
	private void readDatatoTableHD(List<LapHoaDon_dto> dshd)
	{
		for (LapHoaDon_dto hd : dshd) {
			modelHD.addRow(new Object[] {hd.getMaHD(),hd.getTenHD(),hd.getNgayLapHD(),hd.getNv().getTaiKhoan(),hd.getKh().getMaKH()});
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			txtmaHD.setText(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0).toString());
			txttenhd.setText(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 1).toString());
			txtngayLapHD.setText(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 2).toString());
			txtmanv.setText(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 3).toString());
			txtkhachhang.setText(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 4).toString());
			
			List<ChiTietHoaDon_dto> dscthd=ChiTietHoaDon_DAL.getCTHD_DAL().getCTHDByHD(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0).toString());
			DeleteAlltable_CTHD();
			readDSCTHD(dscthd);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this,e2.getMessage());
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		
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
	private void DeleteAlltable_CTHD()
	{
		DefaultTableModel dm=(DefaultTableModel)tblChiTiet.getModel();
		dm.getDataVector().removeAllElements();
	}
	private void DeleteAlltable_HD()
	{
		DefaultTableModel dm=(DefaultTableModel)tblHoaDon.getModel();
		dm.getDataVector().removeAllElements();
	}
	private void readDSCTHD(List<ChiTietHoaDon_dto> dscthd) {
		for (ChiTietHoaDon_dto ct : dscthd) {
			modelCTHD.addRow(new Object[] {ct.getHoadon().getMaHD(),ct.getBangdia().getMaBD(),ct.getSoLuong(),ct.getNgayTra()});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source=e.getSource();
		if(source.equals(btnxoaHoaDon))
		{
			int question=JOptionPane.showConfirmDialog(this, "Bạn có chắc xóa hóa đơn: "+tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0).toString());
			if(question==JOptionPane.YES_OPTION)
			{
				
				
				try {
					boolean xoaHD=HoaDonDAL.getHoaDonDAL().deleteHD(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0).toString());
					if(xoaHD)
					{
						JOptionPane.showMessageDialog(this, "Đã xóa thành công hóa đơn");
						modelHD.removeRow(tblHoaDon.getSelectedRow());
					}
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
			}
		}
		if(source.equals(btnupdateCTHD))
		{
			String maHD=tblChiTiet.getValueAt(tblChiTiet.getSelectedRow(),0).toString();
			String maBD=tblChiTiet.getValueAt(tblChiTiet.getSelectedRow(), 1).toString();
			int soLuong=Integer.parseInt(tblChiTiet.getValueAt(tblChiTiet.getSelectedRow(), 2).toString());
			
			try {
				boolean updateCT = ChiTietHoaDon_DAL.getCTHD_DAL().updateCTHD(maHD, maBD, soLuong);
				if(updateCT && soLuong<=MuaBanDAL.getMuaBanDAL().getSoLuongBD(maBD))
				{
					JOptionPane.showMessageDialog(this, "Update thành công");
					MuaBanDAL.getMuaBanDAL().updateSLBangDia(maBD,MuaBanDAL.getMuaBanDAL().getSoLuongBD(maBD)-soLuong);
					
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Update thất bại");
				}
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
}
