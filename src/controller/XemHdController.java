package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.table.DefaultTableModel;

import model.*;
import view.View;

public class XemHdController implements ActionListener {
	View view;
	Account acc1 = new Account("9999", "1234", 123);
	LocalDate ngaySinh1 = LocalDate.of(2004, 6, 24);
	KhachHang khachHang1 = new KhachHang("KH01", "Le Trong Nghia", ngaySinh1, "Tây Hồ, Hà Nội",
			"999999999", "01230123", "trongnghia@gmail.com", acc1);
	Account acc2 = new Account("1111", "1234", 111);
	LocalDate ngaySinh2 = LocalDate.of(2004, 1, 1);
	KhachHang khachHang2 = new KhachHang("KH01", "Huynh Hoai Linh", ngaySinh2, "Thu Duc, TP.HCM",
			"88888888", "223334444", "hoailinhgay@gmail.com", acc2);
	HoaDonDien hoaDonDien = new HoaDonDien("112233" ,"KH01", 100);
    HoaDonNuoc hoaDonNuoc = new HoaDonNuoc("112234","KH02", 50);
	public XemHdController(View view) {
		this.view = view;
		hoaDonDien.setMaHoaDon("112233");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand(); 
		if (src.equals("Xem Hd Btn")) {
			view.showXemHdFrame();
	        Object[][] tableData = new Object[3][4];
	        tableData[0] = new Object[]{hoaDonDien.getMaHoaDon(), hoaDonDien.getSoTien(), hoaDonDien.getNgayGuiHD(), hoaDonDien.kiemTraThanhToan()};
	        tableData[1] = new Object[]{hoaDonNuoc.getMaHoaDon(), hoaDonNuoc.getSoTien(), hoaDonNuoc.getNgayGuiHD(), hoaDonNuoc.kiemTraThanhToan()};
	        String[] columnNames = {"Mã Hóa Đơn", "Số Tiền", "Ngày Gửi", "Trạng Thái Thanh Toán"};
	        view.getHoaDonTable().setModel(new DefaultTableModel(tableData, columnNames));
		}
	}
	

}
