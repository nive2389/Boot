package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.DemoApplication;
import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.TransactionDTO;
import com.example.demo.Exception.CustomException;
import com.example.demo.Service.AccountService;
import com.example.demo.Service.TransactionService;
@RestController
public class FirstController{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AccountService accservice;
	
	@Autowired
	TransactionService transervice;
@PostMapping("/accountdetails")
public AccountDTO getAccountDetails(@RequestParam("accountNumber") Long accountNumber) throws CustomException{
	logger.info("Get Account Details Called");
	return accservice.getAccountDetails(accountNumber);
}
@PostMapping("/transactiondetails")
public List<TransactionDTO> getTransactionDetails(@RequestParam("accountNumber") Long accountNumber) throws CustomException{
	logger.info("Get transaction Details Called for: "+ accountNumber);
	return transervice.getTransactionDetails(accountNumber);
}

/* out of scope */
@GetMapping(path="/addAccount", consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<String> addAccount(@RequestBody AccountDTO accountDto) throws CustomException{
	accservice.addAccount(accountDto);
	return new ResponseEntity<String>(HttpStatus.CREATED);
}


}
