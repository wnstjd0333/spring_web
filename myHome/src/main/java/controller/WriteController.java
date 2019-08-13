package controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import logic.WriteCatalog;
import model.Condition;
import model.Writing;

@Controller
public class WriteController {
	@Autowired
	private WriteCatalog writeCatalog;
	
	@RequestMapping(value="/write/deleteDo.html", method=RequestMethod.POST)
	public ModelAndView deleteDo(Writing writing) {
		Writing old = writeCatalog.getWritingById(writing.getWriting_id());//기존 글 검색
		ModelAndView mav= new ModelAndView("home/template");
		if(writing.getPassword().equals(old.getPassword())) {
			this.writeCatalog.deleteWriting(writing);//DB에서 삭제
			mav.addObject("BODY","delete_result.jsp");
		} //입력한 암호와 게시글의 암호가 일치하는 경우 
		else {
			mav.addObject("BODY","delete_result.jsp?id="+writing.getWriting_id());
			
		}//일치하지 않는 경우
		return mav;
	}
	
	@RequestMapping(value="/write/writeDelete.html", method=RequestMethod.GET)
	public ModelAndView writeDelete(Integer id) {
		ModelAndView mav = new ModelAndView("home/template");
		Writing writing = this.writeCatalog.getWritingById(id);
		mav.addObject(writing);
		mav.addObject("BODY","delete_form.jsp");
		return mav;
	}
	
	@RequestMapping(value="/write/writeList.html")
	public ModelAndView writeList(Integer SEQNO, Integer PAGE_NUM) {
		if(PAGE_NUM == null) PAGE_NUM = 1;
		ModelAndView mav = new ModelAndView("home/template");
		if(SEQNO != null) {
			int rownum = writeCatalog.selectReplyPages(SEQNO);
			int page = rownum/5;
			if(rownum % 5 != 0) page++;
			PAGE_NUM = page;
		}
		int currentPage = PAGE_NUM;
		int totalPageCount = 0;
		int startRow = 0;
		int endRow = 0;
		int count = writeCatalog.selectImageCount();//전체글 갯수
		if(count > 0) {
			totalPageCount = count / 5;
			if(count % 5 > 0) totalPageCount++;
			startRow = (currentPage - 1) *5 +1;
			endRow = currentPage * 5;
			if(endRow > count) endRow = count;
		}
		Condition c = new Condition();
		c.setStartRow(startRow);
		c.setEndRow(endRow);
		List<Writing> writeList = writeCatalog.getWriting(c);
		mav.addObject("LIST",writeList);
		mav.addObject("count",count);
		mav.addObject("startRow",startRow);
		mav.addObject("endRow",endRow);
		mav.addObject("pageCount",totalPageCount);
		mav.addObject("currentPage",currentPage);
		mav.addObject("BODY","list_view.jsp");
		return mav;
	}
	
	@RequestMapping(value="/write/write.html", method=RequestMethod.POST)
	public ModelAndView write(@Valid Writing writing,BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("home/template");
			mav.addObject("BODY","writeForm.jsp");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		MultipartFile multiFile=writing.getImage();
		String fileName = null;
		String path = null;
		OutputStream os = null;
		if(multiFile != null) {//업로드 이미지를 선택한 경우
			fileName = multiFile.getOriginalFilename();
			ServletContext context = session.getServletContext();
			path = context.getRealPath("/upload/" +fileName);
			try {
				os = new FileOutputStream(path);
				BufferedInputStream bis = new BufferedInputStream(multiFile.getInputStream());
				byte[] buffer = new byte[8196];//8k 크기 메모리 선언
				int read = 0;
				while((read=bis.read(buffer))>0) {
					os.write(buffer,0,read);//파일에 출력(즉,업로드)
				}
				if(os != null) os.close();
			}catch(Exception e) { }
			writing.setImage_name(fileName);//파일이름 설정
		}
		//DB삽입
		Integer maxId = writeCatalog.getMaxWritingId();
		if(maxId == null) maxId = 0;//글번호 저장
		if(writing.getParent_id() == null) {//원글의 경우
			writing.setGroup_id(0);//임시로 처리
			writing.setParent_id(0);
			writing.setOrder_no(0);
		}else {//답글인 경우
			
		}
		writing.setWriting_id(maxId+1);//글번호 1증가
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONDAY) +1;
		int date = today.get(Calendar.DATE);
		String registerDate =year+"/"+month+"/"+date;
		writing.setRegister_date(registerDate);
		this.writeCatalog.insertWriting(writing);//DB에삽입
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BODY","writeResult.jsp?SEQNO="+(maxId+1));
		return mav;
	}
	
	@RequestMapping(value="/write/writeForm.html", method=RequestMethod.GET)
	public ModelAndView writeForm(HttpSession session) {
		String id = (String)session.getAttribute("loginUser");
		ModelAndView mav = new ModelAndView("home/template");
		if(id == null) {//로그인 하지 않은 경우
			mav.addObject("BODY","writeFormLogin.jsp");
		} else {//로그인 한 경우
			mav.addObject("BODY","writeForm.jsp");
			mav.addObject(new Writing()); // 객체주입 (form:form)
			
		}
		return mav;
	}
}
