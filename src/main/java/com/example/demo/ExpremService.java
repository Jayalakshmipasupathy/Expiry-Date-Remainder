package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExpremService {
	    @Autowired
	    private ExpremRepository repository;

	    public List<Exprem> getExpiringProducts() {
	        LocalDate targetDate = LocalDate.now().plusDays(7);
	        return repository.findByExpiringProducts(targetDate);
	    }

	    public Exprem saveProduct(Exprem exprem) {
	        return repository.save(exprem);
	    }
	    @Transactional
	    public void deleteExpiredProducts() {
	        repository.deleteExpiredProducts(LocalDate.now());
	        System.out.println("Expired products deleted automatically.");
	    }

	    @Scheduled(cron = "0 0 0 * * ?")  // Runs every day at midnight
	    public void autoDeleteExpiredProducts() {
	        deleteExpiredProducts();
	    }
	    public List<Exprem> getAllProducts() {
	        return repository.findAll();
	    }
	}
	

