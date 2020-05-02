package victor.notebook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/notebook")
public class NotebookController {
	
	@RequestMapping(value="/list",method= {RequestMethod.GET,RequestMethod.POST})
	public String listNotebook(HttpServletRequest req,Model model) {
		// check member in session
		
		// if not in session
		
		// if in session
		return "";
	}
	
	@RequestMapping(value="/showPage/{id}",method= {RequestMethod.GET,RequestMethod.POST})
	public String showPages(HttpServletRequest req,Model model,@PathVariable("id") int id) {
		// check pageService
		return "";
	}
	
}
