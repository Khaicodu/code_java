package QuanLyQuanCF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class NhanVienDao implements Serializable{
	public void ghiFile(ArrayList<NhanVien> dsnv) {
		FileOutputStream fout = null;
		ObjectOutputStream oss = null;
		try {
			fout = new FileOutputStream("d:\\dsnv7.bin");
			oss = new ObjectOutputStream(fout);
			oss.writeObject(dsnv);
			System.out.println("=> Đã thực hiện đọc file <=");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oss != null) {
				try {
					oss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ArrayList<NhanVien> docFile(String filename) {
		ArrayList<NhanVien> dsnv = new ArrayList<>();
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try {
			fin = new FileInputStream(filename);
			ois = new ObjectInputStream(fin);
			dsnv = (ArrayList<NhanVien>) ois.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return dsnv;
	}

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

	public void ghiFile2(ArrayList<LoaiThucUong> dsltu) {
		FileOutputStream fout2 = null;
		ObjectOutputStream oss2 = null;
		try {
			fout2 = new FileOutputStream("d:\\dsltu1.bin");
			oss2 = new ObjectOutputStream(fout2);
			oss2.writeObject(dsltu);
			System.out.println("=> Đã thực hiện đọc file <=");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fout2 != null) {
				try {
					fout2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oss2 != null) {
				try {
					oss2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ArrayList<LoaiThucUong> docFile2(String filename2) {
		ArrayList<LoaiThucUong> dsltu1 = new ArrayList<>();
		FileInputStream fin2 = null;
		ObjectInputStream ois2 = null;
		try {
			fin2 = new FileInputStream(filename2);
			ois2 = new ObjectInputStream(fin2);
			dsltu1 = (ArrayList<LoaiThucUong>) ois2.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fin2 != null) {
				try {
					fin2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ois2 != null) {
				try {
					ois2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return dsltu1;
	}

//	public void ghiFile3(ArrayList<KhachHangVip> vip) {
//		FileOutputStream fout3 = null;
//		ObjectOutputStream oss3 = null;
//		try {
//			fout3 = new FileOutputStream("d:\\dskh6.bin");
//			oss3 = new ObjectOutputStream(fout3);
//			oss3.writeObject(vip);
//			System.out.println("=> Đã thực hiện đọc file <=");
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			if (fout3 != null) {
//				try {
//					fout3.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if (oss3 != null) {
//				try {
//					oss3.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
//	public ArrayList<KhachHangVip> docFile3(String filename3) {
//		ArrayList<KhachHangVip> vip = new ArrayList<>();
//		FileInputStream fin3 = null;
//		ObjectInputStream ois3 = null;
//		try {
//			fin3 = new FileInputStream(filename3);
//			ois3 = new ObjectInputStream(fin3);
//			vip = (ArrayList<KhachHangVip>) ois3.readObject();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			if (fin3 != null) {
//				try {
//					fin3.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if (ois3 != null) {
//				try {
//					ois3.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return vip;
//	}
	public void ghiFile3(ArrayList<KhachHangVip> vip) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\dskh5.bin"))) {
			oos.writeObject(vip);
			System.out.println("=> Đã thực hiện ghi file <=");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<KhachHangVip> docFile3(String filename3) {
		ArrayList<KhachHangVip> vip = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename3))) {
			vip = (ArrayList<KhachHangVip>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return vip;
	}
	
	

	public void ghiFile4(ArrayList<OderThucUong> oderTU) {
		FileOutputStream fout4 = null;
		ObjectOutputStream oss4 = null;
		try {
			fout4 = new FileOutputStream("d:\\oder1.bin");
			oss4 = new ObjectOutputStream(fout4);
			oss4.writeObject(oderTU);
			System.out.println("=> Đã thực hiện đọc file <=");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fout4 != null) {
				try {
					fout4.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oss4 != null) {
				try {
					oss4.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ArrayList<OderThucUong> docFile4(String filename4) {
		ArrayList<OderThucUong> oderTU = new ArrayList<>();
		FileInputStream fin4 = null;
		ObjectInputStream ois4 = null;
		try {
			fin4 = new FileInputStream(filename4);
			ois4 = new ObjectInputStream(fin4);
			oderTU = (ArrayList<OderThucUong>) ois4.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fin4 != null) {
				try {
					fin4.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ois4 != null) {
				try {
					ois4.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return oderTU;
	}
	
	public void ghiFile5(ArrayList<HoaDon> hoaDon) {
		FileOutputStream fout5 = null;
		ObjectOutputStream oss5 = null;
		try {
			fout5 = new FileOutputStream("d:\\hoadon3.bin");
			oss5 = new ObjectOutputStream(fout5);
			oss5.writeObject(hoaDon);
			System.out.println("=> Đã thực hiện đọc file <=");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fout5 != null) {
				try {
					fout5.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oss5 != null) {
				try {
					oss5.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ArrayList<HoaDon> docFile5(String filename5) {
		ArrayList<HoaDon> hoaDon = new ArrayList<>();
		FileInputStream fin5 = null;
		ObjectInputStream ois5 = null;
		try {
			fin5 = new FileInputStream(filename5);
			ois5 = new ObjectInputStream(fin5);
			hoaDon = (ArrayList<HoaDon>) ois5.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fin5 != null) {
				try {
					fin5.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ois5 != null) {
				try {
					ois5.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return hoaDon;
	}
	
	public void ghiFile6(ArrayList<HoaDon> hoaDon) {
		FileOutputStream fout6 = null;
		ObjectOutputStream oss6 = null;
		try {
			fout6 = new FileOutputStream("d:\\tong.bin");
			oss6 = new ObjectOutputStream(fout6);
			oss6.writeObject(hoaDon);
			System.out.println("=> Đã thực hiện đọc file <=");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fout6 != null) {
				try {
					fout6.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oss6 != null) {
				try {
					oss6.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ArrayList<HoaDon> docFile6(String filename6) {
		ArrayList<HoaDon> hoaDon = new ArrayList<>();
		FileInputStream fin6 = null;
		ObjectInputStream ois6 = null;
		try {
			fin6 = new FileInputStream(filename6);
			ois6 = new ObjectInputStream(fin6);
			hoaDon = (ArrayList<HoaDon>) ois6.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fin6 != null) {
				try {
					fin6.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ois6 != null) {
				try {
					ois6.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return hoaDon;
	}
}
