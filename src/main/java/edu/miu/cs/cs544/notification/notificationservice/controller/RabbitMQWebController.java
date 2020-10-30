package edu.miu.cs.cs544.notification.notificationservice.controller;


import edu.miu.cs.cs544.notification.notificationservice.model.EmailObject;
import edu.miu.cs.cs544.notification.notificationservice.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notification/")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("email") String email, @RequestParam("reservationId") String reservationId) {
	
	EmailObject emailObject=new EmailObject();
		emailObject.setReservationId(reservationId);
		emailObject.setEmail(email);
		rabbitMQSender.send(emailObject);

		return "Message sent to the RabbitMQ for sent email Successfully";
	}

}

