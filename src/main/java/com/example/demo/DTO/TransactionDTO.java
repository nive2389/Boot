package com.example.demo.DTO;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;

public class TransactionDTO {
private Long id;
@Override
public String toString() {
	return "TransactionDTO [idvalue=" + id + ", accountName=" + accountName + ", valueDate=" + valueDate + ", currency=" + currency
			+ ", creditAmt=" + creditAmt + ", accountType=" + accountType + ", accSummary=" + accSummary + "]";
}

private AccountDTO account;
private Date valueDate;
private String currency;
private Double creditAmt;
private String accountType;
private String accSummary;
private String accountName;


public TransactionDTO()
{
	
}
public TransactionDTO(Long id, Date valueDate, String accountName, String currency, Double creditAmt, String accountType,
		String accSummary) {
	
	this.id = id;
	this.account = account;
	this.valueDate = valueDate;
	this.currency = currency;
	this.creditAmt = creditAmt;
	this.accountType = accountType;
	this.accSummary = accSummary;
	this.accountName = accountName;
	
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
/*public AccountDTO getAccount() {
	return account;
}*/
public void setAccount(AccountDTO account) {
	this.account = account;
}
public Date getValueDate() {
	return valueDate;
}
public void setValueDate(Date valueDate) {
	this.valueDate = valueDate;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public Double getCreditAmt() {
	return creditAmt;
}
public void setCreditAmt(Double creditAmt) {
	this.creditAmt = creditAmt;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public String getAccSummary() {
	return accSummary;
}
public void setAccSummary(String accSummary) {
	this.accSummary = accSummary;
}
public String getAccountName() {
	return accountName;
}
public void setAccountName(String accountName) {
	this.accountName = accountName;
}

	public static TransactionDTO valueOf(Transaction transaction) {
		TransactionDTO transationdto=new TransactionDTO();
		transationdto.setId(transaction.getId());
		transationdto.setValueDate(transaction.getValueDate());
		AccountDTO ac=AccountDTO.valueOf(transaction.getAccount());
		transationdto.setAccountName(ac.getAccountName());
		transationdto.setAccountType(transaction.getAccountType());
		transationdto.setCreditAmt(transaction.getCreditAmt());
		transationdto.setCurrency(transaction.getCurrency());
		transationdto.setAccSummary(transaction.getAccSummary());
		
	return transationdto;
	}
	
		

}
