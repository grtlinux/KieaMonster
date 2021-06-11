package org.tain.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.tain.jpa.domain.TbCust;
import org.tain.jpa.repository.TbCustRepository;
import org.tain.mybatis.mappers.CustMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping({"/rest/cust"})
@Slf4j
public class CustRestController {

	@Autowired
	private TbCustRepository tbCustRepository;
	
	@Autowired
	private CustMapper custMapper;
	
	///////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/findAll")
	public List<TbCust> findAll() {
		return this.tbCustRepository.findAll();
	}
	
	@GetMapping("/selectAll")
	public List<Map<String,Object>> selectAll() {
		return this.custMapper.selectAll(null);
	}
	
	///////////////////////////////////////////////////////////////////////////
	@GetMapping({"/{code}"})
	public ResponseEntity<?> selectByCode(@PathVariable("code") String code, HttpEntity<String> httpEntity) {
		if (Boolean.TRUE) {
			HttpHeaders headers = httpEntity.getHeaders();
			String body = httpEntity.getBody();
			log.info(">>>>> request.headers: " + headers.toString());
			log.info(">>>>> request.body: " + body);
		}
		if (Boolean.TRUE) {
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
			log.info(">>>>> X-FORWARDED-FOR: " + request.getHeader("X-FORWARDED-FOR"));
			log.info(">>>>> RemoteAddr: " + request.getRemoteAddr());
			
			String ip = request.getHeader("X-FORWARDED-FOR");
			if (ip == null)
				ip = request.getRemoteAddr();
			log.info(">>>>> Client IP: " + ip);
		}
		
		Map<String,Object> itm = null;
		if (Boolean.TRUE) {
			Map<String,Object> mapIn = new HashMap<>();
			mapIn.put("code", code);
			itm = this.custMapper.selectByCode(mapIn);
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(itm, headers, HttpStatus.OK);
	}
}
