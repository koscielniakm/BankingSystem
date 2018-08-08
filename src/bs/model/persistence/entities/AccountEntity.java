package bs.model.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
	
	@Column(name = "ID_Person")
	private Integer idPerson;
	
	@Column(name = "AccountNumber")
	private Integer accountNumber;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "DateOpen")
	@Temporal(TemporalType.TIMESTAMP)
	private Date openDate;
	
    @OneToOne(mappedBy="account")
    @PrimaryKeyJoinColumn
	private PersonEntity person;
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LoginEntity> loginList;
    
	public AccountEntity() { }

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

	public Date getOpenDate() {
		return openDate;
	}

	public PersonEntity getPerson() {
		return person;
	}

	public List<LoginEntity> getLoginList() {
		return loginList;
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

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public void setPerson(PersonEntity person) {
		this.person = person;
	}

	public void setLoginList(List<LoginEntity> loginList) {
		this.loginList = loginList;
	}

}
