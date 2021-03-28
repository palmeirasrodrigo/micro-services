package br.com.rodrigo.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.rodrigo.hroauth.entities.User;
import br.com.rodrigo.hroauth.feignclients.UserFeignclients;

@Service
public class UserService implements UserDetailsService{
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignclients userFeignclients;
	
	public User findByEmail(String email) {
		User user = userFeignclients.findByEmail(email).getBody();
		if (user == null) {
			logger.error("Email not found " + email);
			throw new IllegalArgumentException("Eamil not found");
		}
		logger.info("Email found " + email);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignclients.findByEmail(username).getBody();
		if (user == null) {
			logger.error("Email not found " + username);
			throw new UsernameNotFoundException("Eamil not found");
		}
		logger.info("Email found " + username);
		return user;
	}
}
