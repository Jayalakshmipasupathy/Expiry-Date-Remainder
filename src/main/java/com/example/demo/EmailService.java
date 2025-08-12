package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmailService {
	    @Autowired
	    private JavaMailSender mailSender;

	    public void sendExpiryReminder(List<Exprem> products, String recipientEmail) {
	        if (products.isEmpty()) return;

	        StringBuilder message = new StringBuilder("The following products are expiring soon:\n");
	        for (Exprem product : products) {
	            message.append(product.getName()).append(" - Expiry: ")
	                   .append(product.getExpiryDate()).append("\n");
	        }

	        SimpleMailMessage mailMessage = new SimpleMailMessage();
	        mailMessage.setTo(recipientEmail);
	        mailMessage.setSubject("Expiry Date Reminder");
	        mailMessage.setText(message.toString());

	        mailSender.send(mailMessage);
	        System.out.println("Email sent successfully to " + recipientEmail);
	    }
}
