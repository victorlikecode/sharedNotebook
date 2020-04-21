package victor.notebook.persistence.DAO;

import java.util.List;
import java.util.Objects;

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
}
