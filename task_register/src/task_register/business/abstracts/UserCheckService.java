package task_register.business.abstracts;

import task_register.dataAccess.abstracts.UserDao;
import task_register.entities.concretes.User;

public interface UserCheckService {
boolean isValidFirstName(String firstName);
boolean isValidSurName(String surName);
boolean isValidPassword(String password);
boolean isValidEmailFormat(String email);
boolean isUsedEmail(String email, UserDao userdao);
boolean isValidUser(User user,UserDao userdao);
boolean isCorrectLoginInput(String email,String password,UserDao userdao);

}
