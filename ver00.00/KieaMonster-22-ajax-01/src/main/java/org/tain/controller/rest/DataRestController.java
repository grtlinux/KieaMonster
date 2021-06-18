package org.tain.controller.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/rest"})
public class DataRestController {

	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public List<Map<String,Object>> list() {
		List<Map<String,Object>> lst = new ArrayList<>();
		
		for (int i=0; i < 10; i++) {
			Map<String,Object> map = new HashMap<>();
			map.put("code", String.format("CD%02d", i));
			map.put("name", String.format("name-%02d", i));
			map.put("content", String.format("content of CD%02d", i));
			lst.add(map);
		}
		
		System.out.println(">>>>> " + lst);
		
		return lst;
	}
}
