package com.example.demo.DTO;

import java.sql.Date;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.entity.Account;

import javax.persistence.Id;

public class AccountDTO {

private Long AccountNumber;
private String AccountName;
private String AccountType;
private Date BalanceDate;
private String Currency;
private Double OpAvailBalance;

public AccountDTO(Long accountNumber, String accountName, String accountType, Date balanceDate, String currency,
		Double opAvailBalance) {
	this.AccountNumber = accountNumber;
	this.AccountName = accountName;
	this.AccountType = accountType;
	this.BalanceDate = balanceDate;
	this.Currency = currency;
	this.OpAvailBalance = opAvailBalance;
}
public AccountDTO()
{
	
}

public Long getAccountNumber() {
	return AccountNumber;
}
@Override
public String toString() {
	return "Account [AccountNumber=" + AccountNumber + ", AccountName=" + AccountName + ", AccountType=" + AccountType
			+ ", BalanceDate=" + BalanceDate + ", Currency=" + Currency + ", OpAvailBalance=" + OpAvailBalance + "]";
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

public static AccountDTO valueOf(Account account) {
		AccountDTO accountdto=new AccountDTO();
		accountdto.setAccountNumber(account.getAccountNumber());
		accountdto.setAccountName(account.getAccountName());
		accountdto.setAccountType(account.getAccountType());
		accountdto.setCurrency(account.getCurrency());
		accountdto.setBalanceDate(account.getBalanceDate());
		accountdto.setOpAvailBalance(account.getOpAvailBalance());
		return accountdto;
	}

public static Account valueOf(AccountDTO accountdto) {
	Account account=new Account();
	account.setAccountNumber(accountdto.getAccountNumber());
	account.setAccountName(accountdto.getAccountName());
	account.setAccountType(accountdto.getAccountType());
	account.setCurrency(accountdto.getCurrency());
	account.setBalanceDate(accountdto.getBalanceDate());
	account.setOpAvailBalance(accountdto.getOpAvailBalance());
	return account;
}

}
