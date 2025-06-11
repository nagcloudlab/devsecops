package com.securebank.account;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.securebank.account.model.Account;
import com.securebank.account.repository.AccountRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class TransferServiceApplication {

	@Autowired
	private AccountRepository accountRepository;

	@PostConstruct
	public void initDatabase() {
		// insert 2 accounts into the database
		accountRepository.save(new Account(1L, "John Doe", new BigDecimal(1000.00)));
		accountRepository.save(new Account(2L, "Jane Smith", new BigDecimal(2000.00)));
	}

	public static void main(String[] args) {
		SpringApplication.run(TransferServiceApplication.class, args);
	}

}
