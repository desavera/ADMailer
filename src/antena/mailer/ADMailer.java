package antena.mailer;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class ADMailer
{
	// Assuming you are sending email from localhost
	public static String MAILER = "localhost";

	private String from_;
	private String to_;
	private String msg_;
	private String subj_;

	public ADMailer(String from,
			String to,
			String msg,
			String subj) {


		from_ = from.toString();
		to_ = to.toString();
		msg_ = msg.toString();
		subj_ = subj.toString();
	}

	public void send() throws MessagingException {

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", MAILER);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);


		// Create a default MimeMessage object.
		MimeMessage message = new MimeMessage(session);

		// Set From: header field of the header.
		message.setFrom(new InternetAddress(from_));

		// Set To: header field of the header.
		message.addRecipient(Message.RecipientType.TO,
         		    		new InternetAddress(to_));

		// Set Subject: header field
		message.setSubject(subj_.toString());

		// Now set the actual message
		message.setText(msg_.toString());

		// Send message
		Transport.send(message);
		System.out.println("Sent message successfully....");
	}
}
