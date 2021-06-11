package org.tain.working.properties;

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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PropertiesWorking {

	@Autowired
	private ProjEnvParamProperties projEnvParamProperties;
	
	private String custFilePath;
	private String prodFilePath;
	private String custProdFilePath;
	
	private int idx;
	
	public void work() throws Exception {
		if (Boolean.TRUE) {
			this.custFilePath = this.projEnvParamProperties.getBasePath() + File.separator + this.projEnvParamProperties.getCustFile();
			this.prodFilePath = this.projEnvParamProperties.getBasePath() + File.separator + this.projEnvParamProperties.getProdFile();
			this.custProdFilePath = this.projEnvParamProperties.getBasePath() + File.separator + this.projEnvParamProperties.getCustProdFile();
			this.idx = 0;
		}
		
		loadCust();
		loadProd();
		loadCustProd();
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private TbCustRepository tbCustRepository;
	
	private void loadCust() throws Exception {
		List<TbCust> lst = new ObjectMapper().readValue(new File(this.custFilePath), new TypeReference<List<TbCust>>() {});
		
		lst.forEach(itm -> {
			itm.setId((long)this.idx++);
			this.tbCustRepository.save(itm);
		});
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private TbProdRepository tbProdRepository;
	
	private void loadProd() throws Exception {
		List<TbProd> lst = new ObjectMapper().readValue(new File(this.prodFilePath), new TypeReference<List<TbProd>>() {});
		
		lst.forEach(itm -> {
			itm.setId((long)this.idx++);
			this.tbProdRepository.save(itm);
		});
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private TbCustProdRepository tbCustProdRepository;
	
	private void loadCustProd() throws Exception {
		List<TbCustProd> lst = new ObjectMapper().readValue(new File(this.custProdFilePath), new TypeReference<List<TbCustProd>>() {});
		
		lst.forEach(itm -> {
			itm.setId((long)this.idx++);
			this.tbCustProdRepository.save(itm);
		});
	}
}
