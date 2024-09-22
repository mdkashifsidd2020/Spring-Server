package in.graminvikaspahal.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.graminvikaspahal.demo.Model.AppUser;

public interface UserRepo extends JpaRepository<AppUser, Integer> {
	
	public AppUser findByEmail(String email);

}
