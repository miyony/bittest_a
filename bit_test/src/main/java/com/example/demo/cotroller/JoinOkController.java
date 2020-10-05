package com.example.demo.cotroller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/joinOk.do")
public class JoinOkController {
	// 인증키를 전송시키고 입력받는 폼
	
	@RequestMapping(method = RequestMethod.GET)
	public void form() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(String key, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("redirect:/insertMember.do");
		
		session.setAttribute("msg", "전화번호 인증이 되었습니다.");
		session.setAttribute("text_color", "blue");
		String sendMsg = (String)session.getAttribute("sendMsg");
		
		if(!sendMsg.equals(key)) {
			// 인증키가 같지 않다면
			session.setAttribute("msg", "전화번호 인증에 실패하였습니다.");
			mav.setViewName("redirect:/join.do");
			
		}
		
		
		return mav;
		
	}

}
