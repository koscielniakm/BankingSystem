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
@Table(name = "incoming_money_transfer")
public class IncomingMoneyTransferEntity implements DbEntity {

	public IncomingMoneyTransferEntity() { }
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "Date_Receive")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateReceive;

	public Integer getId() {
		return id;
	}

	public Date getDateReceive() {
		return dateReceive;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDateReceive(Date dateReceive) {
		this.dateReceive = dateReceive;
	}
	
}
