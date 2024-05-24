package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class KhoiTaoVayController implements ActionListener {
	View view;
	Account acc1 = new Account("9999", "1234", 123);
	
	LocalDate ngaySinh1 = LocalDate.of(2004, 6, 24);
	KhachHang khachHang1 = new KhachHang("KH01", "Le Trong Nghia", ngaySinh1, "Tây Hồ, Hà Nội",
			"999999999", "01230123", "trongnghia@gmail.com", acc1);
	Account acc2 = new Account("1111", "1234", 111);
	LocalDate ngaySinh2 = LocalDate.of(2004, 1, 1);
	KhachHang khachHang2 = new KhachHang("KH01", "Huynh Hoai Linh", ngaySinh2, "Thu Duc, TP.HCM",
			"88888888", "223334444", "hoailinhgay@gmail.com", acc2);
	public KhoiTaoVayController(View view) {
        this.view = view;
    	acc1.setSoDu(500000);
		acc1.setMaPIN(123);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 String src = e.getActionCommand();
	        if (src.equals("Xac Nhan Vay Btn")) {
	            String hotenNguoiVay = view.getHotenNguoiVayTxf().getText();
	            int soTienVay = Integer.parseInt(view.getSoTienVayTxf().getText());
	            String soThangVayString = view.getSoThangVayCombobox().getSelectedItem().toString();
	            String[] parts = soThangVayString.split(" "); 
	            int soThangVay = Integer.parseInt(parts[0]); 
	            String noiDungVay = view.getNoiDungVayTxf().getText();
	            String soCCCD = view.getSoCCCDtxf().getText();
	            // tạo khoản vay mới
	            VayNganHang vayNganHang = new VayNganHang(soTienVay, soThangVay, noiDungVay, noiDungVay, soCCCD);
		        String maPin = JOptionPane.showInputDialog(view, "Vui lòng nhập mã PIN của bạn:", "Nhập mã PIN", JOptionPane.PLAIN_MESSAGE);
		        int maPIN = Integer.parseInt(maPin);
	            if (khachHang1.vayTien(vayNganHang, soCCCD, maPIN)) {
	                JOptionPane.showMessageDialog(view, "Khoản vay đã được khởi tạo thành công.");
	            } else {
	                JOptionPane.showMessageDialog(view, "Không thể khởi tạo khoản vay. Vui lòng kiểm tra lại thông tin.");
	            }
	        }
	}
	
}
