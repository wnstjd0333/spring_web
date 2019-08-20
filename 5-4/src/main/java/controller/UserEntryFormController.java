package controller;

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
	private Shop shopService;
	private UserEntryValidator userEntryValidator;
	private MessageSource messageSource;
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	public void setUserEntryValidator(UserEntryValidator userEntryValidator) {
		this.userEntryValidator = userEntryValidator;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
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
		return "userEntry";
	}//酉곗씠由꾩쓣 由ы꽩, 利� userEntry�씪�뒗 �씠由꾩쓽 JSP
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user,BindingResult br) {
		this.userEntryValidator.validate(user, br);
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;//�떎�떆 �룞�씪�븳 �벑濡앺뤌(userEntry.jsp)媛� �뿴由곕떎.
		}
		try {
			this.shopService.entryUser(user);
			mav.setViewName("userEntrySuccess");
			mav.addObject("user",user);
			return mav;//�솕硫댁쓣 userEntrySuccess濡� 諛붽씔�떎.
		}catch(DataIntegrityViolationException e) {
			//留뚯빟 �룞�씪�븳 �뜲�씠�꽣媛� DB�뿉 議댁옱�븯�뒗 寃쎌슦, �삁�쇅媛� 諛쒖깮
			br.reject("error.duplicate.user");//�뜲�씠�꽣 以묐났 �삤瑜섏텧�젰
			mav.getModel().putAll(br.getModel());
			return mav;//�떦�떆 �룞�씪�븳 �벑濡앺뤌(userEntry.jsp)�씠 �뿴由곕떎.
		}
	}
}













