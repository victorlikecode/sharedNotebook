package victor.notebook.repository;

import victor.notebook.domain.Member;
import victor.notebook.persistence.core.IGenericJpaDAO;

public interface IMemberDAO extends IGenericJpaDAO<Member,Integer> {
	public Member getMemberByuserId(String userId);
	
	public Member getMemberById(Integer memberId);
}
