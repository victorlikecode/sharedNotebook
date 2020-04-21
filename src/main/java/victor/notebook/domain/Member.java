package victor.notebook.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="member")
public class Member implements Serializable{
	
	public static boolean STATE_NORMAL = false;
	public static boolean STATE_DELETED = true;
	public static boolean NOT_IN_BLACK_LIST = false;
	public static boolean IN_BLACK_LIST = true;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="memberId")
	private int id ;
	private String userid ;
	private String password;
	private String email ;
	private boolean isDeleted;
	private boolean isInBlackList;
	private boolean isExpired;
	
	@OneToMany(cascade=CascadeType.REMOVE,fetch=FetchType.LAZY,mappedBy="author")
	List<Notebook> notebooks;
	@Transient
	private String action;
	@Transient
	private String tmpPassword;
	
	

}
