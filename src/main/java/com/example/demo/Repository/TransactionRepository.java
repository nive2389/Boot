package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>
{
	@Query("select tr from Transaction tr where accountId=?1 and valueDate between ?2 and ?3")
	List<Transaction> findAllByIdandDate(Long accountNumber, String startdate, String enddate);

	@Query("select t from Transaction t where accountid=?1")
	List<Transaction> findAllById(Long accountNumber);
	
}
