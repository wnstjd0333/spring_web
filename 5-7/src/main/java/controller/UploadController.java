package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.Writing;

@Controller
public class UploadController {
	@RequestMapping
	public void Read(String file, HttpSession session, HttpServletResponse response) throws Exception{
		ServletContext context = session.getServletContext(); //session은 절대 경로를 찾기 위해서 필요
		String path = context.getRealPath("/upload"); //웹 어플리케이션의 경로, webapp까지의 경로
		File filePath = new File(path + "/" +file); //File객체 생성
		response.setContentType("application/octet-stream");//브라우저에서 처리될 파일의 형태를 설정(octet-stream은 모든파일을 의미)
//		HttpServletResponse 브라우저와 매핑해주는 객체
		response.setHeader("Content-Disposition", "attachment");//브라우저에서 파일 다운로드 창열림 설정
		FileInputStream fis=new FileInputStream(filePath);
		BufferedInputStream bis = new BufferedInputStream(fis); 
		
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos=new BufferedOutputStream(sos);
		byte[] buffer = new byte[2048];//2k메모리 설정
		int input=0;
		while((input = bis.read(buffer))>0) {
			bos.write(buffer,0,input);
			bos.flush(); //버퍼가 가득차지 않아도 자동 출력
		}
		if(bos !=null) bos.close();
		if(sos !=null) sos.close();
		if(bis !=null) bis.close();
		if(fis !=null) fis.close();
	}
	
	
	@RequestMapping(value="/upload/write.html",method=RequestMethod.POST)
	public ModelAndView upload(Writing writing, HttpSession session) {
		MultipartFile multiFile = writing.getImage();
		String fileName = multiFile.getOriginalFilename();
		String path=null; OutputStream os = null;
		if(!fileName.equals("")) {//파일이 선택된 경우
			ServletContext context = session.getServletContext();
			path = context.getRealPath("/upload/"+fileName);
			try {
				os = new FileOutputStream(path);
				BufferedInputStream bis = new BufferedInputStream(multiFile.getInputStream());
				byte[] buffer = new byte[8196];
				int read = 0;
				while((read = bis.read(buffer))>0) {
					os.write(buffer,0,read);
				}
				if(os !=null) os.close();
			}catch(Exception e) {
				
			}
			writing.setImage_name(fileName);//이미지 파일 이름 설정
		} 
		return list(writing);
	}
	@RequestMapping(value="/upload/list.html", method=RequestMethod.GET)
	public ModelAndView list(Writing writing) {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("upload_file",writing);
		return mav;
	}
	@RequestMapping(value="/upload/form.html", method=RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("uploadForm");
		mav.addObject("writing",new Writing());
		return mav;
	}
}
