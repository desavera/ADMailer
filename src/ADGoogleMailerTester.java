import antena.mailer.ADGoogleMailer;
import javax.mail.*;
import javax.mail.internet.*;

public class ADGoogleMailerTester {


	public static void main(String[] args) {

		ADGoogleMailer mailer = new ADGoogleMailer("desavera@gmail.com","Traccia23");

		try {


			mailer.send("desavera@gmail.com","Isso é um teste... ","TESTANDO MAILERX");


		} catch (MessagingException ex) {

			ex.printStackTrace();
		}

	}
}
