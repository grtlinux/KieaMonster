package org.tain.controller.rest;

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
import org.tain.data.WorkingData;
import org.tain.data.vo.Info;
import org.tain.utils.IpPrint;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping({"/data"})
@Slf4j
public class WorkingDataRestController {

	@Autowired
	private WorkingData workingData;
	
	@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@GetMapping({"/info"})
	public ResponseEntity<?> dataInfo(HttpEntity<String> httpEntity) {
		if (Boolean.TRUE) {
			HttpHeaders headers = httpEntity.getHeaders();
			String body = httpEntity.getBody();
			log.info(">>>>> ip.info: " + IpPrint.get());
			log.info(">>>>> request.headers: " + headers.toString());
			log.info(">>>>> request.body: " + body);
		}
		
		Info info = null;
		if (Boolean.TRUE) {
			//Map<String,Object> mapIn = new HashMap<>();
			info = this.workingData.getInfo();
			log.info(">>>>> info: {}", info);
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(info, headers, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@GetMapping({"/mapCmd"})
	public ResponseEntity<?> dataMapCmd(HttpEntity<String> httpEntity) {
		if (Boolean.TRUE) {
			HttpHeaders headers = httpEntity.getHeaders();
			String body = httpEntity.getBody();
			log.info(">>>>> ip.info: " + IpPrint.get());
			log.info(">>>>> request.headers: " + headers.toString());
			log.info(">>>>> request.body: " + body);
		}
		
		Map<String,Object> mapCmd = null;
		if (Boolean.TRUE) {
			//Map<String,Object> mapIn = new HashMap<>();
			mapCmd = this.workingData.getMapCmd();
			log.info(">>>>> mapCmd: {}", mapCmd);
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(mapCmd, headers, HttpStatus.OK);
	}
}
