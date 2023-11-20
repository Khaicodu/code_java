package QuanLyQuanCF;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class DanhSachLoaiTU{
	public ArrayList<LoaiThucUong> dsltu = new ArrayList<LoaiThucUong>();
	NhanVienDao obj = new NhanVienDao();
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
		System.out.print("\u001B[35m|\u001B[31m=> Nhập số Loại Thức Uống: \u001B[34m                   |\n");
		System.out.println("╰──────────────────────────────────────────────╯");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
			System.out.print("\u001B[35m|\u001B[31m=> Nhập mã Loại Thức Uống: \u001B[34m                   |\n");
			System.out.println("╰──────────────────────────────────────────────╯");
			
			String maLoai;
	        boolean ltuTonTai;

	        do {
	            System.out.printf("=> Nhập mã Loại:");
	            maLoai = sc.nextLine();
	            ltuTonTai = tonTaiLTU(maLoai);

	            if (ltuTonTai) {
	                System.out.println("=> Mã đã tồn tại. Mời bạn nhập");
	            } else if (maLoai.trim().isEmpty()) {
	                System.out.printf("=> Không được bỏ trống.  Mời bạn nhập");
	                ltuTonTai = true;
	            }
	        } while (ltuTonTai);
	        
			String tenLOAI = nhapTenCheck(sc);

			LoaiThucUong loai = new LoaiThucUong(maLoai, tenLOAI);
			dsltu.add(loai);
		}
		obj.ghiFile2(dsltu);
	}
	
	public void docFile2() {
		dsltu = obj.docFile2("d:\\dsltu1.bin");
	}

	public boolean tonTaiLTU(String maLoai) {
	    for (LoaiThucUong loai : dsltu) {
	        if (loai.getMaLoai().equals(maLoai)) {
	            return true;
	        }
	    }
	    return false;
	}

	public void hienThi() {
		System.out.printf("%50s\n","\u001B[35m╭────────────────────────────────────────╮");
		System.out.printf("%45s\n","|     => DANH SÁCH LOẠI THỨC UỐNG <=     |");
		System.out.printf("%45s\n","╰────────────────────────────────────────╯");
		System.out.println("\u001B[36m╔══════════════════════════════════════════════╗");
		System.out.printf("|\t%10s\t %15s       |\n", "Mã Loại TU", "Tên Loại TU");
		for (LoaiThucUong loai : dsltu) {
			System.out.println("|----------------------------------------------|");
			System.out.printf("|\t%-15s\t\t%-15s\t \t\n", loai.getMaLoai(), loai.getTenLOAI());
		}
		System.out.println("╚══════════════════════════════════════════════╝\u001B[36m");
	}
	
	public void hienThiDSThucUongTheoMaLoai(DanhSachThucUong dsThucUong, String maLoai) {
	    if (dsThucUong != null && dsThucUong.dstu != null) {
	    	System.out.printf("%87s\n","\u001B[35m╭───────────────────────────────────────╮");
	        System.out.printf("%82s\n", "|=> DANH SÁCH THỨC UỐNG THEO MÃ LOẠI <= |");
	        System.out.printf("%82s\n","╰───────────────────────────────────────╯");
	        System.out.println("\u001B[36m╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
	        System.out.printf("|%18s\t %20s\t %25s\t %30s                 |\n", "Mã Thức Uống", "Tên Thức Uống", "SIZE", "Giá");
	        for (ThucUong tu : dsThucUong.dstu) {
	            if (tu.getMaLoai().equals(maLoai)) {
	            	System.out.println("|-------------------------------------------------------------------------------------------------------------------------------|");
	                System.out.printf("|\t%-20s\t%-33s\t %-25s\t %-10s \t\n", tu.getMaTU(), tu.getTenTU(), tu.getSizeTU(),tu.getGiaTU() + "đ");
	            }
	        }
	        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[36m");
	    } else {
	        System.out.println("Không có trong danh sách. Mời bạn nhập mã khác");
	    }
	}

	 
	 private String nhapTenCheck(Scanner sc) {
		    String tenLOAI = null;
		    boolean nhapThanhCong = false;
		    
		    do {
		        try {
		            System.out.println("Nhập Tên Loại: ");
		            tenLOAI = sc.nextLine();
		            
		            if (tenLOAI.matches("[a-zA-Z\\p{Punct}\\s\\p{L}]+")) {
		                nhapThanhCong = true;
		            } else {
		                System.out.println("=> Tên không được chứa số. Mời bạn nhập lại <=");
		            }
		        } catch (Exception e) {
		            System.out.println("Hay Nhập Đúng Tên Loại. Mời bạn nhập lại.");
		            sc.nextLine();
		        }
		    } while (!nhapThanhCong);
		    
		    return tenLOAI;
		}
}