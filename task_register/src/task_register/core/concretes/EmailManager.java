package task_register.core.concretes;

import task_register.core.abstracts.EmailService;

public class EmailManager implements EmailService {

	@Override
	public void sendVerificationEmail(String email) {
	System.out.println("Verification mail has sent to:"+email );
	System.out.println("Click on this link: https://onaylamalinki.com/");
		
	}

}
