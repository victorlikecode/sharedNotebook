package victor.notebook.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import victor.notebook.domain.Member;
import victor.notebook.persistence.DAO.MemberDAO;
import victor.notebook.util.EncryptUtil;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mbrdao;
	@Autowired
	private EncryptUtil encryptUtil;
	
	public int getCount() {
		return mbrdao.getcount();
	}
	
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public void saveOrUpdate(Member memberForm) {
		Member memberToEdit = null ;
		if(memberForm.getAction().equalsIgnoreCase("add")) {
			memberToEdit = new Member();
			memberToEdit.setUserid(memberForm.getUserid());
			String password = encryptUtil.md5HashString(memberForm.getPassword());
			memberToEdit.setPassword(password);
			memberToEdit.setEmail(memberForm.getEmail());
			memberToEdit.setInBlackList(false);
			memberToEdit.setExpired(false);
			memberToEdit.setDeleted(false);
			
			mbrdao.create(memberToEdit);
		}else {
			memberToEdit = mbrdao.read(memberForm.getId());
			if(StringUtils.isNotBlank(memberForm.getPassword())) {
				String password = encryptUtil.md5HashString(memberForm.getPassword());
				memberToEdit.setPassword(password);
			}
			
			if(StringUtils.isNotBlank(memberForm.getEmail())) {
				memberToEdit.setEmail(memberForm.getEmail());
			}
			
			if(Objects.nonNull(memberForm.isDeleted())) {
				memberToEdit.setDeleted(memberForm.isDeleted());
			}
			
			if(Objects.nonNull(memberForm.isInBlackList())) {
				memberToEdit.setInBlackList(memberForm.isInBlackList());
			}

			if(Objects.nonNull(memberForm.isExpired())) {
				memberToEdit.setExpired(memberForm.isExpired());
			}

			mbrdao.update(memberToEdit);
		}
	}
	
	public Map<String,String> loginStatus(String userId,String password) {
		Map<String,String> result = new HashMap();
		// input invalid
		if(StringUtils.isNoneBlank(userId)&&StringUtils.isNoneBlank(password)) {
			result.put("status", "invalid Inputs");
		}
		// if member is null 
		Member loginMbr = mbrdao.getMemberByuserId(userId);
		if(Objects.nonNull(loginMbr)) {
			if(encryptUtil.md5HashString(password).equals(loginMbr.getPassword())) {
				result.put("status", "success");
			}else {
				result.put("status", "password error");
			}
		}
		// if member is not null
		else {
			result.put("status", "member not exist");
		}
		return result;
		
	}
}
