package QuanLyQuanCF;

import java.util.Scanner;

public class MenuChinh {
	public static void main(String[] args) {
		CacMenu menu = new CacMenu();
		Scanner sc = new Scanner(System.in);
		int chon;
		do {
			
			System.out.println("\u001B[36m╔══════════════════════════════════════════════╗");
			System.out.println("║               \u001B[31mQUẢN LÝ QUÁN CHIDORI\u001B[36m           ║");
			System.out.println("╠══════════════════════════════════════════════╣");
			System.out.println("║ \u001B[32m1. Làm việc với Nhân Viên\u001B[36m                    ║\u001B[36m");
			System.out.println("║ \u001B[32m2. Làm việc với Thức Uống\u001B[36m                    ║\u001B[36m");
			System.out.println("║ \u001B[32m3. Làm việc với Loại Thức Uống\u001B[36m               ║\u001B[36m");
			System.out.println("║ \u001B[32m4. Làm việc với Khách Hàng\u001B[36m                   ║\u001B[36m");
			System.out.println("║ \u001B[32m5. Khách Hàng Oder thức uống\u001B[36m                 ║\u001B[36m");
			System.out.println("║ \u001B[32m6. Hóa Đơn Thanh Toán\u001B[36m                        ║\u001B[36m");
			System.out.println("╚══════════════════════════════════════════════╝\u001B[36m");
			System.out.println("\u001B[35m╭──────────────────────────────────────────────╮");
			System.out.printf("\u001B[35m|\u001B[31m=> MỜI BẠN CHỌN:\u001B[34m                              |\n"); 
			System.out.println("╰──────────────────────────────────────────────╯");
			chon = sc.nextInt();
			switch(chon) {
				case 1: {
					menu.menuNV(); break;
				}
				case 2: {
					menu.menuTU(); break;
				}
				case 3:{
					menu.menuLOAI(); break;
				}
				case 4:{
					menu.menuKH(); break;
				}
				case 5:{
					menu.menuOder(); break;
				}
				case 6:{
					menu.menuHD(); break;
				}
				default: break;
			}
		}while(chon<=6);
	}
}