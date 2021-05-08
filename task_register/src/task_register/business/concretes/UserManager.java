package task_register.business.concretes;

import task_register.business.abstracts.UserCheckService;
import task_register.business.abstracts.UserService;
import task_register.dataAccess.abstracts.UserDao;
import task_register.entities.concretes.User;

public class UserManager implements UserService {
private UserDao userdao;
private UserCheckService userCheckService;

	public UserManager(UserDao userdao, UserCheckService userCheckService) {
	super();
	this.userdao = userdao;
	this.userCheckService = userCheckService;
}	

	@Override
	public void register(User user) {
		if(userCheckService.isValidUser(user, userdao)) {
			System.out.println("Registration succesfully!");
		return;
		}
		System.out.println("Registration Failed!");
	}

	@Override
	public void login(String email, String password) {
		if(userCheckService.isCorrectLoginInput(email, password, userdao)) {
			System.out.println("...");
			return;
		}
		System.out.println("Login Failed!");
	}

	@Override
	public void update(User user) {
		
		if(userCheckService.isValidUser(user, userdao)) {
			userdao.update(user);
			System.out.println("Updated succesfully!");
			return;
		}
		System.out.println("Update Failed!");
	}

	@Override
	public void delete(User user) {
		userdao.delete(user);
		System.out.println("User deleted succesfully!");
		
	}

}
