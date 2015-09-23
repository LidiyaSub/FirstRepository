package lv.lgs.hibernate.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	
	@Id
	@Column(name = "client_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private String phone;
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
	private Set<Ordering> orders;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
	private Set<CommentOfClient> comments;
	
	public Client() {
	}

	public Client(String name, String surname, String phone, String email) {
		
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Ordering> getOrders() {
		return orders;
	}

	public void setOrders(Set<Ordering> orders) {
		this.orders = orders;
	}

	public Set<CommentOfClient> getComments() {
		return comments;
	}

	public void setComments(Set<CommentOfClient> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name
				+ ", surname=" + surname + ", phone=" + phone + ", email="
				+ email + "]";
	}
	
	
	
	
}
