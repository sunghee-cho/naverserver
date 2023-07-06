package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	@Qualifier("boardServiceImpl")
	BoardService service;
	
	@RequestMapping("/")
	public String start() {
		return "board/start";
	}
	
	@GetMapping("/boardwrite")
	public String writeform() {
		return "board/writingform";
	}
	
	@PostMapping("/boardwrite")
	public ModelAndView writeprocess(BoardDTO dto){
		int insertcount = service.insertBoard(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("insertcount", insertcount);
		//mv.setViewName("board/writeresult");
		//mv.setViewName("redirect:/boardlist");//모델2개 전달받는 리스트뷰  
		mv.setViewName("board/start");
		return mv;
	}
	
	@RequestMapping("/boardlist")
	public ModelAndView boardlist(@RequestParam(value="page", required=false, defaultValue="1") int page) {
		//전체 게시물 갯수 (9) 가져와서 몇페이지까지 (1페이지당 4개 게시물) -  1 2 3
		int totalBoard = service.getTotalBoard();
	
		//page번호 해당 게시물 4개 리스트 조회 
		int limitcount = 4;
		int limitindex = (page-1)*limitcount;
		int limit [] = new int[2];
		limit[0] = limitindex;
		limit[1] = limitcount;
		
		/*  1.  List<BoardDTO> -- 서비스 메소드 (limitindex,  limitcount);
		 *  2.  board-mapping.xml
		 * select * from board order by writingtime desc limit 배열[0],배열[1]
		 *  3. 1번 결과를 모델로 추가 저장
		 *  4. 뷰 3번 모델 저장 테이블 태그 출력
		 * */
		
		List<BoardDTO> list = service.boardList(limit);
				
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalBoard", totalBoard);
		mv.addObject("boardList", list);
		
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping("/boarddetail")
	public ModelAndView boarddetail(int seq) {
		ModelAndView mv = new ModelAndView();
		BoardDTO dto = service.updateViewcountAndGetDetail(seq);
		mv.addObject("detaildto", dto);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping("/boardwriter")
	public ModelAndView boardwriter(int seq) {
		ModelAndView mv = new ModelAndView();
		BoardMemberDTO dto = service.getWriterInform(seq);
		System.out.println(dto.getTitle()+":"+dto.getMember().getMemberid()+":"+dto.getPw()+":"+dto.getMember().getPw());
		mv.addObject("writerdto", dto);
		mv.setViewName("board/writer");
		return mv;
	}
	
	@RequestMapping("/boardsearchlist")
	public ModelAndView boardsearchlist(String item, String word) {
		HashMap map = new HashMap();
		
		map.put("colname", item);
		map.put("colvalue", "%"+word+"%");
		map.put("limitindex", 0);
		map.put("limitcount", 4);
		
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> list = service.searchList(map);
		for(BoardDTO dto : list) {
		System.out.println(dto.getTitle()+":");
		}
		//mv.addObject("writerdto", dto);
		//mv.setViewName("board/writer");
		return mv;
	}
	
	
}







