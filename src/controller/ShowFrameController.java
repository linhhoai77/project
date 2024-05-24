
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.*;
import view.*;
/**
 *
 * @author TRONG NGHIA
 */
public class ShowFrameController implements ActionListener{
    View view;
    GuiTietKiem guiTietKiem = new GuiTietKiem(1000000, 12, "Tiết kiệm"); // Tạo một khoản tiết kiệm với số tiền là 1 triệu và thời gian gửi là 12 tháng
    VayNganHang vayNganHang = new VayNganHang(1000000, 12, "Thông tin tài chính", "Mục đích vay", "123456789"); // Tạo một khoản vay với số tiền là 1 triệu và thời gian vay là 12 năm
	Account acc1 = new Account("9999", "1234", 123);
	
	LocalDate ngaySinh1 = LocalDate.of(2004, 6, 24);
	KhachHang khachHang1 = new KhachHang("KH01", "Le Trong Nghia", ngaySinh1, "Tây Hồ, Hà Nội",
			"999999999", "01230123", "trongnghia@gmail.com", acc1);
	Account acc2 = new Account("1111", "1234", 111);
	LocalDate ngaySinh2 = LocalDate.of(2004, 1, 1);
	KhachHang khachHang2 = new KhachHang("KH01", "Huynh Hoai Linh", ngaySinh2, "Thu Duc, TP.HCM",
			"88888888", "223334444", "hoailinhgay@gmail.com", acc2);
    public ShowFrameController(View view){
    	this.view = view;
    	acc1.setSoDu(500000);
    	guiTietKiem.setLaiSuatThang(0.25);
    	khachHang1.setGuiTietKiem(guiTietKiem);
    	khachHang1.setVay(vayNganHang);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Xem Sd")) {
        	JOptionPane.showMessageDialog(view, acc1.kiemTraSoDu());
		}else if (src.equals("Hóa Đơn")) {
			view.showHoaDonFrame();
		}else if (src.equals("Đổi Mật Khẩu")) {
			view.showChangePassFrame();
		}else if (src.equals("Đổi Mã PIN")) {
			view.showChangePinFrame();
		}else if (src.equals("Chuyển Tiền")) {
			view.showChuyenTienFrame();
		}else if (src.equals("Vay Tiền")) {
			view.showVaytienFrame();
		}else if (src.equals("Tiết Kiệm")) {
			view.showTietKiemFrame();
		}else if (src.equals("Xem Hd Btn")) {
			view.showXemHdFrame();
		}else if (src.equals("Thanh Toan Hd Btn")) {
			view.showThanhToanHdFrame();
		}else if (src.equals("Xem TK Btn")) { 
            JOptionPane.showMessageDialog(view, "Lãi suất tiết kiệm hàng tháng: " + khachHang1.getGuiTietKiem().getLaiSuatThang() + "%");
        }else if (src.equals("Gui TK Btn")) {
			view.showGuiTK();
		}else if (src.equals("Back Btn Gui TK")) {
			view.backBtnGuiTK();
		}else if (src.equals("Xem LS Vay Btn")) {
            JOptionPane.showMessageDialog(view, "Lãi suất vay hàng năm: " + khachHang1.getVay().getLaiSuatNam() + "%");
        }else if (src.equals("Khoi Tao Vay Btn")) {
			view.khoiTaoVayBtn();
		}
    }
    
}
