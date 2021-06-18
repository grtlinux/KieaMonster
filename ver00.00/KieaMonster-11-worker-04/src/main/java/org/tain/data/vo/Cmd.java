package org.tain.data.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cmd {

	//private Long id;
	
	private String mstCode;
	
	private String mstType;
	
	private String cmdCode;
	
	//private String cmdType;
	
	//private String cmdName;
	
	//private String cmdDesc;
	
	private String cmdPeriod;
	
	private String cmdArr;
	
	private boolean flgAlive;
	
	// Cmd.builder().mstCode("")....build();
	@Builder
	public Cmd(
			String mstCode,
			String mstType,
			String cmdCode,
			String cmdPeriod,
			String cmdArr,
			boolean flgAalive
			) {
		this.mstCode = mstCode;
		this.mstType = mstType;
		this.cmdCode = cmdCode;
		this.cmdPeriod = cmdPeriod;
		this.cmdArr = cmdArr;
		this.flgAlive = flgAalive;
	}
}
