package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import model.*;
import view.*;
import model.Account;
import model.KhachHang;
import view.View;

public class ThanhToanVayController implements ActionListener {
	View view;
	Account acc1 = new Account("9999", "1234", 123);
	LocalDate ngaySinh1 = LocalDate.of(2004, 6, 24);
	KhachHang khachHang1 = new KhachHang("KH01", "Le Trong Nghia", ngaySinh1, "Tây Hồ, Hà Nội",
			"999999999", "01230123", "trongnghia@gmail.com", acc1);
	Account acc2 = new Account("1111", "1234", 111);
	LocalDate ngaySinh2 = LocalDate.of(2004, 1, 1);
	KhachHang khachHang2 = new KhachHang("KH01", "Huynh Hoai Linh", ngaySinh2, "Thu Duc, TP.HCM",
			"88888888", "223334444", "hoailinhgay@gmail.com", acc2);
	public ThanhToanVayController(View view) {
        this.view = view;
    	acc1.setSoDu(500000);
		acc1.setMaPIN(123);
        VayNganHang vayNganHang = new VayNganHang(1000, 12, "Thông tin tài chính", "Mục đích vay", "123456789");
        khachHang1.setVay(vayNganHang);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 String src = e.getActionCommand();
	        if (src.equals("Thanh Toan Vay Btn")) {
	        	// hộp thoại yêu cầu nhập mã pin
	        	JPasswordField passwordField = new JPasswordField();
	        	int okCxl = JOptionPane.showConfirmDialog(null, passwordField, "Vui lòng nhập mã PIN", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        	if (okCxl == JOptionPane.OK_OPTION) {
	        	    String maPin = new String(passwordField.getPassword());
	        	    int maPIN = Integer.parseInt(maPin);
	            if (khachHang1.getAccount().kiemTraMaPIN(maPIN)) {
	                // hiển thị hộp thoại xác nhận thanh toán
	                int dialogResult = JOptionPane.showConfirmDialog(view, "Bạn có chắc chắn muốn thanh toán khoản vay không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
	                if(dialogResult == JOptionPane.YES_OPTION){
	                    // nếu chọn OK, thực hiện thanh toán vay
	                    if (khachHang1.traNo(maPIN)) {
	                        JOptionPane.showMessageDialog(view, "Thanh toán vay thành công. Số dư tài khoản đã được trừ đi số tiền vay.");
	                    } else {
	                        JOptionPane.showMessageDialog(view, "Không thể thanh toán vay. Vui lòng kiểm tra lại số dư tài khoản.");
	                    }
	                }
	            } else {
	                JOptionPane.showMessageDialog(view, "Mã PIN không chính xác. Vui lòng kiểm tra lại.");
	            }
	        }
	    
	}
	}
	
}
