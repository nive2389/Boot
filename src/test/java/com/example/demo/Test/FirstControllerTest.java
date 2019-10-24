package com.example.demo.Test;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class FirstControllerTest {
	
/*@Test
public void getAccountDetailsTest() throws URISyntaxException 
{
    RestTemplate restTemplate = new RestTemplate();
    Long accountNumber = 1001L;
    final String baseUrl = "http://localhost:8080/accountdetails" + accountNumber;
    URI uri = new URI(baseUrl);

    ResponseEntity<String> result = restTemplate.postForEntity(uri, String.class, null);
    Assert.assertEquals(200, result.getStatusCodeValue());

}*/
}
