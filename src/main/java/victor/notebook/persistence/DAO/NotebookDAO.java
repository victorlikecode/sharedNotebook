package victor.notebook.persistence.DAO;

import java.util.List;
import java.util.Objects;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import victor.notebook.domain.Notebook;
import victor.notebook.persistence.core.GenericJpaDAO;
import victor.notebook.repository.INotebookDAO;

@Repository
public class NotebookDAO extends GenericJpaDAO<Notebook, Integer> implements INotebookDAO {
	public List<Notebook> showBooksByMemberId(Integer memberId){
		StringBuilder sb = new StringBuilder();
		sb.append("select book from Notebook book where 1 = 1 ");
		if(Objects.nonNull(memberId)) {
			sb.append("and book.author.id=:memberId ");
		}
		
		TypedQuery<Notebook> notebooks = entityManager.createQuery(sb.toString(), Notebook.class);
		
		if(Objects.nonNull(memberId)) {
			notebooks.setParameter("memberId", memberId);			
		}
		
		List<Notebook> result = notebooks.getResultList();
		
		return result;
	}

	@Override
	public Notebook findBookById(Integer id) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select book from Notebook book where 1 = 1 ");
		
		if(Objects.nonNull(id)) {
			sb.append("and book.id = :bookid");
		}
		
		TypedQuery<Notebook> notebook = entityManager.createQuery(sb.toString(),Notebook.class);
		Notebook result = notebook.getResultList().get(0);
		return result;
	}
}
