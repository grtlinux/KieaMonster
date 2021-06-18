package org.tain.working.http.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.tools.httpClient.MonHttpClient;
import org.tain.tools.node.MonJsonNode;
import org.tain.tools.properties.ProjEnvUrl;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CmdControllerTest {

	@Autowired
	private MonHttpClient monHttpClient;
	
	@Autowired
	private ProjEnvUrl projEnvUrl;
	
	///////////////////////////////////////////////////////////////////////////
	//
	public void cmdList() throws Exception {
		log.info("KANG-20210405 >>>>> {} {}", CurrentInfo.get());
		
		if (!Boolean.TRUE) {
			String httpUrl = null;
			String reqData = "{}";
			String resData = null;
			
			httpUrl = this.projEnvUrl.getWrkUrl() + "/rest/cmd/list";
			log.info(">>>>> httpUrl: " + httpUrl);
			resData = this.monHttpClient.get(httpUrl, reqData);
			log.info(">>>>> resData: " + resData);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	//
	public void cmdByMstCode() throws Exception {
		log.info("KANG-20210405 >>>>> {} {}", CurrentInfo.get());
		
		if (!Boolean.TRUE) {
			String httpUrl = null;
			Map<String,String> mapReq = new HashMap<>();
			mapReq.put("mstCode", "SVR04");
			MonJsonNode nodeRes = null;
			
			httpUrl = this.projEnvUrl.getWrkUrl() + "/rest/cmd";
			log.info(">>>>> httpUrl: " + httpUrl);
			nodeRes = this.monHttpClient.get(httpUrl, mapReq);
			log.info(">>>>> nodeRes: " + nodeRes.toPrettyString());
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	//
	public void cmdByCmdCode() throws Exception {
		log.info("KANG-20210405 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			String httpUrl = null;
			Map<String,String> mapReq = new HashMap<>();
			MonJsonNode nodeRes = null;
			
			httpUrl = this.projEnvUrl.getWrkUrl() + "/rest/cmd/SVR0400";
			log.info(">>>>> httpUrl: " + httpUrl);
			nodeRes = this.monHttpClient.get(httpUrl, mapReq);
			log.info(">>>>> nodeRes: " + nodeRes.toPrettyString());
		}
		
		if (!Boolean.TRUE) {
			String httpUrl = null;
			Map<String,String> mapReq = new HashMap<>();
			mapReq.put("cmdCode", "SVR0400");
			MonJsonNode nodeRes = null;
			
			httpUrl = this.projEnvUrl.getWrkUrl() + "/rest/cmd";
			log.info(">>>>> httpUrl: " + httpUrl);
			nodeRes = this.monHttpClient.get(httpUrl, mapReq);
			log.info(">>>>> nodeRes: " + nodeRes.toPrettyString());
		}
	}
}
