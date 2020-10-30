package edu.miu.cs.cs544.notification.notificationservice.service;


import edu.miu.cs.cs544.notification.notificationservice.model.EmailObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${notification.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${notification.rabbitmq.routingkey}")
	private String routingkey;
	String kafkaTopic = "java_in_use_topic";
	
	public void send(EmailObject company) {
		amqpTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("Send msg = " + company);
	    
	}
}