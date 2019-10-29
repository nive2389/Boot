package com.example.demo.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URISyntaxException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.Controller.FirstController;
import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.TransactionDTO;
import com.example.demo.Exception.CustomException;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.TransactionRepository;
import com.example.demo.Service.AccountService;
import com.example.demo.Service.TransactionService;
import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = FirstController.class, secure = false)
public class FirstControllerTest {
	
	@MockBean
	AccountService accServiceMock;
	@MockBean
	TransactionService transServiceMock;
	@Mock
	AccountRepository accRepoMock;
	@Mock
	TransactionRepository transRepoMock;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	@InjectMocks
	FirstController firstControllerMock;
	@Autowired
	private MockMvc mockMvc;
	private TransactionDTO td;
	private AccountDTO acc1; 
	 @Before
	    public void initMocks() throws Exception {
	        MockitoAnnotations.initMocks(this);
	        acc1();
	    }
	
	 
	 @Test
	 public void testTransaction() throws Exception
	 {
		 List<TransactionDTO> tdList = new ArrayList();
		 tdList.add(td);
		  when(transServiceMock.getTransactionDetails(1010L)).thenReturn(tdList);
	        List<TransactionDTO> responseList = firstControllerMock.getTransactionDetails(1010L);
	    	assertThat(tdList).containsAnyOf(td);
		 
	 }
	 
	 @Test
	 public void testTransactionFalse() throws Exception
	 {
		
		  try {
			when(transServiceMock.getTransactionDetails(100L)).thenThrow(CustomException.class);
			firstControllerMock.getTransactionDetails(100L);
			expectedException.expect(CustomException.class);
			expectedException.expectMessage("No transaction done");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 }
	 
	 
	 @Test
	 public void testAccount() throws Exception 
	 {
	        when(accServiceMock.getAccountDetails(1010L)).thenReturn(acc1);
	        AccountDTO response = firstControllerMock.getAccountDetails(1010L);
	        assertThat(response.getAccountName()).isEqualTo(acc1.getAccountName());
	 }
	 
	 @Test
	 public void testAccountFalse() throws Exception 
	 {  
		 try {
	        when(accServiceMock.getAccountDetails(100L)).thenThrow(CustomException.class);
	        firstControllerMock.getAccountDetails(100L);
	        expectedException.expect(CustomException.class);
	        expectedException.expectMessage("Account Not Found");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
	 }
	 
	 
public void acc1() throws CustomException 
{
	   acc1 = new AccountDTO();
	   acc1.setAccountNumber(1010L);
	   acc1.setAccountName("EGT-DT");
	   acc1.setAccountType("Savings");
	   acc1.setBalanceDate(new Date(2019-9-6));
	   acc1.setCurrency("INR");
	   acc1.setOpAvailBalance(7891.8);
	   
	   td=new TransactionDTO();
		 td.setAccount(acc1);
		 td.setId(1L);
		 td.setAccountName(acc1.getAccountName());
		 td.setAccountType("Savings");
		 td.setAccSummary("Summary");
		 td.setCurrency("INR");
		 td.setCreditAmt(100.0);
		 td.setValueDate(new Date(2019-8-6));
	
}
}
