package lv.lgs.hibernate.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Blog {
	@Id
	@Column(name="blog_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String authorName;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	private String text;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "blog")
	private Set<CommentToBlog> commentsToBlog;

	public Blog() {
	}

	public Blog(String title, String authorName, Date date, String text) {
		
		this.title = title;
		this.authorName = authorName;
		this.date = date;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set<CommentToBlog> getCommentsToBlog() {
		return commentsToBlog;
	}

	public void setCommentsToBlog(Set<CommentToBlog> commentsToBlog) {
		this.commentsToBlog = commentsToBlog;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", authorName="
				+ authorName + ", date=" + date + ", text=" + text
				+ ", commentsToBlog=" + commentsToBlog + "]";
	}

}
