package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Temporal;

import com.example.demo.DTO.AccountDTO;
@Entity
@Table(name="TRANSACTION")
public class Transaction {
@Id
	private Long id;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="accountid")
private Account account;

private Date valuedate;

private String currency;
private Double creditamt;
private String accounttype;
private String accsummary;

public Transaction()
{
	
}
public Transaction(Long id, Account account, Date valueDate, String currency, Double creditAmt, String accountType,
		String accSummary) {
	super();
	this.id = id;
	this.account = account;
	this.valuedate = valueDate;
	this.currency = currency;
	this.creditamt = creditAmt;
	this.accounttype = accountType;
	this.accsummary = accSummary;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Account getAccount() {
	return account;
}
public void setAccount(Account account) {
	this.account = account;
}
public Date getValueDate() {
	return valuedate;
}
public void setValueDate(Date valueDate) {
	this.valuedate = valueDate;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public Double getCreditAmt() {
	return creditamt;
}
public void setCreditAmt(Double creditAmt) {
	this.creditamt = creditAmt;
}
public String getAccountType() {
	return accounttype;
}
public void setAccountType(String accountType) {
	this.accounttype = accountType;
}
public String getAccSummary() {
	return accsummary;
}
public void setAccSummary(String accSummary) {
	this.accsummary = accSummary;
}

}
