package QuanLyQuanCF;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.*;
import java.text.DecimalFormat;
public class DanhSachThucUong{
	public ArrayList<ThucUong> dstu = new ArrayList<ThucUong>();

	private DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
	NhanVienDao obj = new NhanVienDao();
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
		System.out.print("\u001B[35m|\u001B[31m=> Nhập số Thức Uống: \u001B[34m                        |\n");
		System.out.println("╰──────────────────────────────────────────────╯");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
			System.out.print("\u001B[35m|\u001B[31m=> Nhập mã Thức Uống "+(i+1)+"  \u001B[34m                      |\n"); 
			System.out.println("╰──────────────────────────────────────────────╯");
			String maTU;
	        boolean thucUongTonTai;
	        do {
	            System.out.println("=> Nhập mã Thức Uống:");
	            maTU = sc.nextLine();
	            thucUongTonTai = tonTaiThucUong(maTU);

	            if (thucUongTonTai) {
	                System.out.println("=> Mã Thức Uống đã tồn tại. Mời nhập lại <=");
	            }else if (maTU.trim().isEmpty()) {
	                System.out.printf("=> Không được bỏ trống.  Mời bạn nhập \n");
	                thucUongTonTai = true;
	            }
	        } while (thucUongTonTai);
	        
			String tenTU = nhapTenCheck(sc);

			System.out.println("Nhập SIZE:");			
			String sizeTU;
	        do {
	        	sizeTU = sc.nextLine();
	            if (sizeTU.trim().isEmpty()) {
	                System.out.println("=> Không được bỏ trống.  Mời bạn nhập");
	            }
	        } while (sizeTU.trim().isEmpty());
			
			Double giaTU = nhapGiaCheck(sc);
			
			System.out.println("Nhập Mã Loại Thức Uống: ");
	        String maLoai;
	        do {
	        	maLoai = sc.nextLine();
	            if (maLoai.trim().isEmpty()) {
	                System.out.println("=> Không được bỏ trống.  Mời bạn nhập");
	            }
	        } while (maLoai.trim().isEmpty());
	        
			ThucUong tu = new ThucUong(maTU, tenTU, giaTU, sizeTU, maLoai);
	        tu.setMaLoai(maLoai); 
	        dstu.add(tu);
		}
		obj.ghiFile1(dstu);
	}
	public void docFile1() {
		dstu = obj.docFile1("d:\\dstu2.bin");
	}
	
	public boolean tonTaiThucUong(String maTU) {
	    for (ThucUong tu : dstu) {
	        if (tu.getMaTU().equals(maTU)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public void hienThi() {
		System.out.printf("%87s\n","\u001B[35m╭───────────────────────────────────────╮");
		System.out.printf("%82s\n","|       => DANH SÁCH THỨC UỐNG <=       |");
		System.out.printf("%82s\n","╰───────────────────────────────────────╯");
		System.out.println("\u001B[36m╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
	    System.out.printf("|%15s\t %20s\t %25s\t %19s\t %19s    |\n", "Mã Thức Uống", "Tên Thức Uống", "SIZE", "Giá", "Mã Loại");
	    for (ThucUong tu : dstu) {
	    	System.out.println("|-------------------------------------------------------------------------------------------------------------------------------|");
	        System.out.printf("|\t%-21s\t%-33s\t %-19s\t %-15s \t %s \t\n", tu.getMaTU(), tu.getTenTU(), tu.getSizeTU(),
	                tu.getGiaTU() + "đ",tu.getMaLoai());
	    }
	    System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[36m");
	}
	
	public void xoaTU(String maTU) {
		ThucUong thucUongCanXoa = null;
		for(ThucUong ds : dstu) {
			if(ds.getMaTU().equals(maTU)) {
				thucUongCanXoa = ds;
				break;
			}
		}
		if(thucUongCanXoa != null) {
			dstu.remove(thucUongCanXoa);
			System.out.println("=>Đã Xóa Thức Uống '"+maTU+"' khỏi danh sách thức uống<=");
		}else {
			System.out.println("=>Không tìm thấy thức uống '"+ maTU +"' trong danh sách<=");
		}
	}
	public void sapXepTU() {
		Collections.sort(dstu, (tu1, tu2) -> tu1.getMaTU().compareTo(tu2.getMaTU()));
		System.out.printf("%87s\n","\u001B[35m╭────────────────────────────────────────────────╮");
		System.out.printf("%82s\n","|      => DANH SÁCH SAU KHI ĐƯỢC SẮP XẾP <=      |");
		System.out.printf("%82s\n","╰────────────────────────────────────────────────╯");
		System.out.println("\u001B[36m╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
		System.out.printf("|%18s\t %20s\t %25s\t %30s                 |\n", "Mã Thức Uống", "Tên Thức Uống", "SIZE", "Giá");
	    for (ThucUong tu : dstu) {
	    	System.out.println("|-------------------------------------------------------------------------------------------------------------------------------|");
	        System.out.printf("|\t%-20s\t%-33s\t %-25s\t %-10s \t\n", tu.getMaTU(), tu.getTenTU(), tu.getSizeTU(),tu.getGiaTU() + "đ");
	    }
	    System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[36m");
	}
	public void themTU(ThucUong obj, int vt) {
		dstu.add(vt,obj);
		hienThi();
	}
	 public void luuFile1() {
	        obj.ghiFile1(dstu); 			
	        System.out.println("=> Đã lưu danh sách thức uống vào file thành công! <=");
	    }
	 private Double nhapGiaCheck(Scanner sc) {
	        Double giaTU = null;
	        boolean nhapThanhCong = false;
	        do {
	            try {
	                System.out.println("Nhập Giá: ");
	                giaTU = sc.nextDouble();
	                if (giaTU >= 0) {
	                    nhapThanhCong = true;
	                } else {
	                    System.out.println("=>Giá không được âm. Mời bạn nhập lại<=");
	                }
	                sc.nextLine();
	                
	            } catch (InputMismatchException e) {
	                System.out.println("=>Giá phải là một số!. Mời bạn nhập lại<=");
	                sc.nextLine();
	            }
	        } while (!nhapThanhCong);

	        return giaTU;
	    }
	 
	 private String nhapTenCheck(Scanner sc) {
		    String tenTU = null;
		    boolean nhapThanhCong = false;
		    
		    do {
		        try {
		            System.out.println("Nhập tên Thức Uống: ");
		            tenTU = sc.nextLine();
		            
		            if (tenTU.matches("[a-zA-Z\\p{Punct}\\s\\p{L}]+")) {
		                nhapThanhCong = true;
		            } else {
		                System.out.println("=> Tên không được chứa số. Mời bạn nhập lại <=");
		            }
		        } catch (Exception e) {
		            System.out.println("Hay Nhập Đúng Tên. Mời bạn nhập lại.");
		            sc.nextLine();
		        }
		    } while (!nhapThanhCong);
		    
		    return tenTU;
		}
}