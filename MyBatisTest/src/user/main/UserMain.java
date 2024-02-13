package user.main;

import java.util.Scanner;

import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserService;

public class UserMain {

	public void menu() {
		Scanner sc = new Scanner(System.in);
		int num;
		
		UserService userService = null;
		
		while(true) {
			System.out.println();
			System.out.println("*****************");
			System.out.println("1. 등록");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 검색");
			System.out.println("6. 종료");
			System.out.println("*****************");
			System.out.print("번호 입력 : ");
			num = sc.nextInt();
			
			if(num == 1) {
				userService = new UserInsertService();
			} else if(num == 2) {
				userService = new UserSelectService();
			}
			
			if(num == 6) break;
			
			userService.execute();
			
		} // while
		
	} // menu
	
	
	public static void main(String[] args) {
		
		UserMain userMain = new UserMain();
		
		userMain.menu();
		System.out.println("프로그램을 종료합니다.");

	} // main

} // end class
