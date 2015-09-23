package lv.lgs.hibernate.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Excursion {
	
	@Id
	@Column(name = "excursion_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int maxCountOfPeoples;
	private int price;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private Type type;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "excursion_lang_tags", joinColumns =
	@JoinColumn(name = "excursion_id"), inverseJoinColumns = 
	@JoinColumn(name = "language_id"))
	private Set<Language> languages;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy ="excursion")
	private Set<CommentOfClient> commentsOfClients;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "excursion")
	private Set<Ordering> ordering;

	public Excursion() {
	}

	public Excursion(String name, String description, int maxCountOfPeoples,
			int price) {

		this.name = name;
		this.description = description;
		this.maxCountOfPeoples = maxCountOfPeoples;
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxCountOfPeoples() {
		return maxCountOfPeoples;
	}

	public void setMaxCountOfPeoples(int maxCountOfPeoples) {
		this.maxCountOfPeoples = maxCountOfPeoples;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Set<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}

	public Set<CommentOfClient> getCommentsOfClients() {
		return commentsOfClients;
	}

	public void setCommentsOfClients(Set<CommentOfClient> commentsOfClients) {
		this.commentsOfClients = commentsOfClients;
	}

	public Set<Ordering> getOrdering() {
		return ordering;
	}

	public void setOrdering(Set<Ordering> ordering) {
		this.ordering = ordering;
	}

	@Override
	public String toString() {
		return "Excursion [id=" + id + ", name=" + name + ", description="
				+ description + ", maxCountOfPeoples=" + maxCountOfPeoples
				+ ", price=" + price + ", city=" + city + ", type=" + type
				+ ", languages=" + languages + ", commentsOfClients="
				+ commentsOfClients + ", ordering=" + ordering + "]";
	}

}
