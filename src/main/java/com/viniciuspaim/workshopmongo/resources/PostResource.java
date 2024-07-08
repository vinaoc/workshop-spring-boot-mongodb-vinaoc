package com.viniciuspaim.workshopmongo.resources;

import com.viniciuspaim.workshopmongo.domain.Post;
import com.viniciuspaim.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	private final PostService service;

	public PostResource(PostService service) {
		this.service = service;
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
