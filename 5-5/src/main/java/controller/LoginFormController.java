package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.User;

@Controller
public class LoginFormController {
	@Autowired
	private Shop shopService;
	@Autowired
	private Validator loginValidator;
	
	@ModelAttribute
	public User setup() {
		return new User();
	}//콜백메서드(user생성)
	
	@RequestMapping(method=RequestMethod.GET)
	public String setupForm() {//콜백메서드
		return "loginform/login";
	}//콜백 메서드(login뷰 호출)
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user,BindingResult br, HttpSession session) { //ModelAndView <- 결과, 뷰
		this.loginValidator.validate(user, br);
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {//유효성 검사 결과가 에러가 있는 경우
			mav.getModel().putAll(br.getModel());
			//로그인 화면에서 입력했던 데이터를 지우지 않고 다시 출력한다.
			return mav;
		}
		try {
			User loginUser=this.shopService.getUserByUserIdAndPassword(user);
			if(loginUser != null) {//로그인 성공한 경우
				mav.setViewName("loginform/loginSuccess");
				mav.addObject("loginUser",loginUser);
				session.setAttribute("USER_KEY", loginUser);
				return mav;
			} else { //로그인 실패한 경우
				br.reject("error.login.user");//화면에 출력될 메세지 설정
				mav.getModel().putAll(br.getModel());
				return mav;
			}
		}catch(EmptyResultDataAccessException e) {
			br.reject("error.login.user");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
	}
}
