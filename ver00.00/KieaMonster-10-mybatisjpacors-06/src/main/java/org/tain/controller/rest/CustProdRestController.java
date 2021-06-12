package org.tain.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.mybatis.mappers.CustProdMapper;
import org.tain.utils.IpPrint;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping({"/rest/custProd"})
@Slf4j
public class CustProdRestController {

	@Autowired
	private CustProdMapper custProdMapper;
	
	@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@GetMapping({"", "/list"})
	public ResponseEntity<?> selectAll(HttpEntity<String> httpEntity) {
		if (Boolean.TRUE) {
			HttpHeaders headers = httpEntity.getHeaders();
			String body = httpEntity.getBody();
			log.info(">>>>> ip.info: " + IpPrint.get());
			log.info(">>>>> request.headers: " + headers.toString());
			log.info(">>>>> request.body: " + body);
		}
		
		List<Map<String,Object>> lst = null;
		if (Boolean.TRUE) {
			Map<String,Object> mapIn = new HashMap<>();
			lst = this.custProdMapper.selectAll(mapIn);
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(lst, headers, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@GetMapping({"/join1"})
	public ResponseEntity<?> selectJoin1(HttpEntity<String> httpEntity) {
		if (Boolean.TRUE) {
			HttpHeaders headers = httpEntity.getHeaders();
			String body = httpEntity.getBody();
			log.info(">>>>> ip.info: " + IpPrint.get());
			log.info(">>>>> request.headers: " + headers.toString());
			log.info(">>>>> request.body: " + body);
		}
		
		List<Map<String,Object>> lst = null;
		if (Boolean.TRUE) {
			Map<String,Object> mapIn = new HashMap<>();
			lst = this.custProdMapper.selectJoin1(mapIn);
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(lst, headers, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@GetMapping({"/join2"})
	public ResponseEntity<?> selectJoin2(HttpEntity<String> httpEntity) {
		if (Boolean.TRUE) {
			HttpHeaders headers = httpEntity.getHeaders();
			String body = httpEntity.getBody();
			log.info(">>>>> ip.info: " + IpPrint.get());
			log.info(">>>>> request.headers: " + headers.toString());
			log.info(">>>>> request.body: " + body);
		}
		
		List<Map<String,Object>> lst = null;
		if (Boolean.TRUE) {
			Map<String,Object> mapIn = new HashMap<>();
			lst = this.custProdMapper.selectJoin2(mapIn);
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(lst, headers, HttpStatus.OK);
	}
}
