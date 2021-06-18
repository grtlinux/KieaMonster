package org.tain.data.vo;

import javax.websocket.Session;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Brw {

	private String sessId;
	
	private Session session;
	
	private String cmdCode;
	
	@Builder
	public Brw(
			String sessId,
			Session session,
			String cmdCode
			) {
		this.sessId = sessId;
		this.session = session;
		this.cmdCode = cmdCode;
	}
}
