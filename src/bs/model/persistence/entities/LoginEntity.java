package bs.model.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "login")
public class LoginEntity implements DbEntity, Serializable {
	
	private static final long serialVersionUID = 1993756702988993527L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "id_account", nullable = true)
	private Integer idAccount;

	@Column(name = "ip")
	private String ip;
	
	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name = "success", columnDefinition="BIT(1)")
	private boolean success;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = AccountEntity.class)
	@JoinColumn(name = "id_account", insertable = false, updatable = false, nullable = true)
	private AccountEntity account;

	public LoginEntity() { }

	public Integer getId() {
		return id;
	}

	public Integer getIdAccount() {
		return idAccount;
	}

	public String getIp() {
		return ip;
	}

	public Date getDate() {
		return date;
	}

	public Boolean isSuccess() {
		return success;
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

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

}
