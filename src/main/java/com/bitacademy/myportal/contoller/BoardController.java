package com.bitacademy.myportal.contoller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal.service.BoardService;
import com.bitacademy.myportal.vo.BoardVo;
import com.bitacademy.myportal.vo.MemberVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	// 로거 연결
	private static Logger logger = 
			LoggerFactory.getLogger(BoardController.class);
	// 서비스 연결하기
	@Autowired
	BoardService boardServiceImpl;
	
	@RequestMapping({"","/","/list"})
	public String list(Model model) {
		List<BoardVo> list = boardServiceImpl.getList();
		model.addAttribute("list", list);
		logger.debug("게시물 목록:" + list);
		
		return "board/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm(HttpSession session) {
		// 사용자를 체크해서 로그인 하지않은 경우 쓰기 기능 제한
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/";
		}
		return "board/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writeAction(@ModelAttribute BoardVo vo,
			HttpSession session) {
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/board/write";
		}
		// 전달받은 BoardVo 객체에 현재 로그인 한 사용자의 PK를 삽입
		vo.setMemberNo(authUser.getNo());
		boolean success = boardServiceImpl.write(vo);
		
		logger.debug("게시물 등록 결과", success);
		if (success) {
			return "redirect:/board";
		} else {
			return "redirect:/board/write";
		}
	}
	// 게시물조회
	@RequestMapping("/{no}")
	public String view(@PathVariable Long no, Model model) {
		BoardVo vo = boardServiceImpl.getContent(no);
		model.addAttribute("vo",vo);
		return "board/view";
	}
	
	@RequestMapping("/{no}/modify")
	public String modifyForm(@PathVariable Long no, Model model,
			HttpSession session) {
		BoardVo vo = boardServiceImpl.getContent(no);
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/board";
		} else if (authUser.getNo() != vo.getMemberNo()) {
			// 게시물 작성자가 아니면
			return "redirect:board";
		}
		model.addAttribute("vo", vo);
		return "/board/modify";
		
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modifyAction(@ModelAttribute BoardVo updatedVo) {
		// 기존 게시물 불러오기
		BoardVo vo = boardServiceImpl.getContent(updatedVo.getNo());
		// 변경된 내용 교체
		vo.setTitle(updatedVo.getTitle());
		vo.setContent(updatedVo.getContent());
		
		boolean success = boardServiceImpl.update(vo);
		
		logger.debug("게시물 업데이트:" + success);
		
		// 리스트로 리다이렉트 
		return "redirect:/board";
	}
}
