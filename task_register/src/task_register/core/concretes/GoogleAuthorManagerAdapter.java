package task_register.core.concretes;

import task_register.core.abstracts.AuthorService;
import task_register.googleAuth.GoogleAuthorManager;

public class GoogleAuthorManagerAdapter implements AuthorService {

	@Override
	public boolean isValidUser() {
	
		return new GoogleAuthorManager().isValidUserByGoogle();
				
	
	}

}
