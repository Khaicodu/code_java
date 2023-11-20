package QuanLyQuanCF;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class OderThucUong implements Serializable {
	private DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
	NhanVienDao obj = new NhanVienDao();
	private ArrayList<HoaDon> hdon = new ArrayList<HoaDon>();
	private String maTU;
	private int soLuongOder;
    private int tongTienHoaDon;
    
    public int getTongTienHoaDon() {
        return tongTienHoaDon;
    }

    public void setTongTienHoaDon(int tongTienHoaDon) {
        this.tongTienHoaDon = tongTienHoaDon;
    }
	public String getMaTU() {
		return maTU;
	}

	public void setMaTU(String maTU) {
		this.maTU = maTU;
	}

	public OderThucUong() {
		super();
	}

	public OderThucUong(String maTU, int soLuongOder) {
		super();
		this.maTU = maTU;
		this.soLuongOder = soLuongOder;
	}

	public int getSoLuongOder() {
		return soLuongOder;
	}

	public void setSoLuongOder(int soLuongOder) {
		this.soLuongOder = soLuongOder;
	}

	public ArrayList<OderThucUong> odertu = new ArrayList<>();

	public void nhap(DanhSachThucUong dsThucUong, String maTU) {
		Scanner sc = new Scanner(System.in);
		int tongTien = tongTien(dsThucUong);
        setTongTienHoaDon(tongTien);
		System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
		System.out.print("\u001B[35m|\u001B[31m=> Nhập số Thức Uống: \u001B[34m                        |\n");
		System.out.println("╰──────────────────────────────────────────────╯");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < n; i++) {
			System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
			System.out.print("\u001B[35m|\u001B[31m=> Nhập mã Thức Uống "+(i+1)+"  \u001B[34m                      |\n"); 
			System.out.println("╰──────────────────────────────────────────────╯");
			maTU = sc.nextLine();
			
			for (ThucUong tu : dsThucUong.dstu) {
				if (tu.getMaTU().equals(maTU)) {
					System.out.println("|-------------------------------------------------------------------------------|");
					System.out.printf("|Mã: %-10s  Tên: %-20s  Size: %-10s  Giá: %.0f đ\n", tu.getMaTU(), tu.getTenTU(), tu.getSizeTU(),tu.getGiaTU());

				}
			}
			System.out.println("=> Nhập số lượng: ");
			int soLuong = sc.nextInt();
			sc.nextLine();
			setSoLuongOder(soLuong);
	        OderThucUong loai = new OderThucUong(maTU, soLuong);
	        odertu.add(loai);
	        obj.ghiFile4(odertu);
		}
		
	}
	public void docFile4() {
		odertu = obj.docFile4("d:\\oder1.bin");
	}
	public void luuFile4() {
        obj.ghiFile4(odertu); 			
        System.out.println("=> Đã lưu danh sách oder vào file thành công! <=");
    }
	
	public int tongTien(DanhSachThucUong dsThucUong) {
	    int tong = 0;

	    for (OderThucUong oderItem : odertu) {
	        for (ThucUong tu : dsThucUong.dstu) {
	            if (tu.getMaTU().equals(oderItem.getMaTU())) {
	                int totalForItem = (int) (tu.getGiaTU() * oderItem.getSoLuongOder());
	                System.out.printf("|%-20s  %-20s  Số lượng: %-10d  Thành tiền: %d đ\n", tu.getTenTU(), tu.getGiaTU() + "đ", oderItem.getSoLuongOder(), totalForItem);
	                tong += totalForItem;
	            }
	        }
	    }

	 
	    for (HoaDon hd : hdon) {
	        hd.setTongTienHoaDon(tong);
	    }

	    System.out.println("Tổng tiền: " + decimalFormat.format(tong) + "đ");

	    return tong;
	}
	
	public int tinhTongTien(DanhSachThucUong dsThucUong) {
	    int tong = 0;

	    for (OderThucUong oderItem : odertu) {
	        for (ThucUong tu : dsThucUong.dstu) {
	            if (tu.getMaTU().equals(oderItem.getMaTU())) {
	                int totalForItem = (int) (tu.getGiaTU() * oderItem.getSoLuongOder());
	                tong += totalForItem;
	            }
	        }
	    }

	    setTongTienHoaDon(tong);

	    return tong;
	}

	public void hienThi(DanhSachThucUong dsThucUong) {
		System.out.printf("%87s\n","\u001B[35m╭───────────────────────────────────────╮");
		System.out.printf("%82s\n","|       => DANH SÁCH THỨC UỐNG <=       |");
		System.out.printf("%82s\n","╰───────────────────────────────────────╯");
		System.out.println("\u001B[36m╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
	    System.out.printf("|%15s\t %20s\t %25s\t %19s\t %19s    |\n", "Mã Thức Uống", "Tên Thức Uống", "SIZE", "Giá", "Mã Loại");
		for (ThucUong tu : dsThucUong.dstu) {
			System.out.println("|-------------------------------------------------------------------------------------------------------------------------------|");
	        System.out.printf("|\t%-21s\t%-33s\t %-19s\t %-15s \t %s \t\n", tu.getMaTU(), tu.getTenTU(), tu.getSizeTU(),
	                tu.getGiaTU() + "đ",tu.getMaLoai());
	    }
	    System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\u001B[36m");
	}

}