package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.TransactionDTO;
import com.example.demo.Exception.CustomException;
import com.example.demo.Repository.AccountRepository;

import com.example.demo.entity.Account;


@Service
public class AccountService {
	
@Autowired
AccountRepository accountrepo;

public AccountDTO getAccountDetails(Long accountNumber) throws CustomException{
	// TODO Auto-generated method stub
	if(!(accountrepo.existsById(accountNumber)))
	{
	throw new CustomException("Account Not Found");
	}
	
	Account account = accountrepo.findById(accountNumber).get();
	AccountDTO accountDTO = AccountDTO.valueOf(account);
	System.out.println(accountDTO);
	return accountDTO;
	
}
/* out of scope */
public void addAccount(AccountDTO accountDto) throws CustomException {
	// TODO Auto-generated method stub
	if(accountrepo.existsById(accountDto.getAccountNumber())) {
		throw new CustomException("Account already Exist");
	}
	Account acc = AccountDTO.valueOf(accountDto);
	accountrepo.saveAndFlush(acc);
}
}
