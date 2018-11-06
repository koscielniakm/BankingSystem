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
@Table(name = "Card")
public class CardEntity implements DbEntity {

	public CardEntity() { }
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "Card_Number")
	private Integer cardNumber;
	
	@Column(name = "Date_Active")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateActive;
	
	@Column(name = "Date_Unactive")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUnactive;

	public Integer getId() {
		return id;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public Date getDateActive() {
		return dateActive;
	}

	public Date getDateUnactive() {
		return dateUnactive;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setDateActive(Date dateActive) {
		this.dateActive = dateActive;
	}

	public void setDateUnactive(Date dateUnactive) {
		this.dateUnactive = dateUnactive;
	}
	
}
