package org.tain.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.jpa.domain.TbCust;

@RepositoryRestResource
public interface TbCustRepository extends JpaRepository<TbCust, Long>{

}
