package antena.mailer;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class ADGoogleMailer {


	public ADGoogleMailer() {}


	public void send() throws MessagingException {

		final String username = "desavera@gmail.com";
		final String password = "Traccia23";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		//SSL props.put("mail.smtp.port", "465");
		//TLS props.put("mail.smtp.port", "587");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
       	 		new javax.mail.Authenticator() {
       	     		protected PasswordAuthentication getPasswordAuthentication() {
       	         		return new PasswordAuthentication(username, password);
       	     		}
       	 	});

    		Message message = new MimeMessage(session);
    		message.setFrom(new InternetAddress("zxcc@zirix.com.br"));
    		message.setRecipients(Message.RecipientType.TO,
       	        InternetAddress.parse("desavera@gmail.com"));
		message.setSubject("Test Subject");
		message.setText("This is a Test");

		Transport.send(message);

		System.out.println("Done");

	}

	public void send1() throws MessagingException {


		final String username = "desavera@gmail.com";
                final String password = "Traccia23";

		Properties props = System.getProperties();
		//props.put("mail.smtp.starttls.enable", true); // added this line
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", true);

		Session session = Session.getInstance(props,null);

		Message message = new MimeMessage(session);
    		message.setFrom(new InternetAddress("desavera@gmail.com"));
    		message.setRecipients(Message.RecipientType.TO,
       	        InternetAddress.parse("desavera@gmail.com"));
		message.setSubject("Test Subject");
		message.setText("Test");

		Transport transport = session.getTransport("smtps");
		String mfrom = "desavera";
		transport.connect("smtp.gmail.com", mfrom, "Traccia23");
		transport.sendMessage(message, message.getAllRecipients());

		System.out.println("Done");
	}
}

