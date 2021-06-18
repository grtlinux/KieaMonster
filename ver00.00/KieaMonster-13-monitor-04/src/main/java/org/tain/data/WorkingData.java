package org.tain.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.Session;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.data.vo.Brw;
import org.tain.data.vo.Cmd;
import org.tain.data.vo.Info;
import org.tain.tools.node.MonJsonNode;
import org.tain.tools.queue.MonQueue;

import lombok.Data;

@Component
@Data
public class WorkingData {

	private String name = "########## MONITOR DATA ############";
	
	///////////////////////////////////////////////////////////////////////////
	//
	private Info info = new Info();
	
	///////////////////////////////////////////////////////////////////////////
	//
	private Map<String,Brw> mapBrw = new HashMap<>();
	private Map<String,Cmd> mapCmd = new HashMap<>();
	
	///////////////////////////////////////////////////////////////////////////
	// Sample Queue
	//private MonQueue<MonJsonNode> queue = new MonQueue<>();
	
	// Queue
	private MonQueue<MonJsonNode> queueFromCommanderToBrowser = new MonQueue<>();
	
	// Queue
	private MonQueue<MonJsonNode> queueFromBrowserToCommander = new MonQueue<>();
	
	///////////////////////////////////////////////////////////////////////////
	// Session
	private Set<Session> brwSessions = new CopyOnWriteArraySet<>();
	private Set<Session> cmdSessions = new CopyOnWriteArraySet<>();
	
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	@Bean
	public void setting() {
		/*
		if (Boolean.TRUE) {
			this.info.setName("SVR01");
			this.info.setDesc("description of SVR01");
		}
		
		if (Boolean.TRUE) {
			this.mapCmd.put("cmd0101", Cmd.builder().cmdPeriod("60").cmdArr("ps -ef").build());
			this.mapCmd.put("cmd0102", Cmd.builder().cmdPeriod("30").cmdArr("netstat -lntp").build());
			this.mapCmd.put("cmd0103", Cmd.builder().cmdPeriod("10").cmdArr("vmstat -w 5").build());
		}
		*/
	}
}
