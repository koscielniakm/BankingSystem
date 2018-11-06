package bs.model.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorizations")
public class AuthorizationEntity implements DbEntity {

	public AuthorizationEntity() { }
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "IP_Address")
	private String ipAddress;
	
	@Column(name = "Result", columnDefinition="bit(1)")
	private Boolean result;

	public Integer getId() {
		return id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public Boolean getResult() {
		return result;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

}
