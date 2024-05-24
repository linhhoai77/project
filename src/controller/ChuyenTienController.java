package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.Account;
import model.ChuyenTien;
import model.KhachHang;
import view.View;

public class ChuyenTienController implements ActionListener {
	View view;
	Account acc1 = new Account("9999", "1234", 123);
	
	LocalDate ngaySinh1 = LocalDate.of(2004, 6, 24);
	KhachHang khachHang1 = new KhachHang("KH01", "Le Trong Nghia", ngaySinh1, "Tây Hồ, Hà Nội",
			"999999999", "01230123", "trongnghia@gmail.com", acc1);
	Account acc2 = new Account("1111", "1234", 111);
	LocalDate ngaySinh2 = LocalDate.of(2004, 1, 1);
	KhachHang khachHang2 = new KhachHang("KH01", "Huynh Hoai Linh", ngaySinh2, "Thu Duc, TP.HCM",
			"88888888", "223334444", "hoailinhgay@gmail.com", acc2);
	ChuyenTien ct = new ChuyenTien(500, "1111", "chuyen tien");
	public ChuyenTienController(View view) {
		this.view = view;
		acc1.setSoDu(500000);
		acc1.setMaPIN(123);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	    String src = e.getActionCommand();
	    if (src.equals("Chuyển Tiền")) {
	        String maPinNhap = new String(view.getCheckPinFld().getPassword()); 
	        if (acc1.kiemTraMaPIN(Integer.parseInt(maPinNhap))) { // ktra mã pin
	            // mã pin đúng, chuyển tiền
	            ct.setSoTien(Integer.parseInt(view.getSoTienChuyenTxf().getText()));
	            if (ct.chuyenTien(khachHang1, khachHang2) == true) {
	                JOptionPane.showMessageDialog(view, "Chuyển thành công số tiền " + ct.getSoTien()+" đến tài khoản "
	                        + khachHang2.getAccount().getSoTaiKhoan()+"Số dư còn lại: " + acc1.getSoDu()+"\n"
	                		+"Lời nhắn: "+view.getLoiNhanTxf().getText());
	            } else { 
	                JOptionPane.showMessageDialog(view, "Số tiền chuyển không hợp lệ");
	            }
	        } else {
	            // mã pin sai
	            JOptionPane.showMessageDialog(view, "Mã PIN không chính xác. Vui lòng thử lại.");
	        }
	    }
	}
	
}
