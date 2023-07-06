package board.spring.mybatis;

import java.util.List;

public interface BoardService {
	public int insertBoard(BoardDTO dto);
	public int getTotalBoard();
	public List<BoardDTO> boardList(int[] limit);
	public BoardDTO updateViewcountAndGetDetail(int seq);
	public BoardMemberDTO getWriterInform(int seq);
	public List<BoardDTO> searchList(java.util.HashMap map);
}
