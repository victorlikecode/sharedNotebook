package victor.notebook.form;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotebookForm {

	private String action;
	
	private Integer memberId;
	private Integer bookId;
	
	private String title;
	private String description;
	
	private boolean Public;
}
