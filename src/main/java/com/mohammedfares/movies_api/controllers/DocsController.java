package com.mohammedfares.movies_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DocsController {

	@GetMapping
	public String index(@RequestParam(name = "param1", required = false) String param1) {
		return "Haaaaaaaaah ... " + param1;
	}
}
