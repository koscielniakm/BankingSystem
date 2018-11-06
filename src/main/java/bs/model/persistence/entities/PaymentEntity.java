package bs.model.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "payment")
public class PaymentEntity implements DbEntity {

	public PaymentEntity() { }
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "Country")
	private String country;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name = "Amount")
	private Double amount;
	
	@Column(name = "Title")
	private String title;

	public Integer getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public Date getDate() {
		return date;
	}

	public Double getAmount() {
		return amount;
	}

	public String getTitle() {
		return title;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
