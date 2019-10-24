package com.example.demo.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

import javax.persistence.Id;
@Entity
@Table(name="ACCOUNT")
public class Account {
@Id
private Long AccountNumber;
private String AccountName;
private String AccountType;

private Date BalanceDate;
private String Currency;
private Double OpAvailBalance;

public Account(){
	super();
}
public Long getAccountNumber() {
	return AccountNumber;
}
public void setAccountNumber(Long accountNumber) {
	AccountNumber = accountNumber;
}
public String getAccountName() {
	return AccountName;
}
public void setAccountName(String accountName) {
	AccountName = accountName;
}
public String getAccountType() {
	return AccountType;
}
public void setAccountType(String accountType) {
	AccountType = accountType;
}
public Date getBalanceDate() {
	return BalanceDate;
}
public void setBalanceDate(Date balanceDate) {
	BalanceDate = balanceDate;
}
public String getCurrency() {
	return Currency;
}
public void setCurrency(String currency) {
	Currency = currency;
}
public Double getOpAvailBalance() {
	return OpAvailBalance;
}
public void setOpAvailBalance(Double opAvailBalance) {
	OpAvailBalance = opAvailBalance;
}

}
