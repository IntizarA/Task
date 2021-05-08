package task_register.dataAccess.abstracts;

import java.util.List;

import task_register.entities.concretes.User;

public interface UserDao {
void add(User user);
void delete(User user);
void update(User user);
User getById(int id);
User getByEmail(String email);
List<User> getAll();
} 
