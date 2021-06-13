package org.tain.mybatis.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustProdMapper {

	List<Map<String,Object>> selectAll(Map<String,Object> mapIn);
	List<Map<String,Object>> selectJoin1(Map<String,Object> mapIn);
	List<Map<String,Object>> selectJoin2(Map<String,Object> mapIn);
}
