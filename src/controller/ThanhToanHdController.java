package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.Account;
import model.HoaDon;
import model.HoaDonDien;
import model.HoaDonNuoc;
import model.KhachHang;
import view.View;

public class ThanhToanHdController implements ActionListener {
	Account acc1 = new Account("9999", "1234", 123);
	LocalDate ngaySinh1 = LocalDate.of(2004, 6, 24);
	KhachHang khachHang1 = new KhachHang("KH01", "Le Trong Nghia", ngaySinh1, "Tây Hồ, Hà Nội",
			"999999999", "01230123", "trongnghia@gmail.com", acc1);
	Account acc2 = new Account("1111", "1234", 111);
	LocalDate ngaySinh2 = LocalDate.of(2004, 1, 1);
	KhachHang khachHang2 = new KhachHang("KH01", "Huynh Hoai Linh", ngaySinh2, "Thu Duc, TP.HCM",
			"88888888", "223334444", "hoailinhgay@gmail.com", acc2);
	HoaDon hoaDonDien = new HoaDonDien("112233", "KH01", 100);
    HoaDon hoaDonNuoc = new HoaDonNuoc("112234","KH02", 50);
    View view;
    public ThanhToanHdController(View view) {
    	this.view = view;
    	acc1.setSoDu(500000);
    	hoaDonDien.setMaHoaDon("112233");
    	hoaDonDien.setSoTien(hoaDonDien.tinhTienHoaDon()); 
    	khachHang1.getDsHoaDon().add(hoaDonDien); 
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 String src = e.getActionCommand();
		    if (src.equals("Xac Nhan Thanh Toan Hd Btn")) {
		        String maHoaDon = view.getNhapMaHdTxf().getText();
		        HoaDon hoaDon = khachHang1.timHoaDonTheoMa(maHoaDon); 
		        if (hoaDon == null) {
		            JOptionPane.showMessageDialog(view, "Không tìm thấy hóa đơn với mã: " + maHoaDon);
		        } else if (hoaDon.getTrangThaiThanhToan()) {
		            JOptionPane.showMessageDialog(view, "Hóa đơn đã được thanh toán");
		        } else {
		            if (hoaDon.thanhToanHoaDon(khachHang1)) {
		                JOptionPane.showMessageDialog(view, "Thanh toán thành công hóa đơn. Thông tin hóa đơn:\n" + hoaDon.inHoaDon());
		            } else {
		                JOptionPane.showMessageDialog(view, "Không đủ tiền để thanh toán hóa đơn. Số tiền yêu cầu: " + hoaDon.getSoTien() + ", số tiền hiện có trong tài khoản: " + khachHang1.getAccount().getSoDu());
		            }
		        }
		    }
	}
	
}
