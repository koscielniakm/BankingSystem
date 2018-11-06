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
@Table(name = "cyclical_money_transfer")
public class CyclicalMoneyTransferEntity implements DbEntity {
	
	public CyclicalMoneyTransferEntity() { }
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "Date_Active")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateActive;

	@Column(name = "Date_Delay")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDelay;
	
	@Column(name = "Date_Unactive")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUnactive;

	public Integer getId() {
		return id;
	}

	public Date getDateActive() {
		return dateActive;
	}

	public Date getDateDelay() {
		return dateDelay;
	}

	public Date getDateUnactive() {
		return dateUnactive;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDateActive(Date dateActive) {
		this.dateActive = dateActive;
	}

	public void setDateDelay(Date dateDelay) {
		this.dateDelay = dateDelay;
	}

	public void setDateUnactive(Date dateUnactive) {
		this.dateUnactive = dateUnactive;
	}
	
}
