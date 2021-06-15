package org.tain.data.vo;

import lombok.Builder;
import lombok.Data;

@Data
public class Cmd {

	//private Long id;
	
	//private String svrCode;
	
	//private String cmdCode;
	
	//private String cmdName;
	
	//private String cmdDesc;
	
	private String cmdPeriod;
	
	//private String cmdType;
	
	private String cmdArr;
	
	@Builder
	public Cmd(
			String cmdPeriod,
			String cmdArr
			) {
		this.cmdPeriod = cmdPeriod;
		this.cmdArr = cmdArr;
	}
}
