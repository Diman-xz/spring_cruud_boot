package com.example.spring_crud_boot;

import com.example.spring_crud_boot.model.Role;
import com.example.spring_crud_boot.model.User;
import com.example.spring_crud_boot.repository.RoleRepository;
import com.example.spring_crud_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication (scanBasePackages = "com.example.spring_crud_boot")
public class SpringCrudBootApplication {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public SpringCrudBootApplication(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@PersistenceContext
	EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudBootApplication.class, args);
	}

	@PostConstruct
	public void getUserTest() {
			Set<Role> roleSet = new HashSet<>();
			User user = new User();
			roleRepository.save(new Role("ROLE_USER"));
			user.setUsername("user");
			user.setPassword(passwordEncoder.encode("user"));
			user.setSurName("userSurname");
			user.setEmail("user@email.ru");
			user.setPhoneNumber("userPhoneNumber");
			TypedQuery<Role> queryRole = entityManager.createQuery("select r from Role r where r.name='ROLE_USER'",
					Role.class);
			roleSet.add(queryRole.getSingleResult());
			user.setRoles(roleSet);
			userRepository.save(user);
		}

	@PostConstruct
	public void getAdminTest() {
		Set<Role> roleSet = new HashSet<>();
		User user = new User();
		roleRepository.save(new Role("ROLE_ADMIN"));
		user.setUsername("admin");
		user.setPassword(passwordEncoder.encode("admin"));
		user.setSurName("adminSurname");
		user.setEmail("admin@email.ru");
		user.setPhoneNumber("adminPhoneNumber");
		TypedQuery<Role> queryRole = entityManager.createQuery("select r from Role r where r.name='ROLE_ADMIN'",
				Role.class);
		roleSet.add(queryRole.getSingleResult());
		user.setRoles(roleSet);
		userRepository.save(user);
	}
}

