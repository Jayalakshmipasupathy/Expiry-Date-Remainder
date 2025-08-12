package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ExpremController {
	    @Autowired
	    private ExpremService service;
	    @Autowired
	    private EmailService emailService;
	    @GetMapping("/expiring")
	    public List<Exprem> getExpiringProducts() {
	        return service.getExpiringProducts();
	    }

	    @PostMapping("/add")
	    public Exprem addProduct(@RequestBody Exprem exprem) {
	        return service.saveProduct(exprem);
	    }
	    @GetMapping("/test-mail")
	    public String testMail() {
	        emailService.sendExpiryReminder(
	            List.of(new Exprem("Test Product", LocalDate.now())),
	            "jaya.060212003@gmail.com"
	        );
	        return "Test Mail Sent!";
	    }
	    @GetMapping("/send-expiry-mail")
	    public String sendExpiryMail() {
	        List<Exprem> expiringProducts = service.getExpiringProducts();
	        if (expiringProducts.isEmpty()) {
	            return "No products are expiring soon!";
	        }
	        emailService.sendExpiryReminder(expiringProducts, "jaya.060212003@gmail.com");
	        return "Expiry Mail Sent!";
	        
	    }
	    @DeleteMapping("/delete-expired")
	    public String deleteExpiredProducts() {
	        service.deleteExpiredProducts();
	        return "Expired products deleted successfully!";
	    }
	 }


