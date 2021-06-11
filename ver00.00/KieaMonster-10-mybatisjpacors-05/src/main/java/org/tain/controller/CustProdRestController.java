package org.tain.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tain.jpa.domain.TbCustProd;
import org.tain.jpa.repository.TbCustProdRepository;
import org.tain.mybatis.mappers.CustProdMapper;

@RestController
@RequestMapping({"/rest/custprod"})
public class CustProdRestController {

	@Autowired
	private TbCustProdRepository tbCustProdRepository;
	
	@Autowired
	private CustProdMapper custProdMapper;
	
	///////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/findAll")
	public List<TbCustProd> findAll() {
		return this.tbCustProdRepository.findAll();
	}
	
	@GetMapping("/selectAll")
	public List<Map<String,Object>> selectAll() {
		return this.custProdMapper.selectAll(null);
	}
	
	@GetMapping("/selectJoin1")
	public List<Map<String,Object>> selectJoin1() {
		return this.custProdMapper.selectJoin1(null);
	}
	
	@GetMapping("/selectJoin2")
	public List<Map<String,Object>> selectJoin2() {
		return this.custProdMapper.selectJoin2(null);
	}
}
