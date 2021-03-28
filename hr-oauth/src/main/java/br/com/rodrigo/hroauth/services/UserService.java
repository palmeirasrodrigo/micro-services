package br.com.rodrigo.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigo.hroauth.entities.User;
import br.com.rodrigo.hroauth.feignclients.UserFeignclients;

@Service
public class UserService {
	
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
}
