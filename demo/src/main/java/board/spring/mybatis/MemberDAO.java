package board.spring.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDAO {
	//@Autowired
	//SqlSession session;
	
	public MemberDTO oneMember(String id);



}




