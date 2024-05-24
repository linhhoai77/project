package controller;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class GuiTKController implements ActionListener {
    private View view;
	Account acc1 = new Account("9999", "1234", 123);
	LocalDate ngaySinh1 = LocalDate.of(2004, 6, 24);
	KhachHang khachHang1 = new KhachHang("KH01", "Le Trong Nghia", ngaySinh1, "Tây Hồ, Hà Nội",
			"999999999", "01230123", "trongnghia@gmail.com", acc1);
	Account acc2 = new Account("1111", "1234", 111);
	LocalDate ngaySinh2 = LocalDate.of(2004, 1, 1);
	KhachHang khachHang2 = new KhachHang("KH01", "Huynh Hoai Linh", ngaySinh2, "Thu Duc, TP.HCM",
			"88888888", "223334444", "hoailinhgay@gmail.com", acc2);
    public GuiTKController(View view) {
        this.view = view;
    	acc1.setSoDu(500000);
		acc1.setMaPIN(123);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Gui TK Button")) {
            int soTienGui = Integer.parseInt(view.getSoTienGuiTxf().getText());
            String soThangGuiString = view.getSoThangGuiComboBox().getItemAt(0);
            String[] parts = soThangGuiString.split(" "); 
            int soThangGui = Integer.parseInt(parts[0]); 
            String maPin = new String(view.getMaPinGuiTKTxf().getPassword());
            int maPIN = Integer.parseInt(maPin); 
            GuiTietKiem guiTietKiem = new GuiTietKiem(soTienGui, soThangGui, "Tiết kiệm");
            if (khachHang1.guiTietKiem(maPIN, guiTietKiem) == true) {
                JOptionPane.showMessageDialog(view, "Gửi tiết kiệm thành công. Số tiền gửi: " + soTienGui + ", số tháng gửi: " + soThangGui);
            } else {
                JOptionPane.showMessageDialog(view, "Không thể gửi tiết kiệm. Vui lòng kiểm tra lại số tiền, số tháng gửi và mã PIN.");
            }
        }
    }
}

