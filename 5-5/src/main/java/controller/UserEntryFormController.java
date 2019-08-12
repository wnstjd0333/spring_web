package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.User;
import utils.UserEntryValidator;

@Controller
public class UserEntryFormController {
	@Autowired
	private Shop shopService;
	@Autowired
	private UserEntryValidator userEntryValidator;
	@Autowired
	private MessageSource messageSource;
		
	@ModelAttribute
	public User setup() {
		User user = new User();
		MessageSourceAccessor msa = 
				new MessageSourceAccessor(this.messageSource);
		user.setUserId(msa.getMessage("user.userId.default"));
		user.setUserName(msa.getMessage("user.userName.default"));
		return user;
	}
	@RequestMapping(method=RequestMethod.GET)
	public String toUserEntry() {
		return "userentryform/userEntry";
	}//酉곗씠由꾩쓣 由ы꽩, 利� userEntry�씪�뒗 �씠由꾩쓽 JSP
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user,BindingResult br, HttpSession session) {
		this.userEntryValidator.validate(user, br);    
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;//다시 동일한 등록폼userEntry.jsp)이열린다
		}
		try {
			this.shopService.entryUser(user);  //삽입
			session.setAttribute("USER_KEY", user);
			mav.setViewName("userentryform/userEntrySuccess");
			mav.addObject("user",user);
			return mav;//화면을 userEntrySuccess로 바꾼다
		}catch(DataIntegrityViolationException e) {
			//만약 동일한 데이터가 DB에 존재하는 경우, 예외가 발생한다.
			br.reject("error.duplicate.user");//데이터 중복 오류
			mav.getModel().putAll(br.getModel());
			return mav;//다시 동일한 등록폼userEntry.jsp)이열린다
		}
	}
}













