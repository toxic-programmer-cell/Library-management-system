package project.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="books")
public class Books {
	@Id
	private long bookId;
	
	@Column(name = "title",length = 100)
	private String title;
	
	@Column(name = "auther",length = 30)
	private String auther;
	
	@Column(name = "publicationYear",length = 4)
	private int publicationYear;
	
	@Column(name = "gener",length = 10)
	private String gener;

	public Books(Long bookId, String title, String auther, int publicationYear, String gener) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.auther = auther;
		this.publicationYear = publicationYear;
		this.gener = gener;
	}

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Books(String btitle, String autherName, int publicationYear, String gener) {
		this.title=btitle;
		this.auther=autherName;
		this.publicationYear=publicationYear;
		this.gener=gener;
	}
	

	public long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		System.out.println("Title insidee the set title");
		this.title = title;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getGener() {
		return gener;
	}

	public void setGener(String gener) {
		this.gener = gener;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", title=" + title + ", auther=" + auther + ", publicationYear="
				+ publicationYear + ", gener=" + gener + "]";
	}

	
	
	
}
