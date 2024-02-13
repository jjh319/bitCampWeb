package user.service;

import java.util.List;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService{

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		
		String name;
		String pwd;
		
		System.out.print("찾고자 하는 아이디 입력 : ");
		String id = sc.next();
		
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.getUserList();
		
		for(UserDTO userDTO : list) {
			
			if(userDTO.getId().equals(id)) {
				System.out.println(userDTO.getName() + "\t" +
							userDTO.getId() + "\t" +
							userDTO.getPwd()
						);
				
				System.out.print("수정할 이름 입력 : ");
				name = sc.next();
				
				System.out.print("수정할 비밀번호 입력 : ");
				pwd = sc.next();
				
				userDTO.setName(name);
				userDTO.setId(id);
				userDTO.setPwd(pwd);
				
				userDAO.updateUser(userDTO);
				
				System.out.println("정보가 수정되었습니다.");
				break;
				
			} else {
				System.out.println("찾는 아이디가 없습니다.");
				break;
			} // if-else
			
		} // for
		
		
		
		
		
	} // execute

} // end class
