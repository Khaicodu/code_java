package QuanLyQuanCF;

import java.io.Serializable;

public class NguoiCskh implements Serializable{
	protected String maQL;
	protected String hoTen;
	private String sdt;
	public NguoiCskh(String maQL, String hoTen, String sdt) {
		super();
		this.maQL = maQL;
		this.hoTen = hoTen;
		this.sdt = sdt;
	}
	public String getMaQL() {
		return maQL;
	}
	public void setMaQL(String maQL) {
		this.maQL = maQL;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	public NguoiCskh() {
		super();
	}
	
	
}
