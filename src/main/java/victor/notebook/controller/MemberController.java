package victor.notebook.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import victor.notebook.annotation.SessionFilter;
import victor.notebook.domain.Member;
import victor.notebook.form.MemberForm;
import victor.notebook.service.MemberService;
import victor.notebook.util.SystemConstant;

@Controller
@RequestMapping(value="/member")
public class MemberController extends BaseController{

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private SystemConstant systemConstant;
	
	// 登入頁面
	@RequestMapping(value="/login",method= {RequestMethod.GET,RequestMethod.POST})
	public String login(HttpServletRequest request,Model model,MemberForm form) {
		model.addAttribute("memberForm", form);
		return "member/login";
	}
	
	// 註冊頁面
	@RequestMapping(value="/signup",method= {RequestMethod.GET,RequestMethod.POST})
	public String register(HttpServletRequest request,Model model,MemberForm form) {
		form.setAction("add");
		model.addAttribute("memberForm", form);

		return "member/signup";
	}

	// 更新會員資訊頁面
	@RequestMapping(value="/update",method= {RequestMethod.GET,RequestMethod.POST})
	@SessionFilter
	public String updateMember(HttpServletRequest request,Model model) {
		MemberForm form = new MemberForm();
		Member mbr = (Member) request.getSession().getAttribute(systemConstant.CurrentUser);
		form.setAction("edit");
		form.setId(mbr.getId());
		model.addAttribute("memberForm", form);
		return "fia.addOrEditMember";
	}
	
	// 會員資訊頁面 dashboard
	@RequestMapping(value="/dashboard",method= {RequestMethod.GET})
//	@SessionFilter
	public String memberCenter(HttpServletRequest request,Model model) {
		return "member/dashboard";
	}
	
	// 登入訊息回傳
	@RequestMapping(value="/dologin",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String doLogin(HttpServletRequest request,Model model , MemberForm form) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String,String> status = new HashMap();
		if(StringUtils.isBlank(form.getUserid())&&StringUtils.isBlank(form.getPassword())) {
			status.put("status", "blank username or password");
		}else {
			status = memberService.loginMessage(request,form);			
		}
		String result = "";
		try {
			result = mapper.writeValueAsString(status);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "{\"status\":\"fail\",\"message\":\"parse error\"}";
		}
		return result ;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String logout(HttpServletRequest request, Model model) {
		request.getSession().invalidate();
		MemberForm lf = new MemberForm();
        model.addAttribute("memberForm", lf);
		return "forward:/member/login";
	}
	
	@RequestMapping(value="/SaveOrUpdate",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String doSaveOrUpdate(HttpServletRequest request,Model model,MemberForm form) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String,String> status = new HashMap();
		String result = "";
		try {
			memberService.saveOrUpdate(form);
			status.put("status", "ok");
			status.put("message", "success");
			result = mapper.writeValueAsString(status);
		}catch(Exception e) {
			result = "{\"status\":\"fail\",\"message\":\""+e.toString()+"\"}";
		}
		
		return result;
		
	}
}
