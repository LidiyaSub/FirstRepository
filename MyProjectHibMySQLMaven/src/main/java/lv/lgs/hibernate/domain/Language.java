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


@Entity
public class Language {

	@Id
	@Column(name ="language_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "excursion_lang_tags", joinColumns =
	@JoinColumn(name = "language_id"), inverseJoinColumns = 
	@JoinColumn(name = "excursion_id"))
	private Set<Excursion> excursions;

	public Language() {
	}

	public Language(String name) {

		this.name = name;
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

	public Set<Excursion> getExcursions() {
		return excursions;
	}

	public void setExcursions(Set<Excursion> excursions) {
		this.excursions = excursions;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + ", excursions="
				+ excursions + "]";
	}

}
