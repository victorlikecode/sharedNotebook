package victor.notebook.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import victor.notebook.domain.Member;
import victor.notebook.form.MemberForm;
import victor.notebook.persistence.DAO.MemberDAO;
import victor.notebook.repository.IMemberDAO;
import victor.notebook.util.EncryptUtil;
import victor.notebook.util.SystemConstant;

@Service
public class MemberService{

	@Autowired
	private IMemberDAO mbrdao;
	
	@Autowired
	private EncryptUtil encryptUtil;
	
	@Autowired
	private SystemConstant sysConst;
//	public int getCount() {
//		return mbrdao.getcount();
//	}
	
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public void saveOrUpdate(MemberForm form) {
		Member memberToEdit = null ;
		if(form.getAction().equalsIgnoreCase("add")) {
			memberToEdit = new Member();
			memberToEdit.setUserid(form.getUserid());
			String password = encryptUtil.md5HashString(form.getPassword());
			memberToEdit.setPassword(password);
			memberToEdit.setEmail(form.getEmail());
			memberToEdit.setInBlackList(false);
			memberToEdit.setExpired(false);
			memberToEdit.setDeleted(false);
			
			mbrdao.create(memberToEdit);
		}else {
			memberToEdit = mbrdao.read(form.getId());
			if(StringUtils.isNotBlank(form.getPassword())&form.getPassword().equals(form.getPasswordConfirm())) {
				String password = encryptUtil.md5HashString(form.getPassword());
				memberToEdit.setPassword(password);
			}
			
			if(StringUtils.isNotBlank(form.getEmail())) {
				memberToEdit.setEmail(form.getEmail());
			}
			

			mbrdao.update(memberToEdit);
		}
	}
	
	/**
	 * return format {"status":ok or fail,"message":訊息}
	 * 
	 * @param request
	 * @param form
	 * @return
	 */
	public Map<String,String> loginMessage(HttpServletRequest request,MemberForm form) {
		Map<String,String> result = new HashMap();
		// input invalid
		String userId = form.getUserid();
		String password = form.getPassword();
//		if(StringUtils.isNoneBlank(userId)&&StringUtils.isNoneBlank(password)) {
//			result.put("status", "invalid Inputs");
//		}
		// if member is not null 
		
		try {
			Member loginMbr = mbrdao.getMemberByuserId(userId);
			if(Objects.nonNull(loginMbr)) {
				if(encryptUtil.md5HashString(password).equals(loginMbr.getPassword())) {
					result.put("status", "ok");
					result.put("message", "login successful");
					request.getSession().setAttribute(sysConst.CurrentUser, loginMbr);
				}else {
					result.put("status", "fail");
					result.put("message", "login error");
				}
			}
			// if member is null
			else {
				result.put("status", "fail");
				result.put("message", "member dont exist");
			}			
		}catch(Exception e) {
			result.put("status", "fail");
			result.put("message", "database error");
		}
		return result;
		
	}
	
	public Member getMemberByUserId(String userId) {
		if(StringUtils.isNoneBlank(userId)) {
			return mbrdao.getMemberByuserId(userId);
		}else {
			return null;
		}
	}
	
	public Member getMemberByMemberId(Integer memberId) {
		return mbrdao.getMemberById(memberId);
	}
}
