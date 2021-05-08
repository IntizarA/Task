package task_register.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import task_register.dataAccess.abstracts.UserDao;
import task_register.entities.concretes.User;

public class HibernateUserDao implements UserDao {
List <User>  userList=new ArrayList<User>();

//	public HibernateUserDao(List<User> userList) {
//	super();
//	this.userList = userList;
//}

	@Override
	public void add(User user) {
		System.out.println("Hibernate tarafindan uretildi:"+user.getEmail());
		userList.add(user);
	}

	@Override
	public void delete(User user) {
		System.out.println("Hibernate tarafindan silindi:"+user.getEmail());
		userList.remove(getById(user.getId()));
	}

	@Override
	public void update(User user) {
		System.out.println("Hibernate tarafindan yenilendi:"+user.getEmail());
		userList.remove(getById(user.getId()));
		userList.add(user);
	}

	@Override
	public User getById(int id) {
		List <User> users=getAll();
		if(users!=null) {
			for (User user:users) {
				if(user.getId()==id) return user;
			}
		}
		return null;
	}

	@Override
	public User getByEmail(String email) {
		List <User> users =getAll();
		if(users!=null) {
			for(User user:users ) {
				if(user.getEmail().equals(email))return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
	
		return userList;
	}

}
