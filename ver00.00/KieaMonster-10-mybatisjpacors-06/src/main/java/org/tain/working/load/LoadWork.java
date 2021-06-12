package org.tain.working.load;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.jpa.domain.TbCust;
import org.tain.jpa.domain.TbCustProd;
import org.tain.jpa.domain.TbProd;
import org.tain.jpa.repository.TbCustProdRepository;
import org.tain.jpa.repository.TbCustRepository;
import org.tain.jpa.repository.TbProdRepository;
import org.tain.working.properties.ProjEnvParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LoadWork {

	@Autowired
	private ProjEnvParam projEnvParam;
	
	private String custFilePath;
	private String prodFilePath;
	private String custProdFilePath;
	private int index = 0;
	
	public void working() throws Exception {
		if (Boolean.TRUE) {
			String basePath = this.projEnvParam.getBasePath() + File.separator;
			this.custFilePath = basePath + this.projEnvParam.getCustFile();
			this.prodFilePath = basePath + this.projEnvParam.getProdFile();
			this.custProdFilePath = basePath + this.projEnvParam.getCustProdFile();
		}
		
		if (Boolean.TRUE) loadCust();
		if (Boolean.TRUE) loadProd();
		if (Boolean.TRUE) loadCustProd();
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private TbCustRepository tbCustRepository;
	
	private void loadCust() throws Exception {
		List<TbCust> lst = new ObjectMapper().readValue(new File(this.custFilePath), new TypeReference<List<TbCust>>() {});
		lst.forEach(item -> {
			item.setId((long)this.index ++);
			this.tbCustRepository.save(item);
		});
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private TbProdRepository tbProdRepository;
	
	private void loadProd() throws Exception {
		List<TbProd> lst = new ObjectMapper().readValue(new File(this.prodFilePath), new TypeReference<List<TbProd>>() {});
		lst.forEach(item -> {
			item.setId((long)this.index ++);
			this.tbProdRepository.save(item);
		});
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private TbCustProdRepository tbCustProdRepository;
	
	private void loadCustProd() throws Exception {
		List<TbCustProd> lst = new ObjectMapper().readValue(new File(this.custProdFilePath), new TypeReference<List<TbCustProd>>() {});
		lst.forEach(item -> {
			item.setId((long)this.index ++);
			this.tbCustProdRepository.save(item);
		});
	}
}
