package QuanLyQuanCF;

import java.util.*;

public class DanhSachKhachHangVip{
    public ArrayList<KhachHangVip> vip = new ArrayList<KhachHangVip>();
    NhanVienDao obj = new NhanVienDao();
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
		System.out.print("\u001B[35m|\u001B[31m=> Nhập số Khách Hàng: \u001B[34m                       |\n");
		System.out.println("╰──────────────────────────────────────────────╯");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
        	System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
			System.out.print("\u001B[35m|\u001B[31m=> Nhập mã Khách Hàng "+(i+1)+"  \u001B[34m                     |\n"); 
			System.out.println("╰──────────────────────────────────────────────╯");
			String maQL;
	        boolean khachHangTonTai;

	        do {
	            System.out.printf("=> Nhập Mã Khách hàng:");
	            maQL = sc.nextLine();
	            khachHangTonTai = tonTaiKhachHang(maQL);

	            if (khachHangTonTai) {
	                System.out.println("=> Khách hàng đã tồn tại. Mời bạn nhập");
	            } else if (maQL.trim().isEmpty()) {
	                System.out.printf("=> Không được bỏ trống.  Mời bạn nhập");
	                khachHangTonTai = true;
	            }
	        } while (khachHangTonTai);

            String hoTen = nhapTenCheck(sc);

            System.out.printf("=> Ngày Sinh:");
            String ngaySinh;
	        do {
	        	ngaySinh = sc.nextLine();
	            if (ngaySinh.trim().isEmpty()) {
	                System.out.println("=> Không được bỏ trống.  Mời bạn nhập");
	            }
	        } while (ngaySinh.trim().isEmpty());

            String sdt = nhapSDTCheck(sc);

            KhachHangVip kh = new KhachHangVip(maQL,hoTen, ngaySinh, sdt);
            vip.add(kh);
        }
        obj.ghiFile3(vip);
    }
    public boolean tonTaiKhachHang(String maQL) {
	    for (KhachHangVip kh : vip) {
	        if (kh.getMaQL().equals(maQL)) {
	            return true;
	        }
	    }
	    return false;
	}
    public void hienThi() {
    	System.out.printf("%87s\n","\u001B[35m╭───────────────────────────────────────╮");
		System.out.printf("%82s\n","|       => DANH SÁCH KHÁCH HÀNG <=      |");
		System.out.printf("%82s\n","╰───────────────────────────────────────╯");
		System.out.println("\u001B[36m╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.printf("|%12s\t %23s\t %33s\t %29s          |\n", "Mã KH", "Tên KH", "Ngày Sinh", "Số điện thoại");
        for (KhachHangVip kh : vip) {
        	System.out.println("|-------------------------------------------------------------------------------------------------------------------------------|");
            System.out.printf("|\t%-20s\t %-33s\t %-25s\t %-12s \t\n", kh.getMaQL(), kh.getHoTen(),kh.getNgaySinh(), kh.getSdt());
        }
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[36m");
    }
    public void docFile3() {
		vip = obj.docFile3("d:\\dskh5.bin");
	}
    public void luuFile3() {
        obj.ghiFile3(vip); 			
        System.out.println("=> Đã lưu danh sách nhân viên vào file thành công! <=");
    }
    public void themKH(KhachHangVip obj, int vt) {
        vip.add(vt, obj);
        hienThi();
    }

    public void xoaKH(String maQL) {
    	KhachHangVip khachHangCanXoa = null;
		for(KhachHangVip kh : vip) {
			if(kh.getMaQL().equals(maQL)) {
				khachHangCanXoa = kh;
				break;
			}
		}
		if(khachHangCanXoa != null) {
			vip.remove(khachHangCanXoa);
			System.out.println("=>Đã Xóa Học Phần '"+maQL+"' khỏi danh sách nhân viên<=");
		}else {
			System.out.println("=>Không tìm thấy nhân viên '"+ maQL +"' trong danh sách<=");
		}
	}

    private String nhapSDTCheck(Scanner sc) {
	    String sdt = null;
	    boolean nhapThanhCong = false;
	    String regex = "\\d+";

	    do {
	        try {
	            System.out.print("=> Nhập SĐT Khách Hàng: ");
	            sdt = sc.nextLine();

	            if (sdt.matches(regex)) {
	                nhapThanhCong = true;
	            } else {
	                System.out.println("=> SĐT chỉ được chứa số. Mời bạn nhập lại. <=");
	            }

	        } catch (Exception e) {
	            System.out.println("=> Hãy Nhập Số!. Mời bạn nhập lại. <=");
	            sc.nextLine();
	        }
	    } while (!nhapThanhCong);

	    return sdt;
	}
    
    private String nhapTenCheck(Scanner sc) {
	    String hoTen = null;
	    boolean nhapThanhCong = false;
	    
	    do {
	        try {
	            System.out.printf("=> Nhập tên Khách Hàng: ");
	            hoTen = sc.nextLine();
	            
	            if (hoTen.matches("[a-zA-Z\\p{Punct}\\s\\p{L}]+")) {
	                nhapThanhCong = true;
	            } else {
	                System.out.println("=> Tên không được chứa số. Mời bạn nhập lại <=");
	            }
	        } catch (Exception e) {
	            System.out.println("Hay Nhập Đúng Tên. Mời bạn nhập lại.");
	            sc.nextLine();
	        }
	    } while (!nhapThanhCong);
	    
	    return hoTen;
	}

}
