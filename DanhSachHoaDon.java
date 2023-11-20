package QuanLyQuanCF;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DanhSachHoaDon {
	private DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
	private ArrayList<HoaDon> hdon = new ArrayList<HoaDon>();
	private ArrayList<OderThucUong> danhSachHoaDon = new ArrayList<>();
	private OderThucUong oder = new OderThucUong();
	private DanhSachThucUong dsThucUong = new DanhSachThucUong();
	
	public boolean tonTaiHoaDon(String maHD) {
	    for (HoaDon hd : hdon) {
	        if (hd.getMaHD().equals(maHD)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	NhanVienDao obj = new NhanVienDao();
	public void nhap() {
		
	    Scanner sc = new Scanner(System.in);
	    System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
	    System.out.print("\u001B[35m|\u001B[31m=> Nhập Số Lượng Hóa Đơn: \u001B[34m                    |\n");
	    System.out.println("╰──────────────────────────────────────────────╯");
	    int n = sc.nextInt();
	    sc.nextLine();

	    for (int i = 0; i < n; i++) {
	        System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
	        System.out.print("\u001B[35m|\u001B[31m=> Nhập số Hóa đơn " + (i + 1) + "  \u001B[34m                        |\n");
	        System.out.println("╰──────────────────────────────────────────────╯");
	        String maHD;
	        boolean hoadonTonTai;

	        do {
	            System.out.printf("=> Nhập số Hóa đơn:");
	            maHD = sc.nextLine();
	            hoadonTonTai = tonTaiHoaDon(maHD);

	            if (hoadonTonTai) {
	                System.out.println("=> Hóa đơn đã tồn tại. Mời bạn nhập");
	            } else if (maHD.trim().isEmpty()) {
	                System.out.printf("=> Không được bỏ trống.  Mời bạn nhập");
	                hoadonTonTai = true;
	            }
	        } while (hoadonTonTai);

	        String tenHD = "HÓA ĐƠN THANH TOÁN";
	        
	        System.out.printf("=> Nhập ngày tạo: ");
	        String ngayTao;
	        do {
	            ngayTao = sc.nextLine();
	            if (ngayTao.trim().isEmpty()) {
	                System.out.println("=> Không được bỏ trống.  Mời bạn nhập");
	            }
	        } while (ngayTao.trim().isEmpty());

	        System.out.printf("=> Nhập trạng thái: ");
	        String trangThai;
	        do {
	            trangThai = sc.nextLine();
	            if (trangThai.trim().isEmpty()) {
	                System.out.println("=> Không được bỏ trống.  Mời bạn nhập");
	            }
	        } while (trangThai.trim().isEmpty());
	        System.out.printf("=> Nhập mã Khách Hàng: ");
	        String maQL = sc.nextLine();
	        System.out.printf("=> Nhập tên Khách Hàng:");
	        String hoTen = sc.nextLine();
	        System.out.printf("=> Nhập sdt Khách Hàng:");
	        String sdt = sc.nextLine();
	        HoaDon hoadon = new HoaDon(maHD, tenHD, ngayTao, trangThai, maQL, hoTen, sdt);
	       
	        hdon.add(hoadon);
	        obj.ghiFile5(hdon);
	    }
	    
	}


	
	public void docFile5() {
		hdon = obj.docFile5("d:\\hoadon3.bin");
	}
	public void luuFile5() {
		obj.ghiFile5(hdon);
		System.out.println("=> Đã lưu danh sách Hóa Đơn vào file thành công! <=");
	}
	public void hienThiHoaDon(DanhSachThucUong dsThucUong, OderThucUong oder) {
	    for (HoaDon hd : hdon) {
	        System.out.println("\u001B[36m╔═══════════════════════════════════════════╗");
	        System.out.println("║            \u001B[31mCHIDORI - XIN CẢM ƠN\u001B[36m           ║");
	        System.out.println("╠═══════════════════════════════════════════╣");
	        System.out.printf("║ \u001B[32m\u001B[36m         %-25s        ║\u001B[36m\n", hd.getTenHD());
	        System.out.printf("║ \u001B[32mSố hóa đơn\u001B[36m %-27s    ║\u001B[36m\n", hd.getMaHD());
	        System.out.printf("║ \u001B[32mNgày tạo\u001B[36m %-22s           ║\u001B[36m\n", hd.getNgayTao());
	        System.out.printf("║ \u001B[32mTổng tiền\u001B[36m   %-22s        ║\u001B[36m\n", oder.tinhTongTien(dsThucUong) + "đ");
	        System.out.printf("║ \u001B[32mTrạng thái\u001B[36m  %-25s     ║\u001B[36m\n", hd.getTrangThaiThanhToan());
	        System.out.printf("║ \u001B[32mMã Khách Hàng\u001B[36m    %-21s    ║\u001B[36m\n", hd.getMaQL());
	        System.out.printf("║ \u001B[32mTên Khách Hàng\u001B[36m    %-21s   ║\u001B[36m\n", hd.getHoTen());
	        System.out.printf("║ \u001B[32mSố điện Thoại\u001B[36m    %-21s    ║\u001B[36m\n", hd.getSdt());
	        System.out.println("╚═══════════════════════════════════════════╝\u001B[36m");

	        obj.ghiFile5(hdon);
	    }
	}



	
	public void sapXepHD() {
		Collections.sort(hdon, (hd1, hd2) -> hd1.getMaHD().compareTo(hd2.getMaHD()));
		System.out.printf("%55s\n","=> DANH SÁCH SAU KHI ĐƯỢC SẮP XẾP <=");
		System.out.printf("|%10s\t %14s\t %18s\t %14s |\n", "Số HĐ", "Tên HĐ", "Ngày Tạo", "Trạng Thái");
	    for (HoaDon hd : hdon) {
	    	System.out.println("|--------------------------------------------------------------------------------------\t|");
	        System.out.printf("|\t%-10s\t%-20s\t %-10s\t %s \t\n", hd.getMaHD(), hd.getTenHD(), hd.getNgayTao(),hd.getTrangThaiThanhToan());
	    }
	}
	
	
}
