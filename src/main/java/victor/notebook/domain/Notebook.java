package victor.notebook.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="notebook")
public class Notebook implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="bookId")
	private int id ;
	
	private String title;
	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinColumn(name="memberId")
	private Member author;
	
	private int download;
	
	private int view;
	
	private int star ;
	
	private boolean isPrivate;
	
	@OneToMany(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER,mappedBy="book")
	private List<Page> pages;
}
