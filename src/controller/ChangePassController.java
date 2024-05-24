package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.Account;
import model.KhachHang;
import view.View;

public class ChangePassController implements ActionListener{
    View view;
	Account acc1 = new Account("9999", "1234", 123);
	LocalDate ngaySinh1 = LocalDate.of(2004, 6, 24);
	KhachHang khachHang1 = new KhachHang("KH01", "Le Trong Nghia", ngaySinh1, "Tây Hồ, Hà Nội",
			"999999999", "01230123", "trongnghia@gmail.com", acc1);
	Account acc2 = new Account("1111", "1234", 111);
	LocalDate ngaySinh2 = LocalDate.of(2004, 1, 1);
	KhachHang khachHang2 = new KhachHang("KH01", "Huynh Hoai Linh", ngaySinh2, "Thu Duc, TP.HCM",
			"88888888", "223334444", "hoailinhgay@gmail.com", acc2);
    public ChangePassController(View view) {
		// TODO Auto-generated constructor stub
    	this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("Doi Mat Khau Btn")) {
			if(acc1.thayDoiMatKhau(view.getNhapPassTxf().getText(), view.getNhapPassmoiTxf().getText(), view.getXacNhanPassmoiTxf().getText())== true) {
				JOptionPane.showMessageDialog(view, "Đổi mật khẩu thành công");
			}else if (!acc1.getMatKhau().equals(view.getNhapPassTxf().getText())){
				JOptionPane.showMessageDialog(view, "Mật khẩu không đúng");
			}else if(!view.getNhapPassmoiTxf().getText().equals(view.getXacNhanPassmoiTxf().getText())) {
				JOptionPane.showMessageDialog(view, "Mật khẩu xác nhận không đúng");
			}
		}
	}
	
}
