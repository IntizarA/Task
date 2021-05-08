package task_register;

import task_register.business.abstracts.UserService;
import task_register.business.concretes.UserCheckManager;
import task_register.business.concretes.UserManager;
import task_register.core.concretes.EmailManager;
import task_register.dataAccess.concretes.HibernateUserDao;
import task_register.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1=new User(1,"Intizar","Aliyeva","intizar.aliyeva69@gmail.com","123456789");
		User user2=new User(2,"Ilqar","Aliyev","intizar.aliyeva@gmail.com","123452229");
		UserManager userService=new UserManager(new HibernateUserDao(),new UserCheckManager(new EmailManager()));
userService.register(user1);
userService.login(user1.getEmail(), user1.getPassword());
System.out.println();
userService.register(user2);
userService.login(user2.getEmail(), user2.getPassword());

	}

}
