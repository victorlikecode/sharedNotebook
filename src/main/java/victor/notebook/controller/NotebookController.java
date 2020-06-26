package victor.notebook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import victor.notebook.annotation.SessionFilter;
import victor.notebook.domain.Member;
import victor.notebook.domain.Notebook;
import victor.notebook.form.NotebookForm;
import victor.notebook.service.NoteBookService;
import victor.notebook.util.SystemConstant;

@Controller
@RequestMapping(value="/notebook")
public class NotebookController extends BaseController{
	
	@Autowired
	private SystemConstant systemConstant;
	@Autowired
	private NoteBookService notebookService;
	
	//新增Notebook
	@RequestMapping(value="/addOne",method= {RequestMethod.GET,RequestMethod.POST})
	@SessionFilter
	public String addnotebook(HttpServletRequest req,Model model,NotebookForm notebookform) {
		Member logMember = (Member) req.getSession().getAttribute(systemConstant.CurrentUser);
		notebookform.setAction("add");
		notebookform.setMemberId(logMember.getId());
		
		model.addAttribute("notebookForm", notebookform);		
		return "notebooks/AddOrEditNotebooks";
	}
	
	//編輯Notebook大綱
	@RequestMapping(value="/editOne/{bookId}",method= {RequestMethod.GET,RequestMethod.POST})
	@SessionFilter
	public String editnotebook(HttpServletRequest req,Model model,@PathVariable("bookId") int id,NotebookForm notebookform) {
		Member logMember = (Member) req.getSession().getAttribute(systemConstant.CurrentUser);
		Notebook note = notebookService.getNotebookById(id);
		notebookform.setAction("edit");
		notebookform.setMemberId(logMember.getId());
		notebookform.setBookId(id);
		notebookform.setTitle(note.getTitle());
		notebookform.setPublic(!note.isPrivate());
		
		model.addAttribute("notebookForm", notebookform);
		return "notebooks/AddOrEditNotebooks";
	}
		
	//儲存Notebook
	@RequestMapping(value="/SaveOrUpdate",method= {RequestMethod.POST},produces="application/json; charset=utf-8")
	@ResponseBody
	public String saveOrUpdate(HttpServletRequest req,Model model, NotebookForm notebookform) {
		return new SaveOrUpdateObject<NotebookForm>(req,notebookform) {

			@Override
			public void doSaveOrUpdate(HttpServletRequest request, NotebookForm vo, Object... objects)
					throws Exception {
				// TODO Auto-generated method stub
				notebookService.saveOrupdate(vo);
			}
			
		}.toString();
	}
}
