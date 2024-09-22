package in.graminvikaspahal.demo.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.graminvikaspahal.demo.Model.AppUser;
import in.graminvikaspahal.demo.repo.UserRepo;
import in.graminvikaspahal.demo.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	private UserService userve;
	
	@Autowired 
	private UserRepo repo;
	
	@GetMapping("/signup")
	public String signuppage(){
		return "signup";
	}
	
	@PostMapping("/register")
	public String registerpage(@ModelAttribute AppUser user, HttpSession session) {
		
		AppUser u =userve.SaveUser(user);
		
		if(u != null) {
			session.setAttribute("msg", "user registered successfully");
			//System.out.println("success");
		}else {
			//System.out.println("error");
			session.setAttribute("msg", "something went wrong");
		}
		
		return "redirect:/signup";
	}
	
	@GetMapping("/customlogin")
	public String loginpage() {
		return "login";
	}
	
	@GetMapping("/user/profile")
	public String profile(Principal p, Model m) {
		
		
		String email = p.getName();
				
			AppUser user = repo.findByEmail(email);	
			
			m.addAttribute("value", user);


		return "profilepage";
	}
	
	@GetMapping("/admin/profile")
	public String adminprofile(Principal p, Model m) {
		
		
		String email = p.getName();
				
			AppUser user = repo.findByEmail(email);	
			
			m.addAttribute("value", user);


		return "admindashboard";
	}
	
	

	

}
