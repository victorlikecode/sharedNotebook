package victor.notebook.repository;

import java.util.List;

import victor.notebook.domain.Page;
import victor.notebook.persistence.core.IGenericJpaDAO;

public interface IPageDAO extends IGenericJpaDAO<Page,Integer>{
	public List<Page> showPagesBybookid(Integer bookid);
	
	public Integer pageNum(Integer bookId);
}
