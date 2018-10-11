package bs.model.persistence.entities;

import java.io.Serializable;
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
@Table(name = "account")
public class AccountEntity implements DbEntity, Serializable {
	
	private static final long serialVersionUID = 1405684322968450778L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "AccountNumber")
	private Integer accountNumber;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "DateOpen")
	@Temporal(TemporalType.TIMESTAMP)
	private Date openDate;
	
	@Column(name = "OwnerFirstName")
	private String ownerFirstName;
	
	@Column(name = "OwnerLastName")
	private String ownerLastName;
    
	public AccountEntity() { }

	public Integer getId() {
		return id;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

}
