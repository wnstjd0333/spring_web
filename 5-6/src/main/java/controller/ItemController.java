package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import logic.ItemService;
import model.Item;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	@RequestMapping(value="/item/create.html",method=RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView mav= new ModelAndView("add");
		mav.addObject(new Item());
		return mav;
	}
	@RequestMapping(value="/item/confirm.html",method=RequestMethod.GET)
	public ModelAndView confirm(Integer itemId) {
		ModelAndView mav= new ModelAndView("delete");
		Item item=this.itemService.getItembyItemId(itemId);
		mav.addObject(item);
		mav.addObject("imageName",item.getPictureUrl());
		return mav;
	}
	
	@RequestMapping(value="/item/delete.html",method=RequestMethod.POST)
	public ModelAndView delete(Integer itemId) {
		this.itemService.deleteItem(itemId);
		return this.index();//삭제한 후 다시 목록 출력
	}
	
	@RequestMapping(value="/item/update.html",method=RequestMethod.POST)
	public ModelAndView update(@Valid Item item, BindingResult bindingResult, HttpServletRequest request) {
	   if(bindingResult.hasErrors()) {
	       ModelAndView mav = new ModelAndView("update");
	         mav.getModel().putAll(bindingResult.getModel());
	         return mav;
	      }
	      MultipartFile multifile = item.getPicture();
	      String fileName = null; 
	      String path = null;
	      OutputStream out = null;
	      if(!item.getPicture().getOriginalFilename().equals("")) {
	         fileName = multifile.getOriginalFilename();//업로드
	         path = request.getSession().getServletContext().getRealPath("/upload/"+fileName);
	         File file = new File(path);
	         try {
	            out = new FileOutputStream(path);
	            BufferedInputStream bis = new BufferedInputStream
	                  (multifile.getInputStream());
	            byte[] buffer = new byte[8106];
	            int read = 0;
	            while((read=bis.read(buffer))>0) {
	               out.write(buffer,0,read);
	            }
	            if(bis != null) bis.close();
	            if(out != null) out.close();
	         } catch(Exception e) {
	            
	         }
	         item.setPictureUrl(fileName);//업로드된 파일이름 설정
	      }//이미지 파일이 선택된 경우
	      
	      this.itemService.updateItem(item);
	      return this.index();// 상품 변경 후 다시 목록을 출력
	      
	   }
	   
	   @RequestMapping(value="/item/edit.html",method=RequestMethod.GET)
	   public ModelAndView edit(Integer itemId) {
	      ModelAndView mav = new ModelAndView("update"); //모델앤뷰를 생성할떄 생성자에 업데이트가 들어가는데 여기 앞뒤에 프레픽스 서픽스 붙은
	      Item item = this.itemService.getItembyItemId(itemId);
	      mav.addObject(item);
	      return mav;
	   }
	   
	@RequestMapping(value="/item/register.html",method=RequestMethod.POST)
	public ModelAndView register(@Valid Item item, BindingResult bindingResult, HttpServletRequest request) {
		//유효성 검사, 이미지 업로드, 이미지 경로는 DB로 
		if(bindingResult.hasErrors()) {
			ModelAndView mav= new ModelAndView("add");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		//지금부터 업로드
		MultipartFile multiFile = item.getPicture();
		String fileName = null;
		String path = null;
		OutputStream out = null;
		if(multiFile != null) {//업로드한 이미지가 존재하는 경우
			fileName = multiFile.getOriginalFilename();//파일이름저장
			//path에 이미지의 절대 경로를 불러온다.
			//절대경로는 ServletContext객체를 통하여 알 수 있으므로, ServletContext객체가 필요하다.
			//이 객체는 HttpServletRequest객체를 통하여 생성이 된다.
			path=request.getSession().getServletContext().getRealPath("/upload/"+fileName);
			System.out.println("업로드경로:"+path);

			File file = new File(path);//업로드할 파일이 생성
			try {
				out = new FileOutputStream(path);
				BufferedInputStream bis=new BufferedInputStream(multiFile.getInputStream());
				byte[] buffer=new byte[8106];//8K크기
				int read = 0;
				while((read = bis.read())>0) {
					out.write(buffer,0,read); //버퍼에 있는 내용을 0부터 read수까지 out해라.
				}//파일로 출력			
				if(out != null) out.close();//사용한 객체를 닫음
				if(bis != null) bis.close();//사용한 객체를 닫음
			}catch(Exception e) {
				
			}
			
		}
		//DB삽입 부분
		item.setPictureUrl(fileName);//파일의 이름을 설정
		this.itemService.entryItem(item);//DB에 삽입
		return index();//아래의 메서드(즉, 목록을 출력)호출
	}

	
	@RequestMapping(value="/item/search.html",method=RequestMethod.POST)//index.jsp
	public ModelAndView search(String itemName) {
		if(itemName == null || itemName.equals("")) {
			return this.index();//목록을 출력
		}//검색된 상품이 없는 경우
		List<Item> itemList = this.itemService.getItemByItemName(itemName);//이름으로 상품 검색
		if(itemList == null || itemList.isEmpty()) {
			return this.index();
		}//검색된 상품이 없는 경우
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("itemList",itemList);
		return mav;
	}
	
	@RequestMapping(value="/item/index.html",method=RequestMethod.GET)
	public ModelAndView index() {
		List<Item> itemList = this.itemService.getItemList();
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("itemList", itemList);
		ModelAndView mav= new ModelAndView("index");
		mav.addAllObjects(model);
		return mav;
		
	}
}
