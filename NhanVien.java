package QuanLyQuanCF;

import java.io.Serializable;

public class NhanVien extends NguoiCskh implements Serializable {
	
	private String diaChi;
	private String chuVu;
	private double luong;
	
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getChuVu() {
		return chuVu;
	}
	public void setChuVu(String chuVu) {
		this.chuVu = chuVu;
	}
	
	public NhanVien(String maQL, String hoTen, String sdt, String chuVu, double luong, String diaChi) {
		super(maQL,hoTen,sdt);
		this.diaChi = diaChi;
		this.chuVu = chuVu;
		this.luong = luong;
	}
	
	public NhanVien() {
		super();
	}
	
}
