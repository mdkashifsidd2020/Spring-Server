package in.graminvikaspahal.demo.service;

import in.graminvikaspahal.demo.Model.AppUser;

public interface UserService {
	
	public AppUser SaveUser(AppUser newuser);
	
	public void removemessage();
	
	public void sendEmail(AppUser user, String path);
	
	public boolean verifyaccount(String verificationCode);

}
