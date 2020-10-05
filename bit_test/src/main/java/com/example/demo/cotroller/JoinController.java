package com.example.demo.cotroller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.BitSms;


@Controller
@RequestMapping("/join.do")
public class JoinController {
	// 인증키를 전송하는 폼
	
	@Autowired
	private BitSms bs;
	
		
	public void setBs(BitSms bs) {
		this.bs = bs;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(String to, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("redirect:/joinOk.do");
		//문자 성공에 성공했으면
		Random rand = new Random();
		String msg = rand.nextInt(10)+""+rand.nextInt(10)+""+rand.nextInt(10)+""+rand.nextInt(10);
		session.setAttribute("sendMsg", msg);
		// 보낸 메세지를 sendMsg로 상태유지
		
		String re = bs.sendMsg("01096873487", to, msg);
		
		if(!re.equals("1")) {
			// 실패햇다면 다시 join으로 돌아감
			mav.setViewName("join");
			mav.addObject("msg", "인증키 전송에 실패하였습니다. 올바른 전화번호를 입력하세요.");
		}
		
		return mav;
			
		
	}

}
