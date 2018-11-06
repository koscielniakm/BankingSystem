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
@Table(name = "outgoing_money_transfer")
public class OutgoingMoneyTransferEntity implements DbEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "Date_Send")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSend;

	public Integer getId() {
		return id;
	}

	public Date getDateSend() {
		return dateSend;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDateSend(Date dateSend) {
		this.dateSend = dateSend;
	}
	
}
