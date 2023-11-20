package QuanLyQuanCF;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CacMenu{
	DanhSachNhanVien nvobj = new DanhSachNhanVien();
	DanhSachThucUong tuobj = new DanhSachThucUong();
	DanhSachLoaiTU lobj = new DanhSachLoaiTU();
	OderThucUong oder = new  OderThucUong();
	DanhSachKhachHangVip danhSach = new DanhSachKhachHangVip();
	DanhSachThucUong dsThucUong = new DanhSachThucUong();
	DanhSachHoaDon hoadon = new DanhSachHoaDon();
	Scanner sc = new Scanner(System.in);

	public void menuNV() {
		int s1;
		do {
			System.out.println("\u001B[36m╔══════════════════════════════════════════════╗");
			System.out.println("║               \u001B[31mQUẢN LÝ NHÂN VIÊN\u001B[36m              ║");
			System.out.println("╠══════════════════════════════════════════════╣");
			System.out.println("║ \u001B[32m1. Nhập thông tin Nhân Viên\u001B[36m                  ║\u001B[36m");
			System.out.println("║ \u001B[32m2. Hiển thị danh sách Nhân Viên\u001B[36m              ║\u001B[36m");
			System.out.println("║ \u001B[32m3. Hiển thị các Nhân Viên lương trên 15 triệu\u001B[36m║\u001B[36m");
			System.out.println("║ \u001B[32m4. Thêm Nhân Viên\u001B[36m                            ║\u001B[36m");
			System.out.println("║ \u001B[32m5. Xóa Nhân Viên theo mã\u001B[36m                     ║\u001B[36m");
			System.out.println("║ \u001B[32m6. Sắp xếp Nhân Viên theo lương\u001B[36m              ║\u001B[36m");
			System.out.println("║ \u001B[32m7. Tìm kiếm Nhân Viên theo mã\u001B[36m                ║\u001B[36m");
			System.out.println("║ \u001B[32m8. Cập nhật Nhân Viên theo mã\u001B[36m                ║\u001B[36m");
			System.out.println("║ \u001B[32m9. Thoát khỏi Nhân Viên\u001B[36m                      ║\u001B[36m");
			System.out.println("╚══════════════════════════════════════════════╝\u001B[36m");
			System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
			System.out.printf("\u001B[35m|\u001B[31m=> MỜI BẠN CHỌN:\u001B[34m                              |\n"); 
			System.out.println("╰──────────────────────────────────────────────╯");
			s1 = sc.nextInt();
			switch (s1) {
			case 1: {
				nvobj.nhap();
				nvobj.docFile();
				break;
			}
			case 2: {
				nvobj.docFile();
				nvobj.hienThi();
				break;
			}
			case 3: {
				nvobj.docFile();
				nvobj.NhanVienLuongCao();
				break;
			}
			case 4: {
				System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
				System.out.printf("\u001B[35m|\u001B[31m=> CHÈN NHÂN VIÊN\u001B[34m                             |\n"); 
				System.out.println("╰──────────────────────────────────────────────╯");
				System.out.printf("=> Nhập vị trí cần chèn: ");
				int vt = sc.nextInt();
				sc.nextLine();
				System.out.printf("=> Nhập Mã Nhân viên: ");
				String maNV = sc.nextLine();

				System.out.printf("=> Nhập Tên Nhân viên: ");
				String tenNV = sc.nextLine();

				System.out.printf("=> Nhập số điện thoại nv: ");
				String sdt = sc.nextLine();
				sc.nextLine();

				System.out.printf("=> Nhập chức vụ:");
				String chucVu = sc.nextLine();

				System.out.printf("=> Nhập lương: ");
				double luong = sc.nextDouble();
				sc.nextLine();

				System.out.printf("=> Nhập địa chỉ:");
				String diaChi = sc.nextLine();

				NhanVien nv = new NhanVien(maNV, tenNV, sdt, chucVu, luong, diaChi);
				nvobj.themNV(nv, vt);
				nvobj.luuFile();
				break;
			}
			case 5: {
				sc.nextLine();
				System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
				System.out.printf("\u001B[35m|\u001B[31m=> XÓA NHÂN VIÊN\u001B[34m                              |\n"); 
				System.out.println("╰──────────────────────────────────────────────╯");
				System.out.printf("=> Nhập mã nhân viên: ");
				String nhapMa = sc.nextLine();
				nvobj.xoaNV(nhapMa);
				nvobj.luuFile();
				System.out.printf("%92s\n","\u001B[35m╭───────────────────────────────────────╮");
				System.out.printf("%87s\n","|     => DANH SÁCH SAU KHI XÓA <=       |");
				System.out.printf("%87s\n","╰───────────────────────────────────────╯");
				nvobj.hienThi();
				break;
			}
			case 6: {
				nvobj.sapXepNV();
				break;
			}
			case 7: {
				sc.nextLine();
				System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
				System.out.printf("\u001B[35m|\u001B[31m=> TÌM NHÂN VIÊN\u001B[34m                              |\n"); 
				System.out.println("╰──────────────────────────────────────────────╯");
				System.out.printf("=> Nhập mã nhân viên: ");
				String maTim = sc.nextLine();
				nvobj.timKiemNV(maTim);
				break;
			}
			case 8: {
				sc.nextLine();
				System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
				System.out.printf("\u001B[35m|\u001B[31m=> SỮA THÔNG TIN NHÂN VIÊN\u001B[34m                       |\n"); 
				System.out.println("╰──────────────────────────────────────────────╯");
				System.out.printf("=> Nhập mã Nhân Viên Cần Sửa: ");
				String maThem = sc.nextLine();
				
				System.out.printf("=> Nhập Số điện thoại mới: ");
				String sdtMoi = sc.nextLine();
				sc.nextLine();
				
				System.out.printf("=> Nhập Chức vụ mới: ");
				String chucVuMoi = sc.nextLine();
				
				System.out.printf("=> Nhập Lương mới: ");
				double luongMoi = sc.nextDouble();
				sc.nextLine();
				
				System.out.printf("=> Nhập Địa chỉ mới: ");
				String diaChiMoi = sc.nextLine();
				
				nvobj.capNhatTT(maThem, sdtMoi, chucVuMoi, luongMoi, diaChiMoi);
				nvobj.luuFile();
				nvobj.hienThi();
				break;
			}
			default:
				break;
			}
		} while (s1 < 9);
	}
	
	public void menuTU() {
		int s2;
		do {
			System.out.println("\u001B[36m╔══════════════════════════════════════════════╗");
			System.out.println("║               \u001B[31mQUẢN LÝ THỨC UỐNG\u001B[36m              ║");
			System.out.println("╠══════════════════════════════════════════════╣");
			System.out.println("║ \u001B[32m1. Nhập thông tin Thức Uống\u001B[36m                  ║\u001B[36m");
			System.out.println("║ \u001B[32m2. Hiển thị danh sách Thức Uống\u001B[36m              ║\u001B[36m");
			System.out.println("║ \u001B[32m3. Thêm Thức Uống\u001B[36m                            ║\u001B[36m");
			System.out.println("║ \u001B[32m4. Xóa Thức Uống theo mã\u001B[36m                     ║\u001B[36m");
			System.out.println("║ \u001B[32m5. Sắp xếp Thức Uống theo mã   \u001B[36m              ║\u001B[36m");
			System.out.println("║ \u001B[32m6. Thoát khỏi Thức Uống\u001B[36m                      ║\u001B[36m");
			System.out.println("╚══════════════════════════════════════════════╝\u001B[36m");
			System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
			System.out.printf("\u001B[35m|\u001B[31m=> MỜI BẠN CHỌN:\u001B[34m                              |\n"); 
			System.out.println("╰──────────────────────────────────────────────╯");
			s2 = sc.nextInt();
			switch (s2) {
			case 1: {
				tuobj.nhap();
				tuobj.docFile1();
				break;
			}
			case 2: {
				tuobj.docFile1();
				tuobj.hienThi();
				break;
			}
			case 3: {
				System.out.println("=> Nhập vị trí cần chèn: ");
				int vt = sc.nextInt();
				sc.nextLine();
				System.out.println("Nhập Mã Thức Uống: ");
				String maTU = sc.nextLine();

				System.out.println("Nhập Tên Thức Uống: ");
				String tenTU = sc.nextLine();

				System.out.println("Nhập SIZE:");
				String sizeTU = sc.nextLine();

				System.out.println("Nhập Giá: ");
				Double giaTU = sc.nextDouble();
				sc.nextLine();
				
				System.out.println("Nhập Mã Loại: ");
				String maLoai = sc.nextLine();
				
				ThucUong tu = new ThucUong(maTU, tenTU, giaTU, sizeTU, maLoai);
				tuobj.themTU(tu, vt);
				tuobj.luuFile1();
				break;
			}
			case 4: {
				sc.nextLine();
				System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
				System.out.printf("\u001B[35m|\u001B[31m=> XÓA THỨC UỐNG\u001B[34m                              |\n"); 
				System.out.println("╰──────────────────────────────────────────────╯");
				System.out.println("=> Nhập mã thức uống cần xóa");
				String nhapMa1 = sc.nextLine();
				tuobj.xoaTU(nhapMa1);
				tuobj.luuFile1();
				System.out.printf("%87s\n","\u001B[35m╭───────────────────────────────────────╮");
				System.out.printf("%82s\n","|     => DANH SÁCH SAU KHI XÓA <=       |");
				System.out.printf("%82s\n","╰───────────────────────────────────────╯");
				tuobj.hienThi();
				break;
			}
			case 5: {
				tuobj.sapXepTU();
				break;
			}
			
			default:
				break;
			}
		} while (s2 < 6);
	}
	
	public void menuLOAI() {
		int s2;
		do {
			System.out.println("\u001B[36m╔══════════════════════════════════════════════╗");
			System.out.println("║             \u001B[31mQUẢN LÝ LOẠI THỨC UỐNG\u001B[36m           ║");
			System.out.println("╠══════════════════════════════════════════════╣");
			System.out.println("║ \u001B[32m1. Nhập thông tin Loại Thức Uống\u001B[36m             ║\u001B[36m");
			System.out.println("║ \u001B[32m2. Hiển thị danh sách Loại Thức Uống\u001B[36m         ║\u001B[36m");
			System.out.println("║ \u001B[32m3. Hiển thị DS Thức Uống theo mã Loại\u001B[36m        ║\u001B[36m");
			System.out.println("║ \u001B[32m4. Thoát khỏi Loại Thức Uống\u001B[36m                 ║\u001B[36m");
			System.out.println("╚══════════════════════════════════════════════╝\u001B[36m");
			System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
			System.out.printf("\u001B[35m|\u001B[31m=> MỜI BẠN CHỌN:\u001B[34m                              |\n"); 
			System.out.println("╰──────────────────────────────────────────────╯");
			s2 = sc.nextInt();
			switch (s2) {
			case 1: {
				lobj.nhap();
				lobj.docFile2();
				break;
			}
			case 2: {
				lobj.docFile2();
				lobj.hienThi();
				break;
			}
			case 3: {
				sc.nextLine();
				System.out.println("Nhập mã loại thức uống:");
				String maLoai = sc.nextLine();
				tuobj.docFile1();
				lobj.hienThiDSThucUongTheoMaLoai(tuobj, maLoai);
				break;
			}
			default:
				break;
			}
		} while (s2 < 4);
	}
	
	
	public void menuOder() {
		dsThucUong.docFile1();

        OderThucUong oder = new OderThucUong();

        int s2;
        do {
        	System.out.println("\u001B[36m╔══════════════════════════════════════════════╗");
        	System.out.println("║            \u001B[31mQUẢN LÝ ODER THỨC UỐNG\u001B[36m            ║");
        	System.out.println("╠══════════════════════════════════════════════╣");
        	System.out.println("║ \u001B[32m1. Hiển thị danh sách Thức Uống\u001B[36m              ║\u001B[36m");
        	System.out.println("║ \u001B[32m2. Nhập mã Thức Uống cần Oder\u001B[36m                ║\u001B[36m");
        	System.out.println("║ \u001B[32m3. Tính tổng tiền\u001B[36m                            ║\u001B[36m");
        	System.out.println("║ \u001B[32m4. Thoát khỏi Oder Thức Uống\u001B[36m                 ║\u001B[36m");
        	System.out.println("╚══════════════════════════════════════════════╝\u001B[36m");
            System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
			System.out.printf("\u001B[35m|\u001B[31m=> MỜI BẠN CHỌN:\u001B[34m                              |\n"); 
			System.out.println("╰──────────────────────────────────────────────╯");

            s2 = sc.nextInt();
            switch (s2) {
                case 1: {
                    dsThucUong.hienThi();
                    break;
                }
                case 2: {
                    sc.nextLine();
                    oder.nhap(dsThucUong, null);
                    break;
                }
                case 3: {
                    if (oder.getSoLuongOder() == 0) {
                        System.out.println("Vui lòng nhập số lượng trước khi tính tổng tiền.");
                    } else {
                        oder.tongTien(dsThucUong);
                    }
                    oder.luuFile4();
                    break;
                }
                default:
                    break;
            }
        } while (s2 < 4);
    }

	
	public void menuKH() {
		int s2;
		do {
			System.out.println("\u001B[36m╔══════════════════════════════════════════════╗");
			System.out.println("║               \u001B[31mQUẢN LÝ KHÁCH HÀNG\u001B[36m             ║");
			System.out.println("╠══════════════════════════════════════════════╣");
			System.out.println("║ \u001B[32m1. Nhập thông tin Khách Hàng\u001B[36m                 ║\u001B[36m");
			System.out.println("║ \u001B[32m2. Hiển thị danh sách Khách Hàng\u001B[36m             ║\u001B[36m");
			System.out.println("║ \u001B[32m3. Thêm Khách Hàng\u001B[36m                           ║\u001B[36m");
			System.out.println("║ \u001B[32m4. Xóa Khách Hàng theo mã\u001B[36m                    ║\u001B[36m");
			System.out.println("║ \u001B[32m5. Thoát khỏi Khách Hàng\u001B[36m                     ║\u001B[36m");
			System.out.println("╚══════════════════════════════════════════════╝\u001B[36m");
			System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
			System.out.printf("\u001B[35m|\u001B[31m=> MỜI BẠN CHỌN:\u001B[34m                              |\n"); 
			System.out.println("╰──────────────────────────────────────────────╯");
			s2 = sc.nextInt();
			switch (s2) {
			case 1: {
				
				danhSach.nhap();
				danhSach.docFile3();
				break;
			}
			case 2: {
				danhSach.docFile3();
				danhSach.hienThi();
				break;
			}
			case 3: {
				System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
				System.out.printf("\u001B[35m|\u001B[31m=> CHÈN KHÁCH HÀNG\u001B[34m                            |\n"); 
				System.out.println("╰──────────────────────────────────────────────╯");
				System.out.printf("=> Nhập vị trí cần chèn: ");
				int vt = sc.nextInt();
				sc.nextLine();
				System.out.printf("Nhập Mã Khách hàng: ");
				String maKH = sc.nextLine();

				System.out.printf("Nhập Tên Khách hàng: ");
				String hoTen = sc.nextLine();

				System.out.printf("Ngày Sinh: ");
				String ngaySinh = sc.nextLine();

				System.out.printf("Số điện thoại: ");
				String sdt = sc.nextLine();
				sc.nextLine();
				
				KhachHangVip kh = new KhachHangVip(maKH, hoTen, ngaySinh, sdt);
				danhSach.themKH(kh, vt);
				danhSach.docFile3();
				break;
			}
			case 4: {
				sc.nextLine();
				System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
				System.out.printf("\u001B[35m|\u001B[31m=> XÓA KHÁCH HÀNG\u001B[34m                             |\n"); 
				System.out.println("╰──────────────────────────────────────────────╯");
				System.out.printf("=> Nhập mã Khách hàng: ");
				String nhapMa = sc.nextLine();
				danhSach.xoaKH(nhapMa);
				danhSach.luuFile3();
				System.out.printf("%87s\n","\u001B[35m╭───────────────────────────────────────╮");
				System.out.printf("%82s\n","|     => DANH SÁCH SAU KHI XÓA <=       |");
				System.out.printf("%82s\n","╰───────────────────────────────────────╯");
				danhSach.hienThi();
				break;
			}
			
			
			default:
				break;
			}
		} while (s2 < 5);
	}
	
	public void menuHD() {

	    int s2;
	    do {
	    	System.out.println("\u001B[36m╔══════════════════════════════════════════════╗");
	    	System.out.println("║               \u001B[31mQUẢN LÝ HÓA ĐƠN\u001B[36m                ║");
	    	System.out.println("╠══════════════════════════════════════════════╣");
	    	System.out.println("║ \u001B[32m1. Nhập thông tin Hóa Đơn\u001B[36m                    ║\u001B[36m");
	    	System.out.println("║ \u001B[32m2. In hóa đơn\u001B[36m                                ║\u001B[36m");
	    	System.out.println("║ \u001B[32m3. Thoát QL hóa đơn\u001B[36m                          ║\u001B[36m");
	    	System.out.println("╚══════════════════════════════════════════════╝\u001B[36m");
	        System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
			System.out.printf("\u001B[35m|\u001B[31m=> MỜI BẠN CHỌN:\u001B[34m                              |\n"); 
			System.out.println("╰──────────────────────────────────────────────╯");
	        s2 = sc.nextInt();
	        switch (s2) {
	            case 1: {
	               hoadon.nhap();
	               hoadon.docFile5();
	               oder.docFile4();
	               break;
	            }
	            case 2: {
	            	hoadon.docFile5();
	                hoadon.hienThiHoaDon(dsThucUong, oder);
	                break;
	            }
	           
	            default:
	                break;
	        }
	    } while (s2 < 3);
	}
	
}