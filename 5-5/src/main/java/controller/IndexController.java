package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.Item;
import model.User;

//컨트롤러 DispatcherServlet에 의해 호출되어 사용자의 Request를 전달 받아 
//해당 요청의 비지니스 처리를 담당하는 서비스 객체를 Spring으로 부터 주입(DI)받아서
//그 서비스 객체에 처리를 위임하고, 처리 결과와 결과 화면에 대한 정보를 DispatcherServlet에 반환한다.
//쉽게 말하자면 접수계에서 주문을 검증하고 배송지 태그 부착
@Controller//컨트롤러 객체임을 명시, 클래스 파일에 대한 bean을 자동 생성
public class IndexController{ //목록을 보여주는 컨트롤러
	@Autowired//속성,setter method, 생성자에서 사용. 의존관계(DI)를 자동으로 설정, 객체 삽입하므로 세터 필요x
	private Shop shopService;
	
	//애노테이션을 이용해서 클라이언트의 요청을 처리할 메서드를 지정,여기서 value값을 찾아서 해당 method를 수행
	//Url을 value또는 method와 매핑 시켜주는 역할
	@RequestMapping  //콜백/리턴값으로 뷰 이름을 넘겨주지 않아도 자동으로 찾아서 수행, Controller anotation하에서만 사용가능
	public ModelAndView handleRequest(HttpSession session) throws Exception {
		List<Item> itemList=this.shopService.getItemList();
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("itemList", itemList);
		ModelAndView mav = new ModelAndView();
		//컨트롤러의 처리 결과를 보여줄 뷰와 뷰에서 출력할 모델을 지정
		//DispatherServlet은 스프링 컨테이너에서 컨트롤러 객체를 검색하기 때문에 스프링 설정 파일에 컨트롤러를 빈으로 등록해야 함.
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser !=null) {
			mav.addObject("loginUser",loginUser);
		}
//		mav.setViewName("index");
		mav.addAllObjects(model); //맵을 ModelAndView에 저장
		return mav;				  //ModelAndView를 서블릿으로 리턴 	
	}

}
