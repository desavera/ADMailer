import antena.mailer.ADGoogleMailer;
import javax.mail.*;
import javax.mail.internet.*;

public class ADGoogleMailerTester {


	public static void main(String[] args) {

		ADGoogleMailer mailer = new ADGoogleMailer();

		try {


			mailer.send();


		} catch (MessagingException ex) {

			ex.printStackTrace();
		}

	}
}
