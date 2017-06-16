package com.choa.freeBoard;

import javax.inject.Inject;

import org.springframework.stereotype.Service;


@Service
//FreeBoardService freeBoardService = new FreeBoardService();
public class FreeBoardService {
	
	@Inject
	private FreeBoardDAO freeBoardDAO;
	
	public void test(){
		
		System.out.println("FreeBoardDAO : "+freeBoardDAO);
	}
	
	/*//Constructor
	public freeBoardService(freeBoardDAO freeBoardDAO) {
		this.freeBoardDAO = freeBoardDAO;
	}
	
	//setter
	public void setfreeBoardDAO(freeBoardDAO freeBoardDAO) {
		this.freeBoardDAO = freeBoardDAO;
	}*/
	
	
/*	//view
	public freeBoardDTO freeBoardView(int num) throws Exception{
		
		
		return freeBoardDAO.freeBoardView(num);
	}
	

	//list
	public List<freeBoardDTO> freeBoardList(int curPage) throws Exception{
		int result = freeBoardDAO.freeBoardCount();
		PageMaker pageMaker = new PageMaker(curPage, result);
		
		
		return freeBoardDAO.freeBoardList(pageMaker.getRowMaker());
	}
	
	//write
	public int freeBoardWrite(freeBoardDTO freeBoardDTO) throws Exception{
		return freeBoardDAO.freeBoardWrite(freeBoardDTO);
	}
	
	//update
	public int freeBoardUpdate(freeBoardDTO freeBoardDTO) throws Exception{
		return freeBoardDAO.freeBoardUpdate(freeBoardDTO);
	}
	
	//delete
	public int freeBoardDelete(int num){
		return freeBoardDAO.freeBoardDelete(num);
	}*/
	

}
