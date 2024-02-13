package user.service;

import java.util.List;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService{

	@Override
	public void execute() {
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		String pwd;
		int cnt = 0;
		
		System.out.print("찾고자 하는 아이디 입력 : ");
		String id = sc.next();
		
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.getUserList();
		
		for(UserDTO userDTO : list) {
			
			if(userDTO.getId().equals(id)) {

				userDAO.deleteUser(userDTO.getId());
				System.out.println("회원 정보 삭제 완료");
				cnt++;
				break;
				
			} 
			
		} // for
		
		if(cnt == 0) {
			System.out.println("찾는 아이디가 없습니다.");
		} // if
		
	} // execute

	
	
} // end class
