package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.Account;
import model.KhachHang;
import view.View;

public class ChangePinController implements ActionListener {
    View view;
	Account acc1 = new Account("9999", "1234", 123);
	LocalDate ngaySinh1 = LocalDate.of(2004, 6, 24);
	KhachHang khachHang1 = new KhachHang("KH01", "Le Trong Nghia", ngaySinh1, "Tây Hồ, Hà Nội",
			"999999999", "01230123", "trongnghia@gmail.com", acc1);
	Account acc2 = new Account("1111", "1234", 111);
	LocalDate ngaySinh2 = LocalDate.of(2004, 1, 1);
	KhachHang khachHang2 = new KhachHang("KH01", "Huynh Hoai Linh", ngaySinh2, "Thu Duc, TP.HCM",
			"88888888", "223334444", "hoailinhgay@gmail.com", acc2);
    public ChangePinController(View view) {
    	this.view = view;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
	    if (src.equals("Doi Ma Pin Btn")) {
	        String maPinCu = view.getNhapMaPinTxf().getText();
	        String maPinMoi = view.getNhapPinmoiTxf().getText();
	        String maPinXacNhan = view.getXacNhanPinmoiTxf().getText();
	        if (acc1.kiemTraMaPIN(Integer.parseInt(maPinCu))) {
	            if (maPinMoi.equals(maPinXacNhan)) {
	                if (acc1.thayDoiMaPIN(Integer.parseInt(maPinCu), Integer.parseInt(maPinMoi))) {
	                    JOptionPane.showMessageDialog(view, "Đổi mã PIN thành công");
	                } else {
	                    JOptionPane.showMessageDialog(view, "Không thể đổi mã PIN. Vui lòng thử lại.");
	                }
	            } else {
	                JOptionPane.showMessageDialog(view, "Xác nhận mã PIN không đúng");
	            }
	        } else {
	            JOptionPane.showMessageDialog(view, "Mã PIN không đúng");
	        }
	    }
	}
    
}
