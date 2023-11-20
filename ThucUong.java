package QuanLyQuanCF;
//homework: làm kết nối giữa các đối tượng
import java.io.Serializable;

public class ThucUong implements Serializable {
	private String maTU;
	private String tenTU;
	private double giaTU;
	private String sizeTU;
	private String maLoai;
	public ThucUong() {
		super();
	}
	public ThucUong(String maTU, String tenTU, double giaTU, String sizeTU,String maLoai) {
		super();
		this.maTU = maTU;
		this.tenTU = tenTU;
		this.giaTU = giaTU;
		this.sizeTU = sizeTU;
		this.maLoai = maLoai;
	}
	public String getMaLoai() {
	    return maLoai;
	}
	public void setMaLoai(String maLoai) {
	    this.maLoai = maLoai;
	}
	public String getMaTU() {
		return maTU;
	}
	public void setMaTU(String maTU) {
		this.maTU = maTU;
	}
	public String getTenTU() {
		return tenTU;
	}
	public void setTenTU(String tenTU) {
		this.tenTU = tenTU;
	}
	public double getGiaTU() {
		return giaTU;
	}
	public void setGiaTU(double giaTU) {
		this.giaTU = giaTU;
	}
	public String getSizeTU() {
		return sizeTU;
	}
	public void setSizeTU(String sizeTU) {
		this.sizeTU = sizeTU;
	}
		
}