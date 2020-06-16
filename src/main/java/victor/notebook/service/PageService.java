package victor.notebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import victor.notebook.domain.Page;
import victor.notebook.persistence.DAO.PageDAO;
import victor.notebook.repository.IPageDAO;

@Service
public class PageService {
	@Autowired
	private IPageDAO pageDAO;
	
	public List<Page> listPage(Integer bookid){
		return pageDAO.showPagesBybookid(bookid);
	}
	
	public Integer totalPage(Integer bookId) {
		return pageDAO.totalPage(bookId);
	}
	
	public boolean isPageNumColision(Integer bookid,Integer pageNum) {
		return pageDAO.isPageNumCollision(bookid, pageNum);
	}
}
