package victor.notebook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/note")
public class NoteController {

	// 新增筆記頁面，回傳html --> 用燈箱的方式
	@RequestMapping(value="/addOne",method= {RequestMethod.GET,RequestMethod.POST},produces=MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String addNotes(HttpServletRequest req,Model model) {
		// note shown on the lightbox with html
		return "";
	}
	
	// 編輯筆記頁面，回傳html --> 用燈箱的方式
	@RequestMapping(value="/editOne/{noteId}",method= {RequestMethod.GET,RequestMethod.POST},produces=MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String editNotes(HttpServletRequest req,Model model,@PathVariable("noteId") Integer id) {
		// note shown on the lightbox with html
		return "";
	}

	// 回傳json
	@RequestMapping(value="/SaveOrUpdate", method= {RequestMethod.POST},produces="application/json; charset=utf-8")
	@ResponseBody
	public String SaveOrUpdate(){
		
		return "";
		
	}
	
	// 回傳json
	@RequestMapping(value="/delete/{noteId}", method= {RequestMethod.POST},produces="application/json; charset=utf-8")
	@ResponseBody
	public String deleteNote(){
		
		return "";	
	}
	
}
