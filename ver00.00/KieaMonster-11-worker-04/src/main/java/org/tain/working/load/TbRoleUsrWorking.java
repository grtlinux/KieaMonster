package org.tain.working.load;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.jpa.domain.TbRoleUsr;
import org.tain.jpa.repository.TbRoleUsrRepository;
import org.tain.tools.properties.ProjEnvJson;
import org.tain.tools.properties.ProjEnvParam;
import org.tain.utils.CurrentInfo;
import org.tain.utils.StringTools;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TbRoleUsrWorking {

	@Autowired
	private ProjEnvParam projEnvParam;

	@Autowired
	private ProjEnvJson projEnvJson;

	@Autowired
	private TbRoleUsrRepository tbRoleUsrRepository;
	
	public void load() throws Exception {
		log.info("KANG-20210405 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			// delete all
			this.tbRoleUsrRepository.deleteAll();
		}
		
		if (Boolean.TRUE) {
			String filePath = this.projEnvParam.getHome()
					+ this.projEnvParam.getBase()
					+ this.projEnvParam.getInfoPath()
					+ File.separator
					+ this.projEnvJson.getRoleUsrInfoFile();
			if (Boolean.TRUE) log.info("KANG-20210406 >>>>> {} {}", CurrentInfo.get(), filePath);

			String strJson = StringTools.stringFromFile(filePath);
			if (Boolean.TRUE) log.info("KANG-20210406 >>>>> {} {}", CurrentInfo.get(), strJson);
			
			List<TbRoleUsr> lstTbUser = new ObjectMapper().readValue(strJson, new TypeReference<List<TbRoleUsr>>() {});
			lstTbUser.forEach(entry -> {
				if (Boolean.TRUE) log.info("KANG-20210406 >>>>> {} {}", CurrentInfo.get(), entry);
				this.tbRoleUsrRepository.save(entry);
			});
		}
	}
}
