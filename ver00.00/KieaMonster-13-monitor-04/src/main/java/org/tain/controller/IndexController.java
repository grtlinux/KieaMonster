package org.tain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "redirect:/home";
	}

	@GetMapping("/dash1")
	public String dash1() {
		return "dash1";
	}

	@GetMapping("/ws")
	public String ws() {
		return "ws/ws";
	}
}
