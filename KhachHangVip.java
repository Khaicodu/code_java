package QuanLyQuanCF;

import java.io.Serializable;

public class KhachHangVip extends NguoiCskh implements Serializable {
	
	private String ngaySinh;
	
	public KhachHangVip() {
		super();
	}
	public KhachHangVip(String maQL, String hoTen, String ngaySinh, String sdt) {
	    super(maQL,hoTen, sdt);
	    this.ngaySinh = ngaySinh;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}
	
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

}
