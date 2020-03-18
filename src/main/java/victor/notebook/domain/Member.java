package victor.notebook.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member implements Serializable{
	
	public static boolean STATE_NORMAL = false;
	public static boolean STATE_DELETED = true;
	public static boolean NOT_IN_BLACK_LIST = false;
	public static boolean IN_BLACK_LIST = true;
	
	@Id
	@GeneratedValue
	private int id ;
	private String userid ;
	private String password;
	private String email ;
	private boolean isDeleted;
	private boolean isInBlackList;
	private boolean isExpired;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public boolean isInBlackList() {
		return isInBlackList;
	}
	public void setInBlackList(boolean isInBlackList) {
		this.isInBlackList = isInBlackList;
	}
	public boolean isExpired() {
		return isExpired;
	}
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	
	

}
