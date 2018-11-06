package bs.model.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "money_transfer")
public class MoneyTransferEntity implements DbEntity {
	
	public MoneyTransferEntity() { }
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "Sender_Account_Number")
	private Integer senderAccountNumber;
	
	@Column(name = "Sender_Name")
	private String senderName;
	
	@Column(name = "Recipient_Account_Number")
	private Integer recipientAccountNumber;
	
	@Column(name = "Recipient_Name")
	private String recipientName;
	
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Amount")
	private Double amount;

	public Integer getId() {
		return id;
	}

	public Integer getSenderAccountNumber() {
		return senderAccountNumber;
	}

	public String getSenderName() {
		return senderName;
	}

	public Integer getRecipientAccountNumber() {
		return recipientAccountNumber;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public String getTitle() {
		return title;
	}

	public Double getAmount() {
		return amount;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSenderAccountNumber(Integer senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public void setRecipientAccountNumber(Integer recipientAccountNumber) {
		this.recipientAccountNumber = recipientAccountNumber;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
