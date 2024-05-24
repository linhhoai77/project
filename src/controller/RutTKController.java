package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import model.Account;
import model.KhachHang;
import view.View;

public class RutTKController implements ActionListener{
    private View view;
	Account acc1 = new Account("9999", "1234", 123);
	LocalDate ngaySinh1 = LocalDate.of(2004, 6, 24);
	KhachHang khachHang1 = new KhachHang("KH01", "Le Trong Nghia", ngaySinh1, "Tây Hồ, Hà Nội",
			"999999999", "01230123", "trongnghia@gmail.com", acc1);
	Account acc2 = new Account("1111", "1234", 111);
	LocalDate ngaySinh2 = LocalDate.of(2004, 1, 1);
	KhachHang khachHang2 = new KhachHang("KH01", "Huynh Hoai Linh", ngaySinh2, "Thu Duc, TP.HCM",
			"88888888", "223334444", "hoailinhgay@gmail.com", acc2);
    public RutTKController(View view) {
        this.view = view;
    	acc1.setSoDu(500000);
		acc1.setMaPIN(123);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
	    if (src.equals("Rut TK Button")) {
	    	JPasswordField passwordField = new JPasswordField();
	    	int okCxl = JOptionPane.showConfirmDialog(null, passwordField, "Vui lòng nhập mã PIN", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	    	if (okCxl == JOptionPane.OK_OPTION) {
	    	    String maPin = new String(passwordField.getPassword());
	        int maPIN = Integer.parseInt(maPin);
	        // Kiểm tra mã pin hợp lệ
	        if (khachHang1.getAccount().kiemTraMaPIN(maPIN)) {
	            int dialogResult = JOptionPane.showConfirmDialog(view, "Bạn có chắc chắn muốn rút tiết kiệm không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
	            if(dialogResult == JOptionPane.YES_OPTION){
	            	// chọn Yes thì rút tiền
	                if (khachHang1.rutTietKiem(maPIN)) {
	                    JOptionPane.showMessageDialog(view, "Rút tiết kiệm thành công. Số tiền gửi tiết kiệm và lãi suất đã được cộng dồn vào số dư tài khoản.");
	                } else {
	                    JOptionPane.showMessageDialog(view, "Không thể rút tiết kiệm. Vui lòng kiểm tra lại.");
	                }
	            }
	        } else {
	            JOptionPane.showMessageDialog(view, "Mã PIN không chính xác. Vui lòng kiểm tra lại.");
	        }
	    } 
	}
	}

}
