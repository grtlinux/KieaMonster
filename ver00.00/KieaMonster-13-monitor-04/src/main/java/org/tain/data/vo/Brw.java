package org.tain.data.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Brw {

	private String sessId;
	
	private String cmdCode;
	
	@Builder
	public Brw(
			String sessId,
			String cmdCode
			) {
		this.sessId = sessId;
		this.cmdCode = cmdCode;
	}
}
