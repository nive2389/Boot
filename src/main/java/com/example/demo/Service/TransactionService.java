package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.TransactionDTO;
import com.example.demo.Exception.CustomException;
import com.example.demo.Repository.TransactionRepository;
import com.example.demo.entity.Transaction;

import antlr.collections.impl.LList;
import javassist.bytecode.Descriptor.Iterator;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transrepo;
		
	public List<TransactionDTO> getTransactionDetails(Long accountNumber)  throws CustomException
	{
	List<Transaction> transDetailslist = transrepo.findAllById(accountNumber);
	if(transDetailslist.isEmpty()) {
		throw new CustomException("No transaction done");
	}
	
	List<TransactionDTO> transactionDto = new ArrayList<TransactionDTO>();
	for (Transaction trans: transDetailslist) {
		TransactionDTO t = TransactionDTO.valueOf(trans);
		transactionDto.add(t);
		}
	return transactionDto;
	}
//	}
	
}
