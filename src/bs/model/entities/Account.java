package bs.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account implements DbEntity, Serializable {
	
	private static final long serialVersionUID = 1405684322968450778L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ID_Person")
	private Integer idPerson;
	
	@Column(name = "AccountNumber")
	private Integer accountNumber;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Email")
	private String email;
	
	public Account() { }

	public Integer getId() {
		return id;
	}

	public Integer getIdPerson() {
		return idPerson;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
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
	
}
