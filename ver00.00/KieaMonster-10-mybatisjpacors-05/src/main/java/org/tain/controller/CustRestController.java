package org.tain.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tain.jpa.domain.TbCust;
import org.tain.jpa.repository.TbCustRepository;
import org.tain.mybatis.mappers.CustMapper;

@RestController
@RequestMapping({"/cust"})
public class CustRestController {

	@Autowired
	private TbCustRepository tbCustRepository;
	
	@Autowired
	private CustMapper custMapper;
	
	///////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/findAll")
	public List<TbCust> findAll() {
		return this.tbCustRepository.findAll();
	}
	
	@GetMapping("/selectAll")
	public List<Map<String,Object>> selectAll() {
		return this.custMapper.selectAll(null);
	}
}
