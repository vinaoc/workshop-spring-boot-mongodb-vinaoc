package com.viniciuspaim.workshopmongo.resources;

import com.viniciuspaim.workshopmongo.DTO.UserDTO;
import com.viniciuspaim.workshopmongo.domain.Post;
import com.viniciuspaim.workshopmongo.domain.User;
import com.viniciuspaim.workshopmongo.services.PostService;
import com.viniciuspaim.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

		/**User obj = service.findById(id.toString());
		return ResponseEntity.ok().body(new UserDTO(obj));**/
	}
}
