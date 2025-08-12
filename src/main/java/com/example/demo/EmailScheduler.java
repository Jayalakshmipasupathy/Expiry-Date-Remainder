package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailScheduler {

    @Autowired
    private ExpremService expremService;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 9 * * ?")  // Every day at 9 AM
    public void sendExpiryReminders() {
        List<Exprem> expiringProducts = expremService.getExpiringProducts();
        if (!expiringProducts.isEmpty()) {
            emailService.sendExpiryReminder(expiringProducts, "jaya.060212003@example.com");
        }
    }
}
  
