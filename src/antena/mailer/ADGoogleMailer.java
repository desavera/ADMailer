package antena.mailer;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class ADGoogleMailer {


	private String username_;
	private String password_;

	public ADGoogleMailer(String username,String password) {

		username_ = username.toString();
		password_ = password.toString();
	}

	public void send(String TO,String MSG,String SUBJ) throws MessagingException {


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
       	         		return new PasswordAuthentication(username_, password_);
       	     		}
       	 	});

    		Message message = new MimeMessage(session);
    		message.setFrom(new InternetAddress(username_.toString()));
    		message.setRecipients(Message.RecipientType.TO,
       	        InternetAddress.parse(TO.toString()));
		message.setSubject("SUBJ.toString()");
		message.setText(MSG.toString());

		Transport.send(message);

		//System.out.println("Done");

	}
}

