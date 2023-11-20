package QuanLyQuanCF;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.*;
import java.text.DecimalFormat;

public class DanhSachNhanVien{
	public ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
	private DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
	NhanVienDao obj = new NhanVienDao();
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
		System.out.print("\u001B[35m|\u001B[31m=> Nhập số Nhân Viên: \u001B[34m                        |\n");
		System.out.println("╰──────────────────────────────────────────────╯");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
			System.out.print("\u001B[35m|\u001B[31m=> Nhập mã Nhân Viên "+(i+1)+"  \u001B[34m                      |\n"); 
			System.out.println("╰──────────────────────────────────────────────╯");
			 String maQL;
		        boolean nhanVienTonTai;
		        do {
		        	System.out.printf("=> Nhập Mã Nhân Viên:");
		            maQL = sc.nextLine();
		            nhanVienTonTai = tonTaiNhanVien(maQL);

		            if (nhanVienTonTai) {
		                System.out.println("=> Mã Nhân Viên đã tồn tại. Mời nhập lại <=");
		            }else if (maQL.trim().isEmpty()) {
		                System.out.printf("=> Không được bỏ trống.  Mời bạn nhập");
		                nhanVienTonTai = true;
		            }
		        } while (nhanVienTonTai);
			
			String hoTen = nhapTenCheck(sc);
			
			String sdt = nhapSDTCheck(sc);			
			
			String chucVu = nhapCVCheck(sc);
			
			double luong = nhapLuongCheck(sc);
			
			System.out.printf("=> Nhập địa chỉ:");
			String diaChi;
	        do {
	        	diaChi = sc.nextLine();
	            if (diaChi.trim().isEmpty()) {
	                System.out.println("=> Không được bỏ trống.  Mời bạn nhập");
	            }
	        } while (diaChi.trim().isEmpty());

			NhanVien nv = new NhanVien(maQL, hoTen, sdt, chucVu, luong, diaChi);
			dsnv.add(nv);
		}
		obj.ghiFile(dsnv);
	}
	
	public void docFile() {
		dsnv = obj.docFile("d:\\dsnv7.bin");
	}
	
	public boolean tonTaiNhanVien(String maQL) {
	    for (NhanVien nv : dsnv) {
	        if (nv.getMaQL().equals(maQL)) {
	            return true;
	        }
	    }
	    return false;
	}
	public void luuFile() {
        obj.ghiFile(dsnv); 			
        System.out.println("=> Đã lưu danh sách Nhân Viên vào file thành công! <=");
    }
	public void hienThi() {
		System.out.printf("%92s\n","\u001B[35m╭───────────────────────────────────────╮");
		System.out.printf("%87s\n","|       => DANH SÁCH NHÂN VIÊN <=       |");
		System.out.printf("%87s\n","╰───────────────────────────────────────╯");
		System.out.println("\u001B[36m╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
		System.out.printf("|%-10s\t %20s\t %18s\t %15s\t %15s\t %20s        |\n", "Mã Nhân Viên", "Tên Nhân Viên", "Số điện thoại", "Chức Vụ", "Lương", "Địa Chỉ");
		for (NhanVien nv : dsnv) {
		    System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------|");
		    System.out.printf("|\t%-9s \t%-15s \t%-15s \t%-25s  %-17s \t%-30s  \n", nv.getMaQL(), nv.getHoTen(), nv.getSdt(),nv.getChuVu(), decimalFormat.format(nv.getLuong()) + "đ", nv.getDiaChi());
		}
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[36m");

	}
	
	public void NhanVienLuongCao() {
		
		System.out.printf("%98s\n","\u001B[35m╭────────────────────────────────────────────────╮");
		System.out.printf("%93s\n","|  => DANH SÁCH NHÂN VIÊN LƯƠNG TRÊN 15 TRIỆU <= |");
		System.out.printf("%93s\n","╰────────────────────────────────────────────────╯");
		System.out.println("\u001B[36m╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
		System.out.printf("|%-10s\t %20s\t %18s\t %15s\t %15s\t %20s        |\n", "Mã Nhân Viên", "Tên Nhân Viên", "Số điện thoại", "Chức Vụ", "Lương", "Địa Chỉ");
		 boolean trieu = false;
		for (NhanVien nv : dsnv) {
			if (nv.getLuong() >= 15000000) {
				 trieu = true;
				    System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------|");
				    System.out.printf("|\t%-9s \t%-15s \t%-15s \t%-25s  %-17s \t%-30s  \n", nv.getMaQL(), nv.getHoTen(), nv.getSdt(),nv.getChuVu(), decimalFormat.format(nv.getLuong()) + "đ", nv.getDiaChi());
			}
		}
		if (!trieu) {
	        System.out.println("=> Không có nhân viên nào lương trên 15 triệu trong tháng này <=");
		}
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[36m");
	}
	
	public void themNV(NhanVien obj, int vt) {
		dsnv.add(vt,obj);
		hienThi();
	}
	
	public void xoaNV(String maQL) {
		NhanVien nhanVienCanXoa = null;
		for(NhanVien ds : dsnv) {
			if(ds.getMaQL().equals(maQL)) {
				nhanVienCanXoa = ds;
				break;
			}
		}
		if(nhanVienCanXoa != null) {
			dsnv.remove(nhanVienCanXoa);
			System.out.println("=>Đã Xóa Học Phần '"+maQL+"' khỏi danh sách nhân viên<=");
		}else {
			System.out.println("=>Không tìm thấy nhân viên '"+ maQL +"' trong danh sách<=");
		}
	}
	
	public void sapXepNV() {
		Collections.sort(dsnv, (nv1, nv2) -> Double.compare(nv2.getLuong(), nv1.getLuong()));
		System.out.printf("%98s\n","\u001B[35m╭────────────────────────────────────────────────╮");
		System.out.printf("%93s\n","|      => DANH SÁCH SAU KHI ĐƯỢC SẮP XẾP <=      |");
		System.out.printf("%93s\n","╰────────────────────────────────────────────────╯");
		System.out.println("\u001B[36m╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
		System.out.printf("|%-10s\t %20s\t %18s\t %15s\t %15s\t %20s        |\n", "Mã Nhân Viên", "Tên Nhân Viên", "Số điện thoại", "Chức Vụ", "Lương", "Địa Chỉ");
		for (NhanVien nv : dsnv) {
			System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------|");
			System.out.printf("|\t%-9s \t%-15s \t%-15s \t%-25s  %-17s \t%-30s  \n", nv.getMaQL(), nv.getHoTen(), nv.getSdt(),nv.getChuVu(), decimalFormat.format(nv.getLuong()) + "đ", nv.getDiaChi());

		}
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[36m");
	}
	
	public void timKiemNV(String maQL) {
		int n = dsnv.size();
		for(int i=0;i<n;i++) {
			NhanVien nv = dsnv.get(i);
			if(nv.getMaQL().equals(maQL)) {
				System.out.println("=>Nhân viên có trong danh sách<=");
				System.out.printf("%92s\n","\u001B[35m╭───────────────────────────────────────╮");
				System.out.printf("%87s\n","|        => TÌM THẤY NHÂN VIÊN <=       |");
				System.out.printf("%87s\n","╰───────────────────────────────────────╯");
				System.out.println("\u001B[36m╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
				System.out.printf("|%-10s\t %20s\t %18s\t %15s\t %15s\t %20s        |\n", "Mã Nhân Viên", "Tên Nhân Viên", "Số điện thoại", "Chức Vụ", "Lương", "Địa Chỉ");
				System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------|");
				System.out.printf("|\t%-9s \t%-15s \t%-15s \t%-25s  %-17s \t%-30s  \n", nv.getMaQL(), nv.getHoTen(), nv.getSdt(),nv.getChuVu(), decimalFormat.format(nv.getLuong()) + "đ", nv.getDiaChi());
				System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[36m");
				return;
				
			}
			
		}
		
	System.out.println("=> Không tìm thấy Nhân Viên có mã '"+maQL+"' <=");
	}
	
	public void capNhatTT(String maQL, String sdtMoi, String chucVuMoi, double luongMoi, String diaChiMoi ) {
		int loai = -1;
		for(int i = 0; i<dsnv.size();i++) {
			NhanVien nv = dsnv.get(i);
			if(nv.getMaQL().equals(maQL)) {
				loai = i;
				break;
			}
		}
		if(loai != -1) {
			NhanVien nv = dsnv.get(loai);
			nv.setSdt(sdtMoi);
			nv.setChuVu(chucVuMoi);
			nv.setLuong(luongMoi);
			nv.setDiaChi(diaChiMoi);
			System.out.println("=> Đã cập nhật cho Nhân Viên có mã '"+maQL+"' <=");
		}else {
			System.out.println("=> Không tìm thấy Nhân Viên có mã '"+maQL+"' <=");
		}
	}
	 
	 
	 private String nhapSDTCheck(Scanner sc) {
		    String sdt = null;
		    boolean nhapThanhCong = false;
		    String regex = "\\d+";

		    do {
		        try {
		            System.out.print("=> Nhập SĐT Nhân Viên: ");
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

	 
	 private Double nhapLuongCheck(Scanner sc) {
			Double luong = null;
	        boolean nhapThanhCong = false;

	        do {
	            try {
	                System.out.printf("=> Nhập Lương nhân viên: ");
	                luong = sc.nextDouble();
	                if (luong >= 0) {
	                    nhapThanhCong = true;
	                } else {
	                    System.out.println("=>Lương không được âm. Mời bạn nhập lại<=");
	                }
	                sc.nextLine();
	                
	            } catch (InputMismatchException e) {
	                System.out.println("=>Hãy Nhập Số!. Mời bạn nhập lại<=");
	                sc.nextLine();
	            }
	        } while (!nhapThanhCong);

	        return luong;
	    }
	 
	 private String nhapTenCheck(Scanner sc) {
		    String hoTen = null;
		    boolean nhapThanhCong = false;
		    
		    do {
		        try {
		            System.out.printf("=> Nhập tên Nhân Viên: ");
		            hoTen = sc.nextLine();
		            
		            if (hoTen.matches("[a-zA-Z\\p{Punct}\\s\\p{L}]+")) {
		                nhapThanhCong = true;
		            } else {
		            	System.out.println("=> Tên không được chứa số. Mời bạn nhập lại <=");
		            }
		        } catch (Exception e) {
		            System.out.println("=> Hay Nhập Đúng Tên. Mời bạn nhập lại.");
		            sc.nextLine();
		        }
		    } while (!nhapThanhCong);
		    
		    return hoTen;
		}
	 
	 private String nhapCVCheck(Scanner sc) {
		    String chucVu = null;
		    boolean nhapThanhCong = false;
		    
		    do {
		        try {
		            System.out.printf("=> Nhập Chức Vụ: ");
		            chucVu = sc.nextLine();
		            
		            if (chucVu.matches("[a-zA-Z\\p{Punct}\\s\\p{L}]+")) {
		                nhapThanhCong = true;
		            } else {
		                System.out.println("=> Chức vụ không được chứa số. Mời bạn nhập lại <=");
		            }
		        } catch (Exception e) {
		            System.out.println("=> Hay Nhập Đúng Chức Vụ. Mời bạn nhập lại.");
		            sc.nextLine();
		        }
		    } while (!nhapThanhCong);
		    
		    return chucVu;
		}
}
