package org.tain.data.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Info {

	private String svrCode;
	
	private String name;
	
	private String desc;
	
	@Builder
	public Info(
			String svrCode,
			String name,
			String desc
			) {
		this.svrCode = svrCode;
		this.name = name;
		this.desc = desc;
	}
}
