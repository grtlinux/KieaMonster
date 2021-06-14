package org.tain.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.tain.data.vo.Info;

import lombok.Data;

@Component
@Data
public class WorkingData {

	private Map<String,Object> mapCmd = new HashMap<>();
	
	private Info info = new Info();
}
