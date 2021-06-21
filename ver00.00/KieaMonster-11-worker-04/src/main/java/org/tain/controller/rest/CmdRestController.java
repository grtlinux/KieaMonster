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
import org.tain.data.vo.Cmd;
import org.tain.mybatis.mappers.CmdMapper;
import org.tain.tasks.asynccmd.AsyncCmdTask;
import org.tain.utils.IpPrint;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping({"/rest"})
@Slf4j
public class CmdRestController {

	@Autowired
	private CmdMapper cmdMapper;
	
	@Autowired
	private AsyncCmdTask asyncCmdTask;
	
	@Autowired
	private WorkingData workingData;
	
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	//
	@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@GetMapping({"/cmd/_list"})
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
	
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	//
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
	
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	//
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
			// get cmd info
			Map<String,Object> mapIn = new HashMap<>();
			mapIn.put("cmdCode", cmdCode);
			lst = this.cmdMapper.selectByCode(mapIn);
			log.info(">>>>> itm: {}", lst);
		}
		
		Cmd cmd = null;
		if (Boolean.TRUE) {
			cmd = Cmd.builder().mstCode("SVR04").mstType("CMD_SVR").cmdCode("SVR0400").cmdPeriod("0").cmdArr("java -version").build();
		}
		
		if (Boolean.TRUE) {
			// run async of cmd
			try {
				this.asyncCmdTask.async_0101(cmd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Map<String,Object> mapRes = null;
		if (Boolean.TRUE) {
			// make return info
			mapRes = new HashMap<>();
			mapRes.put("msgKey", "WRK001");
			mapRes.put("msgType", "RES");
			mapRes.put("cmdCode", cmd.getCmdCode());
			mapRes.put("sessId", "");
			mapRes.put("resCode", "000");
			mapRes.put("resMsg", "SUCCESS");
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(mapRes, headers, HttpStatus.OK);
	}
	
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	// START
	@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@GetMapping({"/cmd/{cmdCode}/start"})
	public ResponseEntity<?> startCommand(@PathVariable("cmdCode") String cmdCode, HttpEntity<String> httpEntity) {
		if (Boolean.TRUE) {
			HttpHeaders headers = httpEntity.getHeaders();
			String body = httpEntity.getBody();
			log.info(">>>>> ip.info: " + IpPrint.get());
			log.info(">>>>> request.headers: " + headers.toString());
			log.info(">>>>> request.body: " + body);
		}
		
		List<Map<String,Object>> lst = null;
		if (Boolean.TRUE) {
			// get cmd info
			Map<String,Object> mapIn = new HashMap<>();
			mapIn.put("cmdCode", cmdCode);
			lst = this.cmdMapper.selectByCode(mapIn);
			log.info(">>>>> itm: {}", lst);
		}
		
		Cmd cmd = null;
		if (Boolean.TRUE) {
			cmd = Cmd.builder()
					.mstCode((String) lst.get(0).get("mstCode"))
					.mstType((String) lst.get(0).get("mstType"))
					.cmdCode((String) lst.get(0).get("cmdCode"))
					.cmdPeriod((String) lst.get(0).get("cmdPeriod"))
					.cmdArr((String) lst.get(0).get("cmdArr"))
					.flgAalive(true)
					.build();
			
			this.workingData.getMapCmd().put(cmdCode, cmd);
		}
		
		if (Boolean.TRUE) {
			// run async of cmd
			try {
				this.asyncCmdTask.async_0101(cmd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Map<String,Object> mapRes = null;
		if (Boolean.TRUE) {
			// make return info
			mapRes = new HashMap<>();
			mapRes.put("msgKey", "WRK001");
			mapRes.put("msgType", "RES");
			mapRes.put("cmdCode", cmd.getCmdCode());
			mapRes.put("sessId", "");
			mapRes.put("resCode", "000");
			mapRes.put("resMsg", "SUCCESS OF START");
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(mapRes, headers, HttpStatus.OK);
	}
	
	///////////////////////////////////////////////////////////////////////////
	// LIST
	@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@GetMapping({"/cmd/list"})
	public ResponseEntity<?> listCommands(HttpEntity<String> httpEntity) {
		if (Boolean.TRUE) {
			HttpHeaders headers = httpEntity.getHeaders();
			String body = httpEntity.getBody();
			log.info(">>>>> ip.info: " + IpPrint.get());
			log.info(">>>>> request.headers: " + headers.toString());
			log.info(">>>>> request.body: " + body);
		}
		
		Map<String,Object> mapCmd = null;
		if (Boolean.TRUE) {
			mapCmd = this.workingData.getMapCmd();
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(mapCmd, headers, HttpStatus.OK);
	}
	
	///////////////////////////////////////////////////////////////////////////
	// STOP
	@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
	@GetMapping({"/cmd/{cmdCode}/stop"})
	public ResponseEntity<?> stopCommand(@PathVariable("cmdCode") String cmdCode, HttpEntity<String> httpEntity) {
		if (Boolean.TRUE) {
			HttpHeaders headers = httpEntity.getHeaders();
			String body = httpEntity.getBody();
			log.info(">>>>> ip.info: " + IpPrint.get());
			log.info(">>>>> request.headers: " + headers.toString());
			log.info(">>>>> request.body: " + body);
		}
		
		Cmd cmd = null;
		if (Boolean.TRUE) {
			cmd = (Cmd) this.workingData.getMapCmd().get(cmdCode);
			cmd.setFlgAlive(false);
		}
		
		Map<String,Object> mapRes = null;
		if (Boolean.TRUE) {
			// make return info
			mapRes = new HashMap<>();
			mapRes.put("msgKey", "WRK001");
			mapRes.put("msgType", "RES");
			mapRes.put("cmdCode", cmd.getCmdCode());
			mapRes.put("sessId", "");
			mapRes.put("resCode", "000");
			mapRes.put("resMsg", "SUCCESS OF STOP");
		}
		
		MultiValueMap<String,String> headers = null;
		if (Boolean.TRUE) {
			headers = new LinkedMultiValueMap<>();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		}
		return new ResponseEntity<>(mapRes, headers, HttpStatus.OK);
	}
}
