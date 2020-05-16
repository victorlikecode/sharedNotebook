package victor.notebook.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import victor.notebook.annotation.SessionFilter;
import victor.notebook.domain.Member;
import victor.notebook.util.SystemConstant;

@Controller
@RequestMapping(value="/notebook")
public class NotebookController {
	
	@Autowired
	private SystemConstant systemConstant;
	
	@RequestMapping(value="/list",method= {RequestMethod.GET,RequestMethod.POST})
	@SessionFilter
	public String listNotebook(HttpServletRequest req,Model model) {
		// check member in session
		Member recentUser = (Member)req.getSession().getAttribute(systemConstant.CurrentUser);
		if(Objects.nonNull(recentUser)) {
			
		}
		// if not in session
		else {
			
		}
		// if in session
		return "fia.Notebooks";
	}
	
	@RequestMapping(value="/edit/{noteId}",method= {RequestMethod.GET,RequestMethod.POST})
	@SessionFilter
	public String addoreditnotebook(HttpServletRequest req,Model model,@PathVariable("noteId") int id) {
		return "fia.NotebookInfo";
	}
	
	@RequestMapping(value="/showPage/{id}",method= {RequestMethod.GET,RequestMethod.POST})
	@SessionFilter
	public String showPages(HttpServletRequest req,Model model,@PathVariable("id") int id) {
		// check pageService
		return "";
	}
	
}
