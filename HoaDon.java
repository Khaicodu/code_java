package QuanLyQuanCF;

import java.io.Serializable;

public class HoaDon extends NguoiCskh implements Serializable {
	private String maHD;
	private String tenHD;
	private String ngayTao;
	private int tongTien;
	private int tongTienHoaDon;
	private String trangThaiThanhToan;
	public HoaDon(String maHD, String tenHD, String ngayTao, String trangThaiThanhToan,String maQL, String hoTen,String sdt) {
		super(maQL, hoTen,sdt);
		this.maHD = maHD;
		this.tenHD = tenHD;
		this.ngayTao = ngayTao;
		
		this.trangThaiThanhToan = trangThaiThanhToan;
	}
	 public int getTongTienHoaDon() {
	        return tongTienHoaDon;
	    }

	    public void setTongTienHoaDon(int tongTienHoaDon) {
	        this.tongTienHoaDon = tongTienHoaDon;
	    }
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getTenHD() {
		return tenHD;
	}
	public void setTenHD(String tenHD) {
		this.tenHD = tenHD;
	}
	public String getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public String getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}
	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}
	
	
	
	
}
