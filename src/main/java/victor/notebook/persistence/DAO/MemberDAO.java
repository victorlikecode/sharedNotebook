package victor.notebook.persistence.DAO;

import java.util.List;
import java.util.Objects;

import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import victor.notebook.domain.Member;
import victor.notebook.persistence.core.GenericJpaDAO;
import victor.notebook.repository.IMemberDAO;

@Repository
public class MemberDAO extends GenericJpaDAO<Member, Integer>  implements IMemberDAO {

//	public int getcount() {
//		int result = 0;
//		String sql = "from Member ";
//		List<Member> memberList = (List<Member>) entityManager.createNamedQuery(sql, Member.class);
//		result = memberList.size();
//		return result;
//	}
	
	public Member getMemberByuserId(String userId) {
		String hql = "from Member mbr ";
		Member result = null ;
		if(StringUtils.isNoneBlank(userId)) {
			hql += "where mbr.userid = :userid ";
		}
		TypedQuery<Member> query = entityManager.createNamedQuery(hql, Member.class);
		if(StringUtils.isNoneBlank(userId)) {
			query.setParameter("userid", userId);
		}
		List<Member> mbrList = query.getResultList();
		if(mbrList.size()>0) {
			result = mbrList.get(0);
		}
		return result ;
	}
}
