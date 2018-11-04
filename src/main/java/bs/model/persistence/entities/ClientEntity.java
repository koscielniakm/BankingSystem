package bs.model.persistence.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class ClientEntity implements DbEntity {

	public ClientEntity() { }
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "Account_Number")
	private Integer accountNumber;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Date_Open")
	private Date dateOpen;
	
	@Column(name = "Date_Close")
	private Date dateClose;

	public Integer getId() {
		return id;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public Date getDateOpen() {
		return dateOpen;
	}

	public Date getDateClose() {
		return dateClose;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDateOpen(Date dateOpen) {
		this.dateOpen = dateOpen;
	}

	public void setDateClose(Date dateClose) {
		this.dateClose = dateClose;
	}
	
}
