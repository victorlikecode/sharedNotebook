package victor.notebook.persistence.DAO;

import java.util.List;
import java.util.Objects;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import victor.notebook.domain.Page;
import victor.notebook.persistence.core.GenericJpaDAO;
import victor.notebook.repository.IPageDAO;

@Repository
public class PageDAO extends GenericJpaDAO<Page, Integer> implements IPageDAO {
	
	public List<Page> showPagesBybookid(Integer bookid){
		StringBuilder sb = new StringBuilder();
		sb.append("select page from Page page where 1=1 ");
		if(Objects.nonNull(bookid)) {
			sb.append("and page.book.id = :bookId");
		}
		TypedQuery<Page> pages = entityManager.createQuery(sb.toString(), Page.class);
		List<Page> result = pages.getResultList();
		
		return result;
	}
	
	public Integer pageNum(Integer bookId) {
		int result = 0 ;
		StringBuilder sb = new StringBuilder();
		sb.append("select count(*) from Page where 1=1 ");
		if(Objects.nonNull(bookId)) {
			sb.append("and Page.book.id = :bookId");
		}
		Query query = entityManager.createQuery(sb.toString());
		if(Objects.nonNull(bookId)) {
			query.setParameter("bookId", bookId);
		}
		List<Object> number = query.getResultList();
		
		if(number.size()>0) {
			result = (Integer)number.get(0);
		}
		return result ;
	}
}
