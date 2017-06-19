package com.choa.ex4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.freeBoard.FreeBoardDTO;
import com.choa.freeBoard.FreeBoardServiceImpl;

@Controller
@RequestMapping(value="/freeBoard/**")
public class FreeBoardController {

	@Inject//type
	private FreeBoardServiceImpl freeBoardServiceImpl;
	
	//list
	@RequestMapping(value="freeBoardList", method=RequestMethod.GET)
	public String freeBoardList(Model model, @RequestParam(defaultValue="1") Integer curPage) throws Exception{
		List<BoardDTO> ar = freeBoardServiceImpl.boardList(curPage);
		model.addAttribute("list", ar);
		model.addAttribute("board", "freeBoard");
		return "board/boardList";
	}
	
	//View
	@RequestMapping(value="freeBoardView", method=RequestMethod.GET)
	public String freeBoardView(Integer num, Model model) throws Exception{
		BoardDTO freeBoardDTO=freeBoardServiceImpl.boardView(num);
		model.addAttribute("dto", freeBoardDTO);
		model.addAttribute("board", "freeBoard");
		
		return "board/boardView";
	}
	
	//writeForm
	@RequestMapping(value="freeBoardWrite", method=RequestMethod.GET)
	public String freeBoardWrite(Model model){
		model.addAttribute("path", "Write");
		model.addAttribute("board", "freeBoard");
		
		return "board/boardWrite";
	}
	
	//write 
	@RequestMapping(value="freeBoardWrite", method=RequestMethod.POST)
	public String freeBoardWrite(FreeBoardDTO freeBoardDTO, RedirectAttributes rd)throws Exception{
		int result=freeBoardServiceImpl.boardWrite(freeBoardDTO);
		String message = "FAIL";
		if(result>0){
			message="SUCCESS";
		}
		rd.addFlashAttribute("message", message);
		return "redirect:freeBoardList?curPage=1";
	}
	
	//update
	@RequestMapping(value="freeBoardUpdate", method=RequestMethod.GET)
	public String freeBoardUpdate(Integer num, Model model) throws Exception{
		BoardDTO freeBoardDTO = freeBoardServiceImpl.boardView(num);
		model.addAttribute("dto", freeBoardDTO);
		model.addAttribute("path", "Update");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="freeBoardUpdate", method=RequestMethod.POST)
	public String freeBoardUpdate(FreeBoardDTO freeBoardDTO, RedirectAttributes rd) throws Exception{
		int result = freeBoardServiceImpl.boardUpdate(freeBoardDTO);
		String message = "FAIL";
		if(result>0){
			message="SUCCESS";
		}
		rd.addFlashAttribute("message", message);
		return "redirect:freeBoardList?curPage=1";
	}
	
	@RequestMapping(value="freeBoardDelete", method=RequestMethod.GET)
	public void freeBoardDelete(Integer num)throws Exception{
		int result = freeBoardServiceImpl.boardDelete(num);
		if(result>0){
			
		}
	}
	
	
	

	
	
}
