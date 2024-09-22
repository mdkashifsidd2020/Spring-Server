package in.graminvikaspahal.demo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import in.graminvikaspahal.demo.Model.AppUser;
import in.graminvikaspahal.demo.repo.UserRepo;
import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public AppUser SaveUser(AppUser newuser) {
		
		String password = passwordEncoder.encode(newuser.getPassword());
		newuser.setPassword(password);
		newuser.setRole("ROLE_NORMAL");
		
		newuser.setEnable(false);
		
		newuser.setVcode(UUID.randomUUID().toString());
		
		AppUser u = repo.save(newuser);
		
		return u;
	}

	@Override
	public void removemessage() {
		
	HttpSession session=((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
	
	session.removeAttribute("msg");
		
	}

	@Override
	public void sendEmail(AppUser user, String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verifyaccount(String verificationCode) {
		// TODO Auto-generated method stub
		return false;
	}

}
