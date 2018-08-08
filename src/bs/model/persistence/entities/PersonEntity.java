package bs.model.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class PersonEntity implements DbEntity, Serializable {

	private static final long serialVersionUID = -3540831518654069251L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ID_Account")
	private Integer idAccount;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
    @OneToOne
    @PrimaryKeyJoinColumn
	private AccountEntity account;
    
	public PersonEntity() { }

	public Integer getId() {
		return id;
	}

	public Integer getIdAccount() {
		return idAccount;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

}
