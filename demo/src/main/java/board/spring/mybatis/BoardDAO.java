package board.spring.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDAO {
	//@Autowired
	//SqlSession session;
	
	public int insertBoard(BoardDTO dto) ;

	
	public int getTotalBoard() ;

	public List<BoardDTO> boardList(int[] limit);
	
	public int updateViewcount(int seq) ;
	
	
	public BoardDTO getDetail(int seq);
	
	public BoardMemberDTO getWriterInform(int seq);
	
	public List<BoardDTO> searchList(java.util.HashMap map);
}
