package mylab.notification.di.annot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;

@Configuration
public class NotificationConfig {
	
	@Bean
	public EmailNotificationService emailNotificationService() {
		EmailNotificationService email = new EmailNotificationService("smtp.gmail.com", 587);
		return email;
	}
	
	@Bean
	public SmsNotificationService smsNotificationService() {
		SmsNotificationService sms = new SmsNotificationService("SKT");
		return sms;
	}
	
	@Bean
	public NotificationManager notificationManager() {
		NotificationManager noti = new NotificationManager(emailNotificationService(), smsNotificationService());
		return noti;
	}

}
