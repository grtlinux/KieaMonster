package org.tain.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_cust")
@Data
public class TbCust {

	@Id
	private Long id;
	
	private String code;
	
	private String name;
	
	private String desc;
}
