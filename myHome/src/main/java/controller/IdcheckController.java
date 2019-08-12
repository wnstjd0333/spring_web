package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.LoginCatalog;

@Controller
public class IdcheckController {
	@Autowired
	private LoginCatalog loginCatalog;
	
	@RequestMapping(value="/idcheck/idcheck.html",method=RequestMethod.GET)
	public ModelAndView idcheck(String ID) {
		//DB에서 ID에 있는 계정이 이미 존재하는지 검사
		ModelAndView mav = new ModelAndView("home/idCheck");
		Integer cnt = loginCatalog.getIdCnt(ID);
		if(cnt > 0) {
			mav.addObject("DUP","YES");
		} else {
			mav.addObject("DUP","NO");
		}
		mav.addObject("ID",ID);
		return mav;
	}
}
