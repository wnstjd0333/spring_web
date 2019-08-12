package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Item;

@Controller
public class ProductController {
	@RequestMapping(value = "/product/open.html", method = RequestMethod.GET)
	public ModelAndView bbsTemp() {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject(new Item());
		mav.addObject("BODY", "open.jsp");
		return mav;
	}

}
