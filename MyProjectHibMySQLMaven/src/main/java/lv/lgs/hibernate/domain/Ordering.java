package lv.lgs.hibernate.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ordering {
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfOrder;
	private int countPeoples;
	
	@Temporal(TemporalType.DATE)
	private Date orderedByDate;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "excursion_id")
	private Excursion excursion;
	
	public Ordering() {
	}

	public Ordering(Date dateOfOrder, int countPeoples, Date orderedByDate) {
		
		this.dateOfOrder = dateOfOrder;
		this.countPeoples = countPeoples;
		this.orderedByDate = orderedByDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public int getCountPeoples() {
		return countPeoples;
	}

	public void setCountPeoples(int countPeoples) {
		this.countPeoples = countPeoples;
	}
	
	public Date getOrderedByDate() {
		return orderedByDate;
	}

	public void setOrderedByDate(Date orderedByDate) {
		this.orderedByDate = orderedByDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Excursion getExcursion() {
		return excursion;
	}

	public void setExcursion(Excursion excursion) {
		this.excursion = excursion;
	}

	@Override
	public String toString() {
		return "Ordering [id=" + id + ", dateOfOrder=" + dateOfOrder
				+ ", countPeoples=" + countPeoples + ", orderedByDate="
				+ orderedByDate + ", client=" + client + ", excursion="
				+ excursion + "]";
	}

	
}
