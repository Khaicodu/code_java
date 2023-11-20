//package QuanLyQuanCF;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class DocGhiFile {
//	 public void luuDanhSachNhanVienVaoFile(String filePath) {
//	    	// lưu dữ liệu đầu ra
//	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
//	            bw.write("Mã NV,Tên,Vị Trí,Lương Ngày,Ngày Làm,Tăng Ca,Giờ Trễ,Lương,Thưởng Tháng\n");
//	            for (qLNhanVien nhanVien : danhSachNhanVien) {
//	                bw.write(
//	                    nhanVien.htmaNV() + "," +
//	                    nhanVien.htTen() + "," +
//	                    nhanVien.htviTri() + "," +
//	                    nhanVien.htluongThang() + "," +
//	                    nhanVien.htngayLam() + "," +
//	                    nhanVien.httangCa() + "," +
//	                    nhanVien.htsoGioLamTre() + "," +
//	                    nhanVien.tinhLuongThang() + " đ," +
//	                    nhanVien.thuongThang() + "\n"
//	                );
//	            }
//	            System.out.println("Lưu dữ liệu thành công!");
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            System.out.println("Lưu dữ liệu không thành công!");
//	        }
//	    }
//	    
//	    public void docDanhSachNhanVienTuFile(String filePath) {
//	    	//BufferedReader đọc dữ liệu vào
//	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//	            String line;
//	            
//	            br.readLine();
//	            while ((line = br.readLine()) != null) {
//	                String[] tokens = line.split(",");
//	                String maNV = tokens[0].trim();
//	                String tenNhanVien = tokens[1].trim();
//	                String viTri = tokens[2].trim();
//	                int luongThang = Integer.parseInt(tokens[3].trim());
//	                int ngayLam = Integer.parseInt(tokens[4].trim());
//	                int tangCa = Integer.parseInt(tokens[5].trim());
//	                int soGioLamTre = Integer.parseInt(tokens[6].trim());
//
//	                qLNhanVien nhanVien = new qLNhanVien(maNV, tenNhanVien, viTri, luongThang, ngayLam, tangCa, soGioLamTre);
//	                themNhanVien(nhanVien);
//	            }
//	            System.out.println("Đọc dữ liệu từ file thành công!");
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            System.out.println("Đọc dữ liệu từ file không thành công!");
//	        }
//	    }
//}