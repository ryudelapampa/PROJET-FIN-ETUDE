package fr.diginamic.projet_final.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.projet_final.model.Collaborateur;
import fr.diginamic.projet_final.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Collaborateur user = userRepository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("User Not found with username :"+ username));
		return UserDetailsImpl.build(user);
	}

}
