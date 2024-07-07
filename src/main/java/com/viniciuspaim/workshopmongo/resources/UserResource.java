package com.viniciuspaim.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.viniciuspaim.workshopmongo.DTO.UserDTO;
import com.viniciuspaim.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.viniciuspaim.workshopmongo.domain.User;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(UserDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));

		/**User obj = service.findById(id.toString());
		return ResponseEntity.ok().body(new UserDTO(obj));**/
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri	= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
