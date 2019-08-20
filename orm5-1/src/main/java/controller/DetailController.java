package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.Item;

@Controller
public class DetailController {
	private Shop shopService;

	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	@RequestMapping
	public ModelAndView detailItem(Integer itemId) {
		Item item=this.shopService.getItemByItemId(itemId);
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("item", item);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("detail");
		mav.addAllObjects(model);
		return mav;
	}
}












