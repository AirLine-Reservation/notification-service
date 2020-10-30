package edu.miu.cs.cs544.notification.notificationservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = EmailObject.class)
public class EmailObject {

	private String email;
	private String reservationId;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	@Override
	public String toString() {
		return "Notification [email=" + email + ", reservationId=" + reservationId + "]";
	}

}
