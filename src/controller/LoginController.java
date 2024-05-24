package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.Account;
import model.KhachHang;
import view.View;

public class LoginController implements ActionListener {
	View view;
	Account acc1 = new Account("9999", "1234", 123);
	
	LocalDate ngaySinh1 = LocalDate.of(2004, 6, 24);
	KhachHang khachHang1 = new KhachHang("KH01", "Le Trong Nghia", ngaySinh1, "Tây Hồ, Hà Nội",
			"999999999", "01230123", "trongnghia@gmail.com", acc1);
	Account acc2 = new Account("1111", "1234", 111);
	LocalDate ngaySinh2 = LocalDate.of(2004, 1, 1);
	KhachHang khachHang2 = new KhachHang("KH01", "Huynh Hoai Linh", ngaySinh2, "Thu Duc, TP.HCM",
			"88888888", "223334444", "hoailinhgay@gmail.com", acc2);
	public LoginController(View view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("Đăng Nhập")) {
			if (acc1.dangNhap(view.getAccTxf().getText(), view.getPassFld().getText()) == true) {
				JOptionPane.showMessageDialog(view, "Đăng Nhập Thành Công");
				view.showLoginFrame();
			}else {
				JOptionPane.showMessageDialog(view, "Đăng Nhập Không Thành Công");
				
			}
		}
	}
	
}
