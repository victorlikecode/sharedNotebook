package victor.notebook.form;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class MemberForm {
	private Integer id;
	private String action ;
	private String userid;
	private String password;
	private String passwordConfirm;
	private String email;
}
