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

	@GetMapping("/ws1")
	public String ws1() {
		return "ws/ws1";
	}

	@GetMapping("/ws2")
	public String ws2() {
		return "ws/ws2";
	}

	@GetMapping("/ws3")
	public String ws3() {
		return "ws/ws3";
	}
}
