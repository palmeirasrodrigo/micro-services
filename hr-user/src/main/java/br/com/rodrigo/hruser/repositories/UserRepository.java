package br.com.rodrigo.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodrigo.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
