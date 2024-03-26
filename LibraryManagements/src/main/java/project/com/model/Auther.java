package project.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "auther")
public class Auther {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long autherId;
	
	@Column(name="auther_name",length=30)
	private String autherName;

	public Auther(Long autherId, String autherName) {
		super();
		this.autherId = autherId;
		this.autherName = autherName;
	}

	public Auther() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getAutherId() {
		return autherId;
	}

	public void setAutherId(Long autherId) {
		this.autherId = autherId;
	}

	public String getAutherName() {
		return autherName;
	}

	public void setAutherName(String autherName) {
		this.autherName = autherName;
	}

	@Override
	public String toString() {
		return "Auther [autherId=" + autherId + ", autherName=" + autherName + "]";
	}
	
	
}
