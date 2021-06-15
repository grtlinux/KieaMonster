package org.tain.data;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class WorkingData {

	private String name = "Hello, WebSocket";
}
