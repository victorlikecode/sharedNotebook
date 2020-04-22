package victor.notebook.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import victor.notebook.annotation.SessionFilter;
import victor.notebook.form.MemberForm;
import victor.notebook.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class HomeController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login",method= {RequestMethod.GET,RequestMethod.POST})
	public String login(HttpServletRequest request,Model model) {
		MemberForm form = new MemberForm();
		model.addAttribute("memberForm", form);
		return "fia.login";
	}
	
	@RequestMapping(value="/register",method= {RequestMethod.GET,RequestMethod.POST})
	public String register(HttpServletRequest request,Model model) {
		MemberForm form = new MemberForm();
		model.addAttribute("memberForm", form);

		return "fia.addOrEditMember";
	}

	
	@RequestMapping(value="/update",method= {RequestMethod.GET,RequestMethod.POST})
	@SessionFilter
	public String updateMember(HttpServletRequest request,Model model) {
		MemberForm form = new MemberForm();
		model.addAttribute("memberForm", form);
		return "fia.addOrEditMember";
	}
	
	@RequestMapping(value="/center",method= {RequestMethod.GET})
	@SessionFilter
	public String memberCenter(HttpServletRequest request,Model model) {
		return "";
	}
	
	@RequestMapping(value="/dologin",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String doLogin(HttpServletRequest request,Model model ,MemberForm form) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String,String> status = new HashMap();
		if(StringUtils.isNoneBlank(form.getUsername())&&StringUtils.isNoneBlank(form.getPassword())) {
			status.put("status", "blank username or password");
		}else {
			status = memberService.loginStatus(request,form);			
		}
		String result = "";
		try {
			result = mapper.writeValueAsString(status);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "{\"status\":\"parse error\"}";
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
}
