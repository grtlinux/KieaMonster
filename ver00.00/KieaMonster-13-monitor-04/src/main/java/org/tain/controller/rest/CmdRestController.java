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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tain.data.WorkingData;
import org.tain.mybatis.mappers.CmdMapper;
import org.tain.utils.IpPrint;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping({"/rest"})
@Slf4j
public class CmdRestController {

	@Autowired
	private CmdMapper cmdMapper;
	
	//@Autowired
	//private AsyncCmdTask asyncCmdTask;
	
	@SuppressWarnings("unused")
	@Autowired
	private WorkingData workingData;
	
	@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@GetMapping({"/cmd/list"})
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
			lst = this.cmdMapper.selectAll(mapIn);
			log.info(">>>>> lst: {}", lst);
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(lst, headers, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@GetMapping({"/cmd"})
	public ResponseEntity<?> selectByMstCode(
			@RequestParam(value = "mstCode", defaultValue = "") String mstCode
			, @RequestParam(value = "cmdCode", defaultValue = "") String cmdCode
			, HttpEntity<String> httpEntity) {
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
			mapIn.put("mstCode", mstCode);
			mapIn.put("cmdCode", cmdCode);
			lst = this.cmdMapper.selectByCode(mapIn);
			log.info(">>>>> itm: {}", lst);
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(lst, headers, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@GetMapping({"/cmd/{cmdCode}"})
	public ResponseEntity<?> selectByCode(@PathVariable("cmdCode") String cmdCode, HttpEntity<String> httpEntity) {
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
			mapIn.put("cmdCode", cmdCode);
			lst = this.cmdMapper.selectByCode(mapIn);
			log.info(">>>>> itm: {}", lst);
		}
		
		if (Boolean.TRUE) {
			try {
				//Cmd cmd = Cmd.builder().cmdPeriod("60").cmdArr("java -version").build();
				//Cmd cmd = Cmd.builder().cmdPeriod("0").cmdArr("java -version").build();
				//this.workingData.getMapCmd().put(cmdCode, cmd);
				//this.asyncCmdTask.async_0101(cmd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(lst, headers, HttpStatus.OK);
	}
}
