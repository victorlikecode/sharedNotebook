package victor.notebook.repository;

import java.util.List;

import victor.notebook.domain.Notebook;
import victor.notebook.persistence.core.IGenericJpaDAO;

public interface INotebookDAO extends IGenericJpaDAO<Notebook,Integer> {
	public List<Notebook> showBooksByMemberId(Integer memberId);
}
