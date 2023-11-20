package QuanLyQuanCF;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ThucUongDao {
	public void ghiFile1(ArrayList<ThucUong> dstu) {
		FileOutputStream fout1 = null;
		ObjectOutputStream oss1 = null;
		try {
			fout1 = new FileOutputStream("d:\\dstu2.bin");
			oss1 = new ObjectOutputStream(fout1);
			oss1.writeObject(dstu);
			System.out.println("=> Đã thực hiện đọc file <=");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fout1 != null) {
				try {
					fout1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oss1 != null) {
				try {
					oss1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ArrayList<ThucUong> docFile1(String filename1) {
		ArrayList<ThucUong> dstu = new ArrayList<>();
		FileInputStream fin1 = null;
		ObjectInputStream ois1 = null;
		try {
			fin1 = new FileInputStream(filename1);
			ois1 = new ObjectInputStream(fin1);
			dstu = (ArrayList<ThucUong>) ois1.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fin1 != null) {
				try {
					fin1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ois1 != null) {
				try {
					ois1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return dstu;
	}
}
