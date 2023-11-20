package QuanLyQuanCF;

import java.io.Serializable;

public class LoaiThucUong implements Serializable {
	private String maLoai;
	private String tenLOAI;
	
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLOAI() {
		return tenLOAI;
	}
	public void setTenLOAI(String tenLOAI) {
		this.tenLOAI = tenLOAI;
	}
	
	public LoaiThucUong() {
		super();
	}
	public LoaiThucUong(String maLoai, String tenLOAI) {
		super();
		this.maLoai = maLoai;
		this.tenLOAI = tenLOAI;
	}
}