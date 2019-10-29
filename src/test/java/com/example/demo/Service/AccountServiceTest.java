package com.example.demo.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.Exception.CustomException;
import com.example.demo.Repository.AccountRepository;
@RunWith(SpringRunner.class)
@ContextConfiguration
public class AccountServiceTest {

	@Mock
	AccountRepository accountrepo;
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	@InjectMocks
	AccountService accountServiceMock;
	AccountDTO accdto, accountdto;
	String dummyData ="dummyData";
	Long id=1001L;
	@Before
	public void Setup()
	{
		MockitoAnnotations.initMocks(this);
		account();
	}
	public void account() {
		accountdto = new AccountDTO();
		accountdto.setAccountNumber(1001L);
		accountdto.setAccountName("TestUser1");
		accountdto.setAccountType("Savings");
		accountdto.setBalanceDate(new Date(2019-20-8));
		accountdto.setCurrency("INR");
		accountdto.setOpAvailBalance(20000.50);
	}
	@Test
	public void testgetAccountService() throws Exception
	{	
		try { 
		//when(accountServiceMock.getAccountDetails(100L)).thenReturn(null);
		when(accountServiceMock.getAccountDetails(1001L)).thenReturn(accountdto);
	//	when(accountrepo.findgetAccountDetails(1001L)).thenReturn(accountdto);
		accdto = accountServiceMock.getAccountDetails(1001L);
		assertEquals(dummyData, accdto.getAccountName());
		assertThat(accdto.getBalanceDate()).hasSameTimeAs(new Date(2019-8-7));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	}
	
	@Test
	public void testgetAccountServiceFalse() throws Exception
	{	
		try { 
		
		when(accountServiceMock.getAccountDetails(1001L)).thenThrow(CustomException.class);
		accdto = accountServiceMock.getAccountDetails(1001L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	}
	
}
