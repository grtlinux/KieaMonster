package org.tain.data.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cmd {

	//private Long id;
	
	private String mstCode;
	
	private String cmdCode;
	
	//private String cmdName;
	
	//private String cmdDesc;
	
	private String cmdPeriod;
	
	//private String cmdType;
	
	private String cmdArr;
	
	@Builder
	public Cmd(
			String mstCode,
			String cmdCode,
			String cmdPeriod,
			String cmdArr
			) {
		this.mstCode = mstCode;
		this.cmdCode = cmdCode;
		this.cmdPeriod = cmdPeriod;
		this.cmdArr = cmdArr;
	}
}
