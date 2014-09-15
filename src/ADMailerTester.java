import antena.mailer.ADMailer;
import javax.mail.*;
import javax.mail.internet.*;

public class ADMailerTester {




	public static void main(String[] args) {


		ADMailer mailer = new ADMailer(args[0],
						args[1],
						args[2],
						args[3]);

		try {


			mailer.send();


		} catch (MessagingException ex) {

			ex.printStackTrace();
		}

	}
}
