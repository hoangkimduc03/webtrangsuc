package com.example.java6.restController;

import com.example.java6.entity.Authority;
import com.example.java6.service.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthorityRestController {

	@Autowired
	AuthoritiesService authorityService;
	
	@GetMapping
	public List<Authority> findAll(@RequestParam("admin") Optional<Boolean> admin){
		if (admin.orElse(false)) {
			return authorityService.findAuthoritiesOfAdministrators();
		}
		return authorityService.findAll();
	}
	
	@PostMapping
	public Authority post(@RequestBody Authority auth) {
		return authorityService.create(auth);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		authorityService.delete(id);
	}
	
	@GetMapping("authoritiesOne")
	public List<Authority> getOneByRole(@RequestParam("username")String username){
		return authorityService.getOneByRole(username);
	}
	
	@DeleteMapping("authoritiesOne/{username}")
	public void deleteByUsername(@PathVariable("username") String username){
		authorityService.deleteByUsername(username);
	}
}
