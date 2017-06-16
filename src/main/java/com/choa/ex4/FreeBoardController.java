package com.choa.ex4;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.freeBoard.FreeBoardDTO;
import com.choa.freeBoard.FreeBoardService;

@Controller
@RequestMapping(value="/freeBoard/**")
public class FreeBoardController {

	@Inject//type
	private FreeBoardService freeBoardService;
	
	@RequestMapping(value="freeBoard")
	public void test(){
		System.out.println("FreeBoardService : "+freeBoardService);
		freeBoardService.test();
	}
	
/*	//list
	@RequestMapping(value="freeBoardList", method=RequestMethod.GET)
	public void FreeBoardList(Model model, @RequestParam(defaultValue="1") Integer curPage) throws Exception{
		List<freeBoardDTO> ar = freeBoardService.freeBoardList(curPage);
		model.addAttribute("list", ar);
	}
	
	//View
	@RequestMapping(value="freeBoardView", method=RequestMethod.GET)
	public void FreeBoardView(Integer num, Model model) throws Exception{
		freeBoardDTO freeBoardDTO=freeBoardService.freeBoardView(num);
		model.addAttribute("dto", freeBoardDTO);
	}
	
	//writeForm
	@RequestMapping(value="freeBoardWrite", method=RequestMethod.GET)
	public void freeBoardWrite(Model model){
		model.addAttribute("path", "Write");
	}
	
	//write 
	@RequestMapping(value="freeBoardWrite", method=RequestMethod.POST)
	public String freeBoardWrite(freeBoardDTO freeBoardDTO, RedirectAttributes rd)throws Exception{
		int result=freeBoardService.freeBoardWrite(freeBoardDTO);
		String message = "FAIL";
		if(result>0){
			message="SUCCESS";
		}
		rd.addFlashAttribute("message", message);
		return "redirect:freeBoardList?curPage=2";
	}
	
	//update
	@RequestMapping(value="freeBoardUpdate", method=RequestMethod.GET)
	public String freeBoardUpdate(Integer num, Model model) throws Exception{
		freeBoardDTO freeBoardDTO = freeBoardService.freeBoardView(num);
		model.addAttribute("dto", freeBoardDTO);
		model.addAttribute("path", "Update");
		return "freeBoard/freeBoardWrite";
	}
	
	@RequestMapping(value="freeBoardUpdate", method=RequestMethod.POST)
	public String freeBoardUpdate(freeBoardDTO freeBoardDTO, RedirectAttributes rd) throws Exception{
		int result = freeBoardService.freeBoardUpdate(freeBoardDTO);
		String message = "FAIL";
		if(result>0){
			message="SUCCESS";
		}
		rd.addFlashAttribute("message", message);
		return "redirect:freeBoardList?curPage=1";
	}
	
	@RequestMapping(value="freeBoardDelete", method=RequestMethod.GET)
	public void freeBoardDelete(Integer num){
		int result = freeBoardService.freeBoardDelete(num);
	}*/
	
	
	
}
