package in.graminvikaspahal.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import in.graminvikaspahal.demo.Model.AppUser;
import in.graminvikaspahal.demo.repo.UserRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		AppUser user = repo.findByEmail(username);
		
		if(user==null) {
			 throw new UsernameNotFoundException("user not found");
		}else {
			
			return new CustomUser(user);
			
		}
	
		
		
	}

}
