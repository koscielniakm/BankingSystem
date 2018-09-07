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
@Table(name = "login")
public class LoginEntity implements DbEntity, Serializable {
	
	private static final long serialVersionUID = 1993756702988993527L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Input")
	private String input;

	@Column(name = "ip")
	private String ip;
	
	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name = "success", columnDefinition="BIT(1)")
	private boolean success;

	public LoginEntity() { }

	public Integer getId() {
		return id;
	}

	public String getInput() {
		return input;
	}

	public String getIp() {
		return ip;
	}

	public Date getDate() {
		return date;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
