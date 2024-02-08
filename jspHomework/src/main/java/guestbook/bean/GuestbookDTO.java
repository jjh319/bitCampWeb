package guestbook.bean;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GuestbookDTO {

	private int seq;
	private String name;
	private String email;
	private String homepage;
	private String subject;
	private String content;
	private String logtime;
	
} // end class
