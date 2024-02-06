import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BoardDTO {
	
	private int seq;
	private String id;
	private String name;
	private String email;
	private String subject;
	private String content;
	
	private int ref;  // 그룹번
	private int lev;  // 단계
	private int step;  // 글순서
	private int pseq;  // 원글번호
	private int reply;   // 답변수
	
	private int hit;  // 조회 수
	private String logtime;  // 시간
	
} // end class
