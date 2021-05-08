package task_register.business.concretes;

import java.util.regex.Pattern;

import task_register.business.abstracts.UserCheckService;
import task_register.core.abstracts.AuthorService;
import task_register.core.abstracts.EmailService;
import task_register.dataAccess.abstracts.UserDao;
import task_register.entities.concretes.User;

public class UserCheckManager implements UserCheckService {
	private AuthorService autorService;
	private EmailService emailService;
	

	public UserCheckManager(EmailService emailService) {
		super();
		this.emailService = emailService;
	}

	public UserCheckManager(AuthorService autorService, EmailService emailService) {
		super();
		this.autorService = autorService;
		this.emailService = emailService;
	}

	@Override
	public boolean isValidFirstName(String firstName) {
		if(firstName.length()>2) {
			return true;
			
		}
		System.out.println("2 karakterden az olamaz!");
		return false;
	}

	@Override
	public boolean isValidSurName(String surName) {
		if(surName.length()>2)return true;
		System.out.println("2 karakterden az olamaz!");
		return false;
	}

	@Override
	public boolean isValidPassword(String password) {
		if(password.length()>6) return true;
		System.out.println("6 karakterden az olamaz!");
		return false;
	}

	@Override
	public boolean isValidEmailFormat(String email) {
		String emailRegex="^(.+)@(.+)$";
		Pattern pattern=Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
		if(email==null) {
			System.out.println("Yalnis email formati!");return false;}
		else if(!pattern.matcher(email).matches()) System.out.println("Yalnis email formati!");
		return true;
	}

	@Override
	public boolean isUsedEmail(String email, UserDao userdao) {
		if(userdao.getByEmail(email)!=null) {
			System.out.println("Kullanilmish email!");
			return true;
		}
		return false;
	}

	@Override
	public boolean isValidUser(User user, UserDao userdao) {
		if(autorService!=null) return autorService.isValidUser();
		if(!isValidFirstName(user.getFirstName())) return false;
		if(!isValidSurName(user.getSurName())) return false;
		if(!isValidEmailFormat(user.getEmail())) return false;
		if(!isUsedEmail(user.getEmail(),userdao)) return false;
		if(!isValidPassword(user.getPassword())) return false;
		emailService.sendVerificationEmail(user.getEmail());
		System.out.println("Verified");
		return true;
	}

	@Override
	public boolean isCorrectLoginInput(String email, String password, UserDao userdao) {
	if(autorService!=null)return autorService.isValidUser();
	User user =userdao.getByEmail(email);
	if(user==null) {
		System.out.println("Yalnis email!");
		return false;
	}
	else if(!user.getPassword().equals(password)) {
		System.out.println("Yalnis password");
		return false;
	}
		return true;
	}

}
