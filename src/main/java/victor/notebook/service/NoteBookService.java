package victor.notebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import victor.notebook.domain.Notebook;
import victor.notebook.persistence.DAO.NotebookDAO;
import victor.notebook.repository.INotebookDAO;

@Service
public class NoteBookService {

	@Autowired
	private INotebookDAO notebookDAO ;
	
	public List<Notebook> listNotebookByMemberId(Integer memberId){
		return notebookDAO.showBooksByMemberId(memberId);
	}
}
