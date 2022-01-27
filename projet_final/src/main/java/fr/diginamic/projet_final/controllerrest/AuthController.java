package fr.diginamic.projet_final.controllerrest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.projet_final.model.Collaborateur;
import fr.diginamic.projet_final.model.Role;
import fr.diginamic.projet_final.model.enumeration.ERole;
import fr.diginamic.projet_final.repository.*;
import fr.diginamic.projet_final.request.LoginRequest;
import fr.diginamic.projet_final.request.SignupRequest;
import fr.diginamic.projet_final.response.JwtResponse;
import fr.diginamic.projet_final.response.MessageResponse;
import fr.diginamic.projet_final.security.jwt.JwtUtils;
import fr.diginamic.projet_final.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired 
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> anthenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getEmail(),
				roles));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"))
		}
		
		Collaborateur user = new Collaborateur(signUpRequest.getUsername(),
				signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));
		
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		
		if(strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.SALARIE)
					.orElseThrow(()-> new RuntimeException("Error : Role is not found."));
			roles.add(userRole);
		}else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ADMINISTRATEUR)
						.orElseThrow(()-> new RuntimeException("Error: Role is not found"));
					roles.add(adminRole);
					break;
					
				case "salarie" :
					Role salarieRole = roleRepository.findByName(ERole.SALARIE)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					roles.add(adminRole);
					break;
					
				case "admin" :
					Role adminRole = roleRepository.findByName(ERole.MANAGER)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					roles.add(adminRole);
					break;
				default: 
					Role userRole = roleRepository.findByLibelle(ERole.SALARIE)
						.orElseThrow(()-> new RuntimeException("Error is not found."));
					roles.add(userRole);
				}
			});
		}
		
		user.setRole(roles);
		userRepository.save(user);
		
		return ResponseEntity.ok(new MessageResponse("User registrated successfully!"));
	}
}
